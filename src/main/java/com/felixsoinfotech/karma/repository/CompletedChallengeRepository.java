package com.felixsoinfotech.karma.repository;

import com.felixsoinfotech.karma.domain.CompletedChallenge;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the CompletedChallenge entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompletedChallengeRepository extends JpaRepository<CompletedChallenge, Long> {

    @Query("select completed_challenge from CompletedChallenge completed_challenge where completed_challenge.user.login = ?#{principal.username}")
    List<CompletedChallenge> findByUserIsCurrentUser();

}
