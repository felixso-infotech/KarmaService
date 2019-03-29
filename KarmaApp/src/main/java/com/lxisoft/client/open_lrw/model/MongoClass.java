package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.lxisoft.client.open_lrw.model.ModelClass;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MongoClass
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class MongoClass   {
  @JsonProperty("classSourcedId")
  private String classSourcedId = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("klass")
  private ModelClass klass = null;

  @JsonProperty("orgId")
  private String orgId = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  public MongoClass classSourcedId(String classSourcedId) {
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

  public MongoClass id(String id) {
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

  public MongoClass klass(ModelClass klass) {
    this.klass = klass;
    return this;
  }

  /**
   * Get klass
   * @return klass
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ModelClass getKlass() {
    return klass;
  }

  public void setKlass(ModelClass klass) {
    this.klass = klass;
  }

  public MongoClass orgId(String orgId) {
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

  public MongoClass tenantId(String tenantId) {
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
    MongoClass mongoClass = (MongoClass) o;
    return Objects.equals(this.classSourcedId, mongoClass.classSourcedId) &&
        Objects.equals(this.id, mongoClass.id) &&
        Objects.equals(this.klass, mongoClass.klass) &&
        Objects.equals(this.orgId, mongoClass.orgId) &&
        Objects.equals(this.tenantId, mongoClass.tenantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(classSourcedId, id, klass, orgId, tenantId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MongoClass {\n");
    
    sb.append("    classSourcedId: ").append(toIndentedString(classSourcedId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    klass: ").append(toIndentedString(klass)).append("\n");
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

