package com.felixsoinfotech.karma.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the RegisteredUser entity.
 */
public class RegisteredUserDTO implements Serializable {

    private Long id;

    @Lob
    private byte[] profilePicture;
    private String profilePictureContentType;

    @Lob
    private byte[] coverPhoto;
    private String coverPhotoContentType;

    private String userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getProfilePictureContentType() {
        return profilePictureContentType;
    }

    public void setProfilePictureContentType(String profilePictureContentType) {
        this.profilePictureContentType = profilePictureContentType;
    }

    public byte[] getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(byte[] coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getCoverPhotoContentType() {
        return coverPhotoContentType;
    }

    public void setCoverPhotoContentType(String coverPhotoContentType) {
        this.coverPhotoContentType = coverPhotoContentType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RegisteredUserDTO registeredUserDTO = (RegisteredUserDTO) o;
        if (registeredUserDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), registeredUserDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RegisteredUserDTO{" +
            "id=" + getId() +
            ", profilePicture='" + getProfilePicture() + "'" +
            ", coverPhoto='" + getCoverPhoto() + "'" +
            ", user='" + getUserId() + "'" +
            "}";
    }
}
