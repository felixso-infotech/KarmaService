/*
* Copyright 2002-2016 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.felixsoinfotech.karma.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.felixsoinfotech.karma.domain.Activity;
import com.felixsoinfotech.karma.domain.IntroductionStory;
import com.felixsoinfotech.karma.model.ActivityAggregate;
import com.felixsoinfotech.karma.repository.ActivityRepository;
import com.felixsoinfotech.karma.repository.IntroductionStoryRepository;
import com.felixsoinfotech.karma.service.AggregateCommandService;
import com.felixsoinfotech.karma.service.dto.ActivityDTO;
import com.felixsoinfotech.karma.service.dto.IntroductionStoryDTO;
import com.felixsoinfotech.karma.service.mapper.ActivityMapper;
import com.felixsoinfotech.karma.service.mapper.IntroductionStoryMapper;

/**
 * TODO Provide a detailed description here  
 * @author Owner
 * sarangibalu, sarangibalu.a@lxisoft.com
 */

/**
 * Service Implementation for managing Command services.
 */
@Service
@Transactional
public class AggregateCommandServiceImpl implements AggregateCommandService {

	private final Logger log = LoggerFactory.getLogger(AggregateCommandServiceImpl.class);

	private ActivityRepository activityRepository;

	private ActivityMapper activityMapper;
	
	private IntroductionStoryMapper introductionStoryMapper;
	
	private IntroductionStoryRepository introductionStoryRepository;

	public AggregateCommandServiceImpl(ActivityRepository activityRepository, ActivityMapper activityMapper,IntroductionStoryMapper introductionStoryMapper,IntroductionStoryRepository introductionStoryRepository) {
		this.activityRepository = activityRepository;
		this.activityMapper = activityMapper;
		this.introductionStoryMapper=introductionStoryMapper; 
		this.introductionStoryRepository=introductionStoryRepository;
	}

	/**
	 * Save a activity.
	 *
	 * @param activityDTO the entity to save
	 * @return the persisted entity
	 */
	@Override
	public ActivityAggregate saveActivity(ActivityAggregate activityAggregate) {
		log.debug("Request to save Activity : {}", activityAggregate);
		
		List<IntroductionStoryDTO> introductionStories= new ArrayList<IntroductionStoryDTO>();

		Activity activity = activityMapper.toEntity(activityAggregate.getActivityDTO());
		activity = activityRepository.save(activity);
		ActivityDTO activityDto = activityMapper.toDto(activity);
		activityAggregate.setActivityDTO(activityDto);
		
		for(IntroductionStoryDTO introductionStoryDto:activityAggregate.getIntroductionStories())
	     {
			IntroductionStory introductionStory=introductionStoryMapper.toEntity(introductionStoryDto);
			introductionStory = introductionStoryRepository.save(introductionStory);
			IntroductionStoryDTO introductionStoryDTo = introductionStoryMapper.toDto(introductionStory);
			introductionStories.add(introductionStoryDTo);
			activityAggregate.setIntroductionStories(introductionStories);			
		 }
	
		return activityAggregate;
	}
	

}
