package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lxisoft.client.open_lrw.model.Course;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ModelClass
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class ModelClass   {
  @JsonProperty("course")
  private Course course = null;

  @JsonProperty("metadata")
  @Valid
  private Map<String, String> metadata = null;

  @JsonProperty("sourcedId")
  private String sourcedId = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    ACTIVE("active"),
    
    INACTIVE("inactive"),
    
    TOBEDELETED("tobedeleted");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("title")
  private String title = null;

  public ModelClass course(Course course) {
    this.course = course;
    return this;
  }

  /**
   * Get course
   * @return course
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public ModelClass metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public ModelClass putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<String, String>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")


  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public ModelClass sourcedId(String sourcedId) {
    this.sourcedId = sourcedId;
    return this;
  }

  /**
   * Get sourcedId
   * @return sourcedId
  **/
  @ApiModelProperty(value = "")


  public String getSourcedId() {
    return sourcedId;
  }

  public void setSourcedId(String sourcedId) {
    this.sourcedId = sourcedId;
  }

  public ModelClass status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ModelClass title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelClass propertyClass = (ModelClass) o;
    return Objects.equals(this.course, propertyClass.course) &&
        Objects.equals(this.metadata, propertyClass.metadata) &&
        Objects.equals(this.sourcedId, propertyClass.sourcedId) &&
        Objects.equals(this.status, propertyClass.status) &&
        Objects.equals(this.title, propertyClass.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(course, metadata, sourcedId, status, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelClass {\n");
    
    sb.append("    course: ").append(toIndentedString(course)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    sourcedId: ").append(toIndentedString(sourcedId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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

