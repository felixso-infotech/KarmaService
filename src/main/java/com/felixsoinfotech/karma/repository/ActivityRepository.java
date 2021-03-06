package com.felixsoinfotech.karma.repository;

import com.felixsoinfotech.karma.domain.Activity;
import com.felixsoinfotech.karma.service.dto.ActivityDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Activity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query(value = "select distinct activity from Activity activity left join fetch activity.dimensions",
        countQuery = "select count(distinct activity) from Activity activity")
    Page<Activity> findAllWithEagerRelationships(Pageable pageable);

    @Query(value = "select distinct activity from Activity activity left join fetch activity.dimensions")
    List<Activity> findAllWithEagerRelationships();

    @Query("select activity from Activity activity left join fetch activity.dimensions where activity.id =:id")
    Optional<Activity> findOneWithEagerRelationships(@Param("id") Long id);

    /**
     * Get all the activities by challengeId.
     * 
	 * @param pageable the pagination information
	 * @param challengeId the challenge information
	 * @return the list of entities
	 */
	Page<Activity> findAllActivitiesByChallengeId(Pageable pageable, Long challengeId);

	/**
	 * Get all the activities by CreatedDateAndTime.
	 * 
	 * @param pageable the pagination information
	 * @param createdDateAndTime the date information
	 * @return the list of entities
	 */
	Page<Activity> findAllActivitiesByCreatedDate(Pageable pageable, ZonedDateTime createdDate);

}
