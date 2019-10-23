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
/**
 * TODO Provide a detailed description here 
 * @author Owner
 * sarangibalu, sarangibalu.a@lxisoft.com
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.felixsoinfotech.karma.domain.enumeration.ProofType;
import com.felixsoinfotech.karma.domain.enumeration.Status;
import com.felixsoinfotech.karma.domain.enumeration.Type;
import com.felixsoinfotech.karma.model.ActivityAggregate;
import com.felixsoinfotech.karma.model.CommittedActivityAggregate;
import com.felixsoinfotech.karma.model.RegisteredUserAggregate;
import com.felixsoinfotech.karma.repository.ActivityRepository;
import com.felixsoinfotech.karma.repository.CommittedActivityRepository;
import com.felixsoinfotech.karma.repository.DimensionRepository;
import com.felixsoinfotech.karma.repository.MediaRepository;
import com.felixsoinfotech.karma.repository.RegisteredUserRepository;


import com.felixsoinfotech.karma.service.AggregateQueryService;
import com.felixsoinfotech.karma.service.dto.ActivityDTO;
import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;
import com.felixsoinfotech.karma.service.dto.DimensionDTO;
import com.felixsoinfotech.karma.service.dto.MediaDTO;
import com.felixsoinfotech.karma.service.dto.RegisteredUserDTO;


import com.felixsoinfotech.karma.service.mapper.ActivityMapper;
import com.felixsoinfotech.karma.service.mapper.CommittedActivityMapper;
import com.felixsoinfotech.karma.service.mapper.DimensionMapper;
import com.felixsoinfotech.karma.service.mapper.MediaMapper;
import com.felixsoinfotech.karma.service.mapper.RegisteredUserMapper;


import com.thoughtworks.xstream.core.util.Base64Encoder;

//import org.bouncycastle.util.encoders.Base64Encoder;

/**
 * Service Implementation for managing Queryservices
 */
@Service
@Transactional
public class AggregateQueryServiceImpl implements AggregateQueryService {

	private final Logger log = LoggerFactory.getLogger(AggregateQueryServiceImpl.class);

	private ActivityRepository activityRepository;

	private ActivityMapper activityMapper;
	
	private DimensionRepository dimensionRepository;
	
	private DimensionMapper dimensionMapper;
	
	private CommittedActivityRepository committedActivityRepository;
	
	private CommittedActivityMapper committedActivityMapper;
	
	private RegisteredUserRepository registeredUserRepository;

    private RegisteredUserMapper registeredUserMapper;
    
    private MediaRepository mediaRepository;

    private MediaMapper mediaMapper;
    

	public AggregateQueryServiceImpl(ActivityRepository activityRepository, ActivityMapper activityMapper,
			                         DimensionRepository dimensionRepository,DimensionMapper dimensionMapper,
			                         CommittedActivityRepository committedActivityRepository,CommittedActivityMapper committedActivityMapper,
			                         RegisteredUserRepository registeredUserRepository, RegisteredUserMapper registeredUserMapper,
			                         MediaRepository mediaRepository, MediaMapper mediaMapper) {
		this.activityRepository = activityRepository;
		this.activityMapper = activityMapper;
		this.dimensionRepository=dimensionRepository;
		this.dimensionMapper=dimensionMapper;
		this.committedActivityRepository=committedActivityRepository;
		this.committedActivityMapper=committedActivityMapper;
		this.registeredUserRepository = registeredUserRepository;
        this.registeredUserMapper = registeredUserMapper;
        this.mediaRepository = mediaRepository;
        this.mediaMapper = mediaMapper;
        
        
        
	}	
	
	/**
	 * Get all the enums ProofType.
	 *
	 * @return the list of enums
	 */
	@Override
	public List<ProofType> findAllEnumProofTypes(){
		
		log.debug("Request to get all Enum ProofTypes");
		
		ProofType[] proofTypes=ProofType.values();
						
		return Arrays.asList(proofTypes);
		
	}

	/**
	 * Get all the enums ProofType.
	 *
	 * @return the list of enums
	 */
	@Override
	public List<Type> findAllEnumTypes(){
		
		log.debug("Request to get all Enum Types");
		
		Type[] types=Type.values();
						
		return Arrays.asList(types);		
	}
	
	/**
	 * Get all the enums Status.
	 *
	 * @return the list of Status
	 */
	@Override
	public List<Status> findAllEnumStatus(){
		
		log.debug("Request to get all Enum Status");
		
		Status[] statuses=Status.values();
						
		return Arrays.asList(statuses);		
	}
	
	/**
     * Get all the dimensions.
     *
     * @param pageable the pagination information
     * 
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DimensionDTO> findAllDimensions(Pageable pageable) {
        log.debug("Request to get all Dimensions");
        return dimensionRepository.findAll(pageable)
            .map(dimensionMapper::toDto);
    }


    /**
     * Get the "status" committedActivity.
     *
     * @param status the status of the entity
     * @param pageable the pagination information
     * 
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CommittedActivityAggregate> findAllCommittedActivitiesByStatus(Pageable pageable,Status status) {
        log.debug("Request to get all CommittedActivities by status");
        
        List<CommittedActivityAggregate> committedActivityAggregateList=new ArrayList<CommittedActivityAggregate>();
        
        CommittedActivityAggregate committedActivityAggregate= new CommittedActivityAggregate();
        
        List<CommittedActivityDTO> committedActivityDtoDoneList=new ArrayList<CommittedActivityDTO>();
        
        Base64Encoder encoder = new Base64Encoder();
                
        Page<CommittedActivityDTO> page=committedActivityRepository.findAll(pageable).map(committedActivityMapper::toDto);
                
        for(CommittedActivityDTO committedActivityDTO : page.getContent())
        {
        	if(committedActivityDTO.getStatus()==status)
        		committedActivityDtoDoneList.add(committedActivityDTO);        		
        }
        
        for(CommittedActivityDTO committedActivityDto : committedActivityDtoDoneList)
        {
        	committedActivityAggregate.setCommittedActivityId(committedActivityDto.getId());
        	committedActivityAggregate.setCommittedActivityDescription(committedActivityDto.getDescription());
        	committedActivityAggregate.setActivityId(committedActivityDto.getActivityId()); 
        	          	
        	Optional<ActivityDTO> activitydto=activityRepository.findById(committedActivityDto.getActivityId()).map(activityMapper::toDto);
        	ActivityDTO activityDTO=activitydto.get();
        	
        	if(activityDTO != null)
        	{
        		
        		committedActivityAggregate.setActivityCreatedDate(activityDTO.getCreatedDate());
        		committedActivityAggregate.setTitle(activityDTO.getTitle());
        		committedActivityAggregate.setActivityDescription(activityDTO.getDescription());
        		committedActivityAggregate.setType(activityDTO.getType());
        		committedActivityAggregate.setChallengeId(activityDTO.getChallengeId());
        		committedActivityAggregate.setDimensions(activityDTO.getDimensions());
        		committedActivityAggregate.setProofType(activityDTO.getProofType());  
        		committedActivityAggregate.setSuccessMessage(activityDTO.getSuccessMessage());
        		
        	}
        	
        	Optional<RegisteredUserDTO> registeredUserdto=registeredUserRepository.findById(committedActivityDto.getRegisteredUserId()).map(registeredUserMapper::toDto);
        	RegisteredUserDTO registeredUserDto =  registeredUserdto.get();
        	       	
        	if(registeredUserDto != null)
        	{
        	   committedActivityAggregate.setProfilePictureContentType(registeredUserDto.getProfilePictureContentType());
        	   
        	   if(registeredUserDto.getProfilePictureContentType().contains("image"))
 		       {
 			    String profilePic= encoder.encode(registeredUserDto.getProfilePicture());
 			    committedActivityAggregate.setProfilePicture(profilePic);				
 		       }
        	   
        	   committedActivityAggregate.setFirstName(registeredUserDto.getFirstName());
        	   
        	}
        	       	
        	Optional<MediaDTO> media=mediaRepository.findByCommittedActivityId(committedActivityDto.getId()).map(mediaMapper::toDto);
        	MediaDTO mediaDto=media.get();
        	
            if(mediaDto != null)    
            {
            	if(mediaDto.getFileContentType().contains("image"))
  		        {
  			    String image= encoder.encode(mediaDto.getFile());
  			    committedActivityAggregate.setImageString(image);
  					
  		        }       	        	
            }
            
            committedActivityAggregate.setTimeElapsed(calculateTimeDifferenceBetweenCurrentAndPostedTime(committedActivityDto.getCreatedDate()));
            committedActivityAggregate.setNoOfReferences(committedActivityRepository.findNumberOfCommittedActivityByReferenceId(committedActivityDto.getId()));
            
        	committedActivityAggregateList.add(committedActivityAggregate);
        	
        	
        }
        
        Page<CommittedActivityAggregate> pagee = new PageImpl<CommittedActivityAggregate>(committedActivityAggregateList, pageable, committedActivityAggregateList.size());

		return pagee;
        
    }
    
  
 	/**
 	 * Find time difference between current date and posted date.
 	 *
 	 * @param postedDateTime
 	 *            to find the time
 	 * 
 	 * @return the time
 	 */

 	@Override
 	public String calculateTimeDifferenceBetweenCurrentAndPostedTime(ZonedDateTime postedDateTime) {
 		
 		long offsetMillis = ZoneOffset.from(postedDateTime).getTotalSeconds() * 1000;
 		long isoMillis = postedDateTime.toInstant().toEpochMilli();
 		Date date = new Date(isoMillis + offsetMillis);
 				
 		Instant instant = Instant.now();
 		long hours = 5;
 		long minutes = 30;
 		Instant instant1 = instant.plus(hours, ChronoUnit.HOURS).plus(minutes, ChronoUnit.MINUTES);

 		Date current = Date.from(instant1);
 		long diffInSecond = 0l;
 		String diffInString = null;
 		if (date != null) {
 			diffInSecond = (current.getTime() - date.getTime()) / 1000l;
 		}
 		long postedBefore = 0l;
 		if (diffInSecond < 60l) {
 			diffInString = "just now";
 		} else if (diffInSecond < 3600l) {
 			postedBefore = diffInSecond / 60l;
 			diffInString = postedBefore + " minutes ago";
 		} else if (diffInSecond < 86400l) {
 			postedBefore = diffInSecond / 3600l;
 			diffInString = postedBefore + " hours ago";
 		} else if (diffInSecond < 2592000l) {
 			postedBefore = diffInSecond / 86400l;
 			diffInString = postedBefore + " days ago";
 		} else if (diffInSecond < 31104000l) {
 			postedBefore = diffInSecond / 2592000l;
 			diffInString = postedBefore + " months ago";
 		} else {
 			postedBefore = diffInSecond / 31104000l;
 			diffInString = postedBefore + " years ago";
 		}

 		return diffInString;
 	}
    
	
    /**
     * Get one registeredUser by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<RegisteredUserAggregate> findOneRegisteredUserByUserId(String userId) {
        log.debug("Request to get RegisteredUser : {}", userId);
       
        RegisteredUserAggregate registeredUserAggregate =new RegisteredUserAggregate();
        
        Base64Encoder encoder = new Base64Encoder();
                   
        Optional<RegisteredUserDTO> registeredUserDTO=registeredUserRepository.findByUserId(userId).map(registeredUserMapper::toDto);
        
        RegisteredUserDTO registeredUserDto=registeredUserDTO.get();
        	
        if(registeredUserDto!=null)	
        {
        registeredUserAggregate.setId(registeredUserDto.getId());	
        registeredUserAggregate.setFirstName(registeredUserDto.getFirstName());
        registeredUserAggregate.setLastName(registeredUserDto.getLastName());
        registeredUserAggregate.setUserId(registeredUserDto.getUserId());
        registeredUserAggregate.setEmail(registeredUserDto.getEmail());
        registeredUserAggregate.setCoverPhotoContentType(registeredUserDto.getCoverPhotoContentType());
        registeredUserAggregate.setProfilePictureContentType(registeredUserDto.getProfilePictureContentType());
        
          if(registeredUserDto.getCoverPhotoContentType().contains("image")) 
        	{
      		   String coverPhoto= encoder.encode(registeredUserDto.getCoverPhoto());
			   registeredUserAggregate.setCoverPhoto(coverPhoto);
        	}
		  if(registeredUserDto.getProfilePictureContentType().contains("image"))
		   {
			String profilePic= encoder.encode(registeredUserDto.getProfilePicture());
			registeredUserAggregate.setProfilePicture(profilePic);				
		   }
                          
        }
                
        return Optional.of(registeredUserAggregate);
        
    }
    
    /**
     * Get all the activities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ActivityAggregate> findAllActivities(Pageable pageable) {
        log.debug("Request to get all Activities");
        
        
         activityRepository.findAll(pageable)
            .map(activityMapper::toDto);
         
         return null;
    }
	
	
}
