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

import com.felixsoinfotech.karma.domain.enumeration.Status;
import com.felixsoinfotech.karma.domain.enumeration.Type;

/**
 * 
 */
public class CommittedActivityProfileAggregate {
	
	 private Long CommittedActivityId;

	 private Long activityId;
	 
	 private String activityTitle;
	 
	 private String activityImageString;
	    
	 private String activityImageContentType;
	    
	 private String proofImageString;
	    
	 private String proofImageContentType;

	 private ZonedDateTime activityCreatedDate;
	 
	 private String timeElapsed;
	 
	 private Status status;
	 
	 private Type type;
	 
	 private Long noOfLoves;
	 
		 	

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
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
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
	 * @return the activityTitle
	 */
	public String getActivityTitle() {
		return activityTitle;
	}

	/**
	 * @param activityTitle the activityTitle to set
	 */
	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	/**
	 * @return the activityImageString
	 */
	public String getActivityImageString() {
		return activityImageString;
	}

	/**
	 * @param activityImageString the activityImageString to set
	 */
	public void setActivityImageString(String activityImageString) {
		this.activityImageString = activityImageString;
	}

	/**
	 * @return the activityImageContentType
	 */
	public String getActivityImageContentType() {
		return activityImageContentType;
	}

	/**
	 * @param activityImageContentType the activityImageContentType to set
	 */
	public void setActivityImageContentType(String activityImageContentType) {
		this.activityImageContentType = activityImageContentType;
	}

	/**
	 * @return the proofImageString
	 */
	public String getProofImageString() {
		return proofImageString;
	}

	/**
	 * @param proofImageString the proofImageString to set
	 */
	public void setProofImageString(String proofImageString) {
		this.proofImageString = proofImageString;
	}

	/**
	 * @return the proofImageContentType
	 */
	public String getProofImageContentType() {
		return proofImageContentType;
	}

	/**
	 * @param proofImageContentType the proofImageContentType to set
	 */
	public void setProofImageContentType(String proofImageContentType) {
		this.proofImageContentType = proofImageContentType;
	}

	/**
	 * @return the activityCreatedDate
	 */
	public ZonedDateTime getActivityCreatedDate() {
		return activityCreatedDate;
	}

	/**
	 * @param activityCreatedDate the activityCreatedDate to set
	 */
	public void setActivityCreatedDate(ZonedDateTime activityCreatedDate) {
		this.activityCreatedDate = activityCreatedDate;
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
	 
	 
	 
}
