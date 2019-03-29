package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.lxisoft.client.open_lrw.model.XApiScore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * XApiResult
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class XApiResult   {
  @JsonProperty("completion")
  private Boolean completion = null;

  @JsonProperty("duration")
  private String duration = null;

  @JsonProperty("extensions")
  @Valid
  private Map<String, Object> extensions = null;

  @JsonProperty("response")
  private String response = null;

  @JsonProperty("score")
  private XApiScore score = null;

  @JsonProperty("success")
  private Boolean success = null;

  public XApiResult completion(Boolean completion) {
    this.completion = completion;
    return this;
  }

  /**
   * Get completion
   * @return completion
  **/
  @ApiModelProperty(value = "")


  public Boolean isCompletion() {
    return completion;
  }

  public void setCompletion(Boolean completion) {
    this.completion = completion;
  }

  public XApiResult duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * @return duration
  **/
  @ApiModelProperty(value = "")


  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public XApiResult extensions(Map<String, Object> extensions) {
    this.extensions = extensions;
    return this;
  }

  public XApiResult putExtensionsItem(String key, Object extensionsItem) {
    if (this.extensions == null) {
      this.extensions = new HashMap<String, Object>();
    }
    this.extensions.put(key, extensionsItem);
    return this;
  }

  /**
   * Get extensions
   * @return extensions
  **/
  @ApiModelProperty(value = "")


  public Map<String, Object> getExtensions() {
    return extensions;
  }

  public void setExtensions(Map<String, Object> extensions) {
    this.extensions = extensions;
  }

  public XApiResult response(String response) {
    this.response = response;
    return this;
  }

  /**
   * Get response
   * @return response
  **/
  @ApiModelProperty(value = "")


  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public XApiResult score(XApiScore score) {
    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiScore getScore() {
    return score;
  }

  public void setScore(XApiScore score) {
    this.score = score;
  }

  public XApiResult success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * Get success
   * @return success
  **/
  @ApiModelProperty(value = "")


  public Boolean isSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XApiResult xapiResult = (XApiResult) o;
    return Objects.equals(this.completion, xapiResult.completion) &&
        Objects.equals(this.duration, xapiResult.duration) &&
        Objects.equals(this.extensions, xapiResult.extensions) &&
        Objects.equals(this.response, xapiResult.response) &&
        Objects.equals(this.score, xapiResult.score) &&
        Objects.equals(this.success, xapiResult.success);
  }

  @Override
  public int hashCode() {
    return Objects.hash(completion, duration, extensions, response, score, success);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XApiResult {\n");
    
    sb.append("    completion: ").append(toIndentedString(completion)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
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

