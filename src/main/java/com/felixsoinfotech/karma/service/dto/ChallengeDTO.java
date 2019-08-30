package com.felixsoinfotech.karma.service.dto;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Challenge entity.
 */
public class ChallengeDTO implements Serializable {

    private Long id;

    private String name;

    private String successMessage;

    private ZonedDateTime createdDateAndTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public ZonedDateTime getCreatedDateAndTime() {
        return createdDateAndTime;
    }

    public void setCreatedDateAndTime(ZonedDateTime createdDateAndTime) {
        this.createdDateAndTime = createdDateAndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ChallengeDTO challengeDTO = (ChallengeDTO) o;
        if (challengeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), challengeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ChallengeDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", successMessage='" + getSuccessMessage() + "'" +
            ", createdDateAndTime='" + getCreatedDateAndTime() + "'" +
            "}";
    }
}
