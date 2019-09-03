package com.felixsoinfotech.karma.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.felixsoinfotech.karma.service.IntroductionStoryService;
import com.felixsoinfotech.karma.web.rest.errors.BadRequestAlertException;
import com.felixsoinfotech.karma.web.rest.util.HeaderUtil;
import com.felixsoinfotech.karma.web.rest.util.PaginationUtil;
import com.felixsoinfotech.karma.service.dto.IntroductionStoryDTO;
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
 * REST controller for managing IntroductionStory.
 */

public class IntroductionStoryResource {

    private final Logger log = LoggerFactory.getLogger(IntroductionStoryResource.class);

    private static final String ENTITY_NAME = "karmaIntroductionStory";

    private final IntroductionStoryService introductionStoryService;

    public IntroductionStoryResource(IntroductionStoryService introductionStoryService) {
        this.introductionStoryService = introductionStoryService;
    }

    /**
     * POST  /introduction-stories : Create a new introductionStory.
     *
     * @param introductionStoryDTO the introductionStoryDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new introductionStoryDTO, or with status 400 (Bad Request) if the introductionStory has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/introduction-stories")
    @Timed
    public ResponseEntity<IntroductionStoryDTO> createIntroductionStory(@RequestBody IntroductionStoryDTO introductionStoryDTO) throws URISyntaxException {
        log.debug("REST request to save IntroductionStory : {}", introductionStoryDTO);
        if (introductionStoryDTO.getId() != null) {
            throw new BadRequestAlertException("A new introductionStory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IntroductionStoryDTO result = introductionStoryService.save(introductionStoryDTO);
        return ResponseEntity.created(new URI("/api/introduction-stories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /introduction-stories : Updates an existing introductionStory.
     *
     * @param introductionStoryDTO the introductionStoryDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated introductionStoryDTO,
     * or with status 400 (Bad Request) if the introductionStoryDTO is not valid,
     * or with status 500 (Internal Server Error) if the introductionStoryDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/introduction-stories")
    @Timed
    public ResponseEntity<IntroductionStoryDTO> updateIntroductionStory(@RequestBody IntroductionStoryDTO introductionStoryDTO) throws URISyntaxException {
        log.debug("REST request to update IntroductionStory : {}", introductionStoryDTO);
        if (introductionStoryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IntroductionStoryDTO result = introductionStoryService.save(introductionStoryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, introductionStoryDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /introduction-stories : get all the introductionStories.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of introductionStories in body
     */
    @GetMapping("/introduction-stories")
    @Timed
    public ResponseEntity<List<IntroductionStoryDTO>> getAllIntroductionStories(Pageable pageable) {
        log.debug("REST request to get a page of IntroductionStories");
        Page<IntroductionStoryDTO> page = introductionStoryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/introduction-stories");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /introduction-stories/:id : get the "id" introductionStory.
     *
     * @param id the id of the introductionStoryDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the introductionStoryDTO, or with status 404 (Not Found)
     */
    @GetMapping("/introduction-stories/{id}")
    @Timed
    public ResponseEntity<IntroductionStoryDTO> getIntroductionStory(@PathVariable Long id) {
        log.debug("REST request to get IntroductionStory : {}", id);
        Optional<IntroductionStoryDTO> introductionStoryDTO = introductionStoryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(introductionStoryDTO);
    }

    /**
     * DELETE  /introduction-stories/:id : delete the "id" introductionStory.
     *
     * @param id the id of the introductionStoryDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/introduction-stories/{id}")
    @Timed
    public ResponseEntity<Void> deleteIntroductionStory(@PathVariable Long id) {
        log.debug("REST request to delete IntroductionStory : {}", id);
        introductionStoryService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
