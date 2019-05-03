package com.lxisoft.service.impl;

import com.lxisoft.service.CompletedActivityService;
import com.lxisoft.domain.CompletedActivity;
import com.lxisoft.repository.CompletedActivityRepository;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.mapper.CompletedActivityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing CompletedActivity.
 */
@Service
@Transactional
public class CompletedActivityServiceImpl implements CompletedActivityService {

    private final Logger log = LoggerFactory.getLogger(CompletedActivityServiceImpl.class);

    private final CompletedActivityRepository completedActivityRepository;

    private final CompletedActivityMapper completedActivityMapper;

    public CompletedActivityServiceImpl(CompletedActivityRepository completedActivityRepository, CompletedActivityMapper completedActivityMapper) {
        this.completedActivityRepository = completedActivityRepository;
        this.completedActivityMapper = completedActivityMapper;
    }

    /**
     * Save a completedActivity.
     *
     * @param completedActivityDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public CompletedActivityDTO save(CompletedActivityDTO completedActivityDTO) {
        log.debug("Request to save CompletedActivity : {}", completedActivityDTO);

        CompletedActivity completedActivity = completedActivityMapper.toEntity(completedActivityDTO);
        completedActivity = completedActivityRepository.save(completedActivity);
        return completedActivityMapper.toDto(completedActivity);
    }

    /**
     * Get all the completedActivities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CompletedActivityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CompletedActivities");
        return completedActivityRepository.findAll(pageable)
            .map(completedActivityMapper::toDto);
    }


    /**
     * Get one completedActivity by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CompletedActivityDTO> findOne(Long id) {
        log.debug("Request to get CompletedActivity : {}", id);
        return completedActivityRepository.findById(id)
            .map(completedActivityMapper::toDto);
    }

    /**
     * Delete the completedActivity by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CompletedActivity : {}", id);
        completedActivityRepository.deleteById(id);
    }
}
