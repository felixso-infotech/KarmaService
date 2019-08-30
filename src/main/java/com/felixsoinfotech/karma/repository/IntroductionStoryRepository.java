package com.felixsoinfotech.karma.repository;

import com.felixsoinfotech.karma.domain.IntroductionStory;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the IntroductionStory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IntroductionStoryRepository extends JpaRepository<IntroductionStory, Long> {

}
