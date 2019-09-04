package com.felixsoinfotech.karma.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * Challenge entity.
 * @author Sarangi Balu A
 */
@ApiModel(description = "Challenge entity. @author Sarangi Balu A")
@Entity
@Table(name = "challenge")
public class Challenge implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "success_message")
    private String successMessage;

    @Column(name = "created_date")
    private ZonedDateTime createdDate;

    @OneToMany(mappedBy = "challenge")
    private Set<CompletedChallenge> completedChallenges = new HashSet<>();
    @OneToMany(mappedBy = "challenge")
    private Set<Activity> activities = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Challenge name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public Challenge successMessage(String successMessage) {
        this.successMessage = successMessage;
        return this;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public Challenge createdDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Set<CompletedChallenge> getCompletedChallenges() {
        return completedChallenges;
    }

    public Challenge completedChallenges(Set<CompletedChallenge> completedChallenges) {
        this.completedChallenges = completedChallenges;
        return this;
    }

    public Challenge addCompletedChallenges(CompletedChallenge completedChallenge) {
        this.completedChallenges.add(completedChallenge);
        completedChallenge.setChallenge(this);
        return this;
    }

    public Challenge removeCompletedChallenges(CompletedChallenge completedChallenge) {
        this.completedChallenges.remove(completedChallenge);
        completedChallenge.setChallenge(null);
        return this;
    }

    public void setCompletedChallenges(Set<CompletedChallenge> completedChallenges) {
        this.completedChallenges = completedChallenges;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public Challenge activities(Set<Activity> activities) {
        this.activities = activities;
        return this;
    }

    public Challenge addActivity(Activity activity) {
        this.activities.add(activity);
        activity.setChallenge(this);
        return this;
    }

    public Challenge removeActivity(Activity activity) {
        this.activities.remove(activity);
        activity.setChallenge(null);
        return this;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
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
        Challenge challenge = (Challenge) o;
        if (challenge.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), challenge.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Challenge{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", successMessage='" + getSuccessMessage() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            "}";
    }
}
