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

/**
 * CompletedChallenge entity.
 * @author Sanil Kumar p
 */
@ApiModel(description = "CompletedChallenge entity. @author Sanil Kumar p")
@Entity
@Table(name = "completed_challenge")
public class CompletedChallenge implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private ZonedDateTime createdDate;

    @ManyToOne
    @JsonIgnoreProperties("completedChallenges")
    private Challenge challenge;

    @OneToMany(mappedBy = "completedChallenge")
    private Set<Media> proofs = new HashSet<>();
    @ManyToOne
    @JsonIgnoreProperties("")
    private User user;

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

    public CompletedChallenge description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public CompletedChallenge createdDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public CompletedChallenge challenge(Challenge challenge) {
        this.challenge = challenge;
        return this;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Set<Media> getProofs() {
        return proofs;
    }

    public CompletedChallenge proofs(Set<Media> media) {
        this.proofs = media;
        return this;
    }

    public CompletedChallenge addProofs(Media media) {
        this.proofs.add(media);
        media.setCompletedChallenge(this);
        return this;
    }

    public CompletedChallenge removeProofs(Media media) {
        this.proofs.remove(media);
        media.setCompletedChallenge(null);
        return this;
    }

    public void setProofs(Set<Media> media) {
        this.proofs = media;
    }

    public User getUser() {
        return user;
    }

    public CompletedChallenge user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
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
        CompletedChallenge completedChallenge = (CompletedChallenge) o;
        if (completedChallenge.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), completedChallenge.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CompletedChallenge{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            "}";
    }
}
