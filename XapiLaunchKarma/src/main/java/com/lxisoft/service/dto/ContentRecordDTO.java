package com.lxisoft.service.dto;

import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ContentRecord entity.
 */
public class ContentRecordDTO implements Serializable {

    private String id;

    private String iconURL;

    private String packageLink;

    private String launchType;

    private String owner;

    private Instant accessed;

    private Instant created;

    private String description;

    private String title;

    private String url;

    private Integer v;

    private Integer launches;

    private String customData;

    private String mediaTypeKey;

    private String publicKey;

    private Integer sessionLength;

    private Integer timeToConsume;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public String getPackageLink() {
        return packageLink;
    }

    public void setPackageLink(String packageLink) {
        this.packageLink = packageLink;
    }

    public String getLaunchType() {
        return launchType;
    }

    public void setLaunchType(String launchType) {
        this.launchType = launchType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Instant getAccessed() {
        return accessed;
    }

    public void setAccessed(Instant accessed) {
        this.accessed = accessed;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Integer getLaunches() {
        return launches;
    }

    public void setLaunches(Integer launches) {
        this.launches = launches;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public String getMediaTypeKey() {
        return mediaTypeKey;
    }

    public void setMediaTypeKey(String mediaTypeKey) {
        this.mediaTypeKey = mediaTypeKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Integer getSessionLength() {
        return sessionLength;
    }

    public void setSessionLength(Integer sessionLength) {
        this.sessionLength = sessionLength;
    }

    public Integer getTimeToConsume() {
        return timeToConsume;
    }

    public void setTimeToConsume(Integer timeToConsume) {
        this.timeToConsume = timeToConsume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ContentRecordDTO contentRecordDTO = (ContentRecordDTO) o;
        if (contentRecordDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), contentRecordDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ContentRecordDTO{" +
            "id=" + getId() +
            ", iconURL='" + getIconURL() + "'" +
            ", packageLink='" + getPackageLink() + "'" +
            ", launchType='" + getLaunchType() + "'" +
            ", owner='" + getOwner() + "'" +
            ", accessed='" + getAccessed() + "'" +
            ", created='" + getCreated() + "'" +
            ", description='" + getDescription() + "'" +
            ", title='" + getTitle() + "'" +
            ", url='" + getUrl() + "'" +
            ", v=" + getV() +
            ", launches=" + getLaunches() +
            ", customData='" + getCustomData() + "'" +
            ", mediaTypeKey='" + getMediaTypeKey() + "'" +
            ", publicKey='" + getPublicKey() + "'" +
            ", sessionLength=" + getSessionLength() +
            ", timeToConsume=" + getTimeToConsume() +
            "}";
    }
}
