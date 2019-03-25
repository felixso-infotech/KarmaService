package com.lxisoft.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A ContentRecord.
 */
@Document(collection = "contentrecords")
public class ContentRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("iconURL")
	private String iconURL;

	@Field("packageLink")
	private String packageLink;

	@Field("launchType")
	private String launchType;

	@Field("owner")
	private String owner;

	@Field("accessed")
	private Instant accessed;

	@Field("created")
	private Instant created;

	@Field("description")
	private String description;

	@Field("title")
	private String title;

	@Field("url")
	private String url;

	@Field("v")
	private Integer v;

	@Field("launches")
	private Integer launches;

	@Field("customData")
	private String customData;

	@Field("mediaTypeKey")
	private String mediaTypeKey;

	@Field("publicKey")
	private String publicKey;

	@Field("sessionLength")
	private Integer sessionLength;

	@Field("timeToConsume")
	private Integer timeToConsume;

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIconURL() {
		return iconURL;
	}

	public ContentRecord iconURL(String iconURL) {
		this.iconURL = iconURL;
		return this;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	public String getPackageLink() {
		return packageLink;
	}

	public ContentRecord packageLink(String packageLink) {
		this.packageLink = packageLink;
		return this;
	}

	public void setPackageLink(String packageLink) {
		this.packageLink = packageLink;
	}

	public String getLaunchType() {
		return launchType;
	}

	public ContentRecord launchType(String launchType) {
		this.launchType = launchType;
		return this;
	}

	public void setLaunchType(String launchType) {
		this.launchType = launchType;
	}

	public String getOwner() {
		return owner;
	}

	public ContentRecord owner(String owner) {
		this.owner = owner;
		return this;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Instant getAccessed() {
		return accessed;
	}

	public ContentRecord accessed(Instant accessed) {
		this.accessed = accessed;
		return this;
	}

	public void setAccessed(Instant accessed) {
		this.accessed = accessed;
	}

	public Instant getCreated() {
		return created;
	}

	public ContentRecord created(Instant created) {
		this.created = created;
		return this;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public String getDescription() {
		return description;
	}

	public ContentRecord description(String description) {
		this.description = description;
		return this;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public ContentRecord title(String title) {
		this.title = title;
		return this;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public ContentRecord url(String url) {
		this.url = url;
		return this;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getV() {
		return v;
	}

	public ContentRecord v(Integer v) {
		this.v = v;
		return this;
	}

	public void setV(Integer v) {
		this.v = v;
	}

	public Integer getLaunches() {
		return launches;
	}

	public ContentRecord launches(Integer launches) {
		this.launches = launches;
		return this;
	}

	public void setLaunches(Integer launches) {
		this.launches = launches;
	}

	public String getCustomData() {
		return customData;
	}

	public ContentRecord customData(String customData) {
		this.customData = customData;
		return this;
	}

	public void setCustomData(String customData) {
		this.customData = customData;
	}

	public String getMediaTypeKey() {
		return mediaTypeKey;
	}

	public ContentRecord mediaTypeKey(String mediaTypeKey) {
		this.mediaTypeKey = mediaTypeKey;
		return this;
	}

	public void setMediaTypeKey(String mediaTypeKey) {
		this.mediaTypeKey = mediaTypeKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public ContentRecord publicKey(String publicKey) {
		this.publicKey = publicKey;
		return this;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public Integer getSessionLength() {
		return sessionLength;
	}

	public ContentRecord sessionLength(Integer sessionLength) {
		this.sessionLength = sessionLength;
		return this;
	}

	public void setSessionLength(Integer sessionLength) {
		this.sessionLength = sessionLength;
	}

	public Integer getTimeToConsume() {
		return timeToConsume;
	}

	public ContentRecord timeToConsume(Integer timeToConsume) {
		this.timeToConsume = timeToConsume;
		return this;
	}

	public void setTimeToConsume(Integer timeToConsume) {
		this.timeToConsume = timeToConsume;
	}
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ContentRecord contentRecord = (ContentRecord) o;
		if (contentRecord.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), contentRecord.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "ContentRecord{" + "id=" + getId() + ", iconURL='" + getIconURL() + "'" + ", packageLink='"
				+ getPackageLink() + "'" + ", launchType='" + getLaunchType() + "'" + ", owner='" + getOwner() + "'"
				+ ", accessed='" + getAccessed() + "'" + ", created='" + getCreated() + "'" + ", description='"
				+ getDescription() + "'" + ", title='" + getTitle() + "'" + ", url='" + getUrl() + "'" + ", v=" + getV()
				+ ", launches=" + getLaunches() + ", customData='" + getCustomData() + "'" + ", mediaTypeKey='"
				+ getMediaTypeKey() + "'" + ", publicKey='" + getPublicKey() + "'" + ", sessionLength="
				+ getSessionLength() + ", timeToConsume=" + getTimeToConsume() + "}";
	}
}
