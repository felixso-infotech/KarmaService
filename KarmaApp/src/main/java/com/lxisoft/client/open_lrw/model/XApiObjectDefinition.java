package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.lxisoft.client.open_lrw.model.XApiInteractionComponent;
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
 * XApiObjectDefinition
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class XApiObjectDefinition   {
  @JsonProperty("choices")
  @Valid
  private List<XApiInteractionComponent> choices = null;

  @JsonProperty("correctResponsesPattern")
  @Valid
  private List<String> correctResponsesPattern = null;

  @JsonProperty("description")
  @Valid
  private Map<String, String> description = null;

  @JsonProperty("extensions")
  @Valid
  private Map<String, Object> extensions = null;

  @JsonProperty("interactionType")
  private String interactionType = null;

  @JsonProperty("moreInfo")
  private String moreInfo = null;

  @JsonProperty("name")
  @Valid
  private Map<String, String> name = null;

  @JsonProperty("scale")
  @Valid
  private List<XApiInteractionComponent> scale = null;

  @JsonProperty("source")
  @Valid
  private List<XApiInteractionComponent> source = null;

  @JsonProperty("steps")
  @Valid
  private List<XApiInteractionComponent> steps = null;

  @JsonProperty("target")
  @Valid
  private List<XApiInteractionComponent> target = null;

  @JsonProperty("type")
  private String type = null;

  public XApiObjectDefinition choices(List<XApiInteractionComponent> choices) {
    this.choices = choices;
    return this;
  }

  public XApiObjectDefinition addChoicesItem(XApiInteractionComponent choicesItem) {
    if (this.choices == null) {
      this.choices = new ArrayList<XApiInteractionComponent>();
    }
    this.choices.add(choicesItem);
    return this;
  }

  /**
   * Get choices
   * @return choices
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<XApiInteractionComponent> getChoices() {
    return choices;
  }

  public void setChoices(List<XApiInteractionComponent> choices) {
    this.choices = choices;
  }

  public XApiObjectDefinition correctResponsesPattern(List<String> correctResponsesPattern) {
    this.correctResponsesPattern = correctResponsesPattern;
    return this;
  }

  public XApiObjectDefinition addCorrectResponsesPatternItem(String correctResponsesPatternItem) {
    if (this.correctResponsesPattern == null) {
      this.correctResponsesPattern = new ArrayList<String>();
    }
    this.correctResponsesPattern.add(correctResponsesPatternItem);
    return this;
  }

  /**
   * Get correctResponsesPattern
   * @return correctResponsesPattern
  **/
  @ApiModelProperty(value = "")


  public List<String> getCorrectResponsesPattern() {
    return correctResponsesPattern;
  }

  public void setCorrectResponsesPattern(List<String> correctResponsesPattern) {
    this.correctResponsesPattern = correctResponsesPattern;
  }

  public XApiObjectDefinition description(Map<String, String> description) {
    this.description = description;
    return this;
  }

  public XApiObjectDefinition putDescriptionItem(String key, String descriptionItem) {
    if (this.description == null) {
      this.description = new HashMap<String, String>();
    }
    this.description.put(key, descriptionItem);
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public Map<String, String> getDescription() {
    return description;
  }

  public void setDescription(Map<String, String> description) {
    this.description = description;
  }

  public XApiObjectDefinition extensions(Map<String, Object> extensions) {
    this.extensions = extensions;
    return this;
  }

  public XApiObjectDefinition putExtensionsItem(String key, Object extensionsItem) {
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

  public XApiObjectDefinition interactionType(String interactionType) {
    this.interactionType = interactionType;
    return this;
  }

  /**
   * Get interactionType
   * @return interactionType
  **/
  @ApiModelProperty(value = "")


  public String getInteractionType() {
    return interactionType;
  }

  public void setInteractionType(String interactionType) {
    this.interactionType = interactionType;
  }

  public XApiObjectDefinition moreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
    return this;
  }

  /**
   * Get moreInfo
   * @return moreInfo
  **/
  @ApiModelProperty(value = "")


  public String getMoreInfo() {
    return moreInfo;
  }

  public void setMoreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
  }

  public XApiObjectDefinition name(Map<String, String> name) {
    this.name = name;
    return this;
  }

  public XApiObjectDefinition putNameItem(String key, String nameItem) {
    if (this.name == null) {
      this.name = new HashMap<String, String>();
    }
    this.name.put(key, nameItem);
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public Map<String, String> getName() {
    return name;
  }

  public void setName(Map<String, String> name) {
    this.name = name;
  }

  public XApiObjectDefinition scale(List<XApiInteractionComponent> scale) {
    this.scale = scale;
    return this;
  }

  public XApiObjectDefinition addScaleItem(XApiInteractionComponent scaleItem) {
    if (this.scale == null) {
      this.scale = new ArrayList<XApiInteractionComponent>();
    }
    this.scale.add(scaleItem);
    return this;
  }

  /**
   * Get scale
   * @return scale
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<XApiInteractionComponent> getScale() {
    return scale;
  }

  public void setScale(List<XApiInteractionComponent> scale) {
    this.scale = scale;
  }

  public XApiObjectDefinition source(List<XApiInteractionComponent> source) {
    this.source = source;
    return this;
  }

  public XApiObjectDefinition addSourceItem(XApiInteractionComponent sourceItem) {
    if (this.source == null) {
      this.source = new ArrayList<XApiInteractionComponent>();
    }
    this.source.add(sourceItem);
    return this;
  }

  /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<XApiInteractionComponent> getSource() {
    return source;
  }

  public void setSource(List<XApiInteractionComponent> source) {
    this.source = source;
  }

  public XApiObjectDefinition steps(List<XApiInteractionComponent> steps) {
    this.steps = steps;
    return this;
  }

  public XApiObjectDefinition addStepsItem(XApiInteractionComponent stepsItem) {
    if (this.steps == null) {
      this.steps = new ArrayList<XApiInteractionComponent>();
    }
    this.steps.add(stepsItem);
    return this;
  }

  /**
   * Get steps
   * @return steps
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<XApiInteractionComponent> getSteps() {
    return steps;
  }

  public void setSteps(List<XApiInteractionComponent> steps) {
    this.steps = steps;
  }

  public XApiObjectDefinition target(List<XApiInteractionComponent> target) {
    this.target = target;
    return this;
  }

  public XApiObjectDefinition addTargetItem(XApiInteractionComponent targetItem) {
    if (this.target == null) {
      this.target = new ArrayList<XApiInteractionComponent>();
    }
    this.target.add(targetItem);
    return this;
  }

  /**
   * Get target
   * @return target
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<XApiInteractionComponent> getTarget() {
    return target;
  }

  public void setTarget(List<XApiInteractionComponent> target) {
    this.target = target;
  }

  public XApiObjectDefinition type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XApiObjectDefinition xapiObjectDefinition = (XApiObjectDefinition) o;
    return Objects.equals(this.choices, xapiObjectDefinition.choices) &&
        Objects.equals(this.correctResponsesPattern, xapiObjectDefinition.correctResponsesPattern) &&
        Objects.equals(this.description, xapiObjectDefinition.description) &&
        Objects.equals(this.extensions, xapiObjectDefinition.extensions) &&
        Objects.equals(this.interactionType, xapiObjectDefinition.interactionType) &&
        Objects.equals(this.moreInfo, xapiObjectDefinition.moreInfo) &&
        Objects.equals(this.name, xapiObjectDefinition.name) &&
        Objects.equals(this.scale, xapiObjectDefinition.scale) &&
        Objects.equals(this.source, xapiObjectDefinition.source) &&
        Objects.equals(this.steps, xapiObjectDefinition.steps) &&
        Objects.equals(this.target, xapiObjectDefinition.target) &&
        Objects.equals(this.type, xapiObjectDefinition.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choices, correctResponsesPattern, description, extensions, interactionType, moreInfo, name, scale, source, steps, target, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XApiObjectDefinition {\n");
    
    sb.append("    choices: ").append(toIndentedString(choices)).append("\n");
    sb.append("    correctResponsesPattern: ").append(toIndentedString(correctResponsesPattern)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    interactionType: ").append(toIndentedString(interactionType)).append("\n");
    sb.append("    moreInfo: ").append(toIndentedString(moreInfo)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    steps: ").append(toIndentedString(steps)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

