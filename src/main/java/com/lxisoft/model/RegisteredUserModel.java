package com.lxisoft.model;

public class RegisteredUserModel {

	private Long registeredUserId;

	private String firstName;

	private String lastName;

	private String email;

	private Long phoneNumber;

	private Long noOfCoins;

	private Long noOfBronzeMedals;

	private Long noOfSilverMedals;

	private Long noOfGoldMedals;

	private Long profilePicId;

	private String profilePicFileName;

	private byte[] profilePicFile;

	private String profilePicFileContentType;

	public Long getRegisteredUserId() {
		return registeredUserId;
	}

	public RegisteredUserModel setRegisteredUserId(Long registeredUserId) {
		this.registeredUserId = registeredUserId;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public RegisteredUserModel setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public RegisteredUserModel setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public RegisteredUserModel setEmail(String email) {
		this.email = email;
		return this;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public RegisteredUserModel setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public Long getNoOfCoins() {
		return noOfCoins;
	}

	public RegisteredUserModel setNoOfCoins(Long noOfCoins) {
		this.noOfCoins = noOfCoins;
		return this;
	}

	public Long getNoOfBronzeMedals() {
		return noOfBronzeMedals;
	}

	public RegisteredUserModel setNoOfBronzeMedals(Long noOfBronzeMedals) {
		this.noOfBronzeMedals = noOfBronzeMedals;
		return this;
	}

	public Long getNoOfSilverMedals() {
		return noOfSilverMedals;
	}

	public RegisteredUserModel setNoOfSilverMedals(Long noOfSilverMedals) {
		this.noOfSilverMedals = noOfSilverMedals;
		return this;
	}

	public Long getNoOfGoldMedals() {
		return noOfGoldMedals;
	}

	public RegisteredUserModel setNoOfGoldMedals(Long noOfGoldMedals) {
		this.noOfGoldMedals = noOfGoldMedals;
		return this;
	}

	public Long getProfilePicId() {
		return profilePicId;
	}

	public RegisteredUserModel setProfilePicId(Long profilePicId) {
		this.profilePicId = profilePicId;
		return this;
	}

	public String getProfilePicFileName() {
		return profilePicFileName;
	}

	public RegisteredUserModel setProfilePicFileName(String profilePicfileName) {
		this.profilePicFileName = profilePicfileName;
		return this;
	}

	public byte[] getProfilePicFile() {
		return profilePicFile;
	}

	public RegisteredUserModel setProfilePicFile(byte[] profilePicFile) {
		this.profilePicFile = profilePicFile;
		return this;
	}

	public String getProfilePicFileContentType() {
		return profilePicFileContentType;
	}

	public RegisteredUserModel setProfilePicFileContentType(String profilePicFileContentType) {
		this.profilePicFileContentType = profilePicFileContentType;
		return this;
	}

}
