package com.lxisoft.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lxisoft.domain.ContentRecord;
import com.lxisoft.repository.ContentRecordRepository;
import com.lxisoft.service.ContentRecordService;
import com.lxisoft.service.dto.ContentRecordDTO;
import com.lxisoft.service.mapper.ContentRecordMapper;

/**
 * Service Implementation for managing ContentRecord.
 */
@Service
public class ContentRecordServiceImpl implements ContentRecordService {

	private final Logger log = LoggerFactory.getLogger(ContentRecordServiceImpl.class);

	private final ContentRecordRepository contentRecordRepository;

	private final ContentRecordMapper contentRecordMapper;

	public ContentRecordServiceImpl(ContentRecordRepository contentRecordRepository,
			ContentRecordMapper contentRecordMapper) {
		this.contentRecordRepository = contentRecordRepository;
		this.contentRecordMapper = contentRecordMapper;
	}

	/**
	 * Save a contentRecord.
	 *
	 * @param contentRecordDTO the entity to save
	 * @return the persisted entity
	 */
	@Override
	public ContentRecordDTO save(ContentRecordDTO contentRecordDTO) {
		log.debug("Request to save ContentRecord : {}", contentRecordDTO);

		ContentRecord contentRecord = contentRecordMapper.toEntity(contentRecordDTO);
		contentRecord = contentRecordRepository.save(contentRecord);
		return contentRecordMapper.toDto(contentRecord);
	}

	/**
	 * Get all the contentRecords.
	 *
	 * @param pageable the pagination information
	 * @return the list of entities
	 */
	@Override
	public Page<ContentRecordDTO> findAll(Pageable pageable) {
		log.debug("Request to get all ContentRecords");
		return contentRecordRepository.findAll(pageable).map(contentRecordMapper::toDto);
	}

	/**
	 * Get one contentRecord by id.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	@Override
	public Optional<ContentRecordDTO> findOne(String id) {
		log.debug("Request to get ContentRecord : {}", id);
		return contentRecordRepository.findById(id).map(contentRecordMapper::toDto);
	}

	/**
	 * Delete the contentRecord by id.
	 *
	 * @param id the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete ContentRecord : {}", id);
		contentRecordRepository.deleteById(id);
	}
}
