package com.felixsoinfotech.karma.service.impl;

import com.felixsoinfotech.karma.service.IntroductionStoryService;
import com.felixsoinfotech.karma.domain.IntroductionStory;
import com.felixsoinfotech.karma.repository.IntroductionStoryRepository;
import com.felixsoinfotech.karma.service.dto.IntroductionStoryDTO;
import com.felixsoinfotech.karma.service.mapper.IntroductionStoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing IntroductionStory.
 */
@Service
@Transactional
public class IntroductionStoryServiceImpl implements IntroductionStoryService {

    private final Logger log = LoggerFactory.getLogger(IntroductionStoryServiceImpl.class);

    private final IntroductionStoryRepository introductionStoryRepository;

    private final IntroductionStoryMapper introductionStoryMapper;

    public IntroductionStoryServiceImpl(IntroductionStoryRepository introductionStoryRepository, IntroductionStoryMapper introductionStoryMapper) {
        this.introductionStoryRepository = introductionStoryRepository;
        this.introductionStoryMapper = introductionStoryMapper;
    }

    /**
     * Save a introductionStory.
     *
     * @param introductionStoryDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public IntroductionStoryDTO save(IntroductionStoryDTO introductionStoryDTO) {
        log.debug("Request to save IntroductionStory : {}", introductionStoryDTO);

        IntroductionStory introductionStory = introductionStoryMapper.toEntity(introductionStoryDTO);
        introductionStory = introductionStoryRepository.save(introductionStory);
        return introductionStoryMapper.toDto(introductionStory);
    }

    /**
     * Get all the introductionStories.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<IntroductionStoryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all IntroductionStories");
        return introductionStoryRepository.findAll(pageable)
            .map(introductionStoryMapper::toDto);
    }


    /**
     * Get one introductionStory by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<IntroductionStoryDTO> findOne(Long id) {
        log.debug("Request to get IntroductionStory : {}", id);
        return introductionStoryRepository.findById(id)
            .map(introductionStoryMapper::toDto);
    }

    /**
     * Delete the introductionStory by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete IntroductionStory : {}", id);
        introductionStoryRepository.deleteById(id);
    }
}
