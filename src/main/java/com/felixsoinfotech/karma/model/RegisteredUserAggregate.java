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
public class RegisteredUserAggregate {

	 private Long id;
	 
     private String profilePicture;
     
	 private String profilePictureContentType;
	 
	 private String coverPhoto;
	 
	 private String coverPhotoContentType;
	 
     private String userId;
     
     private String firstName;

     private String lastName;

     private String email;
     
     private Long noOfCompletedTasks;
     
     private Long noOfLoves;
        
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
	 * @return the noOfCompletedTasks
	 */
	public Long getNoOfCompletedTasks() {
		return noOfCompletedTasks;
	}

	/**
	 * @param noOfCompletedTasks the noOfCompletedTasks to set
	 */
	public void setNoOfCompletedTasks(Long noOfCompletedTasks) {
		this.noOfCompletedTasks = noOfCompletedTasks;
	}

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
	 * @return the coverPhoto
	 */
	public String getCoverPhoto() {
		return coverPhoto;
	}

	/**
	 * @param coverPhoto the coverPhoto to set
	 */
	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	/**
	 * @return the coverPhotoContentType
	 */
	public String getCoverPhotoContentType() {
		return coverPhotoContentType;
	}

	/**
	 * @param coverPhotoContentType the coverPhotoContentType to set
	 */
	public void setCoverPhotoContentType(String coverPhotoContentType) {
		this.coverPhotoContentType = coverPhotoContentType;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

     
}
