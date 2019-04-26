package com.lxisoft.service.dto;

import java.io.Serializable;
import java.util.Objects;

import com.lxisoft.domain.Media;

/**
 * A DTO for the RegisteredUser entity.
 */
public class RegisteredUserDTO implements Serializable {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private Long phoneNumber;

	private Long noOfCoins;

	private Long noOfBronzeMedals;

	private Long noOfSilverMedals;

	private Long noOfGoldMedals;

	private Long profilePicId;

	private Media profilePic;// added

	private String encodedFile;// added

	public String getEncodedFile() {
		return encodedFile;
	}

	public void setEncodedFile(String encodedFile) {
		this.encodedFile = encodedFile;
	}

	public Media getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Media profilePic) {
		this.profilePic = profilePic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getNoOfCoins() {
		return noOfCoins;
	}

	public void setNoOfCoins(Long noOfCoins) {
		this.noOfCoins = noOfCoins;
	}

	public Long getNoOfBronzeMedals() {
		return noOfBronzeMedals;
	}

	public void setNoOfBronzeMedals(Long noOfBronzeMedals) {
		this.noOfBronzeMedals = noOfBronzeMedals;
	}

	public Long getNoOfSilverMedals() {
		return noOfSilverMedals;
	}

	public void setNoOfSilverMedals(Long noOfSilverMedals) {
		this.noOfSilverMedals = noOfSilverMedals;
	}

	public Long getNoOfGoldMedals() {
		return noOfGoldMedals;
	}

	public void setNoOfGoldMedals(Long noOfGoldMedals) {
		this.noOfGoldMedals = noOfGoldMedals;
	}

	public Long getProfilePicId() {
		return profilePicId;
	}

	public void setProfilePicId(Long mediaId) {
		this.profilePicId = mediaId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		RegisteredUserDTO registeredUserDTO = (RegisteredUserDTO) o;
		if (registeredUserDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), registeredUserDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "RegisteredUserDTO{" + "id=" + getId() + ", firstName='" + getFirstName() + "'" + ", lastName='"
				+ getLastName() + "'" + ", email='" + getEmail() + "'" + ", phoneNumber=" + getPhoneNumber()
				+ ", noOfCoins=" + getNoOfCoins() + ", noOfBronzeMedals=" + getNoOfBronzeMedals()
				+ ", noOfSilverMedals=" + getNoOfSilverMedals() + ", noOfGoldMedals=" + getNoOfGoldMedals()
				+ ", profilePic=" + getProfilePicId() + "}";
	}
}
