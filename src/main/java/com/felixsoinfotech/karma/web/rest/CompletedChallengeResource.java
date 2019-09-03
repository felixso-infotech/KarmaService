package com.felixsoinfotech.karma.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.felixsoinfotech.karma.service.CompletedChallengeService;
import com.felixsoinfotech.karma.web.rest.errors.BadRequestAlertException;
import com.felixsoinfotech.karma.web.rest.util.HeaderUtil;
import com.felixsoinfotech.karma.web.rest.util.PaginationUtil;
import com.felixsoinfotech.karma.service.dto.CompletedChallengeDTO;
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
 * REST controller for managing CompletedChallenge.
 */

public class CompletedChallengeResource {

    private final Logger log = LoggerFactory.getLogger(CompletedChallengeResource.class);

    private static final String ENTITY_NAME = "karmaCompletedChallenge";

    private final CompletedChallengeService completedChallengeService;

    public CompletedChallengeResource(CompletedChallengeService completedChallengeService) {
        this.completedChallengeService = completedChallengeService;
    }

    /**
     * POST  /completed-challenges : Create a new completedChallenge.
     *
     * @param completedChallengeDTO the completedChallengeDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new completedChallengeDTO, or with status 400 (Bad Request) if the completedChallenge has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/completed-challenges")
    @Timed
    public ResponseEntity<CompletedChallengeDTO> createCompletedChallenge(@RequestBody CompletedChallengeDTO completedChallengeDTO) throws URISyntaxException {
        log.debug("REST request to save CompletedChallenge : {}", completedChallengeDTO);
        if (completedChallengeDTO.getId() != null) {
            throw new BadRequestAlertException("A new completedChallenge cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CompletedChallengeDTO result = completedChallengeService.save(completedChallengeDTO);
        return ResponseEntity.created(new URI("/api/completed-challenges/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /completed-challenges : Updates an existing completedChallenge.
     *
     * @param completedChallengeDTO the completedChallengeDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated completedChallengeDTO,
     * or with status 400 (Bad Request) if the completedChallengeDTO is not valid,
     * or with status 500 (Internal Server Error) if the completedChallengeDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/completed-challenges")
    @Timed
    public ResponseEntity<CompletedChallengeDTO> updateCompletedChallenge(@RequestBody CompletedChallengeDTO completedChallengeDTO) throws URISyntaxException {
        log.debug("REST request to update CompletedChallenge : {}", completedChallengeDTO);
        if (completedChallengeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CompletedChallengeDTO result = completedChallengeService.save(completedChallengeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, completedChallengeDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /completed-challenges : get all the completedChallenges.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of completedChallenges in body
     */
    @GetMapping("/completed-challenges")
    @Timed
    public ResponseEntity<List<CompletedChallengeDTO>> getAllCompletedChallenges(Pageable pageable) {
        log.debug("REST request to get a page of CompletedChallenges");
        Page<CompletedChallengeDTO> page = completedChallengeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/completed-challenges");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /completed-challenges/:id : get the "id" completedChallenge.
     *
     * @param id the id of the completedChallengeDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the completedChallengeDTO, or with status 404 (Not Found)
     */
    @GetMapping("/completed-challenges/{id}")
    @Timed
    public ResponseEntity<CompletedChallengeDTO> getCompletedChallenge(@PathVariable Long id) {
        log.debug("REST request to get CompletedChallenge : {}", id);
        Optional<CompletedChallengeDTO> completedChallengeDTO = completedChallengeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(completedChallengeDTO);
    }

    /**
     * DELETE  /completed-challenges/:id : delete the "id" completedChallenge.
     *
     * @param id the id of the completedChallengeDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/completed-challenges/{id}")
    @Timed
    public ResponseEntity<Void> deleteCompletedChallenge(@PathVariable Long id) {
        log.debug("REST request to delete CompletedChallenge : {}", id);
        completedChallengeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
