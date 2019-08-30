package com.felixsoinfotech.karma.service.impl;

import com.felixsoinfotech.karma.service.CompletedChallengeService;
import com.felixsoinfotech.karma.domain.CompletedChallenge;
import com.felixsoinfotech.karma.repository.CompletedChallengeRepository;
import com.felixsoinfotech.karma.service.dto.CompletedChallengeDTO;
import com.felixsoinfotech.karma.service.mapper.CompletedChallengeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing CompletedChallenge.
 */
@Service
@Transactional
public class CompletedChallengeServiceImpl implements CompletedChallengeService {

    private final Logger log = LoggerFactory.getLogger(CompletedChallengeServiceImpl.class);

    private final CompletedChallengeRepository completedChallengeRepository;

    private final CompletedChallengeMapper completedChallengeMapper;

    public CompletedChallengeServiceImpl(CompletedChallengeRepository completedChallengeRepository, CompletedChallengeMapper completedChallengeMapper) {
        this.completedChallengeRepository = completedChallengeRepository;
        this.completedChallengeMapper = completedChallengeMapper;
    }

    /**
     * Save a completedChallenge.
     *
     * @param completedChallengeDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public CompletedChallengeDTO save(CompletedChallengeDTO completedChallengeDTO) {
        log.debug("Request to save CompletedChallenge : {}", completedChallengeDTO);

        CompletedChallenge completedChallenge = completedChallengeMapper.toEntity(completedChallengeDTO);
        completedChallenge = completedChallengeRepository.save(completedChallenge);
        return completedChallengeMapper.toDto(completedChallenge);
    }

    /**
     * Get all the completedChallenges.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CompletedChallengeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CompletedChallenges");
        return completedChallengeRepository.findAll(pageable)
            .map(completedChallengeMapper::toDto);
    }


    /**
     * Get one completedChallenge by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CompletedChallengeDTO> findOne(Long id) {
        log.debug("Request to get CompletedChallenge : {}", id);
        return completedChallengeRepository.findById(id)
            .map(completedChallengeMapper::toDto);
    }

    /**
     * Delete the completedChallenge by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CompletedChallenge : {}", id);
        completedChallengeRepository.deleteById(id);
    }
}
