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

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codahale.metrics.annotation.Timed;
import com.felixsoinfotech.karma.service.AggregateQueryService;
import com.felixsoinfotech.karma.service.dto.ActivityDTO;
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

    private static final String ENTITY_NAME = "karmaAggregateQueryResource";

    private AggregateQueryService aggregateQueryService;
    
	public AggregateQueryResource(AggregateQueryService aggregateQueryService) {
		this.aggregateQueryService=aggregateQueryService;
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
     * GET  /activities : get all the activities.
     *
     * @param pageable the pagination information
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many)
     * @return the ResponseEntity with status 200 (OK) and the list of activities in body
     */
	  @GetMapping("/activities/{challengeId}")
	  @Timed 
	  public ResponseEntity<List<ActivityDTO>> getAllActivitiesByChallengeId(Pageable pageable,@PathVariable Long challengeId) {
	  log.debug("REST request to get a page of Activities by challengeId");
	  
	  Page<ActivityDTO> page; 
	  page =aggregateQueryService.findAllActivitiesByChallengeId(pageable,challengeId); 	  
	  HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,"/api/activities");
	  return ResponseEntity.ok().headers(headers).body(page.getContent()); 
	  }
   
	  
	    /**
	     * GET  /activities : get all the activities.
	     *
	     * @param pageable the pagination information
	     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many)
	     * @return the ResponseEntity with status 200 (OK) and the list of activities in body
	     */
		  @GetMapping("/activities/{createdDate}")
		  @Timed 
		  public ResponseEntity<List<ActivityDTO>> getAllActivitiesByCreatedDate(Pageable pageable,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable ZonedDateTime createdDate) {
		  log.debug("REST request to get a page of Activities by challengeId");
		  
		  Page<ActivityDTO> page; 
		  page =aggregateQueryService.findAllActivitiesByCreatedDate(pageable,createdDate); 	  
		  HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,"/api/activities");
		  return ResponseEntity.ok().headers(headers).body(page.getContent()); 
		  }  
	  
	 
	  
    /**
     * GET  /activities/:id : get the "id" activity.
     *
     * @param id the id of the activityDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the activityDTO, or with status 404 (Not Found)
     */
    @GetMapping("/activities/{id}")
    @Timed
    public ResponseEntity<ActivityDTO> getActivity(@PathVariable Long id) {
        log.debug("REST request to get Activity : {}", id);
        Optional<ActivityDTO> activityDTO = aggregateQueryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(activityDTO);
    }

    
   
}
