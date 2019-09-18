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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codahale.metrics.annotation.Timed;
import com.felixsoinfotech.karma.model.ActivityAggregate;
import com.felixsoinfotech.karma.service.AggregateCommandService;
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
        
        return ResponseEntity.created(new URI("/api/activities/" + result.getActivityDTO().getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getActivityDTO().toString()))
            .body(result);
    }

    
    
   

}
