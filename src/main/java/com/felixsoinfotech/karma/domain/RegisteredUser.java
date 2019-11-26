package com.felixsoinfotech.karma.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * RegisteredUser entity.
 * @author Sanil Kumar p
 */
@ApiModel(description = "RegisteredUser entity. @author Sanil Kumar p")
@Entity
@Table(name = "registered_user")
public class RegisteredUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "created_date")
    private ZonedDateTime createdDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @Column(name = "user_id",unique = true, nullable = false)
    private String userId;

    @Lob
    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @Column(name = "profile_picture_content_type")
    private String profilePictureContentType;

    @Lob
    @Column(name = "cover_photo")
    private byte[] coverPhoto;

    @Column(name = "cover_photo_content_type")
    private String coverPhotoContentType;

    @OneToMany(mappedBy = "registeredUser")
    private Set<CommittedActivity> committedActivities = new HashSet<>();
    @OneToMany(mappedBy = "registeredUser")
    private Set<CompletedChallenge> completedChallenges = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisteredUser firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisteredUser lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public RegisteredUser email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public RegisteredUser createdDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RegisteredUser phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public RegisteredUser userId(String userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public RegisteredUser profilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getProfilePictureContentType() {
        return profilePictureContentType;
    }

    public RegisteredUser profilePictureContentType(String profilePictureContentType) {
        this.profilePictureContentType = profilePictureContentType;
        return this;
    }

    public void setProfilePictureContentType(String profilePictureContentType) {
        this.profilePictureContentType = profilePictureContentType;
    }

    public byte[] getCoverPhoto() {
        return coverPhoto;
    }

    public RegisteredUser coverPhoto(byte[] coverPhoto) {
        this.coverPhoto = coverPhoto;
        return this;
    }

    public void setCoverPhoto(byte[] coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getCoverPhotoContentType() {
        return coverPhotoContentType;
    }

    public RegisteredUser coverPhotoContentType(String coverPhotoContentType) {
        this.coverPhotoContentType = coverPhotoContentType;
        return this;
    }

    public void setCoverPhotoContentType(String coverPhotoContentType) {
        this.coverPhotoContentType = coverPhotoContentType;
    }

    public Set<CommittedActivity> getCommittedActivities() {
        return committedActivities;
    }

    public RegisteredUser committedActivities(Set<CommittedActivity> committedActivities) {
        this.committedActivities = committedActivities;
        return this;
    }

    public RegisteredUser addCommittedActivity(CommittedActivity committedActivity) {
        this.committedActivities.add(committedActivity);
        committedActivity.setRegisteredUser(this);
        return this;
    }

    public RegisteredUser removeCommittedActivity(CommittedActivity committedActivity) {
        this.committedActivities.remove(committedActivity);
        committedActivity.setRegisteredUser(null);
        return this;
    }

    public void setCommittedActivities(Set<CommittedActivity> committedActivities) {
        this.committedActivities = committedActivities;
    }

    public Set<CompletedChallenge> getCompletedChallenges() {
        return completedChallenges;
    }

    public RegisteredUser completedChallenges(Set<CompletedChallenge> completedChallenges) {
        this.completedChallenges = completedChallenges;
        return this;
    }

    public RegisteredUser addCompletedChallenge(CompletedChallenge completedChallenge) {
        this.completedChallenges.add(completedChallenge);
        completedChallenge.setRegisteredUser(this);
        return this;
    }

    public RegisteredUser removeCompletedChallenge(CompletedChallenge completedChallenge) {
        this.completedChallenges.remove(completedChallenge);
        completedChallenge.setRegisteredUser(null);
        return this;
    }

    public void setCompletedChallenges(Set<CompletedChallenge> completedChallenges) {
        this.completedChallenges = completedChallenges;
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
        RegisteredUser registeredUser = (RegisteredUser) o;
        if (registeredUser.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), registeredUser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RegisteredUser{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", userId='" + getUserId() + "'" +
            ", profilePicture='" + getProfilePicture() + "'" +
            ", profilePictureContentType='" + getProfilePictureContentType() + "'" +
            ", coverPhoto='" + getCoverPhoto() + "'" +
            ", coverPhotoContentType='" + getCoverPhotoContentType() + "'" +
            "}";
    }
}
