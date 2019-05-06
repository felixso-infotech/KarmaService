package com.lxisoft.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lxisoft.domain.Activity;

/**
 * Spring Data repository for the Activity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

	@Query(value = "select * from activity where id not in(select activityid_id from completed_activity where registered_user_id= ?1)", nativeQuery = true)
	Page<Activity> findIncompletedActivitiesByQuery(@Param("registeredUserId") Long registeredUserId,
			Pageable pageable);

	@Query(value = "select * from activity where id not in(select activityid_id from completed_activity where registered_user_id=(select id from registered_user where phone_number= ?1))", nativeQuery = true)
	Page<Activity> findIncompletedActivitiesByPhoneNumber(@Param("phoneNumber") Long phoneNumber, Pageable pageable);

}
