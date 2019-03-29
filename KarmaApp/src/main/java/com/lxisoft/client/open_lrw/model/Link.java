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
 * Link
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class Link   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("templated")
  private Boolean templated = null;

  public Link href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Get href
   * @return href
  **/
  @ApiModelProperty(value = "")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Link templated(Boolean templated) {
    this.templated = templated;
    return this;
  }

  /**
   * Get templated
   * @return templated
  **/
  @ApiModelProperty(value = "")


  public Boolean isTemplated() {
    return templated;
  }

  public void setTemplated(Boolean templated) {
    this.templated = templated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Link link = (Link) o;
    return Objects.equals(this.href, link.href) &&
        Objects.equals(this.templated, link.templated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, templated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Link {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    templated: ").append(toIndentedString(templated)).append("\n");
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

