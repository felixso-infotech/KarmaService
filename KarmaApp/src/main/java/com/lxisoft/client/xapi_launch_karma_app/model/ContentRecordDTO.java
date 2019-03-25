package com.lxisoft.client.xapi_launch_karma_app.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ContentRecordDTO
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-25T12:34:05.544+05:30[Asia/Calcutta]")

public class ContentRecordDTO   {
  @JsonProperty("accessed")
  private OffsetDateTime accessed = null;

  @JsonProperty("created")
  private OffsetDateTime created = null;

  @JsonProperty("customData")
  private String customData = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("iconURL")
  private String iconURL = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("launchType")
  private String launchType = null;

  @JsonProperty("launches")
  private Integer launches = null;

  @JsonProperty("mediaTypeKey")
  private String mediaTypeKey = null;

  @JsonProperty("owner")
  private String owner = null;

  @JsonProperty("packageLink")
  private String packageLink = null;

  @JsonProperty("publicKey")
  private String publicKey = null;

  @JsonProperty("sessionLength")
  private Integer sessionLength = null;

  @JsonProperty("timeToConsume")
  private Integer timeToConsume = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("v")
  private Integer v = null;

  public ContentRecordDTO accessed(OffsetDateTime accessed) {
    this.accessed = accessed;
    return this;
  }

  /**
   * Get accessed
   * @return accessed
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getAccessed() {
    return accessed;
  }

  public void setAccessed(OffsetDateTime accessed) {
    this.accessed = accessed;
  }

  public ContentRecordDTO created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public ContentRecordDTO customData(String customData) {
    this.customData = customData;
    return this;
  }

  /**
   * Get customData
   * @return customData
  **/
  @ApiModelProperty(value = "")


  public String getCustomData() {
    return customData;
  }

  public void setCustomData(String customData) {
    this.customData = customData;
  }

  public ContentRecordDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ContentRecordDTO iconURL(String iconURL) {
    this.iconURL = iconURL;
    return this;
  }

  /**
   * Get iconURL
   * @return iconURL
  **/
  @ApiModelProperty(value = "")


  public String getIconURL() {
    return iconURL;
  }

  public void setIconURL(String iconURL) {
    this.iconURL = iconURL;
  }

  public ContentRecordDTO id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ContentRecordDTO launchType(String launchType) {
    this.launchType = launchType;
    return this;
  }

  /**
   * Get launchType
   * @return launchType
  **/
  @ApiModelProperty(value = "")


  public String getLaunchType() {
    return launchType;
  }

  public void setLaunchType(String launchType) {
    this.launchType = launchType;
  }

  public ContentRecordDTO launches(Integer launches) {
    this.launches = launches;
    return this;
  }

  /**
   * Get launches
   * @return launches
  **/
  @ApiModelProperty(value = "")


  public Integer getLaunches() {
    return launches;
  }

  public void setLaunches(Integer launches) {
    this.launches = launches;
  }

  public ContentRecordDTO mediaTypeKey(String mediaTypeKey) {
    this.mediaTypeKey = mediaTypeKey;
    return this;
  }

  /**
   * Get mediaTypeKey
   * @return mediaTypeKey
  **/
  @ApiModelProperty(value = "")


  public String getMediaTypeKey() {
    return mediaTypeKey;
  }

  public void setMediaTypeKey(String mediaTypeKey) {
    this.mediaTypeKey = mediaTypeKey;
  }

  public ContentRecordDTO owner(String owner) {
    this.owner = owner;
    return this;
  }

  /**
   * Get owner
   * @return owner
  **/
  @ApiModelProperty(value = "")


  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public ContentRecordDTO packageLink(String packageLink) {
    this.packageLink = packageLink;
    return this;
  }

  /**
   * Get packageLink
   * @return packageLink
  **/
  @ApiModelProperty(value = "")


  public String getPackageLink() {
    return packageLink;
  }

  public void setPackageLink(String packageLink) {
    this.packageLink = packageLink;
  }

  public ContentRecordDTO publicKey(String publicKey) {
    this.publicKey = publicKey;
    return this;
  }

  /**
   * Get publicKey
   * @return publicKey
  **/
  @ApiModelProperty(value = "")


  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }

  public ContentRecordDTO sessionLength(Integer sessionLength) {
    this.sessionLength = sessionLength;
    return this;
  }

  /**
   * Get sessionLength
   * @return sessionLength
  **/
  @ApiModelProperty(value = "")


  public Integer getSessionLength() {
    return sessionLength;
  }

  public void setSessionLength(Integer sessionLength) {
    this.sessionLength = sessionLength;
  }

  public ContentRecordDTO timeToConsume(Integer timeToConsume) {
    this.timeToConsume = timeToConsume;
    return this;
  }

  /**
   * Get timeToConsume
   * @return timeToConsume
  **/
  @ApiModelProperty(value = "")


  public Integer getTimeToConsume() {
    return timeToConsume;
  }

  public void setTimeToConsume(Integer timeToConsume) {
    this.timeToConsume = timeToConsume;
  }

  public ContentRecordDTO title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ContentRecordDTO url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public ContentRecordDTO v(Integer v) {
    this.v = v;
    return this;
  }

  /**
   * Get v
   * @return v
  **/
  @ApiModelProperty(value = "")


  public Integer getV() {
    return v;
  }

  public void setV(Integer v) {
    this.v = v;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentRecordDTO contentRecordDTO = (ContentRecordDTO) o;
    return Objects.equals(this.accessed, contentRecordDTO.accessed) &&
        Objects.equals(this.created, contentRecordDTO.created) &&
        Objects.equals(this.customData, contentRecordDTO.customData) &&
        Objects.equals(this.description, contentRecordDTO.description) &&
        Objects.equals(this.iconURL, contentRecordDTO.iconURL) &&
        Objects.equals(this.id, contentRecordDTO.id) &&
        Objects.equals(this.launchType, contentRecordDTO.launchType) &&
        Objects.equals(this.launches, contentRecordDTO.launches) &&
        Objects.equals(this.mediaTypeKey, contentRecordDTO.mediaTypeKey) &&
        Objects.equals(this.owner, contentRecordDTO.owner) &&
        Objects.equals(this.packageLink, contentRecordDTO.packageLink) &&
        Objects.equals(this.publicKey, contentRecordDTO.publicKey) &&
        Objects.equals(this.sessionLength, contentRecordDTO.sessionLength) &&
        Objects.equals(this.timeToConsume, contentRecordDTO.timeToConsume) &&
        Objects.equals(this.title, contentRecordDTO.title) &&
        Objects.equals(this.url, contentRecordDTO.url) &&
        Objects.equals(this.v, contentRecordDTO.v);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessed, created, customData, description, iconURL, id, launchType, launches, mediaTypeKey, owner, packageLink, publicKey, sessionLength, timeToConsume, title, url, v);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentRecordDTO {\n");
    
    sb.append("    accessed: ").append(toIndentedString(accessed)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    iconURL: ").append(toIndentedString(iconURL)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    launchType: ").append(toIndentedString(launchType)).append("\n");
    sb.append("    launches: ").append(toIndentedString(launches)).append("\n");
    sb.append("    mediaTypeKey: ").append(toIndentedString(mediaTypeKey)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    packageLink: ").append(toIndentedString(packageLink)).append("\n");
    sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
    sb.append("    sessionLength: ").append(toIndentedString(sessionLength)).append("\n");
    sb.append("    timeToConsume: ").append(toIndentedString(timeToConsume)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    v: ").append(toIndentedString(v)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

