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

	public AggregateCommandResource(AggregateCommandService aggregateCommandService) {
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
	public ResponseEntity<RegisteredUserDTO> createRegisteredUser(@RequestBody RegisteredUserDTO registeredUserDTO)
			throws URISyntaxException, IOException {
		log.debug("REST request to save RegisteredUser : {}", registeredUserDTO);
		if (registeredUserDTO.getId() != null) {
			throw new BadRequestAlertException("A new registeredUser cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		RegisteredUserDTO result = aggregateCommandService.saveRegisteredUser(registeredUserDTO);

		return ResponseEntity.created(new URI("/api/command/registered-users" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * POST /registered-users : Create a new media.
	 *
	 * @param mediaDTO the mediaDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         mediaDTO, or with status 400 (Bad Request) if the media has already
	 *         an ID
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 */
	@PostMapping("/command/media")
	@Timed
	public ResponseEntity<MediaDTO> createMedia(@RequestBody MediaDTO mediaDTO) throws URISyntaxException, IOException {
		log.debug("REST request to save Media : {}", mediaDTO);
		if (mediaDTO.getId() != null) {
			throw new BadRequestAlertException("A new media cannot already have an ID", ENTITY_NAME, "idexists");
		}
		MediaDTO result = aggregateCommandService.saveMedia(mediaDTO);
		return ResponseEntity.created(new URI("/api/command/media" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
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
	public ResponseEntity<RegisteredUserDTO> updateRegisteredUser(@RequestBody RegisteredUserDTO registeredUserDTO)
			throws URISyntaxException, IOException {
		log.debug("REST request to  resource update RegisteredUser : {}", registeredUserDTO);
		if (registeredUserDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", "RegisteredUser", "idnull");
		}

		RegisteredUserDTO result = aggregateCommandService.saveRegisteredUser(registeredUserDTO);
		return ResponseEntity.created(new URI("/api/command/registered-users" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /media : Updates an existing media.
	 *
	 * @param mediaDTO the mediaDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         mediaDTO, or with status 400 (Bad Request) if the mediaDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the mediaDTO
	 *         couldn't be updated
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 */
	@PutMapping("/command/media")
	@Timed
	public ResponseEntity<MediaDTO> updateMedia(@RequestBody MediaDTO mediaDTO) throws URISyntaxException, IOException {
		log.debug("REST request to  resource update Media : {}", mediaDTO);
		if (mediaDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", "RegisteredUser", "idnull");
		}
		MediaDTO result = aggregateCommandService.saveMedia(mediaDTO);
		return ResponseEntity.created(new URI("/api//command/media" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
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
	public ResponseEntity<CompletedActivityDTO> createCompletedActivity(
			@RequestPart CompletedActivityDTO completedActivityDTO) throws URISyntaxException, IOException {
		log.debug("REST request to save CompletedActivity : {}", completedActivityDTO);
		if (completedActivityDTO.getId() != null) {
			throw new BadRequestAlertException("A new completedActivity cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		CompletedActivityDTO result = aggregateCommandService.saveCompletedActivity(completedActivityDTO);
		return ResponseEntity.created(new URI("/api/command/completed-activities" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

}
