
package com.felixsoinfotech.karma.service.dto;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import com.felixsoinfotech.karma.domain.enumeration.Type;
import com.felixsoinfotech.karma.domain.enumeration.ProofType;

/**
 * A DTO for the Activity entity.
 */
public class ActivityDTO implements Serializable {

    private Long id;

    private String title;

    private String description;

    private String successMessage;

    private Type type;

    private ZonedDateTime createdDate;

    private ProofType proofType;

    private Boolean isMultipleProofsRequired;

    private Integer noOfPages;

    private Long challengeId;

    private Set<DimensionDTO> dimensions = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ProofType getProofType() {
        return proofType;
    }

    public void setProofType(ProofType proofType) {
        this.proofType = proofType;
    }

    public Boolean isIsMultipleProofsRequired() {
        return isMultipleProofsRequired;
    }

    public void setIsMultipleProofsRequired(Boolean isMultipleProofsRequired) {
        this.isMultipleProofsRequired = isMultipleProofsRequired;
    }

    public Integer getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(Integer noOfPages) {
        this.noOfPages = noOfPages;
    }

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }

    public Set<DimensionDTO> getDimensions() {
        return dimensions;
    }

    public void setDimensions(Set<DimensionDTO> dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ActivityDTO activityDTO = (ActivityDTO) o;
        if (activityDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), activityDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ActivityDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", successMessage='" + getSuccessMessage() + "'" +
            ", type='" + getType() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", proofType='" + getProofType() + "'" +
            ", isMultipleProofsRequired='" + isIsMultipleProofsRequired() + "'" +
            ", noOfPages=" + getNoOfPages() +
            ", challenge=" + getChallengeId() +
            "}";
    }
}
