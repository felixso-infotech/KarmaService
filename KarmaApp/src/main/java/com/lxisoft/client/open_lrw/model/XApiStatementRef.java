package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * XApiStatementRef
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class XApiStatementRef   {
  @JsonProperty("id")
  private String id = null;

  /**
   * Gets or Sets objectType
   */
  public enum ObjectTypeEnum {
    ACTIVITY("Activity"),
    
    AGENT("Agent"),
    
    GROUP("Group"),
    
    SUBSTATEMENT("SubStatement"),
    
    STATEMENTREF("StatementRef");

    private String value;

    ObjectTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ObjectTypeEnum fromValue(String text) {
      for (ObjectTypeEnum b : ObjectTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("objectType")
  private ObjectTypeEnum objectType = null;

  public XApiStatementRef id(String id) {
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

  public XApiStatementRef objectType(ObjectTypeEnum objectType) {
    this.objectType = objectType;
    return this;
  }

  /**
   * Get objectType
   * @return objectType
  **/
  @ApiModelProperty(value = "")


  public ObjectTypeEnum getObjectType() {
    return objectType;
  }

  public void setObjectType(ObjectTypeEnum objectType) {
    this.objectType = objectType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XApiStatementRef xapiStatementRef = (XApiStatementRef) o;
    return Objects.equals(this.id, xapiStatementRef.id) &&
        Objects.equals(this.objectType, xapiStatementRef.objectType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, objectType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XApiStatementRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
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

