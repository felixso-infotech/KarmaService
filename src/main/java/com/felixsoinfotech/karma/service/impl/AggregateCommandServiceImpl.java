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
import com.felixsoinfotech.karma.domain.CommittedActivity;
import com.felixsoinfotech.karma.domain.IntroductionStory;
import com.felixsoinfotech.karma.domain.Media;
import com.felixsoinfotech.karma.domain.RegisteredUser;
import com.felixsoinfotech.karma.domain.enumeration.Status;
import com.felixsoinfotech.karma.model.ActivityAggregate;
import com.felixsoinfotech.karma.model.CommittedActivityStatusAggregate;
import com.felixsoinfotech.karma.repository.ActivityRepository;
import com.felixsoinfotech.karma.repository.CommittedActivityRepository;
import com.felixsoinfotech.karma.repository.IntroductionStoryRepository;
import com.felixsoinfotech.karma.repository.MediaRepository;
import com.felixsoinfotech.karma.repository.RegisteredUserRepository;
import com.felixsoinfotech.karma.service.AggregateCommandService;
import com.felixsoinfotech.karma.service.dto.ActivityDTO;
import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;
import com.felixsoinfotech.karma.service.dto.IntroductionStoryDTO;
import com.felixsoinfotech.karma.service.dto.MediaDTO;
import com.felixsoinfotech.karma.service.dto.RegisteredUserDTO;
import com.felixsoinfotech.karma.service.mapper.ActivityMapper;
import com.felixsoinfotech.karma.service.mapper.CommittedActivityMapper;
import com.felixsoinfotech.karma.service.mapper.IntroductionStoryMapper;
import com.felixsoinfotech.karma.service.mapper.MediaMapper;
import com.felixsoinfotech.karma.service.mapper.RegisteredUserMapper;

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
	
	private CommittedActivityMapper committedActivityMapper;
	
	private CommittedActivityRepository committedActivityRepository;
	
	private RegisteredUserRepository registeredUserRepository;

    private RegisteredUserMapper registeredUserMapper;
    
    private MediaRepository mediaRepository;
    
    private MediaMapper mediaMapper;

	public AggregateCommandServiceImpl(ActivityRepository activityRepository, ActivityMapper activityMapper,
			                           IntroductionStoryMapper introductionStoryMapper,IntroductionStoryRepository introductionStoryRepository,
			                           CommittedActivityRepository committedActivityRepository,CommittedActivityMapper committedActivityMapper,
			                           RegisteredUserRepository registeredUserRepository, RegisteredUserMapper registeredUserMapper,
			                           MediaRepository mediaRepository,MediaMapper mediaMapper) {
		this.activityRepository = activityRepository;
		this.activityMapper = activityMapper;
		this.introductionStoryMapper=introductionStoryMapper; 
		this.introductionStoryRepository=introductionStoryRepository;
		this.committedActivityMapper=committedActivityMapper;
		this.committedActivityRepository=committedActivityRepository;
		this.registeredUserRepository = registeredUserRepository;
        this.registeredUserMapper = registeredUserMapper;
        this.mediaMapper = mediaMapper;
        this.mediaRepository = mediaRepository;
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
			introductionStoryDto.setActivityId(activityAggregate.getActivityDTO().getId());
			
			System.out.println(activityAggregate.getActivityDTO().getId());
			
			IntroductionStory introductionStory=introductionStoryMapper.toEntity(introductionStoryDto);
			introductionStory = introductionStoryRepository.save(introductionStory);
			IntroductionStoryDTO introductionStoryDTo = introductionStoryMapper.toDto(introductionStory);
			introductionStories.add(introductionStoryDTo);
			activityAggregate.setIntroductionStories(introductionStories);			
		 }
	
		return activityAggregate;
	}
	
	/**
     * Save a committedActivity.
     *
     * @param committedActivityDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public CommittedActivityStatusAggregate saveCommittedActivity(CommittedActivityStatusAggregate committedActivityStatusAggregate) {
        log.debug("Request to save CommittedActivity : {}", committedActivityStatusAggregate);
        
        CommittedActivityDTO committedActivityDTO = new CommittedActivityDTO();
        MediaDTO mediaDTO = null;
        
        committedActivityDTO.setId(committedActivityStatusAggregate.getCommittedActivityId());
        committedActivityDTO.setActivityId(committedActivityStatusAggregate.getActivityId());
        committedActivityDTO.setDescription(committedActivityStatusAggregate.getDescription());
        committedActivityDTO.setCreatedDate(committedActivityStatusAggregate.getCreatedDate());
        committedActivityDTO.setReferenceId(committedActivityStatusAggregate.getReferenceId());
        committedActivityDTO.setRegisteredUserId(committedActivityStatusAggregate.getRegisteredUserId());
        
          if(committedActivityStatusAggregate.getStatus() == null)
              committedActivityDTO.setStatus(Status.TODO);
        
        committedActivityDTO.setStatus(committedActivityStatusAggregate.getStatus());
        
        CommittedActivity committedActivity = committedActivityMapper.toEntity(committedActivityDTO);       
        committedActivity = committedActivityRepository.save(committedActivity);
        committedActivityDTO = committedActivityMapper.toDto(committedActivity);
        
              if(committedActivityStatusAggregate.getProofFile() != null)
              {	
        	
                mediaDTO = new MediaDTO();
        
                mediaDTO.setFileName(committedActivityStatusAggregate.getUserId()+""+committedActivityStatusAggregate.getCreatedDate());
                mediaDTO.setCommittedActivityId(committedActivityStatusAggregate.getCommittedActivityId());        
                mediaDTO.setFile(committedActivityStatusAggregate.getProofFile());
                mediaDTO.setFileContentType(committedActivityStatusAggregate.getProofFileContentType());
        
                    Media media = mediaMapper.toEntity(mediaDTO);
                    media = mediaRepository.save(media);
                    mediaDTO = mediaMapper.toDto(media);
        
              if(mediaDTO != null)
              {
        	    committedActivityStatusAggregate.setProofFile(mediaDTO.getFile());
                committedActivityStatusAggregate.setProofFileContentType(mediaDTO.getFileContentType());
              }       
        
            }           
             
        if(committedActivityDTO != null)
        {
        committedActivityStatusAggregate.setActivityId(committedActivityDTO.getActivityId());  
        committedActivityStatusAggregate.setCommittedActivityId(committedActivityDTO.getId());
        committedActivityStatusAggregate.setCreatedDate(committedActivityDTO.getCreatedDate());
        committedActivityStatusAggregate.setDescription(committedActivityDTO.getDescription());
        committedActivityStatusAggregate.setReferenceId(committedActivityDTO.getReferenceId());
        committedActivityStatusAggregate.setStatus(committedActivityDTO.getStatus());
        committedActivityStatusAggregate.setRegisteredUserId(committedActivityDTO.getRegisteredUserId());
        }
                         
        return committedActivityStatusAggregate;
    }
	
    /**
     * Save a registeredUser.
     *
     * @param registeredUserDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public RegisteredUserDTO saveRegisteredUser(RegisteredUserDTO registeredUserDTO) {
        log.debug("Request to save RegisteredUser : {}", registeredUserDTO);

        RegisteredUser registeredUser = registeredUserMapper.toEntity(registeredUserDTO);
        registeredUser = registeredUserRepository.save(registeredUser);
        return registeredUserMapper.toDto(registeredUser);
    }
    

    /**
     * Delete the registeredUser by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void deleteRegisteredUser(Long id) {
        log.debug("Request to delete RegisteredUser : {}", id);
        registeredUserRepository.deleteById(id);
    }

}
