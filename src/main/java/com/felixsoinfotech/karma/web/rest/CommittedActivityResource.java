package com.felixsoinfotech.karma.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.felixsoinfotech.karma.service.CommittedActivityService;
import com.felixsoinfotech.karma.web.rest.errors.BadRequestAlertException;
import com.felixsoinfotech.karma.web.rest.util.HeaderUtil;
import com.felixsoinfotech.karma.web.rest.util.PaginationUtil;
import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing CommittedActivity.
 */

public class CommittedActivityResource {

    private final Logger log = LoggerFactory.getLogger(CommittedActivityResource.class);

    private static final String ENTITY_NAME = "karmaCommittedActivity";

    private final CommittedActivityService committedActivityService;

    public CommittedActivityResource(CommittedActivityService committedActivityService) {
        this.committedActivityService = committedActivityService;
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
    public ResponseEntity<CommittedActivityDTO> createCommittedActivity(@RequestBody CommittedActivityDTO committedActivityDTO) throws URISyntaxException {
        log.debug("REST request to save CommittedActivity : {}", committedActivityDTO);
        if (committedActivityDTO.getId() != null) {
            throw new BadRequestAlertException("A new committedActivity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CommittedActivityDTO result = committedActivityService.save(committedActivityDTO);
        return ResponseEntity.created(new URI("/api/committed-activities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
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
    public ResponseEntity<CommittedActivityDTO> updateCommittedActivity(@RequestBody CommittedActivityDTO committedActivityDTO) throws URISyntaxException {
        log.debug("REST request to update CommittedActivity : {}", committedActivityDTO);
        if (committedActivityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CommittedActivityDTO result = committedActivityService.save(committedActivityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, committedActivityDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /committed-activities : get all the committedActivities.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of committedActivities in body
     */
    @GetMapping("/committed-activities")
    @Timed
    public ResponseEntity<List<CommittedActivityDTO>> getAllCommittedActivities(Pageable pageable) {
        log.debug("REST request to get a page of CommittedActivities");
        Page<CommittedActivityDTO> page = committedActivityService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/committed-activities");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /committed-activities/:id : get the "id" committedActivity.
     *
     * @param id the id of the committedActivityDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the committedActivityDTO, or with status 404 (Not Found)
     */
    @GetMapping("/committed-activities/{id}")
    @Timed
    public ResponseEntity<CommittedActivityDTO> getCommittedActivity(@PathVariable Long id) {
        log.debug("REST request to get CommittedActivity : {}", id);
        Optional<CommittedActivityDTO> committedActivityDTO = committedActivityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(committedActivityDTO);
    }

    /**
     * DELETE  /committed-activities/:id : delete the "id" committedActivity.
     *
     * @param id the id of the committedActivityDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/committed-activities/{id}")
    @Timed
    public ResponseEntity<Void> deleteCommittedActivity(@PathVariable Long id) {
        log.debug("REST request to delete CommittedActivity : {}", id);
        committedActivityService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
