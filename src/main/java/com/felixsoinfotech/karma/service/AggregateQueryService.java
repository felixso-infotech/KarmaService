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
import com.felixsoinfotech.karma.domain.enumeration.Status;
import com.felixsoinfotech.karma.domain.enumeration.Type;
import com.felixsoinfotech.karma.model.RegisteredUserAggregate;
import com.felixsoinfotech.karma.service.dto.ActivityDTO;
import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;
import com.felixsoinfotech.karma.service.dto.DimensionDTO;
import com.felixsoinfotech.karma.service.dto.RegisteredUserDTO;

/**
 * Service Interface for managing Query services.
 */
public interface AggregateQueryService {
	   
	/**
	 * Get all the enums ProofType.
	 * 
	 * @return List of enum prooftypes values
	 */
	List<ProofType> findAllEnumProofTypes();

	/**
	 * Get all the enums Type.
	 * 
	 * @return List of enum Types values
	 */
	List<Type> findAllEnumTypes();
	
	/**
	 * Get all the enums Status.
	 * 
	 * @return List of enum Status values
	 */
	List<Status> findAllEnumStatus();

	/**
	 * Get all the dimensions.
	 * 
	 * @return List of Dimensions
	 */
	Page<DimensionDTO> findAllDimensions(Pageable pageable);

	/**
     * Get the "status" committedActivity.
     *
     * @param status the status of the entity
     * @return the entity
     */
	Page<CommittedActivityDTO> findAllCommittedActivitiesByStatus(Pageable pageable,Status status);


    /**
     * Get all the committedActivities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<CommittedActivityDTO> findAllCommittedActivities(Pageable pageable);

    /**
     * Get the "id" registeredUser.
     *
     * @param id the id of the entity
     * @return the entity
     */
	Optional<RegisteredUserAggregate> findOneRegisteredUserByUserId(String userId);
	
	



    

}
