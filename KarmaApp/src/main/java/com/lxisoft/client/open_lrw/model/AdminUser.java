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
 * AdminUser
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class AdminUser   {
  @JsonProperty("createdAt")
  private OffsetDateTime createdAt = null;

  @JsonProperty("emailAddress")
  private String emailAddress = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("lastModified")
  private OffsetDateTime lastModified = null;

  @JsonProperty("metadata")
  @Valid
  private Map<String, String> metadata = null;

  @JsonProperty("orgId")
  private String orgId = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("superAdmin")
  private Boolean superAdmin = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  @JsonProperty("username")
  private String username = null;

  public AdminUser createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public AdminUser emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Get emailAddress
   * @return emailAddress
  **/
  @ApiModelProperty(value = "")


  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public AdminUser id(String id) {
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

  public AdminUser lastModified(OffsetDateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  /**
   * Get lastModified
   * @return lastModified
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getLastModified() {
    return lastModified;
  }

  public void setLastModified(OffsetDateTime lastModified) {
    this.lastModified = lastModified;
  }

  public AdminUser metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public AdminUser putMetadataItem(String key, String metadataItem) {
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

  public AdminUser orgId(String orgId) {
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

  public AdminUser password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(value = "")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AdminUser superAdmin(Boolean superAdmin) {
    this.superAdmin = superAdmin;
    return this;
  }

  /**
   * Get superAdmin
   * @return superAdmin
  **/
  @ApiModelProperty(value = "")


  public Boolean isSuperAdmin() {
    return superAdmin;
  }

  public void setSuperAdmin(Boolean superAdmin) {
    this.superAdmin = superAdmin;
  }

  public AdminUser tenantId(String tenantId) {
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

  public AdminUser username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(value = "")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminUser adminUser = (AdminUser) o;
    return Objects.equals(this.createdAt, adminUser.createdAt) &&
        Objects.equals(this.emailAddress, adminUser.emailAddress) &&
        Objects.equals(this.id, adminUser.id) &&
        Objects.equals(this.lastModified, adminUser.lastModified) &&
        Objects.equals(this.metadata, adminUser.metadata) &&
        Objects.equals(this.orgId, adminUser.orgId) &&
        Objects.equals(this.password, adminUser.password) &&
        Objects.equals(this.superAdmin, adminUser.superAdmin) &&
        Objects.equals(this.tenantId, adminUser.tenantId) &&
        Objects.equals(this.username, adminUser.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, emailAddress, id, lastModified, metadata, orgId, password, superAdmin, tenantId, username);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminUser {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    superAdmin: ").append(toIndentedString(superAdmin)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

