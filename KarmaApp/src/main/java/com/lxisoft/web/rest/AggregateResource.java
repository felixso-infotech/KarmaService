package com.lxisoft.web.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
//import com.lxisoft.client.openlrw.api.FelixsoMongoEventControllerApi;
import com.lxisoft.service.AggregateService;
import com.lxisoft.service.dto.ActivityDTO;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.dto.RegisteredUserDTO;
import com.lxisoft.web.rest.errors.BadRequestAlertException;
import com.lxisoft.web.rest.util.HeaderUtil;
import com.lxisoft.web.rest.util.PaginationUtil;

import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class AggregateResource {
	private final Logger log = LoggerFactory.getLogger(AggregateResource.class);

	private final AggregateService aggregateService;

	private static final String ENTITY_NAME = "karmaApplicationAggregate";

	// private final FelixsoMongoEventControllerApi felixsoMongoEventControllerApi;

	public AggregateResource(AggregateService aggregateService) {
		this.aggregateService = aggregateService;
	}

	@PostMapping("/registeredUser")
	@Timed
	public ResponseEntity<RegisteredUserDTO> createRegisteredUser(@RequestBody RegisteredUserDTO registeredUserDTO)
			throws URISyntaxException, IOException {
		log.debug("REST request to save RegisteredUser : {}", registeredUserDTO);
		if (registeredUserDTO.getId() != null) {
			throw new BadRequestAlertException("A new registeredUser cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		RegisteredUserDTO result = aggregateService.saveRegisteredUser(registeredUserDTO);
		return ResponseEntity.created(new URI("/api/registeredUser/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

//to be edited
	@PutMapping("/registeredUser")
	@Timed
	public ResponseEntity<RegisteredUserDTO> updateRegisteredUser(@RequestBody RegisteredUserDTO registeredUserDTO)
			throws URISyntaxException, IOException {
		log.debug("REST request to  resource update RegisteredUser : {}", registeredUserDTO);
		if (registeredUserDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", "RegisteredUser", "idnull");
		}
		RegisteredUserDTO result = aggregateService.updateRegisteredUser(registeredUserDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert("Need", registeredUserDTO.getId().toString())).body(result);
	}

	@GetMapping("/registeredUsers")
	@Timed
	public ResponseEntity<List<RegisteredUserDTO>> getAllRegisteredUsers(Pageable pageable) {
		log.debug("REST request to get a page of RegisteredUsers");
		Page<RegisteredUserDTO> page = aggregateService.findAllRegisteredUsers(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/registeredUsers");
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	@GetMapping("/registeredUser/{registeredUserId}")
	@Timed
	public ResponseEntity<RegisteredUserDTO> getRegisteredUser(@PathVariable Long registeredUserId) {
		log.debug("REST request to get a RegisteredUser");
		Optional<RegisteredUserDTO> registeredUserDTO = aggregateService.findRegisteredUserById(registeredUserId);
		return ResponseUtil.wrapOrNotFound(registeredUserDTO);
	}

//*****************************************************************************************************************
	/*
	 * @GetMapping("/incompletedActivities/{userId}")
	 * 
	 * @Timed public ResponseEntity<List<ActivityDTO>>
	 * getAllIncompletedActivities(@PathVariable String userId, Pageable pageable) {
	 * log.debug("REST request to get a page of Activities"); List<MongoEvent>
	 * completedEvents = felixsoMongoEventControllerApi
	 * .getMongoEventsByUserIdAndActionUsingGET(userId, "completed").getBody();
	 * Page<ActivityDTO> page =
	 * aggregateService.findIncompletedActivities(completedEvents, pageable);
	 * HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
	 * "/karma-api/incompletedActivities/{userId}"); return
	 * ResponseEntity.ok().headers(headers).body(page.getContent());
	 * 
	 * }
	 */
//**************************************************************************88

	@GetMapping("/activity/{activityId}")
	@Timed
	public ResponseEntity<ActivityDTO> getActivityById(@PathVariable Long activityId) {
		log.debug("REST request to get a page of Activitiy");
		Optional<ActivityDTO> activityDTO = aggregateService.findActivityById(activityId);
		return ResponseUtil.wrapOrNotFound(activityDTO);
	}

	@GetMapping("/activity")
	@Timed
	public ResponseEntity<List<ActivityDTO>> getAllActivities(Pageable pageable) {
		System.out.println("*****************************************");
		log.debug("REST request to get a page of Activitiy");
		Page<ActivityDTO> page = aggregateService.findAllActivities(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/activity");
		return ResponseEntity.ok().headers(headers).body(page.getContent());

	}
	// ***************************************************************************

	@PostMapping("/completedActivity")
	@Timed
	public ResponseEntity<CompletedActivityDTO> createCompletedActivity(
			@RequestPart CompletedActivityDTO completedActivityDTO) throws URISyntaxException, IOException {
		log.debug("REST request to save CompletedActivity : {}", completedActivityDTO);
		if (completedActivityDTO.getId() != null) {
			throw new BadRequestAlertException("A new completedActivity cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		completedActivityDTO = aggregateService.saveCompletedActivity(completedActivityDTO);
		return ResponseEntity.ok().body(completedActivityDTO);
	}

	@GetMapping("/completedActivity/{completedActivityId}")
	@Timed
	public ResponseEntity<CompletedActivityDTO> findCompletedActivityById(@PathVariable Long completedActivityId)
			throws URISyntaxException {
		log.debug("REST request to get CompletedActivity by id : {}", completedActivityId);

		CompletedActivityDTO completedActivityDTO = aggregateService.findCompletedActivityById(completedActivityId);
		return ResponseEntity.ok().body(completedActivityDTO);

	}

	@GetMapping("/completedActivity/{registeredUserId}")
	@Timed
	public ResponseEntity<List<CompletedActivityDTO>> findCompletedActivityByRegisteredUserId(
			@PathVariable Long registeredUserId, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to save CompletedActivity");
		Page<CompletedActivityDTO> page = aggregateService.findCompletedActivityByRegisteredUserId(registeredUserId,
				pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/completedActivity/{registeredUserId}");
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	// ************************************To
	// do**************************************888
	@GetMapping("/incompletedActivity/{registeredUserId}")
	@Timed
	public ResponseEntity<List<ActivityDTO>> findInompletedActivityByRegisteredUserId(
			@PathVariable Long registeredUserId, Pageable pageable) throws URISyntaxException {
		log.debug("REST request to save CompletedActivity");
		Page<ActivityDTO> page = aggregateService.findIncompletedActivityByRegisteredUserId(registeredUserId, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				"/completedActivity/{registeredUserId}");
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

}
