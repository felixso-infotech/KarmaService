package com.lxisoft.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lxisoft.service.dto.ActivityDTO;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.dto.MediaDTO;
import com.lxisoft.service.dto.RegisteredUserDTO;

public interface AggregateService {

	/**
	 * Save a registeredUser.
	 *
	 * @param registeredUserDTO the entity to save
	 * @return the persisted entity
	 */
	RegisteredUserDTO saveRegisteredUser(RegisteredUserDTO registeredUserDTO);

	Page<RegisteredUserDTO> findAllRegisteredUsers(Pageable pageable);

	// Page<ActivityDTO> findIncompletedActivities(List<MongoEvent> completedEvents,
	// Pageable pageable);

	Optional<ActivityDTO> findActivityById(Long activityId);

	CompletedActivityDTO saveCompletedActivity(CompletedActivityDTO completedActivityDTO);

	RegisteredUserDTO updateRegisteredUser(RegisteredUserDTO registeredUserDTO);

	MediaDTO saveMedia(MediaDTO mediaDTO);

	Optional<RegisteredUserDTO> findRegisteredUserById(Long registeredUserId);

	Page<ActivityDTO> findAllActivities(Pageable pageable);

	CompletedActivityDTO findCompletedActivityById(Long completedActivityId);

	Page<CompletedActivityDTO> findCompletedActivityByRegisteredUserId(Long registeredUserId, Pageable pageable);

	Page<ActivityDTO> findIncompletedActivityByRegisteredUserId(Long registeredUserId, Pageable pageable);
}
