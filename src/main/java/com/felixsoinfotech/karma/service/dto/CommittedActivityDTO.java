package com.felixsoinfotech.karma.service.dto;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;
import com.felixsoinfotech.karma.domain.enumeration.Status;

/**
 * A DTO for the CommittedActivity entity.
 */
public class CommittedActivityDTO implements Serializable {

    private Long id;

    private String description;

    private Status status;

    private ZonedDateTime createdDate;

    private Long activityId;

    private String userId;

    private Long referenceIdId;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getReferenceIdId() {
        return referenceIdId;
    }

    public void setReferenceIdId(Long committedActivityId) {
        this.referenceIdId = committedActivityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CommittedActivityDTO committedActivityDTO = (CommittedActivityDTO) o;
        if (committedActivityDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), committedActivityDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CommittedActivityDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", activity=" + getActivityId() +
            ", user='" + getUserId() + "'" +
            ", referenceId=" + getReferenceIdId() +
            "}";
    }
}
