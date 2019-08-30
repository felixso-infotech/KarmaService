package com.lxisoft.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lxisoft.service.dto.ActivityDTO;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.dto.InstructionVideoDTO;
import com.lxisoft.service.dto.MediaDTO;
import com.lxisoft.service.dto.RegisteredUserDTO;

public interface AggregateQueryService {

	/**
	 * Get all the registeredUsers.
	 *
	 * @param pageable the pagination information
	 * @return the list of entities
	 */
	Page<RegisteredUserDTO> findAllRegisteredUsers(Pageable pageable);

	/**
	 * Get one registeredUser by phoneNumber.
	 *
	 * @param phoneNUmber the phoneNumber of the entity
	 * @return the entity
	 */
	Optional<RegisteredUserDTO> findRegisteredUserByPhoneNumber(Long phoneNumber);

	/**
	 * Get one registeredUser by id.
	 *
	 * @param registeredUser the id of the entity
	 * @return the entity
	 */
	Optional<RegisteredUserDTO> findRegisteredUserById(Long id);

	/**
	 * Get one activity by id.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	Optional<ActivityDTO> findActivityById(Long activityId);

	/**
	 * Get one media by id.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	Optional<MediaDTO> findMediaById(Long mediaId);

	/**
	 * Get all the activities.
	 *
	 * @param pageable the pagination information
	 * @return the list of entities
	 */
	Page<ActivityDTO> findAllActivities(Pageable pageable);

	/**
	 * Get one completedActivity by id.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	Optional<CompletedActivityDTO> findCompletedActivityById(Long completedActivityId);

	/**
	 * Get one completedActivity by registeredUserId.
	 *
	 * @param registeredUserId the id of the entity
	 * @return the list of entity
	 */
	Page<CompletedActivityDTO> findCompletedActivityByRegisteredUserId(Long registeredUserId, Pageable pageable);

	/**
	 * Get list of incompletedActivity by registeredUserId.
	 *
	 * @param registeredUserId the id of the entity
	 * @return the list of entity
	 */
	Page<ActivityDTO> findIncompletedActivityByRegisteredUserId(Long registeredUserId, Pageable pageable);

	/**
	 * Get list of completedActivity by phoneNumber.
	 *
	 * @param registeredUserId the id of the entity
	 * @return the list of entity
	 */
	Page<CompletedActivityDTO> findCompletedActivityByRegisteredUserPhoneNumber(Long phoneNumber, Pageable pageable);

	/**
	 * Get list of incompletedActivity by phoneNumber.
	 *
	 * @param phoneNumber the id of the entity
	 * @return the list of entity
	 */
	Page<ActivityDTO> findIncompletedActivityByRegisteredUserPhoneNumber(Long phoneNumber, Pageable pageable);

	/**
	 * Get one instructionVideo by activityId.
	 *
	 * @param activityId the id of the activity of instruction video
	 * @return the entity
	 * @throws IOException
	 *//*
		 * Optional<InstructionVideoDTO> findInstructionVideoByActivityId(Long
		 * activityId) throws IOException;
		 */
	/**
	 * Get one instructionVideo by id.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	Optional<InstructionVideoDTO> findInstructionVideoById(Long id);

	/**
	 * Get list of media by activityId.
	 *
	 * @param activityId the id of the entity
	 * @return the list of entity
	 */
	Page<MediaDTO> findMediaByActivityId(Long activiytId, Pageable pageable);

	/**
	 * Get list of media by completedActivityId.
	 *
	 * @param completedActivityId the id of the entity
	 * @return the list of entity
	 */
	Page<MediaDTO> findMediaByCompletedActivityId(Long completedActivityId, Pageable pageable);

	/**
	 * Get one registeredUser by userIdd.
	 *
	 * @param userId the id of the entity
	 * @return the entity
	 */
	Optional<RegisteredUserDTO> findRegisteredUserByUserId(String userId);

	/**
	 * Get list of medias by registeredUserId.
	 *
	 * @param registeredUserId the id of the user
	 * @return the list of entity
	 */
	Page<MediaDTO> findAllCompletedActivityMediasByRegisteredUserId(Long registeredUserId, Pageable pageable);
}
