package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * XApiInteractionComponent
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class XApiInteractionComponent   {
  @JsonProperty("description")
  @Valid
  private Map<String, String> description = null;

  @JsonProperty("id")
  private String id = null;

  public XApiInteractionComponent description(Map<String, String> description) {
    this.description = description;
    return this;
  }

  public XApiInteractionComponent putDescriptionItem(String key, String descriptionItem) {
    if (this.description == null) {
      this.description = new HashMap<String, String>();
    }
    this.description.put(key, descriptionItem);
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public Map<String, String> getDescription() {
    return description;
  }

  public void setDescription(Map<String, String> description) {
    this.description = description;
  }

  public XApiInteractionComponent id(String id) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XApiInteractionComponent xapiInteractionComponent = (XApiInteractionComponent) o;
    return Objects.equals(this.description, xapiInteractionComponent.description) &&
        Objects.equals(this.id, xapiInteractionComponent.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XApiInteractionComponent {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

