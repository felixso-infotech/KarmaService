package com.felixsoinfotech.karma.repository;

import com.felixsoinfotech.karma.domain.CommittedActivity;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


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

}
