package com.felixsoinfotech.karma.repository;

import com.felixsoinfotech.karma.domain.CommittedActivity;
import com.felixsoinfotech.karma.domain.enumeration.Status;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


/**
 * Spring Data  repository for the CommittedActivity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommittedActivityRepository extends JpaRepository<CommittedActivity, Long> {

	/**
	 * @param id
	 * @return
	 */
	@Query(value = "select count(c) from CommittedActivity c where c.reference.id=:id")
	Long findNumberOfCommittedActivityByReferenceId(@Param("id") Long id);
	
	/**
	 * @param id
	 * @return
	 */
	@Query(value = "select count(c) from CommittedActivity c where c.registeredUser.id=:registeredUserId and c.status=:status")
	Long findNumberOfCompletedCommittedActivitiesByRegisteredUserId(@Param("registeredUserId") Long registeredUserId,@Param("status") Status status);
	
	Page<CommittedActivity> findAllCommittedActivitiesByStatusOrderByCreatedDateDesc(Pageable pageable ,Status status);
	
	Page<CommittedActivity> findAllCommittedActivitiesByStatusAndRegisteredUserIdOrderByCreatedDateDesc(Pageable pageable,Status status,Long registeredUserId);
	
	

}
