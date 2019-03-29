package org.apereo.openlrw.felixso.service;

import java.util.List;

import org.apereo.openlrw.caliper.service.repository.MongoEvent;

public interface FelixsoMongoEventService {
	public List<MongoEvent> findAll();

	public List<MongoEvent> findCompletedEventsByName(String userId);

	public List<MongoEvent> findStartedEventsByName(String userId);

}
