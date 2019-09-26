 /*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.felixsoinfotech.karma.service.impl;
/**
 * TODO Provide a detailed description here 
 * @author Owner
 * sarangibalu, sarangibalu.a@lxisoft.com
 */

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felixsoinfotech.karma.domain.enumeration.ProofType;
import com.felixsoinfotech.karma.domain.enumeration.Status;
import com.felixsoinfotech.karma.domain.enumeration.Type;
import com.felixsoinfotech.karma.repository.ActivityRepository;
import com.felixsoinfotech.karma.repository.CommittedActivityRepository;
import com.felixsoinfotech.karma.repository.DimensionRepository;
import com.felixsoinfotech.karma.service.AggregateQueryService;
import com.felixsoinfotech.karma.service.dto.ActivityDTO;
import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;
import com.felixsoinfotech.karma.service.dto.DimensionDTO;
import com.felixsoinfotech.karma.service.mapper.ActivityMapper;
import com.felixsoinfotech.karma.service.mapper.CommittedActivityMapper;
import com.felixsoinfotech.karma.service.mapper.DimensionMapper;

/**
 * Service Implementation for managing Queryservices
 */
@Service
@Transactional
public class AggregateQueryServiceImpl implements AggregateQueryService {

	private final Logger log = LoggerFactory.getLogger(AggregateQueryServiceImpl.class);

	private ActivityRepository activityRepository;

	private ActivityMapper activityMapper;
	
	private DimensionRepository dimensionRepository;
	
	private DimensionMapper dimensionMapper;
	
	private CommittedActivityRepository committedActivityRepository;
	
	private CommittedActivityMapper committedActivityMapper;

	public AggregateQueryServiceImpl(ActivityRepository activityRepository, ActivityMapper activityMapper,
			                         DimensionRepository dimensionRepository,DimensionMapper dimensionMapper,
			                         CommittedActivityRepository committedActivityRepository,CommittedActivityMapper committedActivityMapper) {
		this.activityRepository = activityRepository;
		this.activityMapper = activityMapper;
		this.dimensionRepository=dimensionRepository;
		this.dimensionMapper=dimensionMapper;
		this.committedActivityRepository=committedActivityRepository;
		this.committedActivityMapper=committedActivityMapper;
	}	
	
	/**
	 * Get all the enums ProofType.
	 *
	 * @return the list of enums
	 */
	@Override
	public List<ProofType> findAllEnumProofTypes(){
		
		log.debug("Request to get all Enum ProofTypes");
		
		ProofType[] proofTypes=ProofType.values();
						
		return Arrays.asList(proofTypes);
		
	}

	/**
	 * Get all the enums ProofType.
	 *
	 * @return the list of enums
	 */
	@Override
	public List<Type> findAllEnumTypes(){
		
		log.debug("Request to get all Enum Types");
		
		Type[] types=Type.values();
						
		return Arrays.asList(types);		
	}
	
	/**
	 * Get all the enums Status.
	 *
	 * @return the list of Status
	 */
	@Override
	public List<Status> findAllEnumStatus(){
		
		log.debug("Request to get all Enum Status");
		
		Status[] statuses=Status.values();
						
		return Arrays.asList(statuses);		
	}
	
	/**
     * Get all the dimensions.
     *
     * @param pageable the pagination information
     * 
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DimensionDTO> findAllDimensions(Pageable pageable) {
        log.debug("Request to get all Dimensions");
        return dimensionRepository.findAll(pageable)
            .map(dimensionMapper::toDto);
    }

    /**
     * Get all the committedActivities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CommittedActivityDTO> findAllCommittedActivities(Pageable pageable) {
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
    public Page<CommittedActivityDTO> findAllCommittedActivitiesByStatus(Pageable pageable,Status status) {
        log.debug("Request to get all CommittedActivities");
        return committedActivityRepository.findAll(pageable)
                .map(committedActivityMapper::toDto);
    }
	
	
	
}
