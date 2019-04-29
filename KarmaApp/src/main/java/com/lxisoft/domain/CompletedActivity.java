package com.lxisoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A CompletedActivity.
 */
@Entity
@Table(name = "completed_activity")
public class CompletedActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("completedActivities")
    private RegisteredUser registeredUser;

    @OneToMany(mappedBy = "completedActivity")
    private Set<Media> proofs = new HashSet<>();
    @ManyToOne
    @JsonIgnoreProperties("completedActivities")
    private Activity activityid;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public CompletedActivity registeredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
        return this;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }

    public Set<Media> getProofs() {
        return proofs;
    }

    public CompletedActivity proofs(Set<Media> media) {
        this.proofs = media;
        return this;
    }

    public CompletedActivity addProofs(Media media) {
        this.proofs.add(media);
        media.setCompletedActivity(this);
        return this;
    }

    public CompletedActivity removeProofs(Media media) {
        this.proofs.remove(media);
        media.setCompletedActivity(null);
        return this;
    }

    public void setProofs(Set<Media> media) {
        this.proofs = media;
    }

    public Activity getActivityid() {
        return activityid;
    }

    public CompletedActivity activityid(Activity activity) {
        this.activityid = activity;
        return this;
    }

    public void setActivityid(Activity activity) {
        this.activityid = activity;
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
        CompletedActivity completedActivity = (CompletedActivity) o;
        if (completedActivity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), completedActivity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CompletedActivity{" +
            "id=" + getId() +
            "}";
    }
}
