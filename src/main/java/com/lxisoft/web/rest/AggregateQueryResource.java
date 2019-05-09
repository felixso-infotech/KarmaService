package com.lxisoft.web.rest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.lxisoft.model.ActivityModel;
import com.lxisoft.model.CompletedActivityModel;
import com.lxisoft.model.InstructionVideoModel;
import com.lxisoft.model.RegisteredUserModel;
import com.lxisoft.service.AggregateQueryService;
//import com.lxisoft.client.openlrw.api.FelixsoMongoEventControllerApi;
import com.lxisoft.service.dto.ActivityDTO;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.dto.InstructionVideoDTO;
import com.lxisoft.service.dto.MediaDTO;
import com.lxisoft.service.dto.RegisteredUserDTO;
import com.lxisoft.web.rest.util.PaginationUtil;

@RestController
@RequestMapping("/api")
public class AggregateQueryResource {
	private final Logger log = LoggerFactory.getLogger(AggregateQueryResource.class);
	
	private AggregateQueryService aggregateQueryService;

	 public AggregateQueryResource(AggregateQueryService aggregateQueryService)
	 {
	  this.aggregateQueryService = aggregateQueryService;
	 }
	 

	/**
	 * GET /registered-users : get all the registeredUsers.
	 *
	 * @param pageable the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         registeredUsers in body
	 */

	@GetMapping("/query/registered-users")
	@Timed
	public ResponseEntity<List<RegisteredUserModel>> getAllRegisteredUsers(Pageable pageable) {
		log.debug("REST request to get a page of RegisteredUsers");
		Page<RegisteredUserDTO> page = aggregateQueryService.findAllRegisteredUsers(pageable);
		List<RegisteredUserModel> registeredUserModels = new ArrayList<RegisteredUserModel>();
		
		for (RegisteredUserDTO registeredUserDTO : page.getContent()) {
			MediaDTO mediaDTO = aggregateQueryService.findMediaById(registeredUserDTO.getProfilePicId()).get();
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

	@GetMapping("/query/registered-users-by-phonenumber/{phoneNumber}")
	@Timed
	public ResponseEntity<RegisteredUserModel> getRegisteredUserByPhoneNumber(@PathVariable Long phoneNumber) {
		log.debug("REST request to get a RegisteredUser by phone number");
		RegisteredUserDTO registeredUserDTO = aggregateQueryService.findRegisteredUserByPhoneNumber(phoneNumber)
				.orElse(null);
		RegisteredUserModel registeredUserModel = new RegisteredUserModel();
		if (registeredUserDTO != null) {
			MediaDTO mediaDTO = aggregateQueryService.findMediaById(registeredUserDTO.getProfilePicId()).get();
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
	@GetMapping("/query/registered-users/{id}")
	@Timed
	public ResponseEntity<RegisteredUserModel> getRegisteredUser(@PathVariable Long id) {
		log.debug("REST request to get RegisteredUser : {}", id);
		RegisteredUserDTO registeredUserDTO = aggregateQueryService.findRegisteredUserById(id).orElse(null);
		//System.out.println("&&&&&&&&&&&&&&&&7" + registeredUserDTO);
		RegisteredUserModel registeredUserModel = new RegisteredUserModel();
		if (registeredUserDTO != null) {
			MediaDTO mediaDTO = aggregateQueryService.findMediaById(registeredUserDTO.getProfilePicId()).get();
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
	@GetMapping("/query/activity/{activityId}")
	@Timed
	public ResponseEntity<ActivityModel> getActivityById(@PathVariable Long activityId, Pageable pageable) {
		log.debug("REST request to get a activitiy");
		ActivityDTO activityDTO = aggregateQueryService.findActivityById(activityId).orElse(null);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&77" + activityDTO);
		ActivityModel activityModel = new ActivityModel();
		if (activityDTO != null) {
			InstructionVideoDTO instructionVideoDTO = aggregateQueryService
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
	@GetMapping("/query/activities")
	@Timed
	public ResponseEntity<List<ActivityModel>> getAllActivities(Pageable pageable) {
		log.debug("REST request to get a page of Activitiy");
		Page<ActivityDTO> page = aggregateQueryService.findAllActivities(pageable);
		List<ActivityModel> activityModels = new ArrayList<ActivityModel>();
		for (ActivityDTO activityDTO : page.getContent()) {
			ActivityModel activityModel = new ActivityModel();
			InstructionVideoDTO instructionVideoDTO = aggregateQueryService
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
	 * GET /completed-activity/:id : get the "completedActivityId"
	 * completedActivity.
	 *
	 * @param completedActivityId the id of the completedActivityDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         completedActivityDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/query/completed-activity/{completedActivityId}")
	@Timed
	public ResponseEntity<CompletedActivityModel> findCompletedActivityById(@PathVariable Long completedActivityId,
			Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get CompletedActivity by id : {}", completedActivityId);

		CompletedActivityDTO completedActivityDTO = aggregateQueryService.findCompletedActivityById(completedActivityId)
				.orElse(null);
		CompletedActivityModel completedActivityModel = new CompletedActivityModel();
		if (completedActivityDTO != null) {
			ActivityDTO activityDTO = aggregateQueryService.findActivityById(completedActivityDTO.getActivityId())
					.orElse(null);
			completedActivityModel.setId(completedActivityDTO.getId())
					.setRegisteredUserId(completedActivityDTO.getRegisteredUserId())
					.setActivityId(completedActivityDTO.getActivityId());
			if (activityDTO != null) {
				completedActivityModel.setActivityTitle(activityDTO.getTitle())
						.setActivityDescription(activityDTO.getDescription());
			}
			List<MediaDTO> mediaDTOs = aggregateQueryService
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
	@GetMapping("/query/completed-activity-by-registered-user/{registeredUserId}")
	@Timed
	public ResponseEntity<List<CompletedActivityModel>> findCompletedActivityByRegisteredUserId(
			@PathVariable Long registeredUserId, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get completedActivity by registeredUderId : {}", registeredUserId);
		Page<CompletedActivityDTO> page = aggregateQueryService.findCompletedActivityByRegisteredUserId(registeredUserId,
				pageable);
		List<CompletedActivityModel> completedActivityModels = new ArrayList<CompletedActivityModel>();
		for (CompletedActivityDTO completedActivityDTO : page.getContent()) {
			CompletedActivityModel completedActivityModel = new CompletedActivityModel();
			ActivityDTO activityDTO = aggregateQueryService.findActivityById(completedActivityDTO.getActivityId())
					.orElse(null);
			completedActivityModel.setId(completedActivityDTO.getId())
					.setRegisteredUserId(completedActivityDTO.getRegisteredUserId())
					.setActivityId(completedActivityDTO.getActivityId());
			if (activityDTO != null) {
				completedActivityModel.setActivityTitle(activityDTO.getTitle())
						.setActivityDescription(activityDTO.getDescription());
			}
			List<MediaDTO> mediaDTOs = aggregateQueryService
					.findMediaByCompletedActivityId(completedActivityDTO.getId(), pageable).getContent();
			completedActivityModel.setProofs(mediaDTOs);
			completedActivityModels.add(completedActivityModel);
		}
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/api/completed-activity-by-registered-user/{registeredUserId}");
		return ResponseEntity.ok().headers(headers).body(completedActivityModels);
	}

	/**
	 * GET /completed-activity/:phoneNumber : get the "phoneNumber"
	 * completedActivity.
	 *
	 * @param phoneNumber the phoneNumber of the completedActivityDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         completedActivityDTO, or with status 404 (Not Found)
	 */

	@GetMapping("/query/completed-activity-by-phonenumber/{phoneNumber}")
	@Timed
	public ResponseEntity<List<CompletedActivityModel>> findCompletedActivityByRegisteredUserPhoneNumber(
			@PathVariable Long phoneNumber, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get completedActivity by phoneNumber : {}", phoneNumber);
		Page<CompletedActivityDTO> page = aggregateQueryService.findCompletedActivityByRegisteredUserPhoneNumber(phoneNumber,
				pageable);
		List<CompletedActivityModel> completedActivityModels = new ArrayList<CompletedActivityModel>();
		for (CompletedActivityDTO completedActivityDTO : page.getContent()) {
			CompletedActivityModel completedActivityModel = new CompletedActivityModel();
			ActivityDTO activityDTO = aggregateQueryService.findActivityById(completedActivityDTO.getActivityId())
					.orElse(null);
			completedActivityModel.setId(completedActivityDTO.getId())
					.setRegisteredUserId(completedActivityDTO.getRegisteredUserId())
					.setActivityId(completedActivityDTO.getActivityId());
			if (activityDTO != null) {
				completedActivityModel.setActivityTitle(activityDTO.getTitle())
						.setActivityDescription(activityDTO.getDescription());
			}
			List<MediaDTO> mediaDTOs = aggregateQueryService
					.findMediaByCompletedActivityId(completedActivityDTO.getId(), pageable).getContent();
			completedActivityModel.setProofs(mediaDTOs);
			completedActivityModels.add(completedActivityModel);
		}
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/api/completed-activity-by-phonenumber/{phoneNumber}");
		return ResponseEntity.ok().headers(headers).body(completedActivityModels);
	}

	/**
	 * GET /instruction-videos/:activityId : get the "activityId" of
	 * instructionVideo.
	 *
	 * @param id the id of the instructionVideoDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         instructionVideoDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/query/instruction-video-by-activityId/{activityId}")
	@Timed
	public ResponseEntity<InstructionVideoModel> getInstructionVideoByActivityId(@PathVariable Long activityId) {
		log.debug("REST request to get InstructionVideo : {}", activityId);
		InstructionVideoDTO instructionVideoDTO = aggregateQueryService.findInstructionVideoByActivityId(activityId)
				.orElse(null);
		InstructionVideoModel instructionVideoModel = new InstructionVideoModel();
		if (instructionVideoDTO != null) {
			instructionVideoModel.setId(instructionVideoDTO.getId()).setFileName(instructionVideoDTO.getFileName())
					.setFile(instructionVideoDTO.getFile())
					.setFileContentType(instructionVideoDTO.getFileContentType());

		}
		return ResponseEntity.ok().body(instructionVideoModel);
	}

	/**
	 * GET /incompleted-activity/:registeredUserId : get the "registeredUserId"
	 * incompletedActivity.
	 *
	 * @param registeredUserId the id of the completedActivityDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         completedActivityDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/query/incompleted-activity-by-registered-user/{registeredUserId}")
	@Timed
	public ResponseEntity<List<ActivityModel>> findIncompletedActivityByRegisteredUserIdByQuery(
			@PathVariable Long registeredUserId, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get incompletedActivity by registeredUserId: {}", registeredUserId);
		Page<ActivityDTO> page = aggregateQueryService.findIncompletedActivityByRegisteredUserId(registeredUserId, pageable);
		List<ActivityModel> activityModels = new ArrayList<ActivityModel>();
		for (ActivityDTO activityDTO : page.getContent()) {
			ActivityModel activityModel = new ActivityModel();
			InstructionVideoDTO instructionVideoDTO = aggregateQueryService
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
				"/api/incompleted-activity-by-registered-user-by-query/{registeredUserId}");
		return ResponseEntity.ok().headers(headers).body(activityModels);
	}

	/**
	 * GET /incompleted-activity/:registeredUserId : get the "registeredUserId"
	 * incompletedActivity.
	 *
	 * @param registeredUserId the id of the completedActivityDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         completedActivityDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/query/incompleted-activity-by-phone-number/{phoneNumber}")
	@Timed
	public ResponseEntity<List<ActivityModel>> findIncompletedActivityByPhoneNumberByQuery(
			@PathVariable Long phoneNumber, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get incompletedActivity by phoneNumber: {}", phoneNumber);
		Page<ActivityDTO> page = aggregateQueryService.findIncompletedActivityByRegisteredUserPhoneNumber(phoneNumber,
				pageable);
		List<ActivityModel> activityModels = new ArrayList<ActivityModel>();
		for (ActivityDTO activityDTO : page.getContent()) {
			ActivityModel activityModel = new ActivityModel();
			InstructionVideoDTO instructionVideoDTO = aggregateQueryService
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
				"/api/incompleted-activity-by-phone-number-query/{phoneNumber}");
		return ResponseEntity.ok().headers(headers).body(activityModels);
	}

}
