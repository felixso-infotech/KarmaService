package com.lxisoft.service;

import com.lxisoft.service.dto.InstructionVideoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing InstructionVideo.
 */
public interface InstructionVideoService {

    /**
     * Save a instructionVideo.
     *
     * @param instructionVideoDTO the entity to save
     * @return the persisted entity
     */
    InstructionVideoDTO save(InstructionVideoDTO instructionVideoDTO);

    /**
     * Get all the instructionVideos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<InstructionVideoDTO> findAll(Pageable pageable);


    /**
     * Get the "id" instructionVideo.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<InstructionVideoDTO> findOne(Long id);

    /**
     * Delete the "id" instructionVideo.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
