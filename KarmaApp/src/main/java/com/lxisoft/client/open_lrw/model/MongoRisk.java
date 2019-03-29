package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MongoRisk
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class MongoRisk   {
  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("classSourcedId")
  private String classSourcedId = null;

  @JsonProperty("dateTime")
  private OffsetDateTime dateTime = null;

  @JsonProperty("metadata")
  @Valid
  private Map<String, String> metadata = null;

  @JsonProperty("modelType")
  private String modelType = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("orgId")
  private String orgId = null;

  @JsonProperty("score")
  private String score = null;

  @JsonProperty("sourcedId")
  private String sourcedId = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  @JsonProperty("timeZoneOffset")
  private Long timeZoneOffset = null;

  @JsonProperty("userSourcedId")
  private String userSourcedId = null;

  @JsonProperty("velocity")
  private String velocity = null;

  public MongoRisk active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(value = "")


  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public MongoRisk classSourcedId(String classSourcedId) {
    this.classSourcedId = classSourcedId;
    return this;
  }

  /**
   * Get classSourcedId
   * @return classSourcedId
  **/
  @ApiModelProperty(value = "")


  public String getClassSourcedId() {
    return classSourcedId;
  }

  public void setClassSourcedId(String classSourcedId) {
    this.classSourcedId = classSourcedId;
  }

  public MongoRisk dateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * Get dateTime
   * @return dateTime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public MongoRisk metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public MongoRisk putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<String, String>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")


  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public MongoRisk modelType(String modelType) {
    this.modelType = modelType;
    return this;
  }

  /**
   * Get modelType
   * @return modelType
  **/
  @ApiModelProperty(value = "")


  public String getModelType() {
    return modelType;
  }

  public void setModelType(String modelType) {
    this.modelType = modelType;
  }

  public MongoRisk name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MongoRisk orgId(String orgId) {
    this.orgId = orgId;
    return this;
  }

  /**
   * Get orgId
   * @return orgId
  **/
  @ApiModelProperty(value = "")


  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public MongoRisk score(String score) {
    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
  **/
  @ApiModelProperty(value = "")


  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }

  public MongoRisk sourcedId(String sourcedId) {
    this.sourcedId = sourcedId;
    return this;
  }

  /**
   * Get sourcedId
   * @return sourcedId
  **/
  @ApiModelProperty(value = "")


  public String getSourcedId() {
    return sourcedId;
  }

  public void setSourcedId(String sourcedId) {
    this.sourcedId = sourcedId;
  }

  public MongoRisk tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * Get tenantId
   * @return tenantId
  **/
  @ApiModelProperty(value = "")


  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public MongoRisk timeZoneOffset(Long timeZoneOffset) {
    this.timeZoneOffset = timeZoneOffset;
    return this;
  }

  /**
   * Get timeZoneOffset
   * @return timeZoneOffset
  **/
  @ApiModelProperty(value = "")


  public Long getTimeZoneOffset() {
    return timeZoneOffset;
  }

  public void setTimeZoneOffset(Long timeZoneOffset) {
    this.timeZoneOffset = timeZoneOffset;
  }

  public MongoRisk userSourcedId(String userSourcedId) {
    this.userSourcedId = userSourcedId;
    return this;
  }

  /**
   * Get userSourcedId
   * @return userSourcedId
  **/
  @ApiModelProperty(value = "")


  public String getUserSourcedId() {
    return userSourcedId;
  }

  public void setUserSourcedId(String userSourcedId) {
    this.userSourcedId = userSourcedId;
  }

  public MongoRisk velocity(String velocity) {
    this.velocity = velocity;
    return this;
  }

  /**
   * Get velocity
   * @return velocity
  **/
  @ApiModelProperty(value = "")


  public String getVelocity() {
    return velocity;
  }

  public void setVelocity(String velocity) {
    this.velocity = velocity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MongoRisk mongoRisk = (MongoRisk) o;
    return Objects.equals(this.active, mongoRisk.active) &&
        Objects.equals(this.classSourcedId, mongoRisk.classSourcedId) &&
        Objects.equals(this.dateTime, mongoRisk.dateTime) &&
        Objects.equals(this.metadata, mongoRisk.metadata) &&
        Objects.equals(this.modelType, mongoRisk.modelType) &&
        Objects.equals(this.name, mongoRisk.name) &&
        Objects.equals(this.orgId, mongoRisk.orgId) &&
        Objects.equals(this.score, mongoRisk.score) &&
        Objects.equals(this.sourcedId, mongoRisk.sourcedId) &&
        Objects.equals(this.tenantId, mongoRisk.tenantId) &&
        Objects.equals(this.timeZoneOffset, mongoRisk.timeZoneOffset) &&
        Objects.equals(this.userSourcedId, mongoRisk.userSourcedId) &&
        Objects.equals(this.velocity, mongoRisk.velocity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, classSourcedId, dateTime, metadata, modelType, name, orgId, score, sourcedId, tenantId, timeZoneOffset, userSourcedId, velocity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MongoRisk {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    classSourcedId: ").append(toIndentedString(classSourcedId)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    modelType: ").append(toIndentedString(modelType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    sourcedId: ").append(toIndentedString(sourcedId)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    timeZoneOffset: ").append(toIndentedString(timeZoneOffset)).append("\n");
    sb.append("    userSourcedId: ").append(toIndentedString(userSourcedId)).append("\n");
    sb.append("    velocity: ").append(toIndentedString(velocity)).append("\n");
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

