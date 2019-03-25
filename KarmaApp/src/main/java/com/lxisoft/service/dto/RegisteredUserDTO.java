package com.lxisoft.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the RegisteredUser entity.
 */
public class RegisteredUserDTO implements Serializable {

    private Long id;

    @Lob
    private byte[] profilePic;
    private String profilePicContentType;

    private String userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public String getProfilePicContentType() {
        return profilePicContentType;
    }

    public void setProfilePicContentType(String profilePicContentType) {
        this.profilePicContentType = profilePicContentType;
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
            ", profilePic='" + getProfilePic() + "'" +
            ", user='" + getUserId() + "'" +
            "}";
    }
}
