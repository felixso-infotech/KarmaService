package com.felixsoinfotech.karma.repository;

import com.felixsoinfotech.karma.domain.Media;


import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Media entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
	
	Optional<Media> findByCommittedActivityId(Long committedActivityId);

}
