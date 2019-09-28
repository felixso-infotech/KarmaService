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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felixsoinfotech.karma.domain.User;
import com.felixsoinfotech.karma.domain.enumeration.ProofType;
import com.felixsoinfotech.karma.domain.enumeration.Status;
import com.felixsoinfotech.karma.domain.enumeration.Type;
import com.felixsoinfotech.karma.model.RegisteredUserAggregate;
import com.felixsoinfotech.karma.repository.ActivityRepository;
import com.felixsoinfotech.karma.repository.CommittedActivityRepository;
import com.felixsoinfotech.karma.repository.DimensionRepository;
import com.felixsoinfotech.karma.repository.RegisteredUserRepository;
import com.felixsoinfotech.karma.repository.UserRepository;
import com.felixsoinfotech.karma.service.AggregateQueryService;

import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;
import com.felixsoinfotech.karma.service.dto.DimensionDTO;
import com.felixsoinfotech.karma.service.dto.RegisteredUserDTO;
import com.felixsoinfotech.karma.service.dto.UserDTO;
import com.felixsoinfotech.karma.service.mapper.ActivityMapper;
import com.felixsoinfotech.karma.service.mapper.CommittedActivityMapper;
import com.felixsoinfotech.karma.service.mapper.DimensionMapper;
import com.felixsoinfotech.karma.service.mapper.RegisteredUserMapper;
import com.felixsoinfotech.karma.service.mapper.UserMapper;
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
    
    private UserRepository userRepository;
    
    private UserMapper userMapper;
    

	public AggregateQueryServiceImpl(ActivityRepository activityRepository, ActivityMapper activityMapper,
			                         DimensionRepository dimensionRepository,DimensionMapper dimensionMapper,
			                         CommittedActivityRepository committedActivityRepository,CommittedActivityMapper committedActivityMapper,
			                         RegisteredUserRepository registeredUserRepository, RegisteredUserMapper registeredUserMapper,
			                         UserRepository userRepository,UserMapper userMapper) {
		this.activityRepository = activityRepository;
		this.activityMapper = activityMapper;
		this.dimensionRepository=dimensionRepository;
		this.dimensionMapper=dimensionMapper;
		this.committedActivityRepository=committedActivityRepository;
		this.committedActivityMapper=committedActivityMapper;
		this.registeredUserRepository = registeredUserRepository;
        this.registeredUserMapper = registeredUserMapper;
        this.userMapper=userMapper;
        this.userRepository=userRepository;
        
        
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
    public Page<CommittedActivityDTO> findAllCommittedActivitiesByStatus(Pageable pageable,Status status) {
        log.debug("Request to get all CommittedActivities by status");
        
        List<CommittedActivityDTO> committedActivityDtoDoneList=new ArrayList<CommittedActivityDTO>();
        
        Page<CommittedActivityDTO> page=committedActivityRepository.findAll(pageable).map(committedActivityMapper::toDto);
                
        for(CommittedActivityDTO committedActivityDTO : page.getContent())
        {
        	if(committedActivityDTO.getStatus()==status)
        		committedActivityDtoDoneList.add(committedActivityDTO);        		
        }
        
        Page<CommittedActivityDTO> pagee = new PageImpl<CommittedActivityDTO>(committedActivityDtoDoneList, pageable, committedActivityDtoDoneList.size());

		return pagee;
        
    }
    
    
    /**
     * Get all the committedActivities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CommittedActivityDTO> findAllCommittedActivities(Pageable pageable) {
        log.debug("Request to get all CommittedActivities");
        return committedActivityRepository.findAll(pageable)
            .map(committedActivityMapper::toDto);
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
        
        Optional<RegisteredUserDTO> registeredUserDTO=registeredUserRepository.findById(userId).map(registeredUserMapper::toDto);
        
        Optional<UserDTO> userDTO = userRepository.findById(userId).map(userMapper::userToUserDTO);
        
        RegisteredUserDTO registeredUserDto = registeredUserDTO.get();
        
        UserDTO userDto=userDTO.get();
       
        if((userDto!=null) && (registeredUserDto!=null))
        {	
        registeredUserAggregate.setFirstName(userDto.getFirstName());
        registeredUserAggregate.setLastName(userDto.getLastName());
        registeredUserAggregate.setEmail(userDto.getEmail());
        registeredUserAggregate.setUserId(userDto.getId());
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
	
	
}
