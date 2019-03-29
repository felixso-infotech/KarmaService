package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lxisoft.client.open_lrw.model.Link;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Result
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class Result   {
  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("date")
  private OffsetDateTime date = null;

  @JsonProperty("dateLastModified")
  private OffsetDateTime dateLastModified = null;

  @JsonProperty("lineitem")
  private Link lineitem = null;

  @JsonProperty("metadata")
  @Valid
  private Map<String, String> metadata = null;

  @JsonProperty("resultstatus")
  private String resultstatus = null;

  @JsonProperty("score")
  private Double score = null;

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

  @JsonProperty("student")
  private Link student = null;

  public Result comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Get comment
   * @return comment
  **/
  @ApiModelProperty(value = "")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Result date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public Result dateLastModified(OffsetDateTime dateLastModified) {
    this.dateLastModified = dateLastModified;
    return this;
  }

  /**
   * Get dateLastModified
   * @return dateLastModified
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDateLastModified() {
    return dateLastModified;
  }

  public void setDateLastModified(OffsetDateTime dateLastModified) {
    this.dateLastModified = dateLastModified;
  }

  public Result lineitem(Link lineitem) {
    this.lineitem = lineitem;
    return this;
  }

  /**
   * Get lineitem
   * @return lineitem
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Link getLineitem() {
    return lineitem;
  }

  public void setLineitem(Link lineitem) {
    this.lineitem = lineitem;
  }

  public Result metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public Result putMetadataItem(String key, String metadataItem) {
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

  public Result resultstatus(String resultstatus) {
    this.resultstatus = resultstatus;
    return this;
  }

  /**
   * Get resultstatus
   * @return resultstatus
  **/
  @ApiModelProperty(value = "")


  public String getResultstatus() {
    return resultstatus;
  }

  public void setResultstatus(String resultstatus) {
    this.resultstatus = resultstatus;
  }

  public Result score(Double score) {
    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
  **/
  @ApiModelProperty(value = "")


  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public Result sourcedId(String sourcedId) {
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

  public Result status(StatusEnum status) {
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

  public Result student(Link student) {
    this.student = student;
    return this;
  }

  /**
   * Get student
   * @return student
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Link getStudent() {
    return student;
  }

  public void setStudent(Link student) {
    this.student = student;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Result result = (Result) o;
    return Objects.equals(this.comment, result.comment) &&
        Objects.equals(this.date, result.date) &&
        Objects.equals(this.dateLastModified, result.dateLastModified) &&
        Objects.equals(this.lineitem, result.lineitem) &&
        Objects.equals(this.metadata, result.metadata) &&
        Objects.equals(this.resultstatus, result.resultstatus) &&
        Objects.equals(this.score, result.score) &&
        Objects.equals(this.sourcedId, result.sourcedId) &&
        Objects.equals(this.status, result.status) &&
        Objects.equals(this.student, result.student);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment, date, dateLastModified, lineitem, metadata, resultstatus, score, sourcedId, status, student);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Result {\n");
    
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    dateLastModified: ").append(toIndentedString(dateLastModified)).append("\n");
    sb.append("    lineitem: ").append(toIndentedString(lineitem)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    resultstatus: ").append(toIndentedString(resultstatus)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    sourcedId: ").append(toIndentedString(sourcedId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    student: ").append(toIndentedString(student)).append("\n");
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

