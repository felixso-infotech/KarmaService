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

package com.felixsoinfotech.karma.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codahale.metrics.annotation.Timed;
import com.felixsoinfotech.karma.model.ActivityAggregate;
import com.felixsoinfotech.karma.model.CommittedActivityStatusAggregate;
import com.felixsoinfotech.karma.service.AggregateCommandService;
import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;
import com.felixsoinfotech.karma.service.dto.RegisteredUserDTO;
import com.felixsoinfotech.karma.web.rest.errors.BadRequestAlertException;
import com.felixsoinfotech.karma.web.rest.util.HeaderUtil;


/**
 * TODO Provide a detailed description here 
 * @author Owner
 * sarangibalu, sarangibalu.a@lxisoft.com
 */
/**
 * REST controller for managing Command resources.
 */
@RestController
@RequestMapping("/api/command")
public class AggregateCommandResource {
	
	private final Logger log = LoggerFactory.getLogger(AggregateCommandResource.class);

    private static final String ENTITY_NAME = "karmaAggregateCommandResource";

    private AggregateCommandService aggregateCommandService;

	public AggregateCommandResource(AggregateCommandService aggregateCommandService) {
		this.aggregateCommandService=aggregateCommandService;
	}
	
	  /**
     * POST  /activities : Create a new activity.
     *
     * @param activityDTO the activityDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new activityDTO, or with status 400 (Bad Request) if the activity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/activities")
    @Timed
    public ResponseEntity<ActivityAggregate> createActivity(@RequestBody ActivityAggregate activityAggregate) throws URISyntaxException {
        log.debug("REST request to save Activity : {}", activityAggregate);
        if (activityAggregate.getActivityDTO().getId() != null) {
            throw new BadRequestAlertException("A new activity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ActivityAggregate result = aggregateCommandService.saveActivity(activityAggregate);
        
        return ResponseEntity.created(new URI("/api/activities/" + activityAggregate.getActivityDTO().getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, activityAggregate.getActivityDTO().getId().toString()))
                .body(result);
    }
    
    /**
     * PUT  /activities : Updates an existing activity.
     *
     * @param activityDTO the activityDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated activityDTO,
     * or with status 400 (Bad Request) if the activityDTO is not valid,
     * or with status 500 (Internal Server Error) if the activityDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/activities")
    @Timed
    public ResponseEntity<ActivityAggregate> updateActivity(@RequestBody ActivityAggregate activityAggregate) throws URISyntaxException {
        log.debug("REST request to update Activity : {}", activityAggregate);
        if (activityAggregate.getActivityDTO().getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        
        ActivityAggregate result = aggregateCommandService.saveActivity(activityAggregate);
        
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, activityAggregate.getActivityDTO().getId().toString()))
            .body(result);
    }  


    /**
     * POST  /committed-activities : Create a new committedActivity.
     *
     * @param committedActivityDTO the committedActivityDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new committedActivityDTO, or with status 400 (Bad Request) if the committedActivity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/committed-activities")
    @Timed
    public ResponseEntity<CommittedActivityStatusAggregate> createCommittedActivity(@RequestBody CommittedActivityStatusAggregate committedActivityStatusAggregate) throws URISyntaxException {
        log.debug("REST request to save CommittedActivity : {}", committedActivityStatusAggregate);
        
        if (committedActivityStatusAggregate.getCommittedActivityId() != null) {
            throw new BadRequestAlertException("A new committedActivity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        
        CommittedActivityStatusAggregate result = aggregateCommandService.saveCommittedActivity(committedActivityStatusAggregate);
        
        return ResponseEntity.created(new URI("/api/committed-activities/" + result.getCommittedActivityId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getCommittedActivityId().toString()))
            .body(result);
    }
    
    
    /**
     * PUT  /committed-activities : Updates an existing committedActivity.
     *
     * @param committedActivityDTO the committedActivityDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated committedActivityDTO,
     * or with status 400 (Bad Request) if the committedActivityDTO is not valid,
     * or with status 500 (Internal Server Error) if the committedActivityDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/committed-activities")
    @Timed
    public ResponseEntity<CommittedActivityStatusAggregate> updateCommittedActivity(@RequestBody CommittedActivityStatusAggregate committedActivityStatusAggregate) throws URISyntaxException {
        log.debug("REST request to update CommittedActivity : {}", committedActivityStatusAggregate);
        if (committedActivityStatusAggregate.getCommittedActivityId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CommittedActivityStatusAggregate result = aggregateCommandService.saveCommittedActivity(committedActivityStatusAggregate);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, committedActivityStatusAggregate.getCommittedActivityId().toString()))
            .body(result);
    }
    
    /**
     * POST  /registered-users : Create a new registeredUser.
     *
     * @param registeredUserDTO the registeredUserDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new registeredUserDTO, or with status 400 (Bad Request) if the registeredUser has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/registered-users")
    @Timed
    public ResponseEntity<RegisteredUserDTO> createRegisteredUser(@RequestBody RegisteredUserDTO registeredUserDTO) throws URISyntaxException {
        log.debug("REST request to save RegisteredUser : {}", registeredUserDTO);
        if (registeredUserDTO.getId() != null) {
            throw new BadRequestAlertException("A new registeredUser cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RegisteredUserDTO result = aggregateCommandService.saveRegisteredUser(registeredUserDTO);
        return ResponseEntity.created(new URI("/api/registered-users/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * PUT  /registered-users : Updates an existing registeredUser.
     *
     * @param registeredUserDTO the registeredUserDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated registeredUserDTO,
     * or with status 400 (Bad Request) if the registeredUserDTO is not valid,
     * or with status 500 (Internal Server Error) if the registeredUserDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/registered-users")
    @Timed
    public ResponseEntity<RegisteredUserDTO> updateRegisteredUser(@RequestBody RegisteredUserDTO registeredUserDTO) throws URISyntaxException {
        log.debug("REST request to update RegisteredUser : {}", registeredUserDTO);
        if (registeredUserDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RegisteredUserDTO result = aggregateCommandService.saveRegisteredUser(registeredUserDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, registeredUserDTO.getId().toString()))
            .body(result);
    }
    
    /**
     * DELETE  /registered-users/:id : delete the "id" registeredUser.
     *
     * @param id the id of the registeredUserDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/registered-users/{id}")
    @Timed
    public ResponseEntity<Void> deleteRegisteredUser(@PathVariable Long id) {
        log.debug("REST request to delete RegisteredUser : {}", id);
        aggregateCommandService.deleteRegisteredUser(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

   

}
