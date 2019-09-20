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
package com.felixsoinfotech.karma.model;

import java.util.ArrayList;
import java.util.List;

import com.felixsoinfotech.karma.service.dto.ActivityDTO;
import com.felixsoinfotech.karma.service.dto.IntroductionStoryDTO;

/**
 * 
 */
public class ActivityAggregate {
	
    private Long id;
    
	private ActivityDTO activityDTO;
	
	private List<IntroductionStoryDTO> introductionStories= new ArrayList<IntroductionStoryDTO>();
   
	 /**
	  * @return the id
	  */
	public Long getId() {
			return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
	this.id = id;
	}
		
    /**
	 * @return the activityDTO
	 */
	public ActivityDTO getActivityDTO() {
		return activityDTO;
	}
	/**
	 * @param activityDTO the activityDTO to set
	 */
	public void setActivityDTO(ActivityDTO activityDTO) {
		this.activityDTO = activityDTO;
	}
	/**
	 * @return the introductionStories
	 */
	public List<IntroductionStoryDTO> getIntroductionStories() {
		return introductionStories;
	}
	/**
	 * @param introductionStories the introductionStories to set
	 */
	public void setIntroductionStories(List<IntroductionStoryDTO> introductionStories) {
		this.introductionStories = introductionStories;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityDTO == null) ? 0 : activityDTO.hashCode());
		result = prime * result + ((introductionStories == null) ? 0 : introductionStories.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityAggregate other = (ActivityAggregate) obj;
		if (activityDTO == null) {
			if (other.activityDTO != null)
				return false;
		} else if (!activityDTO.equals(other.activityDTO))
			return false;
		if (introductionStories == null) {
			if (other.introductionStories != null)
				return false;
		} else if (!introductionStories.equals(other.introductionStories))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActivityAggregate [activityDTO=" + activityDTO + ", introductionStories=" + introductionStories + "]";
	}
	
	
	
	
	}
