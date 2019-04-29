package com.lxisoft.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.lxisoft.service.CompletedActivityService;
import com.lxisoft.web.rest.errors.BadRequestAlertException;
import com.lxisoft.web.rest.util.HeaderUtil;
import com.lxisoft.web.rest.util.PaginationUtil;
import com.lxisoft.service.dto.CompletedActivityDTO;
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
 * REST controller for managing CompletedActivity.
 */
@RestController
@RequestMapping("/api")
public class CompletedActivityResource {

    private final Logger log = LoggerFactory.getLogger(CompletedActivityResource.class);

    private static final String ENTITY_NAME = "karmaAppCompletedActivity";

    private final CompletedActivityService completedActivityService;

    public CompletedActivityResource(CompletedActivityService completedActivityService) {
        this.completedActivityService = completedActivityService;
    }

    /**
     * POST  /completed-activities : Create a new completedActivity.
     *
     * @param completedActivityDTO the completedActivityDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new completedActivityDTO, or with status 400 (Bad Request) if the completedActivity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/completed-activities")
    @Timed
    public ResponseEntity<CompletedActivityDTO> createCompletedActivity(@RequestBody CompletedActivityDTO completedActivityDTO) throws URISyntaxException {
        log.debug("REST request to save CompletedActivity : {}", completedActivityDTO);
        if (completedActivityDTO.getId() != null) {
            throw new BadRequestAlertException("A new completedActivity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CompletedActivityDTO result = completedActivityService.save(completedActivityDTO);
        return ResponseEntity.created(new URI("/api/completed-activities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /completed-activities : Updates an existing completedActivity.
     *
     * @param completedActivityDTO the completedActivityDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated completedActivityDTO,
     * or with status 400 (Bad Request) if the completedActivityDTO is not valid,
     * or with status 500 (Internal Server Error) if the completedActivityDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/completed-activities")
    @Timed
    public ResponseEntity<CompletedActivityDTO> updateCompletedActivity(@RequestBody CompletedActivityDTO completedActivityDTO) throws URISyntaxException {
        log.debug("REST request to update CompletedActivity : {}", completedActivityDTO);
        if (completedActivityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CompletedActivityDTO result = completedActivityService.save(completedActivityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, completedActivityDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /completed-activities : get all the completedActivities.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of completedActivities in body
     */
    @GetMapping("/completed-activities")
    @Timed
    public ResponseEntity<List<CompletedActivityDTO>> getAllCompletedActivities(Pageable pageable) {
        log.debug("REST request to get a page of CompletedActivities");
        Page<CompletedActivityDTO> page = completedActivityService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/completed-activities");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /completed-activities/:id : get the "id" completedActivity.
     *
     * @param id the id of the completedActivityDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the completedActivityDTO, or with status 404 (Not Found)
     */
    @GetMapping("/completed-activities/{id}")
    @Timed
    public ResponseEntity<CompletedActivityDTO> getCompletedActivity(@PathVariable Long id) {
        log.debug("REST request to get CompletedActivity : {}", id);
        Optional<CompletedActivityDTO> completedActivityDTO = completedActivityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(completedActivityDTO);
    }

    /**
     * DELETE  /completed-activities/:id : delete the "id" completedActivity.
     *
     * @param id the id of the completedActivityDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/completed-activities/{id}")
    @Timed
    public ResponseEntity<Void> deleteCompletedActivity(@PathVariable Long id) {
        log.debug("REST request to delete CompletedActivity : {}", id);
        completedActivityService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
