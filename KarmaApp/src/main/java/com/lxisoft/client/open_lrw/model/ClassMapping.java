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
 * ClassMapping
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class ClassMapping   {
  @JsonProperty("classExternalId")
  private String classExternalId = null;

  @JsonProperty("classSourcedId")
  private String classSourcedId = null;

  @JsonProperty("dateLastModified")
  private OffsetDateTime dateLastModified = null;

  @JsonProperty("organizationId")
  private String organizationId = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  public ClassMapping classExternalId(String classExternalId) {
    this.classExternalId = classExternalId;
    return this;
  }

  /**
   * Get classExternalId
   * @return classExternalId
  **/
  @ApiModelProperty(value = "")


  public String getClassExternalId() {
    return classExternalId;
  }

  public void setClassExternalId(String classExternalId) {
    this.classExternalId = classExternalId;
  }

  public ClassMapping classSourcedId(String classSourcedId) {
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

  public ClassMapping dateLastModified(OffsetDateTime dateLastModified) {
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

  public ClassMapping organizationId(String organizationId) {
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

  public ClassMapping tenantId(String tenantId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClassMapping classMapping = (ClassMapping) o;
    return Objects.equals(this.classExternalId, classMapping.classExternalId) &&
        Objects.equals(this.classSourcedId, classMapping.classSourcedId) &&
        Objects.equals(this.dateLastModified, classMapping.dateLastModified) &&
        Objects.equals(this.organizationId, classMapping.organizationId) &&
        Objects.equals(this.tenantId, classMapping.tenantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(classExternalId, classSourcedId, dateLastModified, organizationId, tenantId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClassMapping {\n");
    
    sb.append("    classExternalId: ").append(toIndentedString(classExternalId)).append("\n");
    sb.append("    classSourcedId: ").append(toIndentedString(classSourcedId)).append("\n");
    sb.append("    dateLastModified: ").append(toIndentedString(dateLastModified)).append("\n");
    sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
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

