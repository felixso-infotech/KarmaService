package org.apereo.openlrw.felixso.rest;

import java.util.List;

import org.apereo.openlrw.caliper.service.repository.MongoEvent;
import org.apereo.openlrw.felixso.service.FelixsoMongoEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FelixsoMongoEventController {

	@Autowired
	private FelixsoMongoEventService felixsoMongoEventService;

	@RequestMapping("/completed-events/{userId}")
	public ResponseEntity<List<MongoEvent>> getMongoCompletedEvents(@PathVariable String userId) {
		List<MongoEvent> mongoEvents = felixsoMongoEventService.findCompletedEventsByName(userId);
		return ResponseEntity.ok().body(mongoEvents);
	}

	@RequestMapping("/started-events/{userId}")
	public ResponseEntity<List<MongoEvent>> getMongoEStartedEvents(@PathVariable String userId) {
		List<MongoEvent> mongoEvents = felixsoMongoEventService.findStartedEventsByName(userId);
		return ResponseEntity.ok().body(mongoEvents);
	}

}
