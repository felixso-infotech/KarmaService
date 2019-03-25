package com.lxisoft.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.lxisoft.service.ContentRecordService;
import com.lxisoft.web.rest.errors.BadRequestAlertException;
import com.lxisoft.web.rest.util.HeaderUtil;
import com.lxisoft.web.rest.util.PaginationUtil;
import com.lxisoft.service.dto.ContentRecordDTO;
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
 * REST controller for managing ContentRecord.
 */
@RestController
@RequestMapping("/api")
public class ContentRecordResource {

    private final Logger log = LoggerFactory.getLogger(ContentRecordResource.class);

    private static final String ENTITY_NAME = "xapiLaunchKarmaContentRecord";

    private final ContentRecordService contentRecordService;

    public ContentRecordResource(ContentRecordService contentRecordService) {
        this.contentRecordService = contentRecordService;
    }

    /**
     * POST  /content-records : Create a new contentRecord.
     *
     * @param contentRecordDTO the contentRecordDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new contentRecordDTO, or with status 400 (Bad Request) if the contentRecord has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/content-records")
    @Timed
    public ResponseEntity<ContentRecordDTO> createContentRecord(@RequestBody ContentRecordDTO contentRecordDTO) throws URISyntaxException {
        log.debug("REST request to save ContentRecord : {}", contentRecordDTO);
        if (contentRecordDTO.getId() != null) {
            throw new BadRequestAlertException("A new contentRecord cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ContentRecordDTO result = contentRecordService.save(contentRecordDTO);
        return ResponseEntity.created(new URI("/api/content-records/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /content-records : Updates an existing contentRecord.
     *
     * @param contentRecordDTO the contentRecordDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated contentRecordDTO,
     * or with status 400 (Bad Request) if the contentRecordDTO is not valid,
     * or with status 500 (Internal Server Error) if the contentRecordDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/content-records")
    @Timed
    public ResponseEntity<ContentRecordDTO> updateContentRecord(@RequestBody ContentRecordDTO contentRecordDTO) throws URISyntaxException {
        log.debug("REST request to update ContentRecord : {}", contentRecordDTO);
        if (contentRecordDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ContentRecordDTO result = contentRecordService.save(contentRecordDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, contentRecordDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /content-records : get all the contentRecords.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of contentRecords in body
     */
    @GetMapping("/content-records")
    @Timed
    public ResponseEntity<List<ContentRecordDTO>> getAllContentRecords(Pageable pageable) {
        log.debug("REST request to get a page of ContentRecords");
        Page<ContentRecordDTO> page = contentRecordService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/content-records");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /content-records/:id : get the "id" contentRecord.
     *
     * @param id the id of the contentRecordDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the contentRecordDTO, or with status 404 (Not Found)
     */
    @GetMapping("/content-records/{id}")
    @Timed
    public ResponseEntity<ContentRecordDTO> getContentRecord(@PathVariable String id) {
        log.debug("REST request to get ContentRecord : {}", id);
        Optional<ContentRecordDTO> contentRecordDTO = contentRecordService.findOne(id);
        return ResponseUtil.wrapOrNotFound(contentRecordDTO);
    }

    /**
     * DELETE  /content-records/:id : delete the "id" contentRecord.
     *
     * @param id the id of the contentRecordDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/content-records/{id}")
    @Timed
    public ResponseEntity<Void> deleteContentRecord(@PathVariable String id) {
        log.debug("REST request to delete ContentRecord : {}", id);
        contentRecordService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
