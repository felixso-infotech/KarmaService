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

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.felixsoinfotech.karma.domain.enumeration.Type;

/**
 * 
 */
public class ActivityViewAggregate {
	
	private Long activityId;

	private String title;
	
	private Type type;
	
	private Long challengeId;
	
	private String challengeName;
	
	private ZonedDateTime createdDate;
	
    private String imageString;
    
    private String imageStringContentType;
	
	List<ActivityImageAggregate> introductionStories =new ArrayList<ActivityImageAggregate>();	
	
	
	
	public String getImageString() {
		return imageString;
	}

	public void setImageString(String imageString) {
		this.imageString = imageString;
	}

	public String getImageStringContentType() {
		return imageStringContentType;
	}

	public void setImageStringContentType(String imageStringContentType) {
		this.imageStringContentType = imageStringContentType;
	}

	/**
	 * @return the introductionStories
	 */
	public List<ActivityImageAggregate> getIntroductionStories() {
		return introductionStories;
	}

	/**
	 * @param introductionStories the introductionStories to set
	 */
	public void setIntroductionStories(List<ActivityImageAggregate> introductionStories) {
		this.introductionStories = introductionStories;
	}

	/**
	 * @return the challengeName
	 */
	public String getChallengeName() {
		return challengeName;
	}

	/**
	 * @param challengeName the challengeName to set
	 */
	public void setChallengeName(String challengeName) {
		this.challengeName = challengeName;
	}

	/**
	 * @return the activityId
	 */
	public Long getActivityId() {
		return activityId;
	}

	/**
	 * @param activityId the activityId to set
	 */
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the challengeId
	 */
	public Long getChallengeId() {
		return challengeId;
	}

	/**
	 * @param challengeId the challengeId to set
	 */
	public void setChallengeId(Long challengeId) {
		this.challengeId = challengeId;
	}

	/**
	 * @return the createdDate
	 */
	public ZonedDateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(ZonedDateTime createdDate) {
		this.createdDate = createdDate;
	}

	
    
    
	
	

}
