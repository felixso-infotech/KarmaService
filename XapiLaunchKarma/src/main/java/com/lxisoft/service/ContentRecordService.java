package com.lxisoft.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lxisoft.service.dto.ContentRecordDTO;

/**
 * Service Interface for managing ContentRecord.
 */
public interface ContentRecordService {

	/**
	 * Save a contentRecord.
	 *
	 * @param contentRecordDTO the entity to save
	 * @return the persisted entity
	 */
	ContentRecordDTO save(ContentRecordDTO contentRecordDTO);

	/**
	 * Get all the contentRecords.
	 *
	 * @param pageable the pagination information
	 * @return the list of entities
	 */
	Page<ContentRecordDTO> findAll(Pageable pageable);

	/**
	 * Get the "id" contentRecord.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	Optional<ContentRecordDTO> findOne(String id);

	/**
	 * Delete the "id" contentRecord.
	 *
	 * @param id the id of the entity
	 */
	void delete(String id);

}
