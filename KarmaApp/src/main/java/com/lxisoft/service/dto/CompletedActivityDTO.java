package com.lxisoft.service.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the CompletedActivity entity.
 */
public class CompletedActivityDTO implements Serializable {

	private Long id;

	private Long registeredUserId;

	private Long activityId;

	private ActivityDTO activityDTO;// added
	private RegisteredUserDTO registeredUserDTO;// added
	// private Set<Media> proofs;// added
	private Set<String> encodedProofs;// added

	public ActivityDTO getActivityDTO() {
		return activityDTO;
	}

	public void setActivityDTO(ActivityDTO activityDTO) {
		this.activityDTO = activityDTO;
	}

	public RegisteredUserDTO getRegisteredUserDTO() {
		return registeredUserDTO;
	}

	public void setRegisteredUserDTO(RegisteredUserDTO registeredUserDTO) {
		this.registeredUserDTO = registeredUserDTO;
	}

	public Set<String> getEncodedProofs() {
		return encodedProofs;
	}

	public void setEncodedProofs(Set<String> encodedProofs) {
		this.encodedProofs = encodedProofs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegisteredUserId() {
		return registeredUserId;
	}

	public void setRegisteredUserId(Long registeredUserId) {
		this.registeredUserId = registeredUserId;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		CompletedActivityDTO completedActivityDTO = (CompletedActivityDTO) o;
		if (completedActivityDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), completedActivityDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "CompletedActivityDTO{" + "id=" + getId() + ", registeredUser=" + getRegisteredUserId() + ", activity="
				+ getActivityId() + "}";
	}
}
