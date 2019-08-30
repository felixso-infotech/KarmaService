package com.felixsoinfotech.karma.service.impl;

import com.felixsoinfotech.karma.service.CommittedActivityService;
import com.felixsoinfotech.karma.domain.CommittedActivity;
import com.felixsoinfotech.karma.repository.CommittedActivityRepository;
import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;
import com.felixsoinfotech.karma.service.mapper.CommittedActivityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing CommittedActivity.
 */
@Service
@Transactional
public class CommittedActivityServiceImpl implements CommittedActivityService {

    private final Logger log = LoggerFactory.getLogger(CommittedActivityServiceImpl.class);

    private final CommittedActivityRepository committedActivityRepository;

    private final CommittedActivityMapper committedActivityMapper;

    public CommittedActivityServiceImpl(CommittedActivityRepository committedActivityRepository, CommittedActivityMapper committedActivityMapper) {
        this.committedActivityRepository = committedActivityRepository;
        this.committedActivityMapper = committedActivityMapper;
    }

    /**
     * Save a committedActivity.
     *
     * @param committedActivityDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public CommittedActivityDTO save(CommittedActivityDTO committedActivityDTO) {
        log.debug("Request to save CommittedActivity : {}", committedActivityDTO);

        CommittedActivity committedActivity = committedActivityMapper.toEntity(committedActivityDTO);
        committedActivity = committedActivityRepository.save(committedActivity);
        return committedActivityMapper.toDto(committedActivity);
    }

    /**
     * Get all the committedActivities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CommittedActivityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CommittedActivities");
        return committedActivityRepository.findAll(pageable)
            .map(committedActivityMapper::toDto);
    }


    /**
     * Get one committedActivity by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CommittedActivityDTO> findOne(Long id) {
        log.debug("Request to get CommittedActivity : {}", id);
        return committedActivityRepository.findById(id)
            .map(committedActivityMapper::toDto);
    }

    /**
     * Delete the committedActivity by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CommittedActivity : {}", id);
        committedActivityRepository.deleteById(id);
    }
}
