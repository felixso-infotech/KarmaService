package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.lxisoft.client.open_lrw.model.XApiObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * XApiContextActivities
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class XApiContextActivities   {
  @JsonProperty("category")
  @Valid
  private List<XApiObject> category = null;

  @JsonProperty("grouping")
  @Valid
  private List<XApiObject> grouping = null;

  @JsonProperty("other")
  @Valid
  private List<XApiObject> other = null;

  @JsonProperty("parent")
  @Valid
  private List<XApiObject> parent = null;

  public XApiContextActivities category(List<XApiObject> category) {
    this.category = category;
    return this;
  }

  public XApiContextActivities addCategoryItem(XApiObject categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<XApiObject>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<XApiObject> getCategory() {
    return category;
  }

  public void setCategory(List<XApiObject> category) {
    this.category = category;
  }

  public XApiContextActivities grouping(List<XApiObject> grouping) {
    this.grouping = grouping;
    return this;
  }

  public XApiContextActivities addGroupingItem(XApiObject groupingItem) {
    if (this.grouping == null) {
      this.grouping = new ArrayList<XApiObject>();
    }
    this.grouping.add(groupingItem);
    return this;
  }

  /**
   * Get grouping
   * @return grouping
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<XApiObject> getGrouping() {
    return grouping;
  }

  public void setGrouping(List<XApiObject> grouping) {
    this.grouping = grouping;
  }

  public XApiContextActivities other(List<XApiObject> other) {
    this.other = other;
    return this;
  }

  public XApiContextActivities addOtherItem(XApiObject otherItem) {
    if (this.other == null) {
      this.other = new ArrayList<XApiObject>();
    }
    this.other.add(otherItem);
    return this;
  }

  /**
   * Get other
   * @return other
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<XApiObject> getOther() {
    return other;
  }

  public void setOther(List<XApiObject> other) {
    this.other = other;
  }

  public XApiContextActivities parent(List<XApiObject> parent) {
    this.parent = parent;
    return this;
  }

  public XApiContextActivities addParentItem(XApiObject parentItem) {
    if (this.parent == null) {
      this.parent = new ArrayList<XApiObject>();
    }
    this.parent.add(parentItem);
    return this;
  }

  /**
   * Get parent
   * @return parent
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<XApiObject> getParent() {
    return parent;
  }

  public void setParent(List<XApiObject> parent) {
    this.parent = parent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XApiContextActivities xapiContextActivities = (XApiContextActivities) o;
    return Objects.equals(this.category, xapiContextActivities.category) &&
        Objects.equals(this.grouping, xapiContextActivities.grouping) &&
        Objects.equals(this.other, xapiContextActivities.other) &&
        Objects.equals(this.parent, xapiContextActivities.parent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, grouping, other, parent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XApiContextActivities {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    grouping: ").append(toIndentedString(grouping)).append("\n");
    sb.append("    other: ").append(toIndentedString(other)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
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

