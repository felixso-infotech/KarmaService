package com.lxisoft.service.impl;

import com.lxisoft.service.InstructionVideoService;
import com.lxisoft.domain.InstructionVideo;
import com.lxisoft.repository.InstructionVideoRepository;
import com.lxisoft.service.dto.InstructionVideoDTO;
import com.lxisoft.service.mapper.InstructionVideoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing InstructionVideo.
 */
@Service
@Transactional
public class InstructionVideoServiceImpl implements InstructionVideoService {

    private final Logger log = LoggerFactory.getLogger(InstructionVideoServiceImpl.class);

    private final InstructionVideoRepository instructionVideoRepository;

    private final InstructionVideoMapper instructionVideoMapper;

    public InstructionVideoServiceImpl(InstructionVideoRepository instructionVideoRepository, InstructionVideoMapper instructionVideoMapper) {
        this.instructionVideoRepository = instructionVideoRepository;
        this.instructionVideoMapper = instructionVideoMapper;
    }

    /**
     * Save a instructionVideo.
     *
     * @param instructionVideoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public InstructionVideoDTO save(InstructionVideoDTO instructionVideoDTO) {
        log.debug("Request to save InstructionVideo : {}", instructionVideoDTO);

        InstructionVideo instructionVideo = instructionVideoMapper.toEntity(instructionVideoDTO);
        instructionVideo = instructionVideoRepository.save(instructionVideo);
        return instructionVideoMapper.toDto(instructionVideo);
    }

    /**
     * Get all the instructionVideos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<InstructionVideoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all InstructionVideos");
        return instructionVideoRepository.findAll(pageable)
            .map(instructionVideoMapper::toDto);
    }


    /**
     * Get one instructionVideo by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<InstructionVideoDTO> findOne(Long id) {
        log.debug("Request to get InstructionVideo : {}", id);
        return instructionVideoRepository.findById(id)
            .map(instructionVideoMapper::toDto);
    }

    /**
     * Delete the instructionVideo by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete InstructionVideo : {}", id);
        instructionVideoRepository.deleteById(id);
    }
}
