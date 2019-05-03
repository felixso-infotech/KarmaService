package com.lxisoft.web.rest;

import com.lxisoft.KarmaApp;

import com.lxisoft.domain.InstructionVideo;
import com.lxisoft.repository.InstructionVideoRepository;
import com.lxisoft.service.InstructionVideoService;
import com.lxisoft.service.dto.InstructionVideoDTO;
import com.lxisoft.service.mapper.InstructionVideoMapper;
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
import org.springframework.util.Base64Utils;

import javax.persistence.EntityManager;
import java.util.List;


import static com.lxisoft.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the InstructionVideoResource REST controller.
 *
 * @see InstructionVideoResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KarmaApp.class)
public class InstructionVideoResourceIntTest {

    private static final String DEFAULT_FILE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FILE_NAME = "BBBBBBBBBB";

    private static final byte[] DEFAULT_FILE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_FILE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_FILE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_FILE_CONTENT_TYPE = "image/png";

    @Autowired
    private InstructionVideoRepository instructionVideoRepository;

    @Autowired
    private InstructionVideoMapper instructionVideoMapper;

    @Autowired
    private InstructionVideoService instructionVideoService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restInstructionVideoMockMvc;

    private InstructionVideo instructionVideo;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final InstructionVideoResource instructionVideoResource = new InstructionVideoResource(instructionVideoService);
        this.restInstructionVideoMockMvc = MockMvcBuilders.standaloneSetup(instructionVideoResource)
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
    public static InstructionVideo createEntity(EntityManager em) {
        InstructionVideo instructionVideo = new InstructionVideo()
            .fileName(DEFAULT_FILE_NAME)
            .file(DEFAULT_FILE)
            .fileContentType(DEFAULT_FILE_CONTENT_TYPE);
        return instructionVideo;
    }

    @Before
    public void initTest() {
        instructionVideo = createEntity(em);
    }

    @Test
    @Transactional
    public void createInstructionVideo() throws Exception {
        int databaseSizeBeforeCreate = instructionVideoRepository.findAll().size();

        // Create the InstructionVideo
        InstructionVideoDTO instructionVideoDTO = instructionVideoMapper.toDto(instructionVideo);
        restInstructionVideoMockMvc.perform(post("/api/instruction-videos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(instructionVideoDTO)))
            .andExpect(status().isCreated());

        // Validate the InstructionVideo in the database
        List<InstructionVideo> instructionVideoList = instructionVideoRepository.findAll();
        assertThat(instructionVideoList).hasSize(databaseSizeBeforeCreate + 1);
        InstructionVideo testInstructionVideo = instructionVideoList.get(instructionVideoList.size() - 1);
        assertThat(testInstructionVideo.getFileName()).isEqualTo(DEFAULT_FILE_NAME);
        assertThat(testInstructionVideo.getFile()).isEqualTo(DEFAULT_FILE);
        assertThat(testInstructionVideo.getFileContentType()).isEqualTo(DEFAULT_FILE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void createInstructionVideoWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = instructionVideoRepository.findAll().size();

        // Create the InstructionVideo with an existing ID
        instructionVideo.setId(1L);
        InstructionVideoDTO instructionVideoDTO = instructionVideoMapper.toDto(instructionVideo);

        // An entity with an existing ID cannot be created, so this API call must fail
        restInstructionVideoMockMvc.perform(post("/api/instruction-videos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(instructionVideoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the InstructionVideo in the database
        List<InstructionVideo> instructionVideoList = instructionVideoRepository.findAll();
        assertThat(instructionVideoList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllInstructionVideos() throws Exception {
        // Initialize the database
        instructionVideoRepository.saveAndFlush(instructionVideo);

        // Get all the instructionVideoList
        restInstructionVideoMockMvc.perform(get("/api/instruction-videos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(instructionVideo.getId().intValue())))
            .andExpect(jsonPath("$.[*].fileName").value(hasItem(DEFAULT_FILE_NAME.toString())))
            .andExpect(jsonPath("$.[*].fileContentType").value(hasItem(DEFAULT_FILE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].file").value(hasItem(Base64Utils.encodeToString(DEFAULT_FILE))));
    }
    
    @Test
    @Transactional
    public void getInstructionVideo() throws Exception {
        // Initialize the database
        instructionVideoRepository.saveAndFlush(instructionVideo);

        // Get the instructionVideo
        restInstructionVideoMockMvc.perform(get("/api/instruction-videos/{id}", instructionVideo.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(instructionVideo.getId().intValue()))
            .andExpect(jsonPath("$.fileName").value(DEFAULT_FILE_NAME.toString()))
            .andExpect(jsonPath("$.fileContentType").value(DEFAULT_FILE_CONTENT_TYPE))
            .andExpect(jsonPath("$.file").value(Base64Utils.encodeToString(DEFAULT_FILE)));
    }

    @Test
    @Transactional
    public void getNonExistingInstructionVideo() throws Exception {
        // Get the instructionVideo
        restInstructionVideoMockMvc.perform(get("/api/instruction-videos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateInstructionVideo() throws Exception {
        // Initialize the database
        instructionVideoRepository.saveAndFlush(instructionVideo);

        int databaseSizeBeforeUpdate = instructionVideoRepository.findAll().size();

        // Update the instructionVideo
        InstructionVideo updatedInstructionVideo = instructionVideoRepository.findById(instructionVideo.getId()).get();
        // Disconnect from session so that the updates on updatedInstructionVideo are not directly saved in db
        em.detach(updatedInstructionVideo);
        updatedInstructionVideo
            .fileName(UPDATED_FILE_NAME)
            .file(UPDATED_FILE)
            .fileContentType(UPDATED_FILE_CONTENT_TYPE);
        InstructionVideoDTO instructionVideoDTO = instructionVideoMapper.toDto(updatedInstructionVideo);

        restInstructionVideoMockMvc.perform(put("/api/instruction-videos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(instructionVideoDTO)))
            .andExpect(status().isOk());

        // Validate the InstructionVideo in the database
        List<InstructionVideo> instructionVideoList = instructionVideoRepository.findAll();
        assertThat(instructionVideoList).hasSize(databaseSizeBeforeUpdate);
        InstructionVideo testInstructionVideo = instructionVideoList.get(instructionVideoList.size() - 1);
        assertThat(testInstructionVideo.getFileName()).isEqualTo(UPDATED_FILE_NAME);
        assertThat(testInstructionVideo.getFile()).isEqualTo(UPDATED_FILE);
        assertThat(testInstructionVideo.getFileContentType()).isEqualTo(UPDATED_FILE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingInstructionVideo() throws Exception {
        int databaseSizeBeforeUpdate = instructionVideoRepository.findAll().size();

        // Create the InstructionVideo
        InstructionVideoDTO instructionVideoDTO = instructionVideoMapper.toDto(instructionVideo);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restInstructionVideoMockMvc.perform(put("/api/instruction-videos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(instructionVideoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the InstructionVideo in the database
        List<InstructionVideo> instructionVideoList = instructionVideoRepository.findAll();
        assertThat(instructionVideoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteInstructionVideo() throws Exception {
        // Initialize the database
        instructionVideoRepository.saveAndFlush(instructionVideo);

        int databaseSizeBeforeDelete = instructionVideoRepository.findAll().size();

        // Get the instructionVideo
        restInstructionVideoMockMvc.perform(delete("/api/instruction-videos/{id}", instructionVideo.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<InstructionVideo> instructionVideoList = instructionVideoRepository.findAll();
        assertThat(instructionVideoList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(InstructionVideo.class);
        InstructionVideo instructionVideo1 = new InstructionVideo();
        instructionVideo1.setId(1L);
        InstructionVideo instructionVideo2 = new InstructionVideo();
        instructionVideo2.setId(instructionVideo1.getId());
        assertThat(instructionVideo1).isEqualTo(instructionVideo2);
        instructionVideo2.setId(2L);
        assertThat(instructionVideo1).isNotEqualTo(instructionVideo2);
        instructionVideo1.setId(null);
        assertThat(instructionVideo1).isNotEqualTo(instructionVideo2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(InstructionVideoDTO.class);
        InstructionVideoDTO instructionVideoDTO1 = new InstructionVideoDTO();
        instructionVideoDTO1.setId(1L);
        InstructionVideoDTO instructionVideoDTO2 = new InstructionVideoDTO();
        assertThat(instructionVideoDTO1).isNotEqualTo(instructionVideoDTO2);
        instructionVideoDTO2.setId(instructionVideoDTO1.getId());
        assertThat(instructionVideoDTO1).isEqualTo(instructionVideoDTO2);
        instructionVideoDTO2.setId(2L);
        assertThat(instructionVideoDTO1).isNotEqualTo(instructionVideoDTO2);
        instructionVideoDTO1.setId(null);
        assertThat(instructionVideoDTO1).isNotEqualTo(instructionVideoDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(instructionVideoMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(instructionVideoMapper.fromId(null)).isNull();
    }
}
