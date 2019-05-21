package com.lxisoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * RegisteredUser entity.
 * @author Muhammed Ruhail
 */
@ApiModel(description = "RegisteredUser entity. @author Muhammed Ruhail")
@Entity
@Table(name = "registered_user")
public class RegisteredUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "no_of_coins")
    private Long noOfCoins;

    @Column(name = "no_of_bronze_medals")
    private Long noOfBronzeMedals;

    @Column(name = "no_of_silver_medals")
    private Long noOfSilverMedals;

    @Column(name = "no_of_gold_medals")
    private Long noOfGoldMedals;

    @OneToOne    @JoinColumn(unique = true)
    private Media profilePic;

    @OneToMany(mappedBy = "registeredUser")
    private Set<CompletedActivity> completedActivities = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public RegisteredUser phoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getNoOfCoins() {
        return noOfCoins;
    }

    public RegisteredUser noOfCoins(Long noOfCoins) {
        this.noOfCoins = noOfCoins;
        return this;
    }

    public void setNoOfCoins(Long noOfCoins) {
        this.noOfCoins = noOfCoins;
    }

    public Long getNoOfBronzeMedals() {
        return noOfBronzeMedals;
    }

    public RegisteredUser noOfBronzeMedals(Long noOfBronzeMedals) {
        this.noOfBronzeMedals = noOfBronzeMedals;
        return this;
    }

    public void setNoOfBronzeMedals(Long noOfBronzeMedals) {
        this.noOfBronzeMedals = noOfBronzeMedals;
    }

    public Long getNoOfSilverMedals() {
        return noOfSilverMedals;
    }

    public RegisteredUser noOfSilverMedals(Long noOfSilverMedals) {
        this.noOfSilverMedals = noOfSilverMedals;
        return this;
    }

    public void setNoOfSilverMedals(Long noOfSilverMedals) {
        this.noOfSilverMedals = noOfSilverMedals;
    }

    public Long getNoOfGoldMedals() {
        return noOfGoldMedals;
    }

    public RegisteredUser noOfGoldMedals(Long noOfGoldMedals) {
        this.noOfGoldMedals = noOfGoldMedals;
        return this;
    }

    public void setNoOfGoldMedals(Long noOfGoldMedals) {
        this.noOfGoldMedals = noOfGoldMedals;
    }

    public Media getProfilePic() {
        return profilePic;
    }

    public RegisteredUser profilePic(Media media) {
        this.profilePic = media;
        return this;
    }

    public void setProfilePic(Media media) {
        this.profilePic = media;
    }

    public Set<CompletedActivity> getCompletedActivities() {
        return completedActivities;
    }

    public RegisteredUser completedActivities(Set<CompletedActivity> completedActivities) {
        this.completedActivities = completedActivities;
        return this;
    }

    public RegisteredUser addCompletedActivities(CompletedActivity completedActivity) {
        this.completedActivities.add(completedActivity);
        completedActivity.setRegisteredUser(this);
        return this;
    }

    public RegisteredUser removeCompletedActivities(CompletedActivity completedActivity) {
        this.completedActivities.remove(completedActivity);
        completedActivity.setRegisteredUser(null);
        return this;
    }

    public void setCompletedActivities(Set<CompletedActivity> completedActivities) {
        this.completedActivities = completedActivities;
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
            ", userId='" + getUserId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber=" + getPhoneNumber() +
            ", noOfCoins=" + getNoOfCoins() +
            ", noOfBronzeMedals=" + getNoOfBronzeMedals() +
            ", noOfSilverMedals=" + getNoOfSilverMedals() +
            ", noOfGoldMedals=" + getNoOfGoldMedals() +
            "}";
    }
}
