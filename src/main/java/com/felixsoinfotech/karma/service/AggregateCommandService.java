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

import com.felixsoinfotech.karma.model.ActivityAggregate;
import com.felixsoinfotech.karma.model.CommittedActivityProfileAggregate;
import com.felixsoinfotech.karma.model.CommittedActivityStatusAggregate;
import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;
import com.felixsoinfotech.karma.service.dto.RegisteredUserDTO;


/**
 * TODO Provide a detailed description here 
 * @author Owner
 * sarangibalu, sarangibalu.a@lxisoft.com
 */

/**
 * Service Interface for managing Command services.
 */
public interface AggregateCommandService   {
	
	/**
     * Save a activity.
     *
     * @param activityAggregate the entity to save
     * @return the persisted entity
     */
	ActivityAggregate saveActivity(ActivityAggregate activityAggregate);

	/**
     * Save a committedActivity.
     *
     * @param committedActivityDTO the entity to save
     * @return the persisted entity
     */
	CommittedActivityStatusAggregate saveCommittedActivity(CommittedActivityStatusAggregate committedActivityStatusAggregate);
	
	/**
     * Save a registeredUser.
     *
     * @param registeredUserDTO the entity to save
     * @return the persisted entity
     */
    RegisteredUserDTO saveRegisteredUser(RegisteredUserDTO registeredUserDTO);
    
    /**
     * Delete the "id" registeredUser.
     *
     * @param id the id of the entity
     */
    void deleteRegisteredUser(Long id);

	
	
}
