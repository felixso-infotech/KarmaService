package com.felixsoinfotech.karma.web.rest;

import com.felixsoinfotech.karma.KarmaApp;

import com.felixsoinfotech.karma.domain.IntroductionStory;
import com.felixsoinfotech.karma.repository.IntroductionStoryRepository;
import com.felixsoinfotech.karma.service.IntroductionStoryService;
import com.felixsoinfotech.karma.service.dto.IntroductionStoryDTO;
import com.felixsoinfotech.karma.service.mapper.IntroductionStoryMapper;
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
import org.springframework.util.Base64Utils;

import javax.persistence.EntityManager;
import java.util.List;


import static com.felixsoinfotech.karma.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the IntroductionStoryResource REST controller.
 *
 * @see IntroductionStoryResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KarmaApp.class)
public class IntroductionStoryResourceIntTest {

    private static final String DEFAULT_STORY = "AAAAAAAAAA";
    private static final String UPDATED_STORY = "BBBBBBBBBB";

    private static final byte[] DEFAULT_IMAGE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_CONTENT_TYPE = "image/png";

    @Autowired
    private IntroductionStoryRepository introductionStoryRepository;

    @Autowired
    private IntroductionStoryMapper introductionStoryMapper;

    @Autowired
    private IntroductionStoryService introductionStoryService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restIntroductionStoryMockMvc;

    private IntroductionStory introductionStory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final IntroductionStoryResource introductionStoryResource = new IntroductionStoryResource(introductionStoryService);
        this.restIntroductionStoryMockMvc = MockMvcBuilders.standaloneSetup(introductionStoryResource)
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
    public static IntroductionStory createEntity(EntityManager em) {
        IntroductionStory introductionStory = new IntroductionStory()
            .story(DEFAULT_STORY)
            .image(DEFAULT_IMAGE)
            .imageContentType(DEFAULT_IMAGE_CONTENT_TYPE);
        return introductionStory;
    }

    @Before
    public void initTest() {
        introductionStory = createEntity(em);
    }

    @Test
    @Transactional
    public void createIntroductionStory() throws Exception {
        int databaseSizeBeforeCreate = introductionStoryRepository.findAll().size();

        // Create the IntroductionStory
        IntroductionStoryDTO introductionStoryDTO = introductionStoryMapper.toDto(introductionStory);
        restIntroductionStoryMockMvc.perform(post("/api/introduction-stories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(introductionStoryDTO)))
            .andExpect(status().isCreated());

        // Validate the IntroductionStory in the database
        List<IntroductionStory> introductionStoryList = introductionStoryRepository.findAll();
        assertThat(introductionStoryList).hasSize(databaseSizeBeforeCreate + 1);
        IntroductionStory testIntroductionStory = introductionStoryList.get(introductionStoryList.size() - 1);
        assertThat(testIntroductionStory.getStory()).isEqualTo(DEFAULT_STORY);
        assertThat(testIntroductionStory.getImage()).isEqualTo(DEFAULT_IMAGE);
        assertThat(testIntroductionStory.getImageContentType()).isEqualTo(DEFAULT_IMAGE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void createIntroductionStoryWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = introductionStoryRepository.findAll().size();

        // Create the IntroductionStory with an existing ID
        introductionStory.setId(1L);
        IntroductionStoryDTO introductionStoryDTO = introductionStoryMapper.toDto(introductionStory);

        // An entity with an existing ID cannot be created, so this API call must fail
        restIntroductionStoryMockMvc.perform(post("/api/introduction-stories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(introductionStoryDTO)))
            .andExpect(status().isBadRequest());

        // Validate the IntroductionStory in the database
        List<IntroductionStory> introductionStoryList = introductionStoryRepository.findAll();
        assertThat(introductionStoryList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllIntroductionStories() throws Exception {
        // Initialize the database
        introductionStoryRepository.saveAndFlush(introductionStory);

        // Get all the introductionStoryList
        restIntroductionStoryMockMvc.perform(get("/api/introduction-stories?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(introductionStory.getId().intValue())))
            .andExpect(jsonPath("$.[*].story").value(hasItem(DEFAULT_STORY.toString())))
            .andExpect(jsonPath("$.[*].imageContentType").value(hasItem(DEFAULT_IMAGE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE))));
    }
    
    @Test
    @Transactional
    public void getIntroductionStory() throws Exception {
        // Initialize the database
        introductionStoryRepository.saveAndFlush(introductionStory);

        // Get the introductionStory
        restIntroductionStoryMockMvc.perform(get("/api/introduction-stories/{id}", introductionStory.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(introductionStory.getId().intValue()))
            .andExpect(jsonPath("$.story").value(DEFAULT_STORY.toString()))
            .andExpect(jsonPath("$.imageContentType").value(DEFAULT_IMAGE_CONTENT_TYPE))
            .andExpect(jsonPath("$.image").value(Base64Utils.encodeToString(DEFAULT_IMAGE)));
    }

    @Test
    @Transactional
    public void getNonExistingIntroductionStory() throws Exception {
        // Get the introductionStory
        restIntroductionStoryMockMvc.perform(get("/api/introduction-stories/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateIntroductionStory() throws Exception {
        // Initialize the database
        introductionStoryRepository.saveAndFlush(introductionStory);

        int databaseSizeBeforeUpdate = introductionStoryRepository.findAll().size();

        // Update the introductionStory
        IntroductionStory updatedIntroductionStory = introductionStoryRepository.findById(introductionStory.getId()).get();
        // Disconnect from session so that the updates on updatedIntroductionStory are not directly saved in db
        em.detach(updatedIntroductionStory);
        updatedIntroductionStory
            .story(UPDATED_STORY)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE);
        IntroductionStoryDTO introductionStoryDTO = introductionStoryMapper.toDto(updatedIntroductionStory);

        restIntroductionStoryMockMvc.perform(put("/api/introduction-stories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(introductionStoryDTO)))
            .andExpect(status().isOk());

        // Validate the IntroductionStory in the database
        List<IntroductionStory> introductionStoryList = introductionStoryRepository.findAll();
        assertThat(introductionStoryList).hasSize(databaseSizeBeforeUpdate);
        IntroductionStory testIntroductionStory = introductionStoryList.get(introductionStoryList.size() - 1);
        assertThat(testIntroductionStory.getStory()).isEqualTo(UPDATED_STORY);
        assertThat(testIntroductionStory.getImage()).isEqualTo(UPDATED_IMAGE);
        assertThat(testIntroductionStory.getImageContentType()).isEqualTo(UPDATED_IMAGE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingIntroductionStory() throws Exception {
        int databaseSizeBeforeUpdate = introductionStoryRepository.findAll().size();

        // Create the IntroductionStory
        IntroductionStoryDTO introductionStoryDTO = introductionStoryMapper.toDto(introductionStory);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIntroductionStoryMockMvc.perform(put("/api/introduction-stories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(introductionStoryDTO)))
            .andExpect(status().isBadRequest());

        // Validate the IntroductionStory in the database
        List<IntroductionStory> introductionStoryList = introductionStoryRepository.findAll();
        assertThat(introductionStoryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteIntroductionStory() throws Exception {
        // Initialize the database
        introductionStoryRepository.saveAndFlush(introductionStory);

        int databaseSizeBeforeDelete = introductionStoryRepository.findAll().size();

        // Get the introductionStory
        restIntroductionStoryMockMvc.perform(delete("/api/introduction-stories/{id}", introductionStory.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<IntroductionStory> introductionStoryList = introductionStoryRepository.findAll();
        assertThat(introductionStoryList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(IntroductionStory.class);
        IntroductionStory introductionStory1 = new IntroductionStory();
        introductionStory1.setId(1L);
        IntroductionStory introductionStory2 = new IntroductionStory();
        introductionStory2.setId(introductionStory1.getId());
        assertThat(introductionStory1).isEqualTo(introductionStory2);
        introductionStory2.setId(2L);
        assertThat(introductionStory1).isNotEqualTo(introductionStory2);
        introductionStory1.setId(null);
        assertThat(introductionStory1).isNotEqualTo(introductionStory2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(IntroductionStoryDTO.class);
        IntroductionStoryDTO introductionStoryDTO1 = new IntroductionStoryDTO();
        introductionStoryDTO1.setId(1L);
        IntroductionStoryDTO introductionStoryDTO2 = new IntroductionStoryDTO();
        assertThat(introductionStoryDTO1).isNotEqualTo(introductionStoryDTO2);
        introductionStoryDTO2.setId(introductionStoryDTO1.getId());
        assertThat(introductionStoryDTO1).isEqualTo(introductionStoryDTO2);
        introductionStoryDTO2.setId(2L);
        assertThat(introductionStoryDTO1).isNotEqualTo(introductionStoryDTO2);
        introductionStoryDTO1.setId(null);
        assertThat(introductionStoryDTO1).isNotEqualTo(introductionStoryDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(introductionStoryMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(introductionStoryMapper.fromId(null)).isNull();
    }
}
