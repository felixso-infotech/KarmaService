package com.felixsoinfotech.karma.repository;

import com.felixsoinfotech.karma.domain.CommittedActivity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the CommittedActivity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommittedActivityRepository extends JpaRepository<CommittedActivity, Long> {

    @Query("select committed_activity from CommittedActivity committed_activity where committed_activity.user.login = ?#{principal.username}")
    List<CommittedActivity> findByUserIsCurrentUser();

}
