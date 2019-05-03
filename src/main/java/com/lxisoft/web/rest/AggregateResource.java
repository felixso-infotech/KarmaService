package com.lxisoft.web.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.lxisoft.model.ActivityModel;
import com.lxisoft.model.CompletedActivityModel;
import com.lxisoft.model.InstructionVideoModel;
import com.lxisoft.model.RegisteredUserModel;
//import com.lxisoft.client.openlrw.api.FelixsoMongoEventControllerApi;
import com.lxisoft.service.AggregateService;
import com.lxisoft.service.dto.ActivityDTO;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.dto.InstructionVideoDTO;
import com.lxisoft.service.dto.MediaDTO;
import com.lxisoft.service.dto.RegisteredUserDTO;
import com.lxisoft.web.rest.errors.BadRequestAlertException;
import com.lxisoft.web.rest.util.HeaderUtil;
import com.lxisoft.web.rest.util.PaginationUtil;

@RestController
@RequestMapping("/api")
public class AggregateResource {
	private final Logger log = LoggerFactory.getLogger(AggregateResource.class);

	private final AggregateService aggregateService;

	private static final String ENTITY_NAME = "karmaApplicationAggregate";

	public AggregateResource(AggregateService aggregateService) {
		this.aggregateService = aggregateService;
	}

	/**
	 * POST /registered-users : Create a new registeredUser.
	 *
	 * @param registeredUserDTO the registeredUserDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         registeredUserDTO, or with status 400 (Bad Request) if the
	 *         registeredUser has already an ID
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 */
	@PostMapping("/registered-users")
	@Timed
	public ResponseEntity<RegisteredUserModel> createRegisteredUser(
			@RequestBody RegisteredUserModel registeredUserModel) throws URISyntaxException, IOException {
		log.debug("REST request to save RegisteredUser : {}", registeredUserModel);
		if (registeredUserModel.getRegisteredUserId() != null) {
			throw new BadRequestAlertException("A new registeredUser cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		RegisteredUserDTO registeredUserDTO = new RegisteredUserDTO();
		registeredUserDTO.setFirstName(registeredUserModel.getFirstName());
		registeredUserDTO.setLastName(registeredUserModel.getLastName());
		registeredUserDTO.setEmail(registeredUserModel.getEmail());
		registeredUserDTO.setPhoneNumber(registeredUserModel.getPhoneNumber());
		MediaDTO mediaDTO = new MediaDTO();
		mediaDTO.setFileName(registeredUserModel.getFirstName());
		mediaDTO.setFile(registeredUserModel.getProfilePicFile());
		mediaDTO.setFileContentType(registeredUserModel.getProfilePicFileContentType());
		mediaDTO = aggregateService.saveMedia(mediaDTO);
		registeredUserDTO.setProfilePicId(mediaDTO.getId());
		RegisteredUserDTO result = aggregateService.saveRegisteredUser(registeredUserDTO);
		return ResponseEntity.created(new URI("/api/registered-users/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(registeredUserModel);
	}

	/**
	 * PUT /registered-users : Updates an existing registeredUser.
	 *
	 * @param registeredUserDTO the registeredUserDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         registeredUserDTO, or with status 400 (Bad Request) if the
	 *         registeredUserDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the registeredUserDTO couldn't be updated
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 */
	@PutMapping("/registered-users")
	@Timed
	public ResponseEntity<RegisteredUserModel> updateRegisteredUser(
			@RequestBody RegisteredUserModel registeredUserModel) throws URISyntaxException, IOException {
		log.debug("REST request to  resource update RegisteredUser : {}", registeredUserModel);
		if (registeredUserModel.getRegisteredUserId() == null) {
			throw new BadRequestAlertException("Invalid id", "RegisteredUser", "idnull");
		}
		RegisteredUserDTO registeredUserDTO = new RegisteredUserDTO();
		registeredUserDTO.setId(registeredUserModel.getRegisteredUserId());
		registeredUserDTO.setFirstName(registeredUserModel.getFirstName());
		registeredUserDTO.setLastName(registeredUserModel.getLastName());
		registeredUserDTO.setEmail(registeredUserModel.getEmail());
		registeredUserDTO.setPhoneNumber(registeredUserModel.getPhoneNumber());
		MediaDTO mediaDTO = new MediaDTO();
		mediaDTO.setId(registeredUserModel.getProfilePicId());
		mediaDTO.setFileName(registeredUserModel.getFirstName());
		mediaDTO.setFile(registeredUserModel.getProfilePicFile());
		mediaDTO.setFileContentType(registeredUserModel.getProfilePicFileContentType());
		mediaDTO = aggregateService.saveMedia(mediaDTO);
		RegisteredUserDTO result = aggregateService.saveRegisteredUser(registeredUserDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert("Need", registeredUserDTO.getId().toString()))
				.body(registeredUserModel);
	}

	/**
	 * GET /registered-users : get all the registeredUsers.
	 *
	 * @param pageable the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         registeredUsers in body
	 */

	@GetMapping("/registered-users")
	@Timed
	public ResponseEntity<List<RegisteredUserModel>> getAllRegisteredUsers(Pageable pageable) {
		log.debug("REST request to get a page of RegisteredUsers");
		Page<RegisteredUserDTO> page = aggregateService.findAllRegisteredUsers(pageable);
		List<RegisteredUserModel> registeredUserModels = new ArrayList<RegisteredUserModel>();
		for (RegisteredUserDTO registeredUserDTO : page.getContent()) {
			MediaDTO mediaDTO = aggregateService.findMediaById(registeredUserDTO.getProfilePicId()).get();
			RegisteredUserModel registeredUserModel = new RegisteredUserModel();
			registeredUserModel = registeredUserModel.setRegisteredUserId(registeredUserDTO.getId())
					.setFirstName(registeredUserDTO.getFirstName()).setLastName(registeredUserDTO.getLastName())
					.setEmail(registeredUserDTO.getEmail()).setPhoneNumber(registeredUserDTO.getPhoneNumber())
					.setNoOfCoins(registeredUserDTO.getNoOfCoins())
					.setNoOfBronzeMedals(registeredUserDTO.getNoOfBronzeMedals())
					.setNoOfSilverMedals(registeredUserDTO.getNoOfSilverMedals())
					.setNoOfGoldMedals(registeredUserDTO.getNoOfGoldMedals()).setProfilePicId(mediaDTO.getId())
					.setProfilePicFileName(mediaDTO.getFileName()).setProfilePicFile(mediaDTO.getFile())
					.setProfilePicFileContentType(mediaDTO.getFileContentType());
			registeredUserModels.add(registeredUserModel);
		}
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/registered-users");
		return ResponseEntity.ok().headers(headers).body(registeredUserModels);
	}

	/**
	 * GET /registered-users/:phoneNumber : get the "phoneNumber" registeredUser.
	 *
	 * @param phoneNumber the phoneNumber of the registeredUserDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         registeredUserModel, or with status 404 (Not Found)
	 */

	@GetMapping("/registered-users-by-phonenumber/{phoneNumber}")
	@Timed
	public ResponseEntity<RegisteredUserModel> getRegisteredUserByPhoneNumber(@PathVariable Long phoneNumber) {
		log.debug("REST request to get a RegisteredUser by phone number");
		RegisteredUserDTO registeredUserDTO = aggregateService.findRegisteredUserByPhoneNumber(phoneNumber)
				.orElse(null);
		RegisteredUserModel registeredUserModel = new RegisteredUserModel();
		if (registeredUserDTO != null) {
			MediaDTO mediaDTO = aggregateService.findMediaById(registeredUserDTO.getProfilePicId()).get();
			registeredUserModel = registeredUserModel.setRegisteredUserId(registeredUserDTO.getId())
					.setFirstName(registeredUserDTO.getFirstName()).setLastName(registeredUserDTO.getLastName())
					.setEmail(registeredUserDTO.getEmail()).setPhoneNumber(registeredUserDTO.getPhoneNumber())
					.setNoOfCoins(registeredUserDTO.getNoOfCoins())
					.setNoOfBronzeMedals(registeredUserDTO.getNoOfBronzeMedals())
					.setNoOfSilverMedals(registeredUserDTO.getNoOfSilverMedals())
					.setNoOfGoldMedals(registeredUserDTO.getNoOfGoldMedals()).setProfilePicId(mediaDTO.getId())
					.setProfilePicFileName(mediaDTO.getFileName()).setProfilePicFile(mediaDTO.getFile())
					.setProfilePicFileContentType(mediaDTO.getFileContentType());
		}
		return ResponseEntity.ok().body(registeredUserModel);
	}

	/**
	 * GET /registered-users/:id : get the "id" registeredUser.
	 *
	 * @param id the id of the registeredUserDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         registeredUserModel, or with status 404 (Not Found)
	 */
	@GetMapping("/registered-users/{id}")
	@Timed
	public ResponseEntity<RegisteredUserModel> getRegisteredUser(@PathVariable Long id) {
		log.debug("REST request to get RegisteredUser : {}", id);
		RegisteredUserDTO registeredUserDTO = aggregateService.findRegisteredUserById(id).orElse(null);
		System.out.println("&&&&&&&&&&&&&&&&7" + registeredUserDTO);
		RegisteredUserModel registeredUserModel = new RegisteredUserModel();
		if (registeredUserDTO != null) {
			MediaDTO mediaDTO = aggregateService.findMediaById(registeredUserDTO.getProfilePicId()).get();
			registeredUserModel = registeredUserModel.setRegisteredUserId(registeredUserDTO.getId())
					.setFirstName(registeredUserDTO.getFirstName()).setLastName(registeredUserDTO.getLastName())
					.setEmail(registeredUserDTO.getEmail()).setPhoneNumber(registeredUserDTO.getPhoneNumber())
					.setNoOfCoins(registeredUserDTO.getNoOfCoins())
					.setNoOfBronzeMedals(registeredUserDTO.getNoOfBronzeMedals())
					.setNoOfSilverMedals(registeredUserDTO.getNoOfSilverMedals())
					.setNoOfGoldMedals(registeredUserDTO.getNoOfGoldMedals()).setProfilePicId(mediaDTO.getId())
					.setProfilePicFileName(mediaDTO.getFileName()).setProfilePicFile(mediaDTO.getFile())
					.setProfilePicFileContentType(mediaDTO.getFileContentType());
		}
		return ResponseEntity.ok().body(registeredUserModel);
	}

	/**
	 * GET /activities/:activityId : get the "activityId" activity.
	 *
	 * @param activityId the actvityId of the activityDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         activityModel, or with status 404 (Not Found)
	 */
	@GetMapping("/activity/{activityId}")
	@Timed
	public ResponseEntity<ActivityModel> getActivityById(@PathVariable Long activityId, Pageable pageable) {
		log.debug("REST request to get a page of Activitiy");
		ActivityDTO activityDTO = aggregateService.findActivityById(activityId).orElse(null);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&77" + activityDTO);
		ActivityModel activityModel = new ActivityModel();
		if (activityDTO != null) {
			InstructionVideoDTO instructionVideoDTO = aggregateService
					.findInstructionVideoById(activityDTO.getInstructionVideoId()).orElse(null);
			activityModel.setId(activityDTO.getId()).setTitle(activityDTO.getTitle())
					.setDescription(activityDTO.getDescription()).setSuccessMessage(activityDTO.getSuccessMessage())
					.setUrl(activityDTO.getUrl()).setInstructionVideoId(instructionVideoDTO.getId());
			/*
			 * .setInstructionVideoFileName(instructionVideoDTO.getFileName())
			 * .setInstructionVideoFile(instructionVideoDTO.getFile())
			 * .setInstructionVideoFileContentType(instructionVideoDTO.getFileContentType())
			 * ;
			 */
		}
		return ResponseEntity.ok().body(activityModel);
	}

	/**
	 * GET /activities : get all the activities.
	 *
	 * @param pageable the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of activities in
	 *         body
	 */
	@GetMapping("/activities")
	@Timed
	public ResponseEntity<List<ActivityModel>> getAllActivities(Pageable pageable) {
		log.debug("REST request to get a page of Activitiy");
		Page<ActivityDTO> page = aggregateService.findAllActivities(pageable);
		List<ActivityModel> activityModels = new ArrayList<ActivityModel>();
		for (ActivityDTO activityDTO : page.getContent()) {
			ActivityModel activityModel = new ActivityModel();
			InstructionVideoDTO instructionVideoDTO = aggregateService
					.findInstructionVideoById(activityDTO.getInstructionVideoId()).orElse(null);
			activityModel.setId(activityDTO.getId()).setTitle(activityDTO.getTitle())
					.setDescription(activityDTO.getDescription()).setSuccessMessage(activityDTO.getSuccessMessage())
					.setUrl(activityDTO.getUrl()).setInstructionVideoId(instructionVideoDTO.getId());
			/*
			 * .setInstructionVideoFileName(instructionVideoDTO.getFileName())
			 * .setInstructionVideoFile(instructionVideoDTO.getFile())
			 * .setInstructionVideoFileContentType(instructionVideoDTO.getFileContentType())
			 * ;
			 */
			activityModels.add(activityModel);
		}
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/activities");
		return ResponseEntity.ok().headers(headers).body(activityModels);

	}

	/**
	 * POST /completed-activities : Create a new completedActivity.
	 *
	 * @param completedActivityModel the completedActivityDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         completedActivityDTO, or with status 400 (Bad Request) if the
	 *         completedActivity has already an ID
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 */
	@PostMapping("/completed-activities")
	@Timed
	public ResponseEntity<CompletedActivityModel> createCompletedActivity(
			@RequestPart CompletedActivityModel completedActivityModel) throws URISyntaxException, IOException {
		log.debug("REST request to save CompletedActivity : {}", completedActivityModel);
		if (completedActivityModel.getId() != null) {
			throw new BadRequestAlertException("A new completedActivity cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		CompletedActivityDTO completedActivityDTO = new CompletedActivityDTO();
		completedActivityDTO.setActivityId(completedActivityModel.getActivityId());
		completedActivityDTO.setRegisteredUserId(completedActivityModel.getRegisteredUserId());
		completedActivityDTO = aggregateService.saveCompletedActivity(completedActivityDTO);
		List<MediaDTO> mediaDTOs = completedActivityModel.getProofs();
		for (MediaDTO mediaDTO : mediaDTOs) {
			mediaDTO.setCompletedActivityId(completedActivityDTO.getId());
			aggregateService.saveMedia(mediaDTO);
		}
		return ResponseEntity.ok().body(completedActivityModel);
	}

	/**
	 * GET /completed-activity/:id : get the "completedActivityId"
	 * completedActivity.
	 *
	 * @param completedActivityId the id of the completedActivityDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         completedActivityDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/completed-activity/{completedActivityId}")
	@Timed
	public ResponseEntity<CompletedActivityModel> findCompletedActivityById(@PathVariable Long completedActivityId,
			Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get CompletedActivity by id : {}", completedActivityId);

		CompletedActivityDTO completedActivityDTO = aggregateService.findCompletedActivityById(completedActivityId)
				.orElse(null);
		CompletedActivityModel completedActivityModel = new CompletedActivityModel();
		if (completedActivityDTO != null) {
			ActivityDTO activityDTO = aggregateService.findActivityById(completedActivityDTO.getActivityId())
					.orElse(null);
			completedActivityModel.setId(completedActivityDTO.getId())
					.setRegisteredUserId(completedActivityDTO.getRegisteredUserId())
					.setActivityId(completedActivityDTO.getActivityId());
			if (activityDTO != null) {
				completedActivityModel.setActivityTitle(activityDTO.getTitle())
						.setActivityDescription(activityDTO.getDescription());
			}
			List<MediaDTO> mediaDTOs = aggregateService
					.findMediaByCompletedActivityId(completedActivityDTO.getId(), pageable).getContent();
			completedActivityModel.setProofs(mediaDTOs);
		}

		return ResponseEntity.ok().body(completedActivityModel);

	}

	/**
	 * GET /completed-activity/:registeredUserId : get the "registeredUserId"
	 * completedActivity.
	 *
	 * @param registeredUserId the id of the completedActivityDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         completedActivityDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/completed-activity-by-registered-user/{registeredUserId}")
	@Timed
	public ResponseEntity<List<CompletedActivityModel>> findCompletedActivityByRegisteredUserId(
			@PathVariable Long registeredUserId, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to save CompletedActivity");
		Page<CompletedActivityDTO> page = aggregateService.findCompletedActivityByRegisteredUserId(registeredUserId,
				pageable);
		List<CompletedActivityModel> completedActivityModels = new ArrayList<CompletedActivityModel>();
		for (CompletedActivityDTO completedActivityDTO : page.getContent()) {
			CompletedActivityModel completedActivityModel = new CompletedActivityModel();
			ActivityDTO activityDTO = aggregateService.findActivityById(completedActivityDTO.getActivityId())
					.orElse(null);
			completedActivityModel.setId(completedActivityDTO.getId())
					.setRegisteredUserId(completedActivityDTO.getRegisteredUserId())
					.setActivityId(completedActivityDTO.getActivityId());
			if (activityDTO != null) {
				completedActivityModel.setActivityTitle(activityDTO.getTitle())
						.setActivityDescription(activityDTO.getDescription());
			}
			List<MediaDTO> mediaDTOs = aggregateService
					.findMediaByCompletedActivityId(completedActivityDTO.getId(), pageable).getContent();
			completedActivityModel.setProofs(mediaDTOs);
			completedActivityModels.add(completedActivityModel);
		}
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/api/completed-activity-by-registered-user/{registeredUserId}");
		return ResponseEntity.ok().headers(headers).body(completedActivityModels);
	}

	/**
	 * GET /incompleted-activity/:registeredUserId : get the "registeredUserId"
	 * incompletedActivity.
	 *
	 * @param registeredUserId the id of the completedActivityDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         completedActivityDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/incompleted-activity-by-registered-user/{registeredUserId}")
	@Timed
	public ResponseEntity<List<ActivityModel>> findIncompletedActivityByRegisteredUserId(
			@PathVariable Long registeredUserId, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to save CompletedActivity");
		Page<ActivityDTO> page = aggregateService.findIncompletedActivityByRegisteredUserId(registeredUserId, pageable);
		List<ActivityModel> activityModels = new ArrayList<ActivityModel>();
		for (ActivityDTO activityDTO : page.getContent()) {
			ActivityModel activityModel = new ActivityModel();
			InstructionVideoDTO instructionVideoDTO = aggregateService
					.findInstructionVideoById(activityDTO.getInstructionVideoId()).orElse(null);
			activityModel.setId(activityDTO.getId()).setTitle(activityDTO.getTitle())
					.setDescription(activityDTO.getDescription()).setSuccessMessage(activityDTO.getSuccessMessage())
					.setUrl(activityDTO.getUrl()).setInstructionVideoId(instructionVideoDTO.getId());
			/*
			 * .setInstructionVideoFileName(instructionVideoDTO.getFileName())
			 * .setInstructionVideoFile(instructionVideoDTO.getFile())
			 * .setInstructionVideoFileContentType(instructionVideoDTO.getFileContentType())
			 * ;
			 */
			activityModels.add(activityModel);
		}
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/api//incompleted-activity-by-registered-user/{registeredUserId}");
		return ResponseEntity.ok().headers(headers).body(activityModels);
	}

	/**
	 * GET /completed-activity/:phoneNumber : get the "phoneNumber"
	 * completedActivity.
	 *
	 * @param phoneNumber the phoneNumber of the completedActivityDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         completedActivityDTO, or with status 404 (Not Found)
	 */

	@GetMapping("/completed-activity-by-phonenumber/{phoneNumber}")
	@Timed
	public ResponseEntity<List<CompletedActivityModel>> findCompletedActivityByRegisteredUserPhoneNumber(
			@PathVariable Long phoneNumber, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to save CompletedActivity");
		Page<CompletedActivityDTO> page = aggregateService.findCompletedActivityByRegisteredUserPhoneNumber(phoneNumber,
				pageable);
		List<CompletedActivityModel> completedActivityModels = new ArrayList<CompletedActivityModel>();
		for (CompletedActivityDTO completedActivityDTO : page.getContent()) {
			CompletedActivityModel completedActivityModel = new CompletedActivityModel();
			ActivityDTO activityDTO = aggregateService.findActivityById(completedActivityDTO.getActivityId())
					.orElse(null);
			completedActivityModel.setId(completedActivityDTO.getId())
					.setRegisteredUserId(completedActivityDTO.getRegisteredUserId())
					.setActivityId(completedActivityDTO.getActivityId());
			if (activityDTO != null) {
				completedActivityModel.setActivityTitle(activityDTO.getTitle())
						.setActivityDescription(activityDTO.getDescription());
			}
			List<MediaDTO> mediaDTOs = aggregateService
					.findMediaByCompletedActivityId(completedActivityDTO.getId(), pageable).getContent();
			completedActivityModel.setProofs(mediaDTOs);
			completedActivityModels.add(completedActivityModel);
		}
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/api/completed-activity-by-phonenumber/{phoneNumber}");
		return ResponseEntity.ok().headers(headers).body(completedActivityModels);
	}

	/**
	 * GET /incompleted-activity/:phoneNumber : get the "phoneNumber"
	 * incompletedActivity.
	 *
	 * @param registeredUserId the id of the completedActivityDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         completedActivityDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/incompleted-activity-by-phonenumber/{phoneNumber}")
	@Timed
	public ResponseEntity<List<ActivityModel>> findIncompletedActivityByRegisteredUserPhoneNumber(
			@PathVariable Long phoneNumber, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get InCompletedActivity");
		Page<ActivityDTO> page = aggregateService.findIncompletedActivityByRegisteredUserPhoneNumber(phoneNumber,
				pageable);
		List<ActivityModel> activityModels = new ArrayList<ActivityModel>();
		for (ActivityDTO activityDTO : page.getContent()) {
			ActivityModel activityModel = new ActivityModel();
			InstructionVideoDTO instructionVideoDTO = aggregateService
					.findInstructionVideoById(activityDTO.getInstructionVideoId()).orElse(null);
			activityModel.setId(activityDTO.getId()).setTitle(activityDTO.getTitle())
					.setDescription(activityDTO.getDescription()).setSuccessMessage(activityDTO.getSuccessMessage())
					.setUrl(activityDTO.getUrl()).setInstructionVideoId(instructionVideoDTO.getId());
			/*
			 * .setInstructionVideoFileName(instructionVideoDTO.getFileName())
			 * .setInstructionVideoFile(instructionVideoDTO.getFile())
			 * .setInstructionVideoFileContentType(instructionVideoDTO.getFileContentType())
			 * ;
			 */
			activityModels.add(activityModel);
		}
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/api/incompleted-activity-by-phonenumber/{phoneNumber}");
		return ResponseEntity.ok().headers(headers).body(activityModels);
	}

	/**
	 * GET /instruction-videos/:activityId : get the "activityId" of
	 * instructionVideo.
	 *
	 * @param id the id of the instructionVideoDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         instructionVideoDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/instruction-video-by-activityId/{activityId}")
	@Timed
	public ResponseEntity<InstructionVideoModel> getInstructionVideoByActivityId(@PathVariable Long activityId) {
		log.debug("REST request to get InstructionVideo : {}", activityId);
		InstructionVideoDTO instructionVideoDTO = aggregateService.findInstructionVideoByActivityId(activityId)
				.orElse(null);
		InstructionVideoModel instructionVideoModel = new InstructionVideoModel();
		if (instructionVideoDTO != null) {
			instructionVideoModel.setId(instructionVideoDTO.getId()).setFileName(instructionVideoDTO.getFileName())
					.setFile(instructionVideoDTO.getFile())
					.setFileContentType(instructionVideoDTO.getFileContentType());

		}
		return ResponseEntity.ok().body(instructionVideoModel);
	}

}
