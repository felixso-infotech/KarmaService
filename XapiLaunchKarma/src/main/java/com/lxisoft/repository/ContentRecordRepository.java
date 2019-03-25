package com.lxisoft.repository;

import com.lxisoft.domain.ContentRecord;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the ContentRecord entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ContentRecordRepository extends MongoRepository<ContentRecord, String> {

}
