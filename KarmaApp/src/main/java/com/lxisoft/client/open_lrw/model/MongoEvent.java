package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.lxisoft.client.open_lrw.model.Event;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MongoEvent
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class MongoEvent   {
  @JsonProperty("classId")
  private String classId = null;

  @JsonProperty("event")
  private Event event = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("organizationId")
  private String organizationId = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  @JsonProperty("userId")
  private String userId = null;

  public MongoEvent classId(String classId) {
    this.classId = classId;
    return this;
  }

  /**
   * Get classId
   * @return classId
  **/
  @ApiModelProperty(value = "")


  public String getClassId() {
    return classId;
  }

  public void setClassId(String classId) {
    this.classId = classId;
  }

  public MongoEvent event(Event event) {
    this.event = event;
    return this;
  }

  /**
   * Get event
   * @return event
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public MongoEvent id(String id) {
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

  public MongoEvent organizationId(String organizationId) {
    this.organizationId = organizationId;
    return this;
  }

  /**
   * Get organizationId
   * @return organizationId
  **/
  @ApiModelProperty(value = "")


  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  public MongoEvent tenantId(String tenantId) {
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

  public MongoEvent userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MongoEvent mongoEvent = (MongoEvent) o;
    return Objects.equals(this.classId, mongoEvent.classId) &&
        Objects.equals(this.event, mongoEvent.event) &&
        Objects.equals(this.id, mongoEvent.id) &&
        Objects.equals(this.organizationId, mongoEvent.organizationId) &&
        Objects.equals(this.tenantId, mongoEvent.tenantId) &&
        Objects.equals(this.userId, mongoEvent.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(classId, event, id, organizationId, tenantId, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MongoEvent {\n");
    
    sb.append("    classId: ").append(toIndentedString(classId)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

