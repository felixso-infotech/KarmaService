package com.felixsoinfotech.karma.service;

import com.felixsoinfotech.karma.service.dto.IntroductionStoryDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing IntroductionStory.
 */
public interface IntroductionStoryService {

    /**
     * Save a introductionStory.
     *
     * @param introductionStoryDTO the entity to save
     * @return the persisted entity
     */
    IntroductionStoryDTO save(IntroductionStoryDTO introductionStoryDTO);

    /**
     * Get all the introductionStories.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<IntroductionStoryDTO> findAll(Pageable pageable);


    /**
     * Get the "id" introductionStory.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<IntroductionStoryDTO> findOne(Long id);

    /**
     * Delete the "id" introductionStory.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
