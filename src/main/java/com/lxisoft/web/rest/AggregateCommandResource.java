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
package com.lxisoft.web.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.lxisoft.model.CompletedActivityModel;
import com.lxisoft.model.RegisteredUserModel;
import com.lxisoft.service.AggregateCommandService;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.dto.MediaDTO;
import com.lxisoft.service.dto.RegisteredUserDTO;
import com.lxisoft.web.rest.errors.BadRequestAlertException;
import com.lxisoft.web.rest.util.HeaderUtil;

@RestController
@RequestMapping("/api")
public class AggregateCommandResource {
	
	private final Logger log = LoggerFactory.getLogger(AggregateCommandResource.class);

	
	private final AggregateCommandService aggregateCommandService;

	private static final String ENTITY_NAME = "karmaApplicationAggregateCommandResource";

	 public AggregateCommandResource(AggregateCommandService aggregateCommandService)
	 { 
		 this.aggregateCommandService = aggregateCommandService; 
	 }
	 

	/**
	 * POST /registered-users : Create a new registeredUser.
	 *
	 * @param registeredUserDTO the registeredUserDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         registeredUserDTO, or with status 400 (Bad Request) if the
	 *         registeredUser has already an ID
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 */
	@PostMapping("/command/registered-users")
	@Timed
	public ResponseEntity<RegisteredUserModel> createRegisteredUser(
			@RequestBody RegisteredUserModel registeredUserModel) throws URISyntaxException, IOException {
		log.debug("REST request to save RegisteredUser : {}", registeredUserModel);
		if (registeredUserModel.getRegisteredUserId() != null) {
			throw new BadRequestAlertException("A new registeredUser cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		
		RegisteredUserDTO registeredUserDTO = new RegisteredUserDTO();
		registeredUserDTO.setFirstName(registeredUserModel.getFirstName());
		registeredUserDTO.setLastName(registeredUserModel.getLastName());
		registeredUserDTO.setEmail(registeredUserModel.getEmail());
		registeredUserDTO.setPhoneNumber(registeredUserModel.getPhoneNumber());
		
		MediaDTO mediaDTO = new MediaDTO();
		mediaDTO.setFileName(registeredUserModel.getFirstName());
		mediaDTO.setFile(registeredUserModel.getProfilePicFile());
		mediaDTO.setFileContentType(registeredUserModel.getProfilePicFileContentType());
		mediaDTO = aggregateCommandService.saveMedia(mediaDTO);
		registeredUserDTO.setProfilePicId(mediaDTO.getId());
		
		RegisteredUserDTO result = aggregateCommandService.saveRegisteredUser(registeredUserDTO);
		
		return ResponseEntity.created(new URI("/api/registered-users/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(registeredUserModel);
	}

	/**
	 * PUT /registered-users : Updates an existing registeredUser.
	 *
	 * @param registeredUserDTO the registeredUserDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         registeredUserDTO, or with status 400 (Bad Request) if the
	 *         registeredUserDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the registeredUserDTO couldn't be updated
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 */
	@PutMapping("/command/registered-users")
	@Timed
	public ResponseEntity<RegisteredUserModel> updateRegisteredUser(
			@RequestBody RegisteredUserModel registeredUserModel) throws URISyntaxException, IOException {
		log.debug("REST request to  resource update RegisteredUser : {}", registeredUserModel);
		if (registeredUserModel.getRegisteredUserId() == null) {
			throw new BadRequestAlertException("Invalid id", "RegisteredUser", "idnull");
		}
		
		RegisteredUserDTO registeredUserDTO = new RegisteredUserDTO();
		registeredUserDTO.setId(registeredUserModel.getRegisteredUserId());
		registeredUserDTO.setFirstName(registeredUserModel.getFirstName());
		registeredUserDTO.setLastName(registeredUserModel.getLastName());
		registeredUserDTO.setEmail(registeredUserModel.getEmail());
		registeredUserDTO.setPhoneNumber(registeredUserModel.getPhoneNumber());
		
		MediaDTO mediaDTO = new MediaDTO();
		mediaDTO.setId(registeredUserModel.getProfilePicId());
		mediaDTO.setFileName(registeredUserModel.getFirstName());
		mediaDTO.setFile(registeredUserModel.getProfilePicFile());
		mediaDTO.setFileContentType(registeredUserModel.getProfilePicFileContentType());
		mediaDTO = aggregateCommandService.saveMedia(mediaDTO);
		
		RegisteredUserDTO result = aggregateCommandService.saveRegisteredUser(registeredUserDTO);
		return ResponseEntity.created(new URI("/api/registered-users/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(registeredUserModel);
	}

	/**
	 * POST /completed-activities : Create a new completedActivity.
	 *
	 * @param completedActivityModel the completedActivityDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         completedActivityDTO, or with status 400 (Bad Request) if the
	 *         completedActivity has already an ID
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 */
	@PostMapping("/command/completed-activities")
	@Timed
	public ResponseEntity<CompletedActivityModel> createCompletedActivity(
			@RequestPart CompletedActivityModel completedActivityModel) throws URISyntaxException, IOException {
		log.debug("REST request to save CompletedActivity : {}", completedActivityModel);
		if (completedActivityModel.getId() != null) {
			throw new BadRequestAlertException("A new completedActivity cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		CompletedActivityDTO completedActivityDTO = new CompletedActivityDTO();
		completedActivityDTO.setActivityId(completedActivityModel.getActivityId());
		completedActivityDTO.setRegisteredUserId(completedActivityModel.getRegisteredUserId());
		completedActivityDTO = aggregateCommandService.saveCompletedActivity(completedActivityDTO);
		List<MediaDTO> mediaDTOs = completedActivityModel.getProofs();
		for (MediaDTO mediaDTO : mediaDTOs) {
			mediaDTO.setCompletedActivityId(completedActivityDTO.getId());
			aggregateCommandService.saveMedia(mediaDTO);
		}
		return ResponseEntity.ok().body(completedActivityModel);
	}

}
