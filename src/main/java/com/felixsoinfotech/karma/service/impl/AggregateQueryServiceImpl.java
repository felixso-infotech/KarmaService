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

import com.felixsoinfotech.karma.domain.Media;
import com.felixsoinfotech.karma.domain.enumeration.ProofType;
import com.felixsoinfotech.karma.domain.enumeration.Status;
import com.felixsoinfotech.karma.domain.enumeration.Type;
import com.felixsoinfotech.karma.model.ActivityViewAggregate;
import com.felixsoinfotech.karma.model.CommittedActivityAggregate;
import com.felixsoinfotech.karma.model.CommittedActivityProfileAggregate;
import com.felixsoinfotech.karma.model.RegisteredUserAggregate;
import com.felixsoinfotech.karma.repository.ActivityRepository;
import com.felixsoinfotech.karma.repository.ChallengeRepository;
import com.felixsoinfotech.karma.repository.CommittedActivityRepository;
import com.felixsoinfotech.karma.repository.DimensionRepository;
import com.felixsoinfotech.karma.repository.IntroductionStoryRepository;
import com.felixsoinfotech.karma.repository.MediaRepository;
import com.felixsoinfotech.karma.repository.RegisteredUserRepository;


import com.felixsoinfotech.karma.service.AggregateQueryService;
import com.felixsoinfotech.karma.service.dto.ActivityDTO;
import com.felixsoinfotech.karma.service.dto.ChallengeDTO;
import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;
import com.felixsoinfotech.karma.service.dto.DimensionDTO;
import com.felixsoinfotech.karma.service.dto.IntroductionStoryDTO;
import com.felixsoinfotech.karma.service.dto.MediaDTO;
import com.felixsoinfotech.karma.service.dto.RegisteredUserDTO;


import com.felixsoinfotech.karma.service.mapper.ActivityMapper;
import com.felixsoinfotech.karma.service.mapper.ChallengeMapper;
import com.felixsoinfotech.karma.service.mapper.CommittedActivityMapper;
import com.felixsoinfotech.karma.service.mapper.DimensionMapper;
import com.felixsoinfotech.karma.service.mapper.IntroductionStoryMapper;
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
    
    private ChallengeRepository challengeRepository;
    
    private ChallengeMapper challengeMapper;
    
    private IntroductionStoryRepository introductionStoryRepository;
    
    private IntroductionStoryMapper introductionStoryMapper;
    

	public AggregateQueryServiceImpl(ActivityRepository activityRepository, ActivityMapper activityMapper,
			                         DimensionRepository dimensionRepository,DimensionMapper dimensionMapper,
			                         CommittedActivityRepository committedActivityRepository,CommittedActivityMapper committedActivityMapper,
			                         RegisteredUserRepository registeredUserRepository, RegisteredUserMapper registeredUserMapper,
			                         MediaRepository mediaRepository, MediaMapper mediaMapper,
			                         ChallengeRepository challengeRepository,ChallengeMapper challengeMapper,
			                         IntroductionStoryRepository introductionStoryRepository,IntroductionStoryMapper introductionStoryMapper) {
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
        this.challengeRepository=challengeRepository;
        this.challengeMapper =challengeMapper;
        this.introductionStoryRepository=introductionStoryRepository;
        this.introductionStoryMapper=introductionStoryMapper;
        
        
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
    public Page<CommittedActivityAggregate> findAllCommittedActivitiesByStatus(Pageable pageable,String status) {
        log.debug("Request to get all CommittedActivities by status");
        
        List<CommittedActivityAggregate> committedActivityAggregateList=new ArrayList<CommittedActivityAggregate>();
        
        CommittedActivityAggregate committedActivityAggregate;
        
        List<CommittedActivityDTO> committedActivityDtoDoneList = null;;
        
        Base64Encoder encoder = new Base64Encoder();
                
        committedActivityDtoDoneList=committedActivityRepository.findAllCommittedActivitiesByStatus(pageable,Status.valueOf(status)).map(committedActivityMapper::toDto).getContent();
                
        
        for(CommittedActivityDTO committedActivityDto : committedActivityDtoDoneList)
        {
        	committedActivityAggregate= new CommittedActivityAggregate();
        	
         if(committedActivityDto != null)
         {
        	        	
        	committedActivityAggregate.setCommittedActivityId(committedActivityDto.getId());
        	committedActivityAggregate.setCommittedActivityDescription(committedActivityDto.getDescription());
        	committedActivityAggregate.setActivityId(committedActivityDto.getActivityId()); 
        	          	
        	ActivityDTO activityDTO=activityRepository.findById(committedActivityDto.getActivityId()).map(activityMapper::toDto).get();
        	
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
        	
               	
            if(committedActivityDto.getRegisteredUserId() != null)
            {
            
             RegisteredUserDTO registeredUserDto=registeredUserRepository.findById(committedActivityDto.getRegisteredUserId()).map(registeredUserMapper::toDto).get();
        	       	       	
        	   if(registeredUserDto != null)
        	   {
        		
        	     if(registeredUserDto.getProfilePictureContentType()!=null && registeredUserDto.getProfilePicture()!=null && registeredUserDto.getProfilePictureContentType().contains("image"))
     		     {
     			   String profilePic= encoder.encode(registeredUserDto.getProfilePicture());
     			   committedActivityAggregate.setProfilePicture(profilePic);
     			   committedActivityAggregate.setProfilePictureContentType(registeredUserDto.getProfilePictureContentType());
     		     }      	  
        	   
        	   committedActivityAggregate.setFirstName(registeredUserDto.getFirstName());
        	   committedActivityAggregate.setLastName(registeredUserDto.getLastName());
        	   committedActivityAggregate.setUserId(registeredUserDto.getUserId());
        	   
        	   }
            }
            
            if(committedActivityDto.getId() != null)
            {
        	       	
        	Media media=mediaRepository.findByCommittedActivityId(committedActivityDto.getId());
        	MediaDTO mediaDto = mediaMapper.toDto(media);
        	
            if(mediaDto != null)    
            {           	
            	if(mediaDto.getFileContentType()!=null && mediaDto.getFile()!=null && mediaDto.getFileContentType().contains("image"))
  		        {
            		
  			    String image= encoder.encode(mediaDto.getFile());
  			    committedActivityAggregate.setImageString(image);
  			    committedActivityAggregate.setImageStringContentType(mediaDto.getFileContentType());
  					
  		        }       	        	
            }
                       
            committedActivityAggregate.setNoOfReferences(committedActivityRepository.findNumberOfCommittedActivityByReferenceId(committedActivityDto.getId()));
            }
            
        	committedActivityAggregateList.add(committedActivityAggregate);
         }
        	
        }
        
        Page<CommittedActivityAggregate> pagee = new PageImpl<CommittedActivityAggregate>(committedActivityAggregateList, pageable, committedActivityAggregateList.size());

		return pagee;
        
    }
    
    /**
     * Get the "status" committedActivity.
     *
     * @param status the status of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
	public Page<CommittedActivityProfileAggregate> findAllCommittedActivitiesByStatusAndRegisteredUserId(Pageable pageable,String status,Long registeredUserId)
	{
        
		List<CommittedActivityProfileAggregate> committedActivityProfileAggregateList=new ArrayList<CommittedActivityProfileAggregate>();
        
		CommittedActivityProfileAggregate committedActivityProfileAggregate;
        
        List<CommittedActivityDTO> registerUserCommittedActivityList = null;;
        
        Base64Encoder encoder = new Base64Encoder();
                
        registerUserCommittedActivityList=committedActivityRepository.findAllCommittedActivitiesByStatusAndRegisteredUserId(pageable,Status.valueOf(status),registeredUserId).map(committedActivityMapper::toDto).getContent();
           
        for(CommittedActivityDTO committedActivityDto : registerUserCommittedActivityList)
        {
        	committedActivityProfileAggregate= new CommittedActivityProfileAggregate();
        	
        	if(committedActivityDto != null)
        	{  
        		committedActivityProfileAggregate.setStatus(committedActivityDto.getStatus());
                committedActivityProfileAggregate.setCommittedActivityCreatedDate(committedActivityDto.getCreatedDate());
          		
        	    if(committedActivityDto.getActivityId() != null)
        	    {
        	    	ActivityDTO activityDto = activityRepository.findOneWithEagerRelationships(committedActivityDto.getActivityId()).map(activityMapper::toDto).get();
        	    	  
        	    	  if(activityDto != null)
        	    	  {
        	    		  committedActivityProfileAggregate.setActivityId(activityDto.getId());
        	    		  committedActivityProfileAggregate.setActivityTitle(activityDto.getTitle());        	    		  
        	    		  committedActivityProfileAggregate.setType(activityDto.getType());
        	    		  
        	    	  }
        	    	  
        	    	  List<IntroductionStoryDTO> introductionStoryDTOs = introductionStoryRepository.findAllIntroductionStoriesByActivityId(pageable,committedActivityDto.getActivityId())
        	    			                                            .map(introductionStoryMapper::toDto).getContent();
        	    	  
        	    		  if(introductionStoryDTOs.get(0) != null)
        	    		  {
        	    			 
        	    			   if(introductionStoryDTOs.get(0).getImage()!=null && introductionStoryDTOs.get(0).getImageContentType()!=null && introductionStoryDTOs.get(0).getImageContentType().contains("image"))
        	    			   {
        	    				   committedActivityProfileAggregate.setActivityImageString(encoder.encode(introductionStoryDTOs.get(0).getImage()));  
        	    				   committedActivityProfileAggregate.setActivityImageContentType(introductionStoryDTOs.get(0).getImageContentType()); 
        	    			   }
        	    		  }
        	    	  
        	    	        	    	  
        	    }       	
        	       
        	    
        	if(committedActivityDto.getId() != null) 
        	{
        	
              committedActivityProfileAggregate.setCommittedActivityId(committedActivityDto.getId());
              
        	  //MediaDTO mediaDto=mediaRepository.findByCommittedActivityId(committedActivityDto.getId()).map(mediaMapper::toDto).get();
            
               Media media=mediaRepository.findByCommittedActivityId(committedActivityDto.getId());
        	   MediaDTO mediaDto = mediaMapper.toDto(media);
        	   
        	   System.out.println("\n\n\t********************************************\t"+committedActivityDto.getId()+"\t->"+mediaDto+"*************************************\n\n\t");
        	
                if(mediaDto != null)    
                {
                	//System.out.println("\n\n\t in the if condition ********************************************\t"+committedActivityDto.getId()+"\t->"+mediaDto.getFile()+"\t"+mediaDto.getFileContentType()+"*************************************\n\n\t");
            	        
                	if(mediaDto.getFile()!=null && mediaDto.getFileContentType()!=null && mediaDto.getFileContentType().contains("image"))
            	        {
                		    
                		//System.out.println("\n\n\t in the file check condition ********************************************\t"+committedActivityDto.getId()+"\t->"+mediaDto.getFile()+"\t"+mediaDto.getFileContentType()+"*************************************\n\n\t");
                		
                		    String imgString = encoder.encode(mediaDto.getFile());
                		    
                		    //System.out.println("\n\n\t encode the file ********************************************\t"+imgString+"*********************");
                		    
            	        	committedActivityProfileAggregate.setProofImageString(imgString); 	
            	            committedActivityProfileAggregate.setProofImageContentType(mediaDto.getFileContentType());
            	        }
                 }
        	}    
            
            committedActivityProfileAggregateList.add(committedActivityProfileAggregate);
        	
         }
        	
        }
        
        Page<CommittedActivityProfileAggregate> pagee = new PageImpl<CommittedActivityProfileAggregate>(committedActivityProfileAggregateList, pageable, committedActivityProfileAggregateList.size());

		return pagee;

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
        
        
          if(registeredUserDto.getCoverPhotoContentType()!=null && registeredUserDto.getCoverPhoto()!=null && registeredUserDto.getCoverPhotoContentType().contains("image")) 
        	{
      		   String coverPhoto= encoder.encode(registeredUserDto.getCoverPhoto());
			   registeredUserAggregate.setCoverPhoto(coverPhoto);
        	}
		  if(registeredUserDto.getProfilePictureContentType()!=null && registeredUserDto.getProfilePicture()!=null && registeredUserDto.getProfilePictureContentType().contains("image"))
		   {
			String profilePic= encoder.encode(registeredUserDto.getProfilePicture());
			registeredUserAggregate.setProfilePicture(profilePic);				
		   }
		  
		  registeredUserAggregate.setNoOfCompletedTasks(committedActivityRepository.findNumberOfCompletedCommittedActivitiesByRegisteredUserId(registeredUserDto.getId(),Status.DONE));
		  
		  //System.out.println(committedActivityRepository.findNumberOfCompletedCommittedActivitiesByRegisteredUserId(registeredUserDto.getUserId(),Status.DONE));
                          
        }
                
        return Optional.of(registeredUserAggregate);
        
    }
    
    
    /**
     * Get all the Activity with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    public Page<ActivityViewAggregate> findAllActivities(Pageable pageable) {
    	
    	List<ActivityViewAggregate> activityViewAggregateList = new ArrayList<ActivityViewAggregate>();
    	
    	ActivityViewAggregate activityViewAggregate;
    	
    	Base64Encoder encoder = new Base64Encoder();
    	
        List<ActivityDTO> activityDTOs = activityRepository.findAllWithEagerRelationships(pageable).map(activityMapper::toDto).getContent();
        
        for(ActivityDTO activityDto : activityDTOs)
        {
        	if(activityDto != null)
        	{
        		activityViewAggregate = new ActivityViewAggregate();
        		
        		activityViewAggregate.setActivityId(activityDto.getId());
        		activityViewAggregate.setTitle(activityDto.getTitle()); 
        		activityViewAggregate.setType(activityDto.getType());
        		activityViewAggregate.setCreatedDate(activityDto.getCreatedDate());
        		
        		   if(activityDto.getChallengeId() != null)
        		   {
        			   ChallengeDTO challengeDTO = challengeRepository.findById(activityDto.getChallengeId()).map(challengeMapper::toDto).get();
        			      if(challengeDTO != null)
        			      {
        			    	  activityViewAggregate.setChallengeId(activityDto.getChallengeId());
        			    	  activityViewAggregate.setChallengeName(challengeDTO.getName());
        			      }
        		   }   
        			   
        		   if(activityDto.getId() != null)
        		   {
        			  List<IntroductionStoryDTO> introductionStoryDTOs = introductionStoryRepository.findAllIntroductionStoriesByActivityId(pageable,activityDto.getId()).map(introductionStoryMapper::toDto).getContent();
        		   
                     
                         if(introductionStoryDTOs.get(0) != null)
                          {
                        	  
                                if(introductionStoryDTOs.get(0).getImage()!=null && introductionStoryDTOs.get(0).getImageContentType()!=null && introductionStoryDTOs.get(0).getImageContentType().contains("image"))
                                {
                                	activityViewAggregate.setImageString(encoder.encode(introductionStoryDTOs.get(0).getImage()));  
                                    activityViewAggregate.setImageStringContentType(introductionStoryDTOs.get(0).getImageContentType());
                                }
                          }
                      
        		   } 
        		   
        		   activityViewAggregateList.add(activityViewAggregate);
        	    }
           }
        
        Page<ActivityViewAggregate> pagee = new PageImpl<ActivityViewAggregate>(activityViewAggregateList, pageable, activityViewAggregateList.size());

		return pagee;
    }
    
    /**
     * Get all the challenges.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ChallengeDTO> findAllChallenges(Pageable pageable) {
        log.debug("Request to get all Challenges");
        return challengeRepository.findAll(pageable)
            .map(challengeMapper::toDto);
    }
	
	
}
