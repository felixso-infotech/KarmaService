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
 * XApiVerb
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class XApiVerb   {
  @JsonProperty("display")
  @Valid
  private Map<String, String> display = null;

  @JsonProperty("id")
  private String id = null;

  public XApiVerb display(Map<String, String> display) {
    this.display = display;
    return this;
  }

  public XApiVerb putDisplayItem(String key, String displayItem) {
    if (this.display == null) {
      this.display = new HashMap<String, String>();
    }
    this.display.put(key, displayItem);
    return this;
  }

  /**
   * Get display
   * @return display
  **/
  @ApiModelProperty(value = "")


  public Map<String, String> getDisplay() {
    return display;
  }

  public void setDisplay(Map<String, String> display) {
    this.display = display;
  }

  public XApiVerb id(String id) {
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
    XApiVerb xapiVerb = (XApiVerb) o;
    return Objects.equals(this.display, xapiVerb.display) &&
        Objects.equals(this.id, xapiVerb.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(display, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XApiVerb {\n");
    
    sb.append("    display: ").append(toIndentedString(display)).append("\n");
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

