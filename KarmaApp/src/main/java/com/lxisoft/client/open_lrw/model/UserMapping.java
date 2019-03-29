package com.lxisoft.client.open_lrw.model;

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
 * UserMapping
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class UserMapping   {
  @JsonProperty("dateLastModified")
  private OffsetDateTime dateLastModified = null;

  @JsonProperty("organizationId")
  private String organizationId = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  @JsonProperty("userExternalId")
  private String userExternalId = null;

  @JsonProperty("userSourcedId")
  private String userSourcedId = null;

  public UserMapping dateLastModified(OffsetDateTime dateLastModified) {
    this.dateLastModified = dateLastModified;
    return this;
  }

  /**
   * Get dateLastModified
   * @return dateLastModified
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDateLastModified() {
    return dateLastModified;
  }

  public void setDateLastModified(OffsetDateTime dateLastModified) {
    this.dateLastModified = dateLastModified;
  }

  public UserMapping organizationId(String organizationId) {
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

  public UserMapping tenantId(String tenantId) {
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

  public UserMapping userExternalId(String userExternalId) {
    this.userExternalId = userExternalId;
    return this;
  }

  /**
   * Get userExternalId
   * @return userExternalId
  **/
  @ApiModelProperty(value = "")


  public String getUserExternalId() {
    return userExternalId;
  }

  public void setUserExternalId(String userExternalId) {
    this.userExternalId = userExternalId;
  }

  public UserMapping userSourcedId(String userSourcedId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserMapping userMapping = (UserMapping) o;
    return Objects.equals(this.dateLastModified, userMapping.dateLastModified) &&
        Objects.equals(this.organizationId, userMapping.organizationId) &&
        Objects.equals(this.tenantId, userMapping.tenantId) &&
        Objects.equals(this.userExternalId, userMapping.userExternalId) &&
        Objects.equals(this.userSourcedId, userMapping.userSourcedId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateLastModified, organizationId, tenantId, userExternalId, userSourcedId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserMapping {\n");
    
    sb.append("    dateLastModified: ").append(toIndentedString(dateLastModified)).append("\n");
    sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    userExternalId: ").append(toIndentedString(userExternalId)).append("\n");
    sb.append("    userSourcedId: ").append(toIndentedString(userSourcedId)).append("\n");
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

