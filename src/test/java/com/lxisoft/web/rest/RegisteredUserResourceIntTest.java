package com.lxisoft.web.rest;

import com.lxisoft.KarmaApp;

import com.lxisoft.domain.RegisteredUser;
import com.lxisoft.repository.RegisteredUserRepository;
import com.lxisoft.service.RegisteredUserService;
import com.lxisoft.service.dto.RegisteredUserDTO;
import com.lxisoft.service.mapper.RegisteredUserMapper;
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
 * Test class for the RegisteredUserResource REST controller.
 *
 * @see RegisteredUserResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KarmaApp.class)
public class RegisteredUserResourceIntTest {

    private static final String DEFAULT_FIRST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FIRST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LAST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final Long DEFAULT_PHONE_NUMBER = 1L;
    private static final Long UPDATED_PHONE_NUMBER = 2L;

    private static final Long DEFAULT_NO_OF_COINS = 1L;
    private static final Long UPDATED_NO_OF_COINS = 2L;

    private static final Long DEFAULT_NO_OF_BRONZE_MEDALS = 1L;
    private static final Long UPDATED_NO_OF_BRONZE_MEDALS = 2L;

    private static final Long DEFAULT_NO_OF_SILVER_MEDALS = 1L;
    private static final Long UPDATED_NO_OF_SILVER_MEDALS = 2L;

    private static final Long DEFAULT_NO_OF_GOLD_MEDALS = 1L;
    private static final Long UPDATED_NO_OF_GOLD_MEDALS = 2L;

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    @Autowired
    private RegisteredUserMapper registeredUserMapper;

    @Autowired
    private RegisteredUserService registeredUserService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRegisteredUserMockMvc;

    private RegisteredUser registeredUser;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RegisteredUserResource registeredUserResource = new RegisteredUserResource(registeredUserService);
        this.restRegisteredUserMockMvc = MockMvcBuilders.standaloneSetup(registeredUserResource)
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
    public static RegisteredUser createEntity(EntityManager em) {
        RegisteredUser registeredUser = new RegisteredUser()
            .firstName(DEFAULT_FIRST_NAME)
            .lastName(DEFAULT_LAST_NAME)
            .email(DEFAULT_EMAIL)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .noOfCoins(DEFAULT_NO_OF_COINS)
            .noOfBronzeMedals(DEFAULT_NO_OF_BRONZE_MEDALS)
            .noOfSilverMedals(DEFAULT_NO_OF_SILVER_MEDALS)
            .noOfGoldMedals(DEFAULT_NO_OF_GOLD_MEDALS);
        return registeredUser;
    }

    @Before
    public void initTest() {
        registeredUser = createEntity(em);
    }

    @Test
    @Transactional
    public void createRegisteredUser() throws Exception {
        int databaseSizeBeforeCreate = registeredUserRepository.findAll().size();

        // Create the RegisteredUser
        RegisteredUserDTO registeredUserDTO = registeredUserMapper.toDto(registeredUser);
        restRegisteredUserMockMvc.perform(post("/api/registered-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(registeredUserDTO)))
            .andExpect(status().isCreated());

        // Validate the RegisteredUser in the database
        List<RegisteredUser> registeredUserList = registeredUserRepository.findAll();
        assertThat(registeredUserList).hasSize(databaseSizeBeforeCreate + 1);
        RegisteredUser testRegisteredUser = registeredUserList.get(registeredUserList.size() - 1);
        assertThat(testRegisteredUser.getFirstName()).isEqualTo(DEFAULT_FIRST_NAME);
        assertThat(testRegisteredUser.getLastName()).isEqualTo(DEFAULT_LAST_NAME);
        assertThat(testRegisteredUser.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testRegisteredUser.getPhoneNumber()).isEqualTo(DEFAULT_PHONE_NUMBER);
        assertThat(testRegisteredUser.getNoOfCoins()).isEqualTo(DEFAULT_NO_OF_COINS);
        assertThat(testRegisteredUser.getNoOfBronzeMedals()).isEqualTo(DEFAULT_NO_OF_BRONZE_MEDALS);
        assertThat(testRegisteredUser.getNoOfSilverMedals()).isEqualTo(DEFAULT_NO_OF_SILVER_MEDALS);
        assertThat(testRegisteredUser.getNoOfGoldMedals()).isEqualTo(DEFAULT_NO_OF_GOLD_MEDALS);
    }

    @Test
    @Transactional
    public void createRegisteredUserWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = registeredUserRepository.findAll().size();

        // Create the RegisteredUser with an existing ID
        registeredUser.setId(1L);
        RegisteredUserDTO registeredUserDTO = registeredUserMapper.toDto(registeredUser);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRegisteredUserMockMvc.perform(post("/api/registered-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(registeredUserDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RegisteredUser in the database
        List<RegisteredUser> registeredUserList = registeredUserRepository.findAll();
        assertThat(registeredUserList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRegisteredUsers() throws Exception {
        // Initialize the database
        registeredUserRepository.saveAndFlush(registeredUser);

        // Get all the registeredUserList
        restRegisteredUserMockMvc.perform(get("/api/registered-users?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(registeredUser.getId().intValue())))
            .andExpect(jsonPath("$.[*].firstName").value(hasItem(DEFAULT_FIRST_NAME.toString())))
            .andExpect(jsonPath("$.[*].lastName").value(hasItem(DEFAULT_LAST_NAME.toString())))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL.toString())))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER.intValue())))
            .andExpect(jsonPath("$.[*].noOfCoins").value(hasItem(DEFAULT_NO_OF_COINS.intValue())))
            .andExpect(jsonPath("$.[*].noOfBronzeMedals").value(hasItem(DEFAULT_NO_OF_BRONZE_MEDALS.intValue())))
            .andExpect(jsonPath("$.[*].noOfSilverMedals").value(hasItem(DEFAULT_NO_OF_SILVER_MEDALS.intValue())))
            .andExpect(jsonPath("$.[*].noOfGoldMedals").value(hasItem(DEFAULT_NO_OF_GOLD_MEDALS.intValue())));
    }
    
    @Test
    @Transactional
    public void getRegisteredUser() throws Exception {
        // Initialize the database
        registeredUserRepository.saveAndFlush(registeredUser);

        // Get the registeredUser
        restRegisteredUserMockMvc.perform(get("/api/registered-users/{id}", registeredUser.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(registeredUser.getId().intValue()))
            .andExpect(jsonPath("$.firstName").value(DEFAULT_FIRST_NAME.toString()))
            .andExpect(jsonPath("$.lastName").value(DEFAULT_LAST_NAME.toString()))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL.toString()))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER.intValue()))
            .andExpect(jsonPath("$.noOfCoins").value(DEFAULT_NO_OF_COINS.intValue()))
            .andExpect(jsonPath("$.noOfBronzeMedals").value(DEFAULT_NO_OF_BRONZE_MEDALS.intValue()))
            .andExpect(jsonPath("$.noOfSilverMedals").value(DEFAULT_NO_OF_SILVER_MEDALS.intValue()))
            .andExpect(jsonPath("$.noOfGoldMedals").value(DEFAULT_NO_OF_GOLD_MEDALS.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingRegisteredUser() throws Exception {
        // Get the registeredUser
        restRegisteredUserMockMvc.perform(get("/api/registered-users/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRegisteredUser() throws Exception {
        // Initialize the database
        registeredUserRepository.saveAndFlush(registeredUser);

        int databaseSizeBeforeUpdate = registeredUserRepository.findAll().size();

        // Update the registeredUser
        RegisteredUser updatedRegisteredUser = registeredUserRepository.findById(registeredUser.getId()).get();
        // Disconnect from session so that the updates on updatedRegisteredUser are not directly saved in db
        em.detach(updatedRegisteredUser);
        updatedRegisteredUser
            .firstName(UPDATED_FIRST_NAME)
            .lastName(UPDATED_LAST_NAME)
            .email(UPDATED_EMAIL)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .noOfCoins(UPDATED_NO_OF_COINS)
            .noOfBronzeMedals(UPDATED_NO_OF_BRONZE_MEDALS)
            .noOfSilverMedals(UPDATED_NO_OF_SILVER_MEDALS)
            .noOfGoldMedals(UPDATED_NO_OF_GOLD_MEDALS);
        RegisteredUserDTO registeredUserDTO = registeredUserMapper.toDto(updatedRegisteredUser);

        restRegisteredUserMockMvc.perform(put("/api/registered-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(registeredUserDTO)))
            .andExpect(status().isOk());

        // Validate the RegisteredUser in the database
        List<RegisteredUser> registeredUserList = registeredUserRepository.findAll();
        assertThat(registeredUserList).hasSize(databaseSizeBeforeUpdate);
        RegisteredUser testRegisteredUser = registeredUserList.get(registeredUserList.size() - 1);
        assertThat(testRegisteredUser.getFirstName()).isEqualTo(UPDATED_FIRST_NAME);
        assertThat(testRegisteredUser.getLastName()).isEqualTo(UPDATED_LAST_NAME);
        assertThat(testRegisteredUser.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testRegisteredUser.getPhoneNumber()).isEqualTo(UPDATED_PHONE_NUMBER);
        assertThat(testRegisteredUser.getNoOfCoins()).isEqualTo(UPDATED_NO_OF_COINS);
        assertThat(testRegisteredUser.getNoOfBronzeMedals()).isEqualTo(UPDATED_NO_OF_BRONZE_MEDALS);
        assertThat(testRegisteredUser.getNoOfSilverMedals()).isEqualTo(UPDATED_NO_OF_SILVER_MEDALS);
        assertThat(testRegisteredUser.getNoOfGoldMedals()).isEqualTo(UPDATED_NO_OF_GOLD_MEDALS);
    }

    @Test
    @Transactional
    public void updateNonExistingRegisteredUser() throws Exception {
        int databaseSizeBeforeUpdate = registeredUserRepository.findAll().size();

        // Create the RegisteredUser
        RegisteredUserDTO registeredUserDTO = registeredUserMapper.toDto(registeredUser);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRegisteredUserMockMvc.perform(put("/api/registered-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(registeredUserDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RegisteredUser in the database
        List<RegisteredUser> registeredUserList = registeredUserRepository.findAll();
        assertThat(registeredUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRegisteredUser() throws Exception {
        // Initialize the database
        registeredUserRepository.saveAndFlush(registeredUser);

        int databaseSizeBeforeDelete = registeredUserRepository.findAll().size();

        // Get the registeredUser
        restRegisteredUserMockMvc.perform(delete("/api/registered-users/{id}", registeredUser.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RegisteredUser> registeredUserList = registeredUserRepository.findAll();
        assertThat(registeredUserList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RegisteredUser.class);
        RegisteredUser registeredUser1 = new RegisteredUser();
        registeredUser1.setId(1L);
        RegisteredUser registeredUser2 = new RegisteredUser();
        registeredUser2.setId(registeredUser1.getId());
        assertThat(registeredUser1).isEqualTo(registeredUser2);
        registeredUser2.setId(2L);
        assertThat(registeredUser1).isNotEqualTo(registeredUser2);
        registeredUser1.setId(null);
        assertThat(registeredUser1).isNotEqualTo(registeredUser2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RegisteredUserDTO.class);
        RegisteredUserDTO registeredUserDTO1 = new RegisteredUserDTO();
        registeredUserDTO1.setId(1L);
        RegisteredUserDTO registeredUserDTO2 = new RegisteredUserDTO();
        assertThat(registeredUserDTO1).isNotEqualTo(registeredUserDTO2);
        registeredUserDTO2.setId(registeredUserDTO1.getId());
        assertThat(registeredUserDTO1).isEqualTo(registeredUserDTO2);
        registeredUserDTO2.setId(2L);
        assertThat(registeredUserDTO1).isNotEqualTo(registeredUserDTO2);
        registeredUserDTO1.setId(null);
        assertThat(registeredUserDTO1).isNotEqualTo(registeredUserDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(registeredUserMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(registeredUserMapper.fromId(null)).isNull();
    }
}
