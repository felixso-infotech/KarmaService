package com.lxisoft.web.rest;

import com.lxisoft.XapiLaunchKarmaApp;

import com.lxisoft.domain.ContentRecord;
import com.lxisoft.repository.ContentRecordRepository;
import com.lxisoft.service.ContentRecordService;
import com.lxisoft.service.dto.ContentRecordDTO;
import com.lxisoft.service.mapper.ContentRecordMapper;
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

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;


import static com.lxisoft.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ContentRecordResource REST controller.
 *
 * @see ContentRecordResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = XapiLaunchKarmaApp.class)
public class ContentRecordResourceIntTest {

    private static final String DEFAULT_ICON_URL = "AAAAAAAAAA";
    private static final String UPDATED_ICON_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PACKAGE_LINK = "AAAAAAAAAA";
    private static final String UPDATED_PACKAGE_LINK = "BBBBBBBBBB";

    private static final String DEFAULT_LAUNCH_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_LAUNCH_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_OWNER = "AAAAAAAAAA";
    private static final String UPDATED_OWNER = "BBBBBBBBBB";

    private static final Instant DEFAULT_ACCESSED = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_ACCESSED = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_CREATED = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_URL = "AAAAAAAAAA";
    private static final String UPDATED_URL = "BBBBBBBBBB";

    private static final Integer DEFAULT_V = 1;
    private static final Integer UPDATED_V = 2;

    private static final Integer DEFAULT_LAUNCHES = 1;
    private static final Integer UPDATED_LAUNCHES = 2;

    private static final String DEFAULT_CUSTOM_DATA = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOM_DATA = "BBBBBBBBBB";

    private static final String DEFAULT_MEDIA_TYPE_KEY = "AAAAAAAAAA";
    private static final String UPDATED_MEDIA_TYPE_KEY = "BBBBBBBBBB";

    private static final String DEFAULT_PUBLIC_KEY = "AAAAAAAAAA";
    private static final String UPDATED_PUBLIC_KEY = "BBBBBBBBBB";

    private static final Integer DEFAULT_SESSION_LENGTH = 1;
    private static final Integer UPDATED_SESSION_LENGTH = 2;

    private static final Integer DEFAULT_TIME_TO_CONSUME = 1;
    private static final Integer UPDATED_TIME_TO_CONSUME = 2;

    @Autowired
    private ContentRecordRepository contentRecordRepository;

    @Autowired
    private ContentRecordMapper contentRecordMapper;

    @Autowired
    private ContentRecordService contentRecordService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    private MockMvc restContentRecordMockMvc;

    private ContentRecord contentRecord;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ContentRecordResource contentRecordResource = new ContentRecordResource(contentRecordService);
        this.restContentRecordMockMvc = MockMvcBuilders.standaloneSetup(contentRecordResource)
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
    public static ContentRecord createEntity() {
        ContentRecord contentRecord = new ContentRecord()
            .iconURL(DEFAULT_ICON_URL)
            .packageLink(DEFAULT_PACKAGE_LINK)
            .launchType(DEFAULT_LAUNCH_TYPE)
            .owner(DEFAULT_OWNER)
            .accessed(DEFAULT_ACCESSED)
            .created(DEFAULT_CREATED)
            .description(DEFAULT_DESCRIPTION)
            .title(DEFAULT_TITLE)
            .url(DEFAULT_URL)
            .v(DEFAULT_V)
            .launches(DEFAULT_LAUNCHES)
            .customData(DEFAULT_CUSTOM_DATA)
            .mediaTypeKey(DEFAULT_MEDIA_TYPE_KEY)
            .publicKey(DEFAULT_PUBLIC_KEY)
            .sessionLength(DEFAULT_SESSION_LENGTH)
            .timeToConsume(DEFAULT_TIME_TO_CONSUME);
        return contentRecord;
    }

    @Before
    public void initTest() {
        contentRecordRepository.deleteAll();
        contentRecord = createEntity();
    }

    @Test
    public void createContentRecord() throws Exception {
        int databaseSizeBeforeCreate = contentRecordRepository.findAll().size();

        // Create the ContentRecord
        ContentRecordDTO contentRecordDTO = contentRecordMapper.toDto(contentRecord);
        restContentRecordMockMvc.perform(post("/api/content-records")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(contentRecordDTO)))
            .andExpect(status().isCreated());

        // Validate the ContentRecord in the database
        List<ContentRecord> contentRecordList = contentRecordRepository.findAll();
        assertThat(contentRecordList).hasSize(databaseSizeBeforeCreate + 1);
        ContentRecord testContentRecord = contentRecordList.get(contentRecordList.size() - 1);
        assertThat(testContentRecord.getIconURL()).isEqualTo(DEFAULT_ICON_URL);
        assertThat(testContentRecord.getPackageLink()).isEqualTo(DEFAULT_PACKAGE_LINK);
        assertThat(testContentRecord.getLaunchType()).isEqualTo(DEFAULT_LAUNCH_TYPE);
        assertThat(testContentRecord.getOwner()).isEqualTo(DEFAULT_OWNER);
        assertThat(testContentRecord.getAccessed()).isEqualTo(DEFAULT_ACCESSED);
        assertThat(testContentRecord.getCreated()).isEqualTo(DEFAULT_CREATED);
        assertThat(testContentRecord.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testContentRecord.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testContentRecord.getUrl()).isEqualTo(DEFAULT_URL);
        assertThat(testContentRecord.getV()).isEqualTo(DEFAULT_V);
        assertThat(testContentRecord.getLaunches()).isEqualTo(DEFAULT_LAUNCHES);
        assertThat(testContentRecord.getCustomData()).isEqualTo(DEFAULT_CUSTOM_DATA);
        assertThat(testContentRecord.getMediaTypeKey()).isEqualTo(DEFAULT_MEDIA_TYPE_KEY);
        assertThat(testContentRecord.getPublicKey()).isEqualTo(DEFAULT_PUBLIC_KEY);
        assertThat(testContentRecord.getSessionLength()).isEqualTo(DEFAULT_SESSION_LENGTH);
        assertThat(testContentRecord.getTimeToConsume()).isEqualTo(DEFAULT_TIME_TO_CONSUME);
    }

    @Test
    public void createContentRecordWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = contentRecordRepository.findAll().size();

        // Create the ContentRecord with an existing ID
        contentRecord.setId("existing_id");
        ContentRecordDTO contentRecordDTO = contentRecordMapper.toDto(contentRecord);

        // An entity with an existing ID cannot be created, so this API call must fail
        restContentRecordMockMvc.perform(post("/api/content-records")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(contentRecordDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ContentRecord in the database
        List<ContentRecord> contentRecordList = contentRecordRepository.findAll();
        assertThat(contentRecordList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    public void getAllContentRecords() throws Exception {
        // Initialize the database
        contentRecordRepository.save(contentRecord);

        // Get all the contentRecordList
        restContentRecordMockMvc.perform(get("/api/content-records?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(contentRecord.getId())))
            .andExpect(jsonPath("$.[*].iconURL").value(hasItem(DEFAULT_ICON_URL.toString())))
            .andExpect(jsonPath("$.[*].packageLink").value(hasItem(DEFAULT_PACKAGE_LINK.toString())))
            .andExpect(jsonPath("$.[*].launchType").value(hasItem(DEFAULT_LAUNCH_TYPE.toString())))
            .andExpect(jsonPath("$.[*].owner").value(hasItem(DEFAULT_OWNER.toString())))
            .andExpect(jsonPath("$.[*].accessed").value(hasItem(DEFAULT_ACCESSED.toString())))
            .andExpect(jsonPath("$.[*].created").value(hasItem(DEFAULT_CREATED.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE.toString())))
            .andExpect(jsonPath("$.[*].url").value(hasItem(DEFAULT_URL.toString())))
            .andExpect(jsonPath("$.[*].v").value(hasItem(DEFAULT_V)))
            .andExpect(jsonPath("$.[*].launches").value(hasItem(DEFAULT_LAUNCHES)))
            .andExpect(jsonPath("$.[*].customData").value(hasItem(DEFAULT_CUSTOM_DATA.toString())))
            .andExpect(jsonPath("$.[*].mediaTypeKey").value(hasItem(DEFAULT_MEDIA_TYPE_KEY.toString())))
            .andExpect(jsonPath("$.[*].publicKey").value(hasItem(DEFAULT_PUBLIC_KEY.toString())))
            .andExpect(jsonPath("$.[*].sessionLength").value(hasItem(DEFAULT_SESSION_LENGTH)))
            .andExpect(jsonPath("$.[*].timeToConsume").value(hasItem(DEFAULT_TIME_TO_CONSUME)));
    }
    
    @Test
    public void getContentRecord() throws Exception {
        // Initialize the database
        contentRecordRepository.save(contentRecord);

        // Get the contentRecord
        restContentRecordMockMvc.perform(get("/api/content-records/{id}", contentRecord.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(contentRecord.getId()))
            .andExpect(jsonPath("$.iconURL").value(DEFAULT_ICON_URL.toString()))
            .andExpect(jsonPath("$.packageLink").value(DEFAULT_PACKAGE_LINK.toString()))
            .andExpect(jsonPath("$.launchType").value(DEFAULT_LAUNCH_TYPE.toString()))
            .andExpect(jsonPath("$.owner").value(DEFAULT_OWNER.toString()))
            .andExpect(jsonPath("$.accessed").value(DEFAULT_ACCESSED.toString()))
            .andExpect(jsonPath("$.created").value(DEFAULT_CREATED.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE.toString()))
            .andExpect(jsonPath("$.url").value(DEFAULT_URL.toString()))
            .andExpect(jsonPath("$.v").value(DEFAULT_V))
            .andExpect(jsonPath("$.launches").value(DEFAULT_LAUNCHES))
            .andExpect(jsonPath("$.customData").value(DEFAULT_CUSTOM_DATA.toString()))
            .andExpect(jsonPath("$.mediaTypeKey").value(DEFAULT_MEDIA_TYPE_KEY.toString()))
            .andExpect(jsonPath("$.publicKey").value(DEFAULT_PUBLIC_KEY.toString()))
            .andExpect(jsonPath("$.sessionLength").value(DEFAULT_SESSION_LENGTH))
            .andExpect(jsonPath("$.timeToConsume").value(DEFAULT_TIME_TO_CONSUME));
    }

    @Test
    public void getNonExistingContentRecord() throws Exception {
        // Get the contentRecord
        restContentRecordMockMvc.perform(get("/api/content-records/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateContentRecord() throws Exception {
        // Initialize the database
        contentRecordRepository.save(contentRecord);

        int databaseSizeBeforeUpdate = contentRecordRepository.findAll().size();

        // Update the contentRecord
        ContentRecord updatedContentRecord = contentRecordRepository.findById(contentRecord.getId()).get();
        updatedContentRecord
            .iconURL(UPDATED_ICON_URL)
            .packageLink(UPDATED_PACKAGE_LINK)
            .launchType(UPDATED_LAUNCH_TYPE)
            .owner(UPDATED_OWNER)
            .accessed(UPDATED_ACCESSED)
            .created(UPDATED_CREATED)
            .description(UPDATED_DESCRIPTION)
            .title(UPDATED_TITLE)
            .url(UPDATED_URL)
            .v(UPDATED_V)
            .launches(UPDATED_LAUNCHES)
            .customData(UPDATED_CUSTOM_DATA)
            .mediaTypeKey(UPDATED_MEDIA_TYPE_KEY)
            .publicKey(UPDATED_PUBLIC_KEY)
            .sessionLength(UPDATED_SESSION_LENGTH)
            .timeToConsume(UPDATED_TIME_TO_CONSUME);
        ContentRecordDTO contentRecordDTO = contentRecordMapper.toDto(updatedContentRecord);

        restContentRecordMockMvc.perform(put("/api/content-records")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(contentRecordDTO)))
            .andExpect(status().isOk());

        // Validate the ContentRecord in the database
        List<ContentRecord> contentRecordList = contentRecordRepository.findAll();
        assertThat(contentRecordList).hasSize(databaseSizeBeforeUpdate);
        ContentRecord testContentRecord = contentRecordList.get(contentRecordList.size() - 1);
        assertThat(testContentRecord.getIconURL()).isEqualTo(UPDATED_ICON_URL);
        assertThat(testContentRecord.getPackageLink()).isEqualTo(UPDATED_PACKAGE_LINK);
        assertThat(testContentRecord.getLaunchType()).isEqualTo(UPDATED_LAUNCH_TYPE);
        assertThat(testContentRecord.getOwner()).isEqualTo(UPDATED_OWNER);
        assertThat(testContentRecord.getAccessed()).isEqualTo(UPDATED_ACCESSED);
        assertThat(testContentRecord.getCreated()).isEqualTo(UPDATED_CREATED);
        assertThat(testContentRecord.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testContentRecord.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testContentRecord.getUrl()).isEqualTo(UPDATED_URL);
        assertThat(testContentRecord.getV()).isEqualTo(UPDATED_V);
        assertThat(testContentRecord.getLaunches()).isEqualTo(UPDATED_LAUNCHES);
        assertThat(testContentRecord.getCustomData()).isEqualTo(UPDATED_CUSTOM_DATA);
        assertThat(testContentRecord.getMediaTypeKey()).isEqualTo(UPDATED_MEDIA_TYPE_KEY);
        assertThat(testContentRecord.getPublicKey()).isEqualTo(UPDATED_PUBLIC_KEY);
        assertThat(testContentRecord.getSessionLength()).isEqualTo(UPDATED_SESSION_LENGTH);
        assertThat(testContentRecord.getTimeToConsume()).isEqualTo(UPDATED_TIME_TO_CONSUME);
    }

    @Test
    public void updateNonExistingContentRecord() throws Exception {
        int databaseSizeBeforeUpdate = contentRecordRepository.findAll().size();

        // Create the ContentRecord
        ContentRecordDTO contentRecordDTO = contentRecordMapper.toDto(contentRecord);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restContentRecordMockMvc.perform(put("/api/content-records")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(contentRecordDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ContentRecord in the database
        List<ContentRecord> contentRecordList = contentRecordRepository.findAll();
        assertThat(contentRecordList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteContentRecord() throws Exception {
        // Initialize the database
        contentRecordRepository.save(contentRecord);

        int databaseSizeBeforeDelete = contentRecordRepository.findAll().size();

        // Get the contentRecord
        restContentRecordMockMvc.perform(delete("/api/content-records/{id}", contentRecord.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<ContentRecord> contentRecordList = contentRecordRepository.findAll();
        assertThat(contentRecordList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ContentRecord.class);
        ContentRecord contentRecord1 = new ContentRecord();
        contentRecord1.setId("id1");
        ContentRecord contentRecord2 = new ContentRecord();
        contentRecord2.setId(contentRecord1.getId());
        assertThat(contentRecord1).isEqualTo(contentRecord2);
        contentRecord2.setId("id2");
        assertThat(contentRecord1).isNotEqualTo(contentRecord2);
        contentRecord1.setId(null);
        assertThat(contentRecord1).isNotEqualTo(contentRecord2);
    }

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ContentRecordDTO.class);
        ContentRecordDTO contentRecordDTO1 = new ContentRecordDTO();
        contentRecordDTO1.setId("id1");
        ContentRecordDTO contentRecordDTO2 = new ContentRecordDTO();
        assertThat(contentRecordDTO1).isNotEqualTo(contentRecordDTO2);
        contentRecordDTO2.setId(contentRecordDTO1.getId());
        assertThat(contentRecordDTO1).isEqualTo(contentRecordDTO2);
        contentRecordDTO2.setId("id2");
        assertThat(contentRecordDTO1).isNotEqualTo(contentRecordDTO2);
        contentRecordDTO1.setId(null);
        assertThat(contentRecordDTO1).isNotEqualTo(contentRecordDTO2);
    }
}
