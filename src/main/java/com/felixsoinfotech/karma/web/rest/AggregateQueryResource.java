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


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codahale.metrics.annotation.Timed;
import com.felixsoinfotech.karma.domain.enumeration.ProofType;
import com.felixsoinfotech.karma.domain.enumeration.Status;
import com.felixsoinfotech.karma.domain.enumeration.Type;
import com.felixsoinfotech.karma.model.CommittedActivityAggregate;
import com.felixsoinfotech.karma.model.RegisteredUserAggregate;
import com.felixsoinfotech.karma.service.AggregateQueryService;
import com.felixsoinfotech.karma.service.dto.ActivityDTO;
import com.felixsoinfotech.karma.service.dto.ChallengeDTO;
import com.felixsoinfotech.karma.service.dto.DimensionDTO;
import com.felixsoinfotech.karma.web.rest.util.PaginationUtil;

import io.github.jhipster.web.util.ResponseUtil;


/**
 * TODO Provide a detailed description here 
 * @author Owner
 * sarangibalu, sarangibalu.a@lxisoft.com
 */

/**
 * REST controller for managing Query
 *  resources.
 */
@RestController
@RequestMapping("/api/query")
public class AggregateQueryResource {

	private final Logger log = LoggerFactory.getLogger(AggregateQueryResource.class);

   // private static final String ENTITY_NAME = "karmaAggregateQueryResource";

    private AggregateQueryService aggregateQueryService;
    
	public AggregateQueryResource(AggregateQueryService aggregateQueryService) {
		this.aggregateQueryService=aggregateQueryService;
	}
    
    /**
     * GET  /enums/proof-type : get all the enum Types.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of activities in body
     */
    @GetMapping("/enums/proof-type")
    @Timed
    public ResponseEntity<List<ProofType>> getAllEnumProofTypes(Pageable pageable) {
    	
    	
        log.debug("REST request to get a enum ProofType");
                       
        List<ProofType> proofTypes = aggregateQueryService.findAllEnumProofTypes();       
      
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(new PageImpl<ProofType>(proofTypes, pageable, proofTypes.size()),"/enums/Proof-type");
        
        return ResponseEntity.ok().headers(headers).body(proofTypes);
    }
    
    /**
     * GET /enums/type : get all the ProofTypes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of activities in body
     */
    @GetMapping("/enums/type")
    @Timed
    public ResponseEntity<List<Type>> getAllEnumTypes(Pageable pageable) {
    	
        log.debug("REST request to get a enum Types");
                       
        List<Type> types = aggregateQueryService.findAllEnumTypes();       
      
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(new PageImpl<Type>(types, pageable, types.size()),"/enums/Type");
        
        return ResponseEntity.ok().headers(headers).body(types);
    }
    
    /**
     * GET  /enums/status : get all the ProofTypes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of activities in body
     */
    @GetMapping("/enums/status")
    @Timed
    public ResponseEntity<List<Status>> getAllEnumStatus(Pageable pageable) {
    	
        log.debug("REST request to get a enum Types");
                       
        List<Status> status = aggregateQueryService.findAllEnumStatus();       
      
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(new PageImpl<Status>(status, pageable, status.size()),"/enums/status");
        
        return ResponseEntity.ok().headers(headers).body(status);
    }
    
    /**
     * GET  /dimensions : get all the dimensions.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of dimensions in body
     */
    @GetMapping("/dimensions")
    @Timed
    public ResponseEntity<List<DimensionDTO>> getAllDimensions(Pageable pageable) {
        log.debug("REST request to get a page of Dimensions");
        Page<DimensionDTO> page = aggregateQueryService.findAllDimensions(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/dimensions");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    /**
     * GET  /committed-activities/:status : get the "status" committedActivity.
     *
     * @param status the status of the committedActivityDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the committedActivityDTO, or with status 404 (Not Found)
     */
    @GetMapping("/committed-activities/{status}")
    @Timed
    public ResponseEntity<List<CommittedActivityAggregate>> getAllCommittedActivitiesByStatus(Pageable pageable,@PathVariable String status) {
        log.debug("REST request to get CommittedActivity : {}", status);
        Page<CommittedActivityAggregate> page = aggregateQueryService.findAllCommittedActivitiesByStatus(pageable,status);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/committed-activities/{status}");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    /**
     * GET  /committed-activities/:status : get the "status" committedActivity.
     *
     * @param status the status of the committedActivityDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the committedActivityDTO, or with status 404 (Not Found)
     */
    @GetMapping("/committed-activities/{status}/{registeredUserId}")
    @Timed
    public ResponseEntity<List<CommittedActivityAggregate>> getAllCommittedActivitiesByStatusAndRegisteredUserId(Pageable pageable,@PathVariable String status,@PathVariable Long registeredUserId) {
        log.debug("REST request to get CommittedActivity : {}", status, registeredUserId);
        
        Page<CommittedActivityAggregate> page = aggregateQueryService.findAllCommittedActivitiesByStatusAndRegisteredUserId(pageable,status,registeredUserId);
        
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/committed-activities/{status}/{registeredUserId}");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
          
    /**
     * GET  /registered-users/:id : get the "id" registeredUser.
     *
     * @param id the id of the registeredUserDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the registeredUserDTO, or with status 404 (Not Found)
     */
    @GetMapping("/registered-user/{userId}")
    @Timed
    public ResponseEntity<RegisteredUserAggregate> getRegisteredUserByUserId(@PathVariable String userId) {
        log.debug("REST request to get RegisteredUser : {}", userId);
        Optional<RegisteredUserAggregate> registeredUserAggregate = aggregateQueryService.findOneRegisteredUserByUserId(userId);
        return ResponseUtil.wrapOrNotFound(registeredUserAggregate);
    }

    /**
     * GET  /activities : get all the activities.
     *
     * @param pageable the pagination information
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many)
     * @return the ResponseEntity with status 200 (OK) and the list of activities in body
     */
    @GetMapping("/activities")
    @Timed
    public ResponseEntity<List<ActivityDTO>> getAllActivities(Pageable pageable, @RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get a page of Activities");
        Page<ActivityDTO> page;
        if (eagerload) {
            page = aggregateQueryService.findAllWithEagerRelationships(pageable);
        } else {
            page = aggregateQueryService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, String.format("/api/activities?eagerload=%b", eagerload));
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /challenges : get all the challenges.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of challenges in body
     */
    @GetMapping("/challenges")
    @Timed
    public ResponseEntity<List<ChallengeDTO>> getAllChallenges(Pageable pageable) {
        log.debug("REST request to get a page of Challenges");
        
        Page<ChallengeDTO> page = aggregateQueryService.findAllChallenges(pageable);
        
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/challenges");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
   
}
