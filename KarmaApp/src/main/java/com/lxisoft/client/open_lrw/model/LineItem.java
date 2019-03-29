package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lxisoft.client.open_lrw.model.LineItemCategory;
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
 * LineItem
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class LineItem   {
  @JsonProperty("assignDate")
  private OffsetDateTime assignDate = null;

  @JsonProperty("category")
  private LineItemCategory category = null;

  @JsonProperty("class")
  private Link propertyClass = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("dueDate")
  private OffsetDateTime dueDate = null;

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

  public LineItem assignDate(OffsetDateTime assignDate) {
    this.assignDate = assignDate;
    return this;
  }

  /**
   * Get assignDate
   * @return assignDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getAssignDate() {
    return assignDate;
  }

  public void setAssignDate(OffsetDateTime assignDate) {
    this.assignDate = assignDate;
  }

  public LineItem category(LineItemCategory category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LineItemCategory getCategory() {
    return category;
  }

  public void setCategory(LineItemCategory category) {
    this.category = category;
  }

  public LineItem propertyClass(Link propertyClass) {
    this.propertyClass = propertyClass;
    return this;
  }

  /**
   * Get propertyClass
   * @return propertyClass
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Link getPropertyClass() {
    return propertyClass;
  }

  public void setPropertyClass(Link propertyClass) {
    this.propertyClass = propertyClass;
  }

  public LineItem description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LineItem dueDate(OffsetDateTime dueDate) {
    this.dueDate = dueDate;
    return this;
  }

  /**
   * Get dueDate
   * @return dueDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDueDate() {
    return dueDate;
  }

  public void setDueDate(OffsetDateTime dueDate) {
    this.dueDate = dueDate;
  }

  public LineItem metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public LineItem putMetadataItem(String key, String metadataItem) {
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

  public LineItem sourcedId(String sourcedId) {
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

  public LineItem status(StatusEnum status) {
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

  public LineItem title(String title) {
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
    LineItem lineItem = (LineItem) o;
    return Objects.equals(this.assignDate, lineItem.assignDate) &&
        Objects.equals(this.category, lineItem.category) &&
        Objects.equals(this.propertyClass, lineItem.propertyClass) &&
        Objects.equals(this.description, lineItem.description) &&
        Objects.equals(this.dueDate, lineItem.dueDate) &&
        Objects.equals(this.metadata, lineItem.metadata) &&
        Objects.equals(this.sourcedId, lineItem.sourcedId) &&
        Objects.equals(this.status, lineItem.status) &&
        Objects.equals(this.title, lineItem.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assignDate, category, propertyClass, description, dueDate, metadata, sourcedId, status, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineItem {\n");
    
    sb.append("    assignDate: ").append(toIndentedString(assignDate)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
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

