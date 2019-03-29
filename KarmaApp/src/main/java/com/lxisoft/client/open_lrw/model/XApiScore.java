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
 * XApiScore
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class XApiScore   {
  @JsonProperty("max")
  private Double max = null;

  @JsonProperty("min")
  private Double min = null;

  @JsonProperty("raw")
  private Double raw = null;

  @JsonProperty("scaled")
  private Double scaled = null;

  public XApiScore max(Double max) {
    this.max = max;
    return this;
  }

  /**
   * Get max
   * @return max
  **/
  @ApiModelProperty(value = "")


  public Double getMax() {
    return max;
  }

  public void setMax(Double max) {
    this.max = max;
  }

  public XApiScore min(Double min) {
    this.min = min;
    return this;
  }

  /**
   * Get min
   * @return min
  **/
  @ApiModelProperty(value = "")


  public Double getMin() {
    return min;
  }

  public void setMin(Double min) {
    this.min = min;
  }

  public XApiScore raw(Double raw) {
    this.raw = raw;
    return this;
  }

  /**
   * Get raw
   * @return raw
  **/
  @ApiModelProperty(value = "")


  public Double getRaw() {
    return raw;
  }

  public void setRaw(Double raw) {
    this.raw = raw;
  }

  public XApiScore scaled(Double scaled) {
    this.scaled = scaled;
    return this;
  }

  /**
   * Get scaled
   * @return scaled
  **/
  @ApiModelProperty(value = "")


  public Double getScaled() {
    return scaled;
  }

  public void setScaled(Double scaled) {
    this.scaled = scaled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XApiScore xapiScore = (XApiScore) o;
    return Objects.equals(this.max, xapiScore.max) &&
        Objects.equals(this.min, xapiScore.min) &&
        Objects.equals(this.raw, xapiScore.raw) &&
        Objects.equals(this.scaled, xapiScore.scaled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(max, min, raw, scaled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XApiScore {\n");
    
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    raw: ").append(toIndentedString(raw)).append("\n");
    sb.append("    scaled: ").append(toIndentedString(scaled)).append("\n");
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

