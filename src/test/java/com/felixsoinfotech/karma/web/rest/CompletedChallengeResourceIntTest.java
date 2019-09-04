package com.felixsoinfotech.karma.web.rest;

import com.felixsoinfotech.karma.KarmaApp;

import com.felixsoinfotech.karma.domain.CompletedChallenge;
import com.felixsoinfotech.karma.repository.CompletedChallengeRepository;
import com.felixsoinfotech.karma.service.CompletedChallengeService;
import com.felixsoinfotech.karma.service.dto.CompletedChallengeDTO;
import com.felixsoinfotech.karma.service.mapper.CompletedChallengeMapper;
import com.felixsoinfotech.karma.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;


import static com.felixsoinfotech.karma.web.rest.TestUtil.sameInstant;
import static com.felixsoinfotech.karma.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the CompletedChallengeResource REST controller.
 *
 * @see CompletedChallengeResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KarmaApp.class)
public class CompletedChallengeResourceIntTest {

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_CREATED_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATED_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Autowired
    private CompletedChallengeRepository completedChallengeRepository;

    @Autowired
    private CompletedChallengeMapper completedChallengeMapper;

    @Autowired
    private CompletedChallengeService completedChallengeService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restCompletedChallengeMockMvc;

    private CompletedChallenge completedChallenge;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CompletedChallengeResource completedChallengeResource = new CompletedChallengeResource(completedChallengeService);
        this.restCompletedChallengeMockMvc = MockMvcBuilders.standaloneSetup(completedChallengeResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CompletedChallenge createEntity(EntityManager em) {
        CompletedChallenge completedChallenge = new CompletedChallenge()
            .description(DEFAULT_DESCRIPTION)
            .createdDate(DEFAULT_CREATED_DATE);
        return completedChallenge;
    }

    @Before
    public void initTest() {
        completedChallenge = createEntity(em);
    }

    @Test
    @Transactional
    public void createCompletedChallenge() throws Exception {
        int databaseSizeBeforeCreate = completedChallengeRepository.findAll().size();

        // Create the CompletedChallenge
        CompletedChallengeDTO completedChallengeDTO = completedChallengeMapper.toDto(completedChallenge);
        restCompletedChallengeMockMvc.perform(post("/api/completed-challenges")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(completedChallengeDTO)))
            .andExpect(status().isCreated());

        // Validate the CompletedChallenge in the database
        List<CompletedChallenge> completedChallengeList = completedChallengeRepository.findAll();
        assertThat(completedChallengeList).hasSize(databaseSizeBeforeCreate + 1);
        CompletedChallenge testCompletedChallenge = completedChallengeList.get(completedChallengeList.size() - 1);
        assertThat(testCompletedChallenge.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testCompletedChallenge.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
    }

    @Test
    @Transactional
    public void createCompletedChallengeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = completedChallengeRepository.findAll().size();

        // Create the CompletedChallenge with an existing ID
        completedChallenge.setId(1L);
        CompletedChallengeDTO completedChallengeDTO = completedChallengeMapper.toDto(completedChallenge);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCompletedChallengeMockMvc.perform(post("/api/completed-challenges")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(completedChallengeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CompletedChallenge in the database
        List<CompletedChallenge> completedChallengeList = completedChallengeRepository.findAll();
        assertThat(completedChallengeList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllCompletedChallenges() throws Exception {
        // Initialize the database
        completedChallengeRepository.saveAndFlush(completedChallenge);

        // Get all the completedChallengeList
        restCompletedChallengeMockMvc.perform(get("/api/completed-challenges?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(completedChallenge.getId().intValue())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].createdDate").value(hasItem(sameInstant(DEFAULT_CREATED_DATE))));
    }
    
    @Test
    @Transactional
    public void getCompletedChallenge() throws Exception {
        // Initialize the database
        completedChallengeRepository.saveAndFlush(completedChallenge);

        // Get the completedChallenge
        restCompletedChallengeMockMvc.perform(get("/api/completed-challenges/{id}", completedChallenge.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(completedChallenge.getId().intValue()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.createdDate").value(sameInstant(DEFAULT_CREATED_DATE)));
    }

    @Test
    @Transactional
    public void getNonExistingCompletedChallenge() throws Exception {
        // Get the completedChallenge
        restCompletedChallengeMockMvc.perform(get("/api/completed-challenges/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCompletedChallenge() throws Exception {
        // Initialize the database
        completedChallengeRepository.saveAndFlush(completedChallenge);

        int databaseSizeBeforeUpdate = completedChallengeRepository.findAll().size();

        // Update the completedChallenge
        CompletedChallenge updatedCompletedChallenge = completedChallengeRepository.findById(completedChallenge.getId()).get();
        // Disconnect from session so that the updates on updatedCompletedChallenge are not directly saved in db
        em.detach(updatedCompletedChallenge);
        updatedCompletedChallenge
            .description(UPDATED_DESCRIPTION)
            .createdDate(UPDATED_CREATED_DATE);
        CompletedChallengeDTO completedChallengeDTO = completedChallengeMapper.toDto(updatedCompletedChallenge);

        restCompletedChallengeMockMvc.perform(put("/api/completed-challenges")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(completedChallengeDTO)))
            .andExpect(status().isOk());

        // Validate the CompletedChallenge in the database
        List<CompletedChallenge> completedChallengeList = completedChallengeRepository.findAll();
        assertThat(completedChallengeList).hasSize(databaseSizeBeforeUpdate);
        CompletedChallenge testCompletedChallenge = completedChallengeList.get(completedChallengeList.size() - 1);
        assertThat(testCompletedChallenge.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testCompletedChallenge.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingCompletedChallenge() throws Exception {
        int databaseSizeBeforeUpdate = completedChallengeRepository.findAll().size();

        // Create the CompletedChallenge
        CompletedChallengeDTO completedChallengeDTO = completedChallengeMapper.toDto(completedChallenge);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCompletedChallengeMockMvc.perform(put("/api/completed-challenges")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(completedChallengeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CompletedChallenge in the database
        List<CompletedChallenge> completedChallengeList = completedChallengeRepository.findAll();
        assertThat(completedChallengeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCompletedChallenge() throws Exception {
        // Initialize the database
        completedChallengeRepository.saveAndFlush(completedChallenge);

        int databaseSizeBeforeDelete = completedChallengeRepository.findAll().size();

        // Get the completedChallenge
        restCompletedChallengeMockMvc.perform(delete("/api/completed-challenges/{id}", completedChallenge.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<CompletedChallenge> completedChallengeList = completedChallengeRepository.findAll();
        assertThat(completedChallengeList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CompletedChallenge.class);
        CompletedChallenge completedChallenge1 = new CompletedChallenge();
        completedChallenge1.setId(1L);
        CompletedChallenge completedChallenge2 = new CompletedChallenge();
        completedChallenge2.setId(completedChallenge1.getId());
        assertThat(completedChallenge1).isEqualTo(completedChallenge2);
        completedChallenge2.setId(2L);
        assertThat(completedChallenge1).isNotEqualTo(completedChallenge2);
        completedChallenge1.setId(null);
        assertThat(completedChallenge1).isNotEqualTo(completedChallenge2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CompletedChallengeDTO.class);
        CompletedChallengeDTO completedChallengeDTO1 = new CompletedChallengeDTO();
        completedChallengeDTO1.setId(1L);
        CompletedChallengeDTO completedChallengeDTO2 = new CompletedChallengeDTO();
        assertThat(completedChallengeDTO1).isNotEqualTo(completedChallengeDTO2);
        completedChallengeDTO2.setId(completedChallengeDTO1.getId());
        assertThat(completedChallengeDTO1).isEqualTo(completedChallengeDTO2);
        completedChallengeDTO2.setId(2L);
        assertThat(completedChallengeDTO1).isNotEqualTo(completedChallengeDTO2);
        completedChallengeDTO1.setId(null);
        assertThat(completedChallengeDTO1).isNotEqualTo(completedChallengeDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(completedChallengeMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(completedChallengeMapper.fromId(null)).isNull();
    }
}
