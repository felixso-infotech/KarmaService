package com.lxisoft.web.rest;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codahale.metrics.annotation.Timed;
import com.lxisoft.service.InstructionVideoService;
import com.lxisoft.service.dto.InstructionVideoDTO;
import com.lxisoft.web.rest.errors.BadRequestAlertException;
import com.lxisoft.web.rest.util.HeaderUtil;
import com.lxisoft.web.rest.util.PaginationUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing InstructionVideo.
 */
//@RestController
//@RequestMapping("/api")
public class InstructionVideoResource {

	private final Logger log = LoggerFactory.getLogger(InstructionVideoResource.class);

	private static final String ENTITY_NAME = "karmaAppInstructionVideo";

	private final InstructionVideoService instructionVideoService;

	public InstructionVideoResource(InstructionVideoService instructionVideoService) {
		this.instructionVideoService = instructionVideoService;
	}

	/**
	 * POST /instruction-videos : Create a new instructionVideo.
	 *
	 * @param instructionVideoDTO the instructionVideoDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         instructionVideoDTO, or with status 400 (Bad Request) if the
	 *         instructionVideo has already an ID
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 */
	@PostMapping("/instruction-videos")
	@Timed
	public ResponseEntity<InstructionVideoDTO> createInstructionVideo(
			@RequestBody InstructionVideoDTO instructionVideoDTO) throws URISyntaxException {
		log.debug("REST request to save InstructionVideo : {}", instructionVideoDTO);
		if (instructionVideoDTO.getId() != null) {
			throw new BadRequestAlertException("A new instructionVideo cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		InstructionVideoDTO result = instructionVideoService.save(instructionVideoDTO);
		return ResponseEntity.created(new URI("/api/instruction-videos/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /instruction-videos : Updates an existing instructionVideo.
	 *
	 * @param instructionVideoDTO the instructionVideoDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         instructionVideoDTO, or with status 400 (Bad Request) if the
	 *         instructionVideoDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the instructionVideoDTO couldn't be updated
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 */
	@PutMapping("/instruction-videos")
	@Timed
	public ResponseEntity<InstructionVideoDTO> updateInstructionVideo(
			@RequestBody InstructionVideoDTO instructionVideoDTO) throws URISyntaxException {
		log.debug("REST request to update InstructionVideo : {}", instructionVideoDTO);
		if (instructionVideoDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		InstructionVideoDTO result = instructionVideoService.save(instructionVideoDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, instructionVideoDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /instruction-videos : get all the instructionVideos.
	 *
	 * @param pageable the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         instructionVideos in body
	 */
	@GetMapping("/instruction-videos")
	@Timed
	public ResponseEntity<List<InstructionVideoDTO>> getAllInstructionVideos(Pageable pageable) {
		log.debug("REST request to get a page of InstructionVideos");
		Page<InstructionVideoDTO> page = instructionVideoService.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/instruction-videos");
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	/**
	 * GET /instruction-videos/:id : get the "id" instructionVideo.
	 *
	 * @param id the id of the instructionVideoDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         instructionVideoDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/instruction-videos/{id}")
	@Timed
	public ResponseEntity<InstructionVideoDTO> getInstructionVideo(@PathVariable Long id) {
		log.debug("REST request to get InstructionVideo : {}", id);
		Optional<InstructionVideoDTO> instructionVideoDTO = instructionVideoService.findOne(id);
		return ResponseUtil.wrapOrNotFound(instructionVideoDTO);
	}

	/**
	 * DELETE /instruction-videos/:id : delete the "id" instructionVideo.
	 *
	 * @param id the id of the instructionVideoDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/instruction-videos/{id}")
	@Timed
	public ResponseEntity<Void> deleteInstructionVideo(@PathVariable Long id) {
		log.debug("REST request to delete InstructionVideo : {}", id);
		instructionVideoService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
