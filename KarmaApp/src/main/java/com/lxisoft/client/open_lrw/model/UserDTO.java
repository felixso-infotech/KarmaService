package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserDTO
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class UserDTO   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  @JsonProperty("orgId")
  private String orgId = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("emailAddress")
  private String emailAddress = null;

  public UserDTO id(String id) {
    this.id = id;
    return this;
  }

  /**
   * User Id
   * @return id
  **/
  @ApiModelProperty(value = "User Id")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UserDTO tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * Tenant Id
   * @return tenantId
  **/
  @ApiModelProperty(value = "Tenant Id")


  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public UserDTO orgId(String orgId) {
    this.orgId = orgId;
    return this;
  }

  /**
   * Organization Id
   * @return orgId
  **/
  @ApiModelProperty(value = "Organization Id")


  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public UserDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * User Name
   * @return username
  **/
  @ApiModelProperty(value = "User Name")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password
   * @return password
  **/
  @ApiModelProperty(value = "Password")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserDTO emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Email Address
   * @return emailAddress
  **/
  @ApiModelProperty(value = "Email Address")


  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDTO userDTO = (UserDTO) o;
    return Objects.equals(this.id, userDTO.id) &&
        Objects.equals(this.tenantId, userDTO.tenantId) &&
        Objects.equals(this.orgId, userDTO.orgId) &&
        Objects.equals(this.username, userDTO.username) &&
        Objects.equals(this.password, userDTO.password) &&
        Objects.equals(this.emailAddress, userDTO.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tenantId, orgId, username, password, emailAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
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

