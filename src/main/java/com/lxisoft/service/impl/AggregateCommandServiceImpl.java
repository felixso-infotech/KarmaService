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
package com.lxisoft.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.domain.CompletedActivity;
import com.lxisoft.domain.Media;
import com.lxisoft.domain.RegisteredUser;
import com.lxisoft.repository.CompletedActivityRepository;
import com.lxisoft.repository.MediaRepository;
import com.lxisoft.repository.RegisteredUserRepository;
import com.lxisoft.service.AggregateCommandService;
import com.lxisoft.service.dto.CompletedActivityDTO;
import com.lxisoft.service.dto.MediaDTO;
import com.lxisoft.service.dto.RegisteredUserDTO;
import com.lxisoft.service.mapper.CompletedActivityMapper;
import com.lxisoft.service.mapper.MediaMapper;
import com.lxisoft.service.mapper.RegisteredUserMapper;

@Service
@Transactional
public class AggregateCommandServiceImpl implements AggregateCommandService {
	
	private final Logger log = LoggerFactory.getLogger(AggregateCommandServiceImpl.class);

	private final RegisteredUserRepository registeredUserRepository;

	private final RegisteredUserMapper registeredUserMapper;

	private final CompletedActivityRepository completedActivityRepository;

	private final MediaRepository mediaRepository;

	private final MediaMapper mediaMapper;

	private final CompletedActivityMapper completedActivityMapper;

	
	public AggregateCommandServiceImpl(RegisteredUserRepository registeredUserRepository,
			RegisteredUserMapper registeredUserMapper,CompletedActivityRepository completedActivityRepository,
			MediaRepository mediaRepository, MediaMapper mediaMapper, CompletedActivityMapper completedActivityMapper) {
		super();
		this.registeredUserRepository = registeredUserRepository;
		this.registeredUserMapper = registeredUserMapper;		
		this.completedActivityRepository = completedActivityRepository;
		this.mediaRepository = mediaRepository;
		this.mediaMapper = mediaMapper;
		this.completedActivityMapper = completedActivityMapper;		
	}

	/**
	 * Save a registeredUser.
	 *
	 * @param RegisteredUserDTO the entity to save
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
	 * Save a registeredActivity.
	 *
	 * @param CompletedActivityDTO the entity to save
	 * @return the persisted entity
	 */
	@Override
	public CompletedActivityDTO saveCompletedActivity(CompletedActivityDTO completedActivityDTO) {

		CompletedActivity completedActivity = completedActivityMapper.toEntity(completedActivityDTO);
		completedActivity = completedActivityRepository.save(completedActivity);
		return completedActivityMapper.toDto(completedActivity);
	}

	/**
	 * Save a media.
	 *
	 * @param MediaDTO the entity to save
	 * @return the persisted entity
	 */
	@Override
	public MediaDTO saveMedia(MediaDTO mediaDTO) {
		Media media = mediaMapper.toEntity(mediaDTO);
		media = mediaRepository.save(media);
		return mediaMapper.toDto(media);
	}
}
