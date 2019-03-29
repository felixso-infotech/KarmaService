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
 * About
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class About   {
  @JsonProperty("extensions")
  @Valid
  private Map<String, String> extensions = null;

  @JsonProperty("version")
  private String version = null;

  public About extensions(Map<String, String> extensions) {
    this.extensions = extensions;
    return this;
  }

  public About putExtensionsItem(String key, String extensionsItem) {
    if (this.extensions == null) {
      this.extensions = new HashMap<String, String>();
    }
    this.extensions.put(key, extensionsItem);
    return this;
  }

  /**
   * Get extensions
   * @return extensions
  **/
  @ApiModelProperty(value = "")


  public Map<String, String> getExtensions() {
    return extensions;
  }

  public void setExtensions(Map<String, String> extensions) {
    this.extensions = extensions;
  }

  public About version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    About about = (About) o;
    return Objects.equals(this.extensions, about.extensions) &&
        Objects.equals(this.version, about.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extensions, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class About {\n");
    
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

