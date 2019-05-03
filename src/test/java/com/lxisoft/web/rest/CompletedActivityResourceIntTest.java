package com.lxisoft.web.rest;

import com.lxisoft.KarmaApp;

import com.lxisoft.domain.CompletedActivity;
import com.lxisoft.repository.CompletedActivityRepository;
import com.lxisoft.service.CompletedActivityService;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.mapper.CompletedActivityMapper;
import com.lxisoft.web.rest.errors.ExceptionTranslator;

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
import java.util.List;


import static com.lxisoft.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the CompletedActivityResource REST controller.
 *
 * @see CompletedActivityResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KarmaApp.class)
public class CompletedActivityResourceIntTest {

    @Autowired
    private CompletedActivityRepository completedActivityRepository;

    @Autowired
    private CompletedActivityMapper completedActivityMapper;

    @Autowired
    private CompletedActivityService completedActivityService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restCompletedActivityMockMvc;

    private CompletedActivity completedActivity;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CompletedActivityResource completedActivityResource = new CompletedActivityResource(completedActivityService);
        this.restCompletedActivityMockMvc = MockMvcBuilders.standaloneSetup(completedActivityResource)
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
    public static CompletedActivity createEntity(EntityManager em) {
        CompletedActivity completedActivity = new CompletedActivity();
        return completedActivity;
    }

    @Before
    public void initTest() {
        completedActivity = createEntity(em);
    }

    @Test
    @Transactional
    public void createCompletedActivity() throws Exception {
        int databaseSizeBeforeCreate = completedActivityRepository.findAll().size();

        // Create the CompletedActivity
        CompletedActivityDTO completedActivityDTO = completedActivityMapper.toDto(completedActivity);
        restCompletedActivityMockMvc.perform(post("/api/completed-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(completedActivityDTO)))
            .andExpect(status().isCreated());

        // Validate the CompletedActivity in the database
        List<CompletedActivity> completedActivityList = completedActivityRepository.findAll();
        assertThat(completedActivityList).hasSize(databaseSizeBeforeCreate + 1);
        CompletedActivity testCompletedActivity = completedActivityList.get(completedActivityList.size() - 1);
    }

    @Test
    @Transactional
    public void createCompletedActivityWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = completedActivityRepository.findAll().size();

        // Create the CompletedActivity with an existing ID
        completedActivity.setId(1L);
        CompletedActivityDTO completedActivityDTO = completedActivityMapper.toDto(completedActivity);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCompletedActivityMockMvc.perform(post("/api/completed-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(completedActivityDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CompletedActivity in the database
        List<CompletedActivity> completedActivityList = completedActivityRepository.findAll();
        assertThat(completedActivityList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllCompletedActivities() throws Exception {
        // Initialize the database
        completedActivityRepository.saveAndFlush(completedActivity);

        // Get all the completedActivityList
        restCompletedActivityMockMvc.perform(get("/api/completed-activities?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(completedActivity.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getCompletedActivity() throws Exception {
        // Initialize the database
        completedActivityRepository.saveAndFlush(completedActivity);

        // Get the completedActivity
        restCompletedActivityMockMvc.perform(get("/api/completed-activities/{id}", completedActivity.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(completedActivity.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingCompletedActivity() throws Exception {
        // Get the completedActivity
        restCompletedActivityMockMvc.perform(get("/api/completed-activities/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCompletedActivity() throws Exception {
        // Initialize the database
        completedActivityRepository.saveAndFlush(completedActivity);

        int databaseSizeBeforeUpdate = completedActivityRepository.findAll().size();

        // Update the completedActivity
        CompletedActivity updatedCompletedActivity = completedActivityRepository.findById(completedActivity.getId()).get();
        // Disconnect from session so that the updates on updatedCompletedActivity are not directly saved in db
        em.detach(updatedCompletedActivity);
        CompletedActivityDTO completedActivityDTO = completedActivityMapper.toDto(updatedCompletedActivity);

        restCompletedActivityMockMvc.perform(put("/api/completed-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(completedActivityDTO)))
            .andExpect(status().isOk());

        // Validate the CompletedActivity in the database
        List<CompletedActivity> completedActivityList = completedActivityRepository.findAll();
        assertThat(completedActivityList).hasSize(databaseSizeBeforeUpdate);
        CompletedActivity testCompletedActivity = completedActivityList.get(completedActivityList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingCompletedActivity() throws Exception {
        int databaseSizeBeforeUpdate = completedActivityRepository.findAll().size();

        // Create the CompletedActivity
        CompletedActivityDTO completedActivityDTO = completedActivityMapper.toDto(completedActivity);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCompletedActivityMockMvc.perform(put("/api/completed-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(completedActivityDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CompletedActivity in the database
        List<CompletedActivity> completedActivityList = completedActivityRepository.findAll();
        assertThat(completedActivityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCompletedActivity() throws Exception {
        // Initialize the database
        completedActivityRepository.saveAndFlush(completedActivity);

        int databaseSizeBeforeDelete = completedActivityRepository.findAll().size();

        // Get the completedActivity
        restCompletedActivityMockMvc.perform(delete("/api/completed-activities/{id}", completedActivity.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<CompletedActivity> completedActivityList = completedActivityRepository.findAll();
        assertThat(completedActivityList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CompletedActivity.class);
        CompletedActivity completedActivity1 = new CompletedActivity();
        completedActivity1.setId(1L);
        CompletedActivity completedActivity2 = new CompletedActivity();
        completedActivity2.setId(completedActivity1.getId());
        assertThat(completedActivity1).isEqualTo(completedActivity2);
        completedActivity2.setId(2L);
        assertThat(completedActivity1).isNotEqualTo(completedActivity2);
        completedActivity1.setId(null);
        assertThat(completedActivity1).isNotEqualTo(completedActivity2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CompletedActivityDTO.class);
        CompletedActivityDTO completedActivityDTO1 = new CompletedActivityDTO();
        completedActivityDTO1.setId(1L);
        CompletedActivityDTO completedActivityDTO2 = new CompletedActivityDTO();
        assertThat(completedActivityDTO1).isNotEqualTo(completedActivityDTO2);
        completedActivityDTO2.setId(completedActivityDTO1.getId());
        assertThat(completedActivityDTO1).isEqualTo(completedActivityDTO2);
        completedActivityDTO2.setId(2L);
        assertThat(completedActivityDTO1).isNotEqualTo(completedActivityDTO2);
        completedActivityDTO1.setId(null);
        assertThat(completedActivityDTO1).isNotEqualTo(completedActivityDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(completedActivityMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(completedActivityMapper.fromId(null)).isNull();
    }
}
