package org.apereo.openlrw.felixso.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apereo.openlrw.caliper.service.repository.MongoEvent;
import org.apereo.openlrw.felixso.repository.FelixsoMongoEventRepository;
import org.apereo.openlrw.felixso.service.FelixsoMongoEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FelixsoMongoEventServiceImpl implements FelixsoMongoEventService {

	@Autowired
	FelixsoMongoEventRepository felixsoMongoEventRepository;

	@Override
	public List<MongoEvent> findAll() {
		return felixsoMongoEventRepository.findAll();
	}

	@Override
	public List<MongoEvent> findByUserIdAndAction(String userId, String action) {
		List<MongoEvent> events = felixsoMongoEventRepository.findByUserIdAndEventAction(userId, action);
		List<MongoEvent> completedEvents = new ArrayList<MongoEvent>();
		events.forEach(ev -> {
			if (ev.getEvent().getAction().equals(action))
				completedEvents.add(ev);
		});
		return completedEvents;

	}

}
