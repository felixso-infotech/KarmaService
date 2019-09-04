package com.felixsoinfotech.karma.service.dto;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the CompletedChallenge entity.
 */
public class CompletedChallengeDTO implements Serializable {

    private Long id;

    private String description;

    private ZonedDateTime createdDate;

    private Long challengeId;

    private String userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CompletedChallengeDTO completedChallengeDTO = (CompletedChallengeDTO) o;
        if (completedChallengeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), completedChallengeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CompletedChallengeDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", challenge=" + getChallengeId() +
            ", user='" + getUserId() + "'" +
            "}";
    }
}
