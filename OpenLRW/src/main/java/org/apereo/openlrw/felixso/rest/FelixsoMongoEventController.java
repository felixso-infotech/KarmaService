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

	@RequestMapping("/events/{userId}/{action}")
	public ResponseEntity<List<MongoEvent>> getMongoEventsByUserIdAndAction(@PathVariable String userId,
			@PathVariable String action) {
		List<MongoEvent> mongoEvents = felixsoMongoEventService.findByUserIdAndAction(userId, action);
		return ResponseEntity.ok().body(mongoEvents);
	}
}
