package org.apereo.openlrw.felixso.rest;

import java.util.List;

import org.apereo.openlrw.caliper.service.repository.MongoEvent;
import org.apereo.openlrw.felixso.service.FelixsoMongoEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FelixsoMongoEventController {

	@Autowired
	private FelixsoMongoEventService felixsoMongoEventService;

	@RequestMapping("/completed-events")
	public ResponseEntity<List<MongoEvent>> getMongoCompletedEvents() {
		List<MongoEvent> mongoEvents = felixsoMongoEventService.findCompletedEvents();
		return ResponseEntity.ok().body(mongoEvents);
	}

	@RequestMapping("/started-events")
	public ResponseEntity<List<MongoEvent>> getMongoEStartedEvents() {
		List<MongoEvent> mongoEvents = felixsoMongoEventService.findStartedEvents();
		return ResponseEntity.ok().body(mongoEvents);
	}

}
