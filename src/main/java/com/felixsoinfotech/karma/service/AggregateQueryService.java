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

package com.felixsoinfotech.karma.service;
/**
 * TODO Provide a detailed description here 
 * @author Owner
 * sarangibalu, sarangibalu.a@lxisoft.com
 */

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.felixsoinfotech.karma.domain.enumeration.ProofType;
import com.felixsoinfotech.karma.service.dto.ActivityDTO;

/**
 * Service Interface for managing Query services.
 */
public interface AggregateQueryService {
	
	/**
     * Get all the activities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ActivityDTO> findAll(Pageable pageable);
    
    /**
     * Get all the activities by challengeId.
     * 
	 * @param pageable the pagination information
	 * @param challengeId the challenge information
	 * @return the list of entities
	 */
	Page<ActivityDTO> findAllActivitiesByChallengeId(Pageable pageable,Long challengeId ); 
 

    /**
     * Get all the Activity with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    Page<ActivityDTO> findAllWithEagerRelationships(Pageable pageable);
    
    /**
     * Get the "id" activity.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ActivityDTO> findOne(Long id);

	/**
	 * Get all the activities by CreatedDate.
	 * 
	 * @param pageable the pagination information
	 * @param createdDateAndTime the date information
	 * @return the list of entities
	 */
	Page<ActivityDTO> findAllActivitiesByCreatedDate(Pageable pageable, ZonedDateTime createdDate);

	/**
	 * Get all the enums ProofType.
	 * 
	 * @return List of enum prooftypes values
	 */
	List<ProofType> findAllEnumProofTypes();


}
