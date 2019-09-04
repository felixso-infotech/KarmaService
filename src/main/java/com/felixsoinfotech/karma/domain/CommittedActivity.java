package com.felixsoinfotech.karma.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.felixsoinfotech.karma.domain.enumeration.Status;

/**
 * CommittedActivity entity.
 * @author Sanil Kumar p
 */
@ApiModel(description = "CommittedActivity entity. @author Sanil Kumar p")
@Entity
@Table(name = "committed_activity")
public class CommittedActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_date")
    private ZonedDateTime createdDate;

    @ManyToOne
    @JsonIgnoreProperties("committededActivities")
    private Activity activity;

    @OneToMany(mappedBy = "committedActivity")
    private Set<Media> activityProofs = new HashSet<>();
    @OneToMany(mappedBy = "referenceId")
    private Set<CommittedActivity> committedActivities = new HashSet<>();
    @ManyToOne
    @JsonIgnoreProperties("")
    private User user;

    @ManyToOne
    @JsonIgnoreProperties("committedActivities")
    private CommittedActivity referenceId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public CommittedActivity description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public CommittedActivity status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public CommittedActivity createdDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Activity getActivity() {
        return activity;
    }

    public CommittedActivity activity(Activity activity) {
        this.activity = activity;
        return this;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Set<Media> getActivityProofs() {
        return activityProofs;
    }

    public CommittedActivity activityProofs(Set<Media> media) {
        this.activityProofs = media;
        return this;
    }

    public CommittedActivity addActivityProofs(Media media) {
        this.activityProofs.add(media);
        media.setCommittedActivity(this);
        return this;
    }

    public CommittedActivity removeActivityProofs(Media media) {
        this.activityProofs.remove(media);
        media.setCommittedActivity(null);
        return this;
    }

    public void setActivityProofs(Set<Media> media) {
        this.activityProofs = media;
    }

    public Set<CommittedActivity> getCommittedActivities() {
        return committedActivities;
    }

    public CommittedActivity committedActivities(Set<CommittedActivity> committedActivities) {
        this.committedActivities = committedActivities;
        return this;
    }

    public CommittedActivity addCommittedActivity(CommittedActivity committedActivity) {
        this.committedActivities.add(committedActivity);
        committedActivity.setReferenceId(this);
        return this;
    }

    public CommittedActivity removeCommittedActivity(CommittedActivity committedActivity) {
        this.committedActivities.remove(committedActivity);
        committedActivity.setReferenceId(null);
        return this;
    }

    public void setCommittedActivities(Set<CommittedActivity> committedActivities) {
        this.committedActivities = committedActivities;
    }

    public User getUser() {
        return user;
    }

    public CommittedActivity user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CommittedActivity getReferenceId() {
        return referenceId;
    }

    public CommittedActivity referenceId(CommittedActivity committedActivity) {
        this.referenceId = committedActivity;
        return this;
    }

    public void setReferenceId(CommittedActivity committedActivity) {
        this.referenceId = committedActivity;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommittedActivity committedActivity = (CommittedActivity) o;
        if (committedActivity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), committedActivity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CommittedActivity{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            "}";
    }
}
