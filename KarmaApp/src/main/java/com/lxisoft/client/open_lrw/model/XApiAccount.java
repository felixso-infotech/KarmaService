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
 * XApiAccount
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class XApiAccount   {
  @JsonProperty("homePage")
  private String homePage = null;

  @JsonProperty("name")
  private String name = null;

  public XApiAccount homePage(String homePage) {
    this.homePage = homePage;
    return this;
  }

  /**
   * Get homePage
   * @return homePage
  **/
  @ApiModelProperty(value = "")


  public String getHomePage() {
    return homePage;
  }

  public void setHomePage(String homePage) {
    this.homePage = homePage;
  }

  public XApiAccount name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XApiAccount xapiAccount = (XApiAccount) o;
    return Objects.equals(this.homePage, xapiAccount.homePage) &&
        Objects.equals(this.name, xapiAccount.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(homePage, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XApiAccount {\n");
    
    sb.append("    homePage: ").append(toIndentedString(homePage)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

