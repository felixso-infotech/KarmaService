package org.apereo.openlrw.felixso.repository;

import java.util.List;

import org.apereo.openlrw.caliper.service.repository.MongoEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FelixsoMongoEventRepository extends MongoRepository<MongoEvent, String> {

	@Override
	public List<MongoEvent> findAll();

	@Query(value = "{'userId': ?0}")
	public List<MongoEvent> findByUserId(String userId);

	public List<MongoEvent> findByUserIdAndEventAction(String userId, String action);

}
