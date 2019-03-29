package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lxisoft.client.open_lrw.model.Link;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Enrollment
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class Enrollment   {
  @JsonProperty("class")
  private Link propertyClass = null;

  @JsonProperty("metadata")
  @Valid
  private Map<String, String> metadata = null;

  @JsonProperty("primary")
  private Boolean primary = null;

  /**
   * Gets or Sets role
   */
  public enum RoleEnum {
    TEACHER("teacher"),
    
    STUDENT("student"),
    
    PARENT("parent"),
    
    GUARDIAN("guardian"),
    
    RELATIVE("relative"),
    
    AIDE("aide"),
    
    ADMINISTRATOR("administrator");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RoleEnum fromValue(String text) {
      for (RoleEnum b : RoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("role")
  private RoleEnum role = null;

  @JsonProperty("sourcedId")
  private String sourcedId = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    ACTIVE("active"),
    
    INACTIVE("inactive"),
    
    TOBEDELETED("tobedeleted");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("user")
  private Link user = null;

  public Enrollment propertyClass(Link propertyClass) {
    this.propertyClass = propertyClass;
    return this;
  }

  /**
   * Get propertyClass
   * @return propertyClass
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Link getPropertyClass() {
    return propertyClass;
  }

  public void setPropertyClass(Link propertyClass) {
    this.propertyClass = propertyClass;
  }

  public Enrollment metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public Enrollment putMetadataItem(String key, String metadataItem) {
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

  public Enrollment primary(Boolean primary) {
    this.primary = primary;
    return this;
  }

  /**
   * Get primary
   * @return primary
  **/
  @ApiModelProperty(value = "")


  public Boolean isPrimary() {
    return primary;
  }

  public void setPrimary(Boolean primary) {
    this.primary = primary;
  }

  public Enrollment role(RoleEnum role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
  **/
  @ApiModelProperty(value = "")


  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public Enrollment sourcedId(String sourcedId) {
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

  public Enrollment status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Enrollment user(Link user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Link getUser() {
    return user;
  }

  public void setUser(Link user) {
    this.user = user;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Enrollment enrollment = (Enrollment) o;
    return Objects.equals(this.propertyClass, enrollment.propertyClass) &&
        Objects.equals(this.metadata, enrollment.metadata) &&
        Objects.equals(this.primary, enrollment.primary) &&
        Objects.equals(this.role, enrollment.role) &&
        Objects.equals(this.sourcedId, enrollment.sourcedId) &&
        Objects.equals(this.status, enrollment.status) &&
        Objects.equals(this.user, enrollment.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyClass, metadata, primary, role, sourcedId, status, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Enrollment {\n");
    
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    sourcedId: ").append(toIndentedString(sourcedId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

