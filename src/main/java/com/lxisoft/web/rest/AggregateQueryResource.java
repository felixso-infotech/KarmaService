package com.lxisoft.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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
import com.lxisoft.service.AggregateQueryService;
//import com.lxisoft.client.openlrw.api.FelixsoMongoEventControllerApi;
import com.lxisoft.service.dto.ActivityDTO;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.dto.InstructionVideoDTO;
import com.lxisoft.service.dto.MediaDTO;
import com.lxisoft.service.dto.RegisteredUserDTO;
import com.lxisoft.web.rest.util.PaginationUtil;

import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class AggregateQueryResource {
	private final Logger log = LoggerFactory.getLogger(AggregateQueryResource.class);

	private AggregateQueryService aggregateQueryService;

	public AggregateQueryResource(AggregateQueryService aggregateQueryService) {
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
	public ResponseEntity<List<RegisteredUserDTO>> getAllRegisteredUsers(Pageable pageable) {
		log.debug("REST request to get a page of RegisteredUsers");
		Page<RegisteredUserDTO> page = aggregateQueryService.findAllRegisteredUsers(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/query/registered-users");
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	/**
	 * GET /media : get media.
	 *
	 * @return the ResponseEntity with status 200 (OK) and with body the mediaDTO,
	 *         or with status 404 (Not Found)
	 */

	@GetMapping("/query/media/{id}")
	@Timed
	public ResponseEntity<MediaDTO> getMediaById(@PathVariable Long id) {
		log.debug("REST request to get media:{}", id);
		Optional<MediaDTO> mediaDTO = aggregateQueryService.findMediaById(id);
		return ResponseUtil.wrapOrNotFound(mediaDTO);
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
	public ResponseEntity<RegisteredUserDTO> getRegisteredUserByPhoneNumber(@PathVariable Long phoneNumber) {
		log.debug("REST request to get a RegisteredUser by phone number");
		Optional<RegisteredUserDTO> registeredUserDTO = aggregateQueryService
				.findRegisteredUserByPhoneNumber(phoneNumber);
		return ResponseUtil.wrapOrNotFound(registeredUserDTO);
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
	public ResponseEntity<RegisteredUserDTO> getRegisteredUserById(@PathVariable Long id) {
		log.debug("REST request to get RegisteredUser : {}", id);
		Optional<RegisteredUserDTO> registeredUserDTO = aggregateQueryService.findRegisteredUserById(id);

		return ResponseUtil.wrapOrNotFound(registeredUserDTO);
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
	public ResponseEntity<ActivityDTO> getActivityById(@PathVariable Long activityId) {
		log.debug("REST request to get a activitiy");
		Optional<ActivityDTO> activityDTO = aggregateQueryService.findActivityById(activityId);
		return ResponseUtil.wrapOrNotFound(activityDTO);
	}

	/**
	 * GET /query/instruction-video/:instructionVideoId : get the
	 * "instructionVideoId" instruction video.
	 *
	 * @param instructionVideoId the instructionVideoId of the instructionVideoDTO
	 *                           to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         instructionVideoDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/query/instruction-video/{instructionVideoId}")
	@Timed
	public ResponseEntity<InstructionVideoDTO> getInstructionVideoById(@PathVariable Long instructionVideoId) {
		log.debug("REST request to get a instructionvideo");
		Optional<InstructionVideoDTO> instructionVideoDTO = aggregateQueryService
				.findInstructionVideoById(instructionVideoId);
		return ResponseUtil.wrapOrNotFound(instructionVideoDTO);
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
	public ResponseEntity<List<ActivityDTO>> getAllActivities(Pageable pageable) {
		log.debug("REST request to get a page of Activitiy");
		Page<ActivityDTO> page = aggregateQueryService.findAllActivities(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/activities");
		return ResponseEntity.ok().headers(headers).body(page.getContent());

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
	public ResponseEntity<CompletedActivityDTO> getCompletedActivityById(@PathVariable Long completedActivityId)
			throws URISyntaxException {
		log.debug("REST request to get CompletedActivity by id : {}", completedActivityId);

		Optional<CompletedActivityDTO> completedActivityDTO = aggregateQueryService
				.findCompletedActivityById(completedActivityId);
		return ResponseUtil.wrapOrNotFound(completedActivityDTO);
	}

	/**
	 * GET /activities : get all the activities.
	 *
	 * @param pageable the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of activities in
	 *         body
	 */
	@GetMapping("/query/completed-activity-media/{completedActivityId}")
	@Timed
	public ResponseEntity<List<MediaDTO>> getMediaByCompletedActivityId(@PathVariable Long completedActivityId,
			Pageable pageable) throws URISyntaxException {

		Page<MediaDTO> page = aggregateQueryService.findMediaByCompletedActivityId(completedActivityId, pageable);

		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/api/query/completed-activity/{completedActivityId}");
		return ResponseEntity.ok().headers(headers).body(page.getContent());
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
	public ResponseEntity<List<CompletedActivityDTO>> getCompletedActivityByRegisteredUserId(
			@PathVariable Long registeredUserId, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get completedActivity by registeredUderId : {}", registeredUserId);
		Page<CompletedActivityDTO> page = aggregateQueryService
				.findCompletedActivityByRegisteredUserId(registeredUserId, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/api/query/completed-activity-by-registered-user/{registeredUserId}");
		return ResponseEntity.ok().headers(headers).body(page.getContent());
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
	public ResponseEntity<List<CompletedActivityDTO>> getCompletedActivityByRegisteredUserPhoneNumber(
			@PathVariable Long phoneNumber, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get completedActivity by phoneNumber : {}", phoneNumber);
		Page<CompletedActivityDTO> page = aggregateQueryService
				.findCompletedActivityByRegisteredUserPhoneNumber(phoneNumber, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/api/query/completed-activity-by-phonenumber/{phoneNumber}");
		return ResponseEntity.ok().headers(headers).body(page.getContent());
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
	public ResponseEntity<InstructionVideoDTO> getInstructionVideoByActivityId(@PathVariable Long activityId) {
		log.debug("REST request to get InstructionVideo : {}", activityId);
		Optional<InstructionVideoDTO> instructionVideoDTO = aggregateQueryService
				.findInstructionVideoByActivityId(activityId);
		return ResponseUtil.wrapOrNotFound(instructionVideoDTO);
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
	public ResponseEntity<List<ActivityDTO>> findIncompletedActivityByRegisteredUserId(
			@PathVariable Long registeredUserId, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get incompletedActivity by registeredUserId: {}", registeredUserId);
		Page<ActivityDTO> page = aggregateQueryService.findIncompletedActivityByRegisteredUserId(registeredUserId,
				pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/api/incompleted-activity-by-registered-user-by-query/{registeredUserId}");
		return ResponseEntity.ok().headers(headers).body(page.getContent());
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
	public ResponseEntity<List<ActivityDTO>> findIncompletedActivityByPhoneNumber(@PathVariable Long phoneNumber,
			Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get incompletedActivity by phoneNumber: {}", phoneNumber);
		Page<ActivityDTO> page = aggregateQueryService.findIncompletedActivityByRegisteredUserPhoneNumber(phoneNumber,
				pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/api/incompleted-activity-by-phone-number-query/{phoneNumber}");
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	/**
	 * GET /registered-user/:userId : get the "userId" registeredUser.
	 *
	 * @param userId the id of the registeredUserDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         registeredUserDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/query/registered-user/userId")
	@Timed
	public ResponseEntity<RegisteredUserDTO> getRegisteredUserByUserId(@PathVariable String userId) {
		log.debug("REST request to get RegisteredUser : {}", userId);
		Optional<RegisteredUserDTO> registeredUserDTO = aggregateQueryService.findRegisteredUserByUserId(userId);
		return ResponseUtil.wrapOrNotFound(registeredUserDTO);
	}

}
