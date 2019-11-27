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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.felixsoinfotech.karma.domain.enumeration.ProofType;
import com.felixsoinfotech.karma.domain.enumeration.Status;
import com.felixsoinfotech.karma.domain.enumeration.Type;
import com.felixsoinfotech.karma.service.dto.DimensionDTO;

/**
 * 
 */
public class CommittedActivityAggregate {

	private Long CommittedActivityId;

    private String committedActivityDescription;

    private Long activityId;
    
    private String title;

    private String activityDescription;

    private String successMessage;

    private Type type;
    
    private Status status;

    private ZonedDateTime committedActivityCreatedDate;

    private ProofType proofType;

    private Long challengeId;

    private Set<DimensionDTO> dimensions = new HashSet<>();

    private String userId;
    
    private String profilePicture;
    
    private String profilePictureContentType;
		 	
    private String firstName;

    private String lastName;

    private Long noOfReferences;
    
    private String imageString;
    
    private String imageStringContentType;
    
    private String videoString;
    
    private String videoStringContentType;
    
    private String timeElapsed;
    
    private Long noOfLoves;
    
	private Long noOfComments;
		
	private boolean isLiked;
	
	
		
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the isLiked
	 */
	public boolean isLiked() {
		return isLiked;
	}

	/**
	 * @param isLiked the isLiked to set
	 */
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}

	/**
	 * @return the imageStringContentType
	 */
	public String getImageStringContentType() {
		return imageStringContentType;
	}

	/**
	 * @param imageStringContentType the imageStringContentType to set
	 */
	public void setImageStringContentType(String imageStringContentType) {
		this.imageStringContentType = imageStringContentType;
	}

	/**
	 * @return the videoStringContentType
	 */
	public String getVideoStringContentType() {
		return videoStringContentType;
	}

	/**
	 * @param videoStringContentType the videoStringContentType to set
	 */
	public void setVideoStringContentType(String videoStringContentType) {
		this.videoStringContentType = videoStringContentType;
	}

	/**
	 * @return the noOfLoves
	 */
	public Long getNoOfLoves() {
		return noOfLoves;
	}

	/**
	 * @param noOfLoves the noOfLoves to set
	 */
	public void setNoOfLoves(Long noOfLoves) {
		this.noOfLoves = noOfLoves;
	}

	/**
	 * @return the noOfComments
	 */
	public Long getNoOfComments() {
		return noOfComments;
	}

	/**
	 * @param noOfComments the noOfComments to set
	 */
	public void setNoOfComments(Long noOfComments) {
		this.noOfComments = noOfComments;
	}

	

	/**
	 * @return the committedActivityId
	 */
	public Long getCommittedActivityId() {
		return CommittedActivityId;
	}

	/**
	 * @param committedActivityId the committedActivityId to set
	 */
	public void setCommittedActivityId(Long committedActivityId) {
		CommittedActivityId = committedActivityId;
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
	 * @return the activityDescription
	 */
	public String getActivityDescription() {
		return activityDescription;
	}

	/**
	 * @param activityDescription the activityDescription to set
	 */
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	/**
	 * @return the successMessage
	 */
	public String getSuccessMessage() {
		return successMessage;
	}

	/**
	 * @param successMessage the successMessage to set
	 */
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
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
	 * @return the activityCreatedDate
	 */
	public ZonedDateTime getCommittedActivityCreatedDate() {
		return committedActivityCreatedDate;
	}

	/**
	 * @param activityCreatedDate the activityCreatedDate to set
	 */
	public void setCommittedActivityCreatedDate(ZonedDateTime committedActivityCreatedDate) {
		this.committedActivityCreatedDate = committedActivityCreatedDate;
	}

	/**
	 * @return the proofType
	 */
	public ProofType getProofType() {
		return proofType;
	}

	/**
	 * @param proofType the proofType to set
	 */
	public void setProofType(ProofType proofType) {
		this.proofType = proofType;
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
	 * @return the dimensions
	 */
	public Set<DimensionDTO> getDimensions() {
		return dimensions;
	}

	/**
	 * @param dimensions the dimensions to set
	 */
	public void setDimensions(Set<DimensionDTO> dimensions) {
		this.dimensions = dimensions;
	}

	
	
	/**
	 * @return the committedActivityDescription
	 */
	public String getCommittedActivityDescription() {
		return committedActivityDescription;
	}

	/**
	 * @param committedActivityDescription the committedActivityDescription to set
	 */
	public void setCommittedActivityDescription(String committedActivityDescription) {
		this.committedActivityDescription = committedActivityDescription;
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
