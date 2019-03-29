package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.lxisoft.client.open_lrw.model.LineItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MongoLineItem
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class MongoLineItem   {
  @JsonProperty("classSourcedId")
  private String classSourcedId = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("lineItem")
  private LineItem lineItem = null;

  @JsonProperty("orgId")
  private String orgId = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  public MongoLineItem classSourcedId(String classSourcedId) {
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

  public MongoLineItem id(String id) {
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

  public MongoLineItem lineItem(LineItem lineItem) {
    this.lineItem = lineItem;
    return this;
  }

  /**
   * Get lineItem
   * @return lineItem
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LineItem getLineItem() {
    return lineItem;
  }

  public void setLineItem(LineItem lineItem) {
    this.lineItem = lineItem;
  }

  public MongoLineItem orgId(String orgId) {
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

  public MongoLineItem tenantId(String tenantId) {
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
    MongoLineItem mongoLineItem = (MongoLineItem) o;
    return Objects.equals(this.classSourcedId, mongoLineItem.classSourcedId) &&
        Objects.equals(this.id, mongoLineItem.id) &&
        Objects.equals(this.lineItem, mongoLineItem.lineItem) &&
        Objects.equals(this.orgId, mongoLineItem.orgId) &&
        Objects.equals(this.tenantId, mongoLineItem.tenantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(classSourcedId, id, lineItem, orgId, tenantId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MongoLineItem {\n");
    
    sb.append("    classSourcedId: ").append(toIndentedString(classSourcedId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lineItem: ").append(toIndentedString(lineItem)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
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

