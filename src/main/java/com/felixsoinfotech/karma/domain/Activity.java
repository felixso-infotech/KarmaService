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

import com.felixsoinfotech.karma.domain.enumeration.Type;

import com.felixsoinfotech.karma.domain.enumeration.ProofType;

/**
 * Activity entity.
 * @author Sarangi Balu A
 */
@ApiModel(description = "Activity entity. @author Sarangi Balu A")
@Entity
@Table(name = "activity")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "success_message")
    private String successMessage;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private Type type;

    @Column(name = "created_date_and_time")
    private ZonedDateTime createdDateAndTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "proof_type")
    private ProofType proofType;

    @Column(name = "is_multiple_proofs_required")
    private Boolean isMultipleProofsRequired;

    @Column(name = "no_of_pages")
    private Integer noOfPages;

    @OneToMany(mappedBy = "activity")
    private Set<IntroductionStory> stories = new HashSet<>();
    @OneToMany(mappedBy = "activity")
    private Set<CommittedActivity> committededActivities = new HashSet<>();
    @ManyToOne
    @JsonIgnoreProperties("activities")
    private Challenge challenge;

    @ManyToMany
    @JoinTable(name = "activity_dimension",
               joinColumns = @JoinColumn(name = "activities_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "dimensions_id", referencedColumnName = "id"))
    private Set<Dimension> dimensions = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Activity title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Activity description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public Activity successMessage(String successMessage) {
        this.successMessage = successMessage;
        return this;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public Type getType() {
        return type;
    }

    public Activity type(Type type) {
        this.type = type;
        return this;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ZonedDateTime getCreatedDateAndTime() {
        return createdDateAndTime;
    }

    public Activity createdDateAndTime(ZonedDateTime createdDateAndTime) {
        this.createdDateAndTime = createdDateAndTime;
        return this;
    }

    public void setCreatedDateAndTime(ZonedDateTime createdDateAndTime) {
        this.createdDateAndTime = createdDateAndTime;
    }

    public ProofType getProofType() {
        return proofType;
    }

    public Activity proofType(ProofType proofType) {
        this.proofType = proofType;
        return this;
    }

    public void setProofType(ProofType proofType) {
        this.proofType = proofType;
    }

    public Boolean isIsMultipleProofsRequired() {
        return isMultipleProofsRequired;
    }

    public Activity isMultipleProofsRequired(Boolean isMultipleProofsRequired) {
        this.isMultipleProofsRequired = isMultipleProofsRequired;
        return this;
    }

    public void setIsMultipleProofsRequired(Boolean isMultipleProofsRequired) {
        this.isMultipleProofsRequired = isMultipleProofsRequired;
    }

    public Integer getNoOfPages() {
        return noOfPages;
    }

    public Activity noOfPages(Integer noOfPages) {
        this.noOfPages = noOfPages;
        return this;
    }

    public void setNoOfPages(Integer noOfPages) {
        this.noOfPages = noOfPages;
    }

    public Set<IntroductionStory> getStories() {
        return stories;
    }

    public Activity stories(Set<IntroductionStory> introductionStories) {
        this.stories = introductionStories;
        return this;
    }

    public Activity addStories(IntroductionStory introductionStory) {
        this.stories.add(introductionStory);
        introductionStory.setActivity(this);
        return this;
    }

    public Activity removeStories(IntroductionStory introductionStory) {
        this.stories.remove(introductionStory);
        introductionStory.setActivity(null);
        return this;
    }

    public void setStories(Set<IntroductionStory> introductionStories) {
        this.stories = introductionStories;
    }

    public Set<CommittedActivity> getCommittededActivities() {
        return committededActivities;
    }

    public Activity committededActivities(Set<CommittedActivity> committedActivities) {
        this.committededActivities = committedActivities;
        return this;
    }

    public Activity addCommittededActivities(CommittedActivity committedActivity) {
        this.committededActivities.add(committedActivity);
        committedActivity.setActivity(this);
        return this;
    }

    public Activity removeCommittededActivities(CommittedActivity committedActivity) {
        this.committededActivities.remove(committedActivity);
        committedActivity.setActivity(null);
        return this;
    }

    public void setCommittededActivities(Set<CommittedActivity> committedActivities) {
        this.committededActivities = committedActivities;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public Activity challenge(Challenge challenge) {
        this.challenge = challenge;
        return this;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Set<Dimension> getDimensions() {
        return dimensions;
    }

    public Activity dimensions(Set<Dimension> dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    public Activity addDimension(Dimension dimension) {
        this.dimensions.add(dimension);
        dimension.getActivities().add(this);
        return this;
    }

    public Activity removeDimension(Dimension dimension) {
        this.dimensions.remove(dimension);
        dimension.getActivities().remove(this);
        return this;
    }

    public void setDimensions(Set<Dimension> dimensions) {
        this.dimensions = dimensions;
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
        Activity activity = (Activity) o;
        if (activity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), activity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Activity{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", successMessage='" + getSuccessMessage() + "'" +
            ", type='" + getType() + "'" +
            ", createdDateAndTime='" + getCreatedDateAndTime() + "'" +
            ", proofType='" + getProofType() + "'" +
            ", isMultipleProofsRequired='" + isIsMultipleProofsRequired() + "'" +
            ", noOfPages=" + getNoOfPages() +
            "}";
    }
}
