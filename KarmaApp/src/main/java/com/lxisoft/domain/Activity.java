package com.lxisoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Activity.
 */
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

    @Column(name = "url")
    private String url;

    @OneToOne    @JoinColumn(unique = true)
    private InstructionVideo instructionVideo;

    @OneToMany(mappedBy = "activity")
    private Set<Media> files = new HashSet<>();
    @OneToMany(mappedBy = "activityid")
    private Set<CompletedActivity> completedActivities = new HashSet<>();
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

    public String getUrl() {
        return url;
    }

    public Activity url(String url) {
        this.url = url;
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InstructionVideo getInstructionVideo() {
        return instructionVideo;
    }

    public Activity instructionVideo(InstructionVideo instructionVideo) {
        this.instructionVideo = instructionVideo;
        return this;
    }

    public void setInstructionVideo(InstructionVideo instructionVideo) {
        this.instructionVideo = instructionVideo;
    }

    public Set<Media> getFiles() {
        return files;
    }

    public Activity files(Set<Media> media) {
        this.files = media;
        return this;
    }

    public Activity addFiles(Media media) {
        this.files.add(media);
        media.setActivity(this);
        return this;
    }

    public Activity removeFiles(Media media) {
        this.files.remove(media);
        media.setActivity(null);
        return this;
    }

    public void setFiles(Set<Media> media) {
        this.files = media;
    }

    public Set<CompletedActivity> getCompletedActivities() {
        return completedActivities;
    }

    public Activity completedActivities(Set<CompletedActivity> completedActivities) {
        this.completedActivities = completedActivities;
        return this;
    }

    public Activity addCompletedActivities(CompletedActivity completedActivity) {
        this.completedActivities.add(completedActivity);
        completedActivity.setActivityid(this);
        return this;
    }

    public Activity removeCompletedActivities(CompletedActivity completedActivity) {
        this.completedActivities.remove(completedActivity);
        completedActivity.setActivityid(null);
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
            ", url='" + getUrl() + "'" +
            "}";
    }
}
