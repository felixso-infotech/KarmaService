package com.felixsoinfotech.karma.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the IntroductionStory entity.
 */
public class IntroductionStoryDTO implements Serializable {

    private Long id;

    private String story;

    @Lob
    private byte[] image;
    private String imageContentType;

    private Long activityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IntroductionStoryDTO introductionStoryDTO = (IntroductionStoryDTO) o;
        if (introductionStoryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), introductionStoryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IntroductionStoryDTO{" +
            "id=" + getId() +
            ", story='" + getStory() + "'" +
            ", image='" + getImage() + "'" +
            ", activity=" + getActivityId() +
            "}";
    }
}
