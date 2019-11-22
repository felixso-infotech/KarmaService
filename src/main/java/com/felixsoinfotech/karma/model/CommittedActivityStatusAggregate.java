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

import javax.persistence.Lob;

import com.felixsoinfotech.karma.domain.enumeration.Status;

/**
 * 
 */
public class CommittedActivityStatusAggregate {

	private Long CommittedActivityId;
	
	private Status status;
	
	private String description;
	
	private Long activityId;
	
	private ZonedDateTime createdDate;
	
	private String userId;
	
	private Long registeredUserId;
	
	private Long referenceId;
	
	@Lob
    private byte[] proofFile;
    private String proofFileContentType;
    
    
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
	 * @return the registeredUserId
	 */
	public Long getRegisteredUserId() {
		return registeredUserId;
	}
	/**
	 * @param registeredUserId the registeredUserId to set
	 */
	public void setRegisteredUserId(Long registeredUserId) {
		this.registeredUserId = registeredUserId;
	}
	/**
	 * @return the referenceId
	 */
	public Long getReferenceId() {
		return referenceId;
	}
	/**
	 * @param referenceId the referenceId to set
	 */
	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}
	/**
	 * @return the proofFile
	 */
	public byte[] getProofFile() {
		return proofFile;
	}
	/**
	 * @param proofFile the proofFile to set
	 */
	public void setProofFile(byte[] proofFile) {
		this.proofFile = proofFile;
	}
	/**
	 * @return the proofFileContentType
	 */
	public String getProofFileContentType() {
		return proofFileContentType;
	}
	/**
	 * @param proofFileContentType the proofFileContentType to set
	 */
	public void setProofFileContentType(String proofFileContentType) {
		this.proofFileContentType = proofFileContentType;
	}
	
	
	
	
	
	

}
