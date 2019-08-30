package com.felixsoinfotech.karma.web.rest;

import com.felixsoinfotech.karma.KarmaApp;

import com.felixsoinfotech.karma.domain.Dimension;
import com.felixsoinfotech.karma.repository.DimensionRepository;
import com.felixsoinfotech.karma.service.DimensionService;
import com.felixsoinfotech.karma.service.dto.DimensionDTO;
import com.felixsoinfotech.karma.service.mapper.DimensionMapper;
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
import java.util.List;


import static com.felixsoinfotech.karma.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the DimensionResource REST controller.
 *
 * @see DimensionResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KarmaApp.class)
public class DimensionResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    @Autowired
    private DimensionRepository dimensionRepository;

    @Autowired
    private DimensionMapper dimensionMapper;

    @Autowired
    private DimensionService dimensionService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restDimensionMockMvc;

    private Dimension dimension;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DimensionResource dimensionResource = new DimensionResource(dimensionService);
        this.restDimensionMockMvc = MockMvcBuilders.standaloneSetup(dimensionResource)
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
    public static Dimension createEntity(EntityManager em) {
        Dimension dimension = new Dimension()
            .name(DEFAULT_NAME);
        return dimension;
    }

    @Before
    public void initTest() {
        dimension = createEntity(em);
    }

    @Test
    @Transactional
    public void createDimension() throws Exception {
        int databaseSizeBeforeCreate = dimensionRepository.findAll().size();

        // Create the Dimension
        DimensionDTO dimensionDTO = dimensionMapper.toDto(dimension);
        restDimensionMockMvc.perform(post("/api/dimensions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dimensionDTO)))
            .andExpect(status().isCreated());

        // Validate the Dimension in the database
        List<Dimension> dimensionList = dimensionRepository.findAll();
        assertThat(dimensionList).hasSize(databaseSizeBeforeCreate + 1);
        Dimension testDimension = dimensionList.get(dimensionList.size() - 1);
        assertThat(testDimension.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    public void createDimensionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dimensionRepository.findAll().size();

        // Create the Dimension with an existing ID
        dimension.setId(1L);
        DimensionDTO dimensionDTO = dimensionMapper.toDto(dimension);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDimensionMockMvc.perform(post("/api/dimensions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dimensionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Dimension in the database
        List<Dimension> dimensionList = dimensionRepository.findAll();
        assertThat(dimensionList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllDimensions() throws Exception {
        // Initialize the database
        dimensionRepository.saveAndFlush(dimension);

        // Get all the dimensionList
        restDimensionMockMvc.perform(get("/api/dimensions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dimension.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())));
    }
    
    @Test
    @Transactional
    public void getDimension() throws Exception {
        // Initialize the database
        dimensionRepository.saveAndFlush(dimension);

        // Get the dimension
        restDimensionMockMvc.perform(get("/api/dimensions/{id}", dimension.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(dimension.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingDimension() throws Exception {
        // Get the dimension
        restDimensionMockMvc.perform(get("/api/dimensions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDimension() throws Exception {
        // Initialize the database
        dimensionRepository.saveAndFlush(dimension);

        int databaseSizeBeforeUpdate = dimensionRepository.findAll().size();

        // Update the dimension
        Dimension updatedDimension = dimensionRepository.findById(dimension.getId()).get();
        // Disconnect from session so that the updates on updatedDimension are not directly saved in db
        em.detach(updatedDimension);
        updatedDimension
            .name(UPDATED_NAME);
        DimensionDTO dimensionDTO = dimensionMapper.toDto(updatedDimension);

        restDimensionMockMvc.perform(put("/api/dimensions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dimensionDTO)))
            .andExpect(status().isOk());

        // Validate the Dimension in the database
        List<Dimension> dimensionList = dimensionRepository.findAll();
        assertThat(dimensionList).hasSize(databaseSizeBeforeUpdate);
        Dimension testDimension = dimensionList.get(dimensionList.size() - 1);
        assertThat(testDimension.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingDimension() throws Exception {
        int databaseSizeBeforeUpdate = dimensionRepository.findAll().size();

        // Create the Dimension
        DimensionDTO dimensionDTO = dimensionMapper.toDto(dimension);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDimensionMockMvc.perform(put("/api/dimensions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dimensionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Dimension in the database
        List<Dimension> dimensionList = dimensionRepository.findAll();
        assertThat(dimensionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDimension() throws Exception {
        // Initialize the database
        dimensionRepository.saveAndFlush(dimension);

        int databaseSizeBeforeDelete = dimensionRepository.findAll().size();

        // Get the dimension
        restDimensionMockMvc.perform(delete("/api/dimensions/{id}", dimension.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Dimension> dimensionList = dimensionRepository.findAll();
        assertThat(dimensionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Dimension.class);
        Dimension dimension1 = new Dimension();
        dimension1.setId(1L);
        Dimension dimension2 = new Dimension();
        dimension2.setId(dimension1.getId());
        assertThat(dimension1).isEqualTo(dimension2);
        dimension2.setId(2L);
        assertThat(dimension1).isNotEqualTo(dimension2);
        dimension1.setId(null);
        assertThat(dimension1).isNotEqualTo(dimension2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DimensionDTO.class);
        DimensionDTO dimensionDTO1 = new DimensionDTO();
        dimensionDTO1.setId(1L);
        DimensionDTO dimensionDTO2 = new DimensionDTO();
        assertThat(dimensionDTO1).isNotEqualTo(dimensionDTO2);
        dimensionDTO2.setId(dimensionDTO1.getId());
        assertThat(dimensionDTO1).isEqualTo(dimensionDTO2);
        dimensionDTO2.setId(2L);
        assertThat(dimensionDTO1).isNotEqualTo(dimensionDTO2);
        dimensionDTO1.setId(null);
        assertThat(dimensionDTO1).isNotEqualTo(dimensionDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(dimensionMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(dimensionMapper.fromId(null)).isNull();
    }
}
