package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Course
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class Course   {
  @JsonProperty("courseCode")
  private String courseCode = null;

  @JsonProperty("grade")
  private String grade = null;

  @JsonProperty("metadata")
  @Valid
  private Map<String, String> metadata = null;

  @JsonProperty("schoolYear")
  private String schoolYear = null;

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

  @JsonProperty("subjects")
  @Valid
  private List<String> subjects = null;

  @JsonProperty("title")
  private String title = null;

  public Course courseCode(String courseCode) {
    this.courseCode = courseCode;
    return this;
  }

  /**
   * Get courseCode
   * @return courseCode
  **/
  @ApiModelProperty(value = "")


  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public Course grade(String grade) {
    this.grade = grade;
    return this;
  }

  /**
   * Get grade
   * @return grade
  **/
  @ApiModelProperty(value = "")


  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public Course metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public Course putMetadataItem(String key, String metadataItem) {
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

  public Course schoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
    return this;
  }

  /**
   * Get schoolYear
   * @return schoolYear
  **/
  @ApiModelProperty(value = "")


  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  public Course sourcedId(String sourcedId) {
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

  public Course status(StatusEnum status) {
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

  public Course subjects(List<String> subjects) {
    this.subjects = subjects;
    return this;
  }

  public Course addSubjectsItem(String subjectsItem) {
    if (this.subjects == null) {
      this.subjects = new ArrayList<String>();
    }
    this.subjects.add(subjectsItem);
    return this;
  }

  /**
   * Get subjects
   * @return subjects
  **/
  @ApiModelProperty(value = "")


  public List<String> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<String> subjects) {
    this.subjects = subjects;
  }

  public Course title(String title) {
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
    Course course = (Course) o;
    return Objects.equals(this.courseCode, course.courseCode) &&
        Objects.equals(this.grade, course.grade) &&
        Objects.equals(this.metadata, course.metadata) &&
        Objects.equals(this.schoolYear, course.schoolYear) &&
        Objects.equals(this.sourcedId, course.sourcedId) &&
        Objects.equals(this.status, course.status) &&
        Objects.equals(this.subjects, course.subjects) &&
        Objects.equals(this.title, course.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseCode, grade, metadata, schoolYear, sourcedId, status, subjects, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Course {\n");
    
    sb.append("    courseCode: ").append(toIndentedString(courseCode)).append("\n");
    sb.append("    grade: ").append(toIndentedString(grade)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    schoolYear: ").append(toIndentedString(schoolYear)).append("\n");
    sb.append("    sourcedId: ").append(toIndentedString(sourcedId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subjects: ").append(toIndentedString(subjects)).append("\n");
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

