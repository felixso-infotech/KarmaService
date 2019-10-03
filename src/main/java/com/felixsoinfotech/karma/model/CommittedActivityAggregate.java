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


/**
 * 
 */
public class CommittedActivityAggregate {

	private Long id;

    private String description;

    private Long activityId;

    private String userId;
    
    private String profilePicture;
    
    private String profilePictureContentType;
		 	
    private String firstName;

    private String lastName;

    private Long noOfReferences;
    
    private String imageString;
    
    private String videoString;
    
    private String timeElapsed;

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	/**
	 * @return the profilePictureContentType
	 */
	public String getProfilePictureContentType() {
		return profilePictureContentType;
	}

	/**
	 * @param profilePictureContentType the profilePictureContentType to set
	 */
	public void setProfilePictureContentType(String profilePictureContentType) {
		this.profilePictureContentType = profilePictureContentType;
	}
	

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
	/**
	 * @return the imageString
	 */
	public String getImageString() {
		return imageString;
	}

	/**
	 * @param imageString the imageString to set
	 */
	public void setImageString(String imageString) {
		this.imageString = imageString;
	}

	/**
	 * @return the videoString
	 */
	public String getVideoString() {
		return videoString;
	}

	/**
	 * @param videoString the videoString to set
	 */
	public void setVideoString(String videoString) {
		this.videoString = videoString;
	}

	/**
	 * @return the noOfReferences
	 */
	public Long getNoOfReferences() {
		return noOfReferences;
	}

	/**
	 * @param noOfReferences the noOfReferences to set
	 */
	public void setNoOfReferences(Long noOfReferences) {
		this.noOfReferences = noOfReferences;
	}

	/**
	 * @return the timeElapsed
	 */
	public String getTimeElapsed() {
		return timeElapsed;
	}

	/**
	 * @param timeElapsed the timeElapsed to set
	 */
	public void setTimeElapsed(String timeElapsed) {
		this.timeElapsed = timeElapsed;
	}
    
    
	
    
    
    

}
