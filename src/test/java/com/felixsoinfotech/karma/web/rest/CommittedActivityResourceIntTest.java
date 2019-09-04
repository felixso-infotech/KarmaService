package com.felixsoinfotech.karma.web.rest;

import com.felixsoinfotech.karma.KarmaApp;

import com.felixsoinfotech.karma.domain.CommittedActivity;
import com.felixsoinfotech.karma.repository.CommittedActivityRepository;
import com.felixsoinfotech.karma.service.CommittedActivityService;
import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;
import com.felixsoinfotech.karma.service.mapper.CommittedActivityMapper;
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

import com.felixsoinfotech.karma.domain.enumeration.Status;
/**
 * Test class for the CommittedActivityResource REST controller.
 *
 * @see CommittedActivityResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KarmaApp.class)
public class CommittedActivityResourceIntTest {

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Status DEFAULT_STATUS = Status.TODO;
    private static final Status UPDATED_STATUS = Status.INPROGRESS;

    private static final ZonedDateTime DEFAULT_CREATED_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATED_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Autowired
    private CommittedActivityRepository committedActivityRepository;

    @Autowired
    private CommittedActivityMapper committedActivityMapper;

    @Autowired
    private CommittedActivityService committedActivityService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restCommittedActivityMockMvc;

    private CommittedActivity committedActivity;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CommittedActivityResource committedActivityResource = new CommittedActivityResource(committedActivityService);
        this.restCommittedActivityMockMvc = MockMvcBuilders.standaloneSetup(committedActivityResource)
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
    public static CommittedActivity createEntity(EntityManager em) {
        CommittedActivity committedActivity = new CommittedActivity()
            .description(DEFAULT_DESCRIPTION)
            .status(DEFAULT_STATUS)
            .createdDate(DEFAULT_CREATED_DATE);
        return committedActivity;
    }

    @Before
    public void initTest() {
        committedActivity = createEntity(em);
    }

    @Test
    @Transactional
    public void createCommittedActivity() throws Exception {
        int databaseSizeBeforeCreate = committedActivityRepository.findAll().size();

        // Create the CommittedActivity
        CommittedActivityDTO committedActivityDTO = committedActivityMapper.toDto(committedActivity);
        restCommittedActivityMockMvc.perform(post("/api/committed-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(committedActivityDTO)))
            .andExpect(status().isCreated());

        // Validate the CommittedActivity in the database
        List<CommittedActivity> committedActivityList = committedActivityRepository.findAll();
        assertThat(committedActivityList).hasSize(databaseSizeBeforeCreate + 1);
        CommittedActivity testCommittedActivity = committedActivityList.get(committedActivityList.size() - 1);
        assertThat(testCommittedActivity.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testCommittedActivity.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testCommittedActivity.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
    }

    @Test
    @Transactional
    public void createCommittedActivityWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = committedActivityRepository.findAll().size();

        // Create the CommittedActivity with an existing ID
        committedActivity.setId(1L);
        CommittedActivityDTO committedActivityDTO = committedActivityMapper.toDto(committedActivity);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCommittedActivityMockMvc.perform(post("/api/committed-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(committedActivityDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CommittedActivity in the database
        List<CommittedActivity> committedActivityList = committedActivityRepository.findAll();
        assertThat(committedActivityList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllCommittedActivities() throws Exception {
        // Initialize the database
        committedActivityRepository.saveAndFlush(committedActivity);

        // Get all the committedActivityList
        restCommittedActivityMockMvc.perform(get("/api/committed-activities?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(committedActivity.getId().intValue())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].createdDate").value(hasItem(sameInstant(DEFAULT_CREATED_DATE))));
    }
    
    @Test
    @Transactional
    public void getCommittedActivity() throws Exception {
        // Initialize the database
        committedActivityRepository.saveAndFlush(committedActivity);

        // Get the committedActivity
        restCommittedActivityMockMvc.perform(get("/api/committed-activities/{id}", committedActivity.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(committedActivity.getId().intValue()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.createdDate").value(sameInstant(DEFAULT_CREATED_DATE)));
    }

    @Test
    @Transactional
    public void getNonExistingCommittedActivity() throws Exception {
        // Get the committedActivity
        restCommittedActivityMockMvc.perform(get("/api/committed-activities/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCommittedActivity() throws Exception {
        // Initialize the database
        committedActivityRepository.saveAndFlush(committedActivity);

        int databaseSizeBeforeUpdate = committedActivityRepository.findAll().size();

        // Update the committedActivity
        CommittedActivity updatedCommittedActivity = committedActivityRepository.findById(committedActivity.getId()).get();
        // Disconnect from session so that the updates on updatedCommittedActivity are not directly saved in db
        em.detach(updatedCommittedActivity);
        updatedCommittedActivity
            .description(UPDATED_DESCRIPTION)
            .status(UPDATED_STATUS)
            .createdDate(UPDATED_CREATED_DATE);
        CommittedActivityDTO committedActivityDTO = committedActivityMapper.toDto(updatedCommittedActivity);

        restCommittedActivityMockMvc.perform(put("/api/committed-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(committedActivityDTO)))
            .andExpect(status().isOk());

        // Validate the CommittedActivity in the database
        List<CommittedActivity> committedActivityList = committedActivityRepository.findAll();
        assertThat(committedActivityList).hasSize(databaseSizeBeforeUpdate);
        CommittedActivity testCommittedActivity = committedActivityList.get(committedActivityList.size() - 1);
        assertThat(testCommittedActivity.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testCommittedActivity.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testCommittedActivity.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingCommittedActivity() throws Exception {
        int databaseSizeBeforeUpdate = committedActivityRepository.findAll().size();

        // Create the CommittedActivity
        CommittedActivityDTO committedActivityDTO = committedActivityMapper.toDto(committedActivity);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCommittedActivityMockMvc.perform(put("/api/committed-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(committedActivityDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CommittedActivity in the database
        List<CommittedActivity> committedActivityList = committedActivityRepository.findAll();
        assertThat(committedActivityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCommittedActivity() throws Exception {
        // Initialize the database
        committedActivityRepository.saveAndFlush(committedActivity);

        int databaseSizeBeforeDelete = committedActivityRepository.findAll().size();

        // Get the committedActivity
        restCommittedActivityMockMvc.perform(delete("/api/committed-activities/{id}", committedActivity.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<CommittedActivity> committedActivityList = committedActivityRepository.findAll();
        assertThat(committedActivityList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CommittedActivity.class);
        CommittedActivity committedActivity1 = new CommittedActivity();
        committedActivity1.setId(1L);
        CommittedActivity committedActivity2 = new CommittedActivity();
        committedActivity2.setId(committedActivity1.getId());
        assertThat(committedActivity1).isEqualTo(committedActivity2);
        committedActivity2.setId(2L);
        assertThat(committedActivity1).isNotEqualTo(committedActivity2);
        committedActivity1.setId(null);
        assertThat(committedActivity1).isNotEqualTo(committedActivity2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CommittedActivityDTO.class);
        CommittedActivityDTO committedActivityDTO1 = new CommittedActivityDTO();
        committedActivityDTO1.setId(1L);
        CommittedActivityDTO committedActivityDTO2 = new CommittedActivityDTO();
        assertThat(committedActivityDTO1).isNotEqualTo(committedActivityDTO2);
        committedActivityDTO2.setId(committedActivityDTO1.getId());
        assertThat(committedActivityDTO1).isEqualTo(committedActivityDTO2);
        committedActivityDTO2.setId(2L);
        assertThat(committedActivityDTO1).isNotEqualTo(committedActivityDTO2);
        committedActivityDTO1.setId(null);
        assertThat(committedActivityDTO1).isNotEqualTo(committedActivityDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(committedActivityMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(committedActivityMapper.fromId(null)).isNull();
    }
}
