package com.felixsoinfotech.karma.repository;

import com.felixsoinfotech.karma.domain.CompletedChallenge;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CompletedChallenge entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompletedChallengeRepository extends JpaRepository<CompletedChallenge, Long> {

}
