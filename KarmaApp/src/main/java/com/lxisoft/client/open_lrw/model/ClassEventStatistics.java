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
 * ClassEventStatistics
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class ClassEventStatistics   {
  @JsonProperty("classSourcedId")
  private String classSourcedId = null;

  @JsonProperty("eventCountGroupedByDate")
  @Valid
  private Map<String, Long> eventCountGroupedByDate = null;

  @JsonProperty("eventCountGroupedByDateAndStudent")
  @Valid
  private Map<String, Map<String, Long>> eventCountGroupedByDateAndStudent = null;

  @JsonProperty("metadata")
  @Valid
  private Map<String, String> metadata = null;

  @JsonProperty("totalEvents")
  private Integer totalEvents = null;

  @JsonProperty("totalStudentEnrollments")
  private Integer totalStudentEnrollments = null;

  public ClassEventStatistics classSourcedId(String classSourcedId) {
    this.classSourcedId = classSourcedId;
    return this;
  }

  /**
   * Get classSourcedId
   * @return classSourcedId
  **/
  @ApiModelProperty(value = "")


  public String getClassSourcedId() {
    return classSourcedId;
  }

  public void setClassSourcedId(String classSourcedId) {
    this.classSourcedId = classSourcedId;
  }

  public ClassEventStatistics eventCountGroupedByDate(Map<String, Long> eventCountGroupedByDate) {
    this.eventCountGroupedByDate = eventCountGroupedByDate;
    return this;
  }

  public ClassEventStatistics putEventCountGroupedByDateItem(String key, Long eventCountGroupedByDateItem) {
    if (this.eventCountGroupedByDate == null) {
      this.eventCountGroupedByDate = new HashMap<String, Long>();
    }
    this.eventCountGroupedByDate.put(key, eventCountGroupedByDateItem);
    return this;
  }

  /**
   * Get eventCountGroupedByDate
   * @return eventCountGroupedByDate
  **/
  @ApiModelProperty(value = "")


  public Map<String, Long> getEventCountGroupedByDate() {
    return eventCountGroupedByDate;
  }

  public void setEventCountGroupedByDate(Map<String, Long> eventCountGroupedByDate) {
    this.eventCountGroupedByDate = eventCountGroupedByDate;
  }

  public ClassEventStatistics eventCountGroupedByDateAndStudent(Map<String, Map<String, Long>> eventCountGroupedByDateAndStudent) {
    this.eventCountGroupedByDateAndStudent = eventCountGroupedByDateAndStudent;
    return this;
  }

  public ClassEventStatistics putEventCountGroupedByDateAndStudentItem(String key, Map<String, Long> eventCountGroupedByDateAndStudentItem) {
    if (this.eventCountGroupedByDateAndStudent == null) {
      this.eventCountGroupedByDateAndStudent = new HashMap<String, Map<String, Long>>();
    }
    this.eventCountGroupedByDateAndStudent.put(key, eventCountGroupedByDateAndStudentItem);
    return this;
  }

  /**
   * Get eventCountGroupedByDateAndStudent
   * @return eventCountGroupedByDateAndStudent
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Map<String, Map<String, Long>> getEventCountGroupedByDateAndStudent() {
    return eventCountGroupedByDateAndStudent;
  }

  public void setEventCountGroupedByDateAndStudent(Map<String, Map<String, Long>> eventCountGroupedByDateAndStudent) {
    this.eventCountGroupedByDateAndStudent = eventCountGroupedByDateAndStudent;
  }

  public ClassEventStatistics metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public ClassEventStatistics putMetadataItem(String key, String metadataItem) {
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

  public ClassEventStatistics totalEvents(Integer totalEvents) {
    this.totalEvents = totalEvents;
    return this;
  }

  /**
   * Get totalEvents
   * @return totalEvents
  **/
  @ApiModelProperty(value = "")


  public Integer getTotalEvents() {
    return totalEvents;
  }

  public void setTotalEvents(Integer totalEvents) {
    this.totalEvents = totalEvents;
  }

  public ClassEventStatistics totalStudentEnrollments(Integer totalStudentEnrollments) {
    this.totalStudentEnrollments = totalStudentEnrollments;
    return this;
  }

  /**
   * Get totalStudentEnrollments
   * @return totalStudentEnrollments
  **/
  @ApiModelProperty(value = "")


  public Integer getTotalStudentEnrollments() {
    return totalStudentEnrollments;
  }

  public void setTotalStudentEnrollments(Integer totalStudentEnrollments) {
    this.totalStudentEnrollments = totalStudentEnrollments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClassEventStatistics classEventStatistics = (ClassEventStatistics) o;
    return Objects.equals(this.classSourcedId, classEventStatistics.classSourcedId) &&
        Objects.equals(this.eventCountGroupedByDate, classEventStatistics.eventCountGroupedByDate) &&
        Objects.equals(this.eventCountGroupedByDateAndStudent, classEventStatistics.eventCountGroupedByDateAndStudent) &&
        Objects.equals(this.metadata, classEventStatistics.metadata) &&
        Objects.equals(this.totalEvents, classEventStatistics.totalEvents) &&
        Objects.equals(this.totalStudentEnrollments, classEventStatistics.totalStudentEnrollments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(classSourcedId, eventCountGroupedByDate, eventCountGroupedByDateAndStudent, metadata, totalEvents, totalStudentEnrollments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClassEventStatistics {\n");
    
    sb.append("    classSourcedId: ").append(toIndentedString(classSourcedId)).append("\n");
    sb.append("    eventCountGroupedByDate: ").append(toIndentedString(eventCountGroupedByDate)).append("\n");
    sb.append("    eventCountGroupedByDateAndStudent: ").append(toIndentedString(eventCountGroupedByDateAndStudent)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    totalEvents: ").append(toIndentedString(totalEvents)).append("\n");
    sb.append("    totalStudentEnrollments: ").append(toIndentedString(totalStudentEnrollments)).append("\n");
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

