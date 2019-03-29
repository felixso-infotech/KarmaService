package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lxisoft.client.open_lrw.model.XApiActor;
import com.lxisoft.client.open_lrw.model.XApiObject;
import com.lxisoft.client.open_lrw.model.XApiObjectDefinition;
import com.lxisoft.client.open_lrw.model.XApiVerb;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * XApiObject
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class XApiObject   {
  @JsonProperty("actor")
  private XApiActor actor = null;

  @JsonProperty("definition")
  private XApiObjectDefinition definition = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("object")
  private XApiObject object = null;

  /**
   * Gets or Sets objectType
   */
  public enum ObjectTypeEnum {
    ACTIVITY("Activity"),
    
    AGENT("Agent"),
    
    GROUP("Group"),
    
    SUBSTATEMENT("SubStatement"),
    
    STATEMENTREF("StatementRef");

    private String value;

    ObjectTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ObjectTypeEnum fromValue(String text) {
      for (ObjectTypeEnum b : ObjectTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("objectType")
  private ObjectTypeEnum objectType = null;

  @JsonProperty("verb")
  private XApiVerb verb = null;

  public XApiObject actor(XApiActor actor) {
    this.actor = actor;
    return this;
  }

  /**
   * Get actor
   * @return actor
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiActor getActor() {
    return actor;
  }

  public void setActor(XApiActor actor) {
    this.actor = actor;
  }

  public XApiObject definition(XApiObjectDefinition definition) {
    this.definition = definition;
    return this;
  }

  /**
   * Get definition
   * @return definition
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiObjectDefinition getDefinition() {
    return definition;
  }

  public void setDefinition(XApiObjectDefinition definition) {
    this.definition = definition;
  }

  public XApiObject id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public XApiObject object(XApiObject object) {
    this.object = object;
    return this;
  }

  /**
   * Get object
   * @return object
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiObject getObject() {
    return object;
  }

  public void setObject(XApiObject object) {
    this.object = object;
  }

  public XApiObject objectType(ObjectTypeEnum objectType) {
    this.objectType = objectType;
    return this;
  }

  /**
   * Get objectType
   * @return objectType
  **/
  @ApiModelProperty(value = "")


  public ObjectTypeEnum getObjectType() {
    return objectType;
  }

  public void setObjectType(ObjectTypeEnum objectType) {
    this.objectType = objectType;
  }

  public XApiObject verb(XApiVerb verb) {
    this.verb = verb;
    return this;
  }

  /**
   * Get verb
   * @return verb
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiVerb getVerb() {
    return verb;
  }

  public void setVerb(XApiVerb verb) {
    this.verb = verb;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XApiObject xapiObject = (XApiObject) o;
    return Objects.equals(this.actor, xapiObject.actor) &&
        Objects.equals(this.definition, xapiObject.definition) &&
        Objects.equals(this.id, xapiObject.id) &&
        Objects.equals(this.object, xapiObject.object) &&
        Objects.equals(this.objectType, xapiObject.objectType) &&
        Objects.equals(this.verb, xapiObject.verb);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actor, definition, id, object, objectType, verb);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XApiObject {\n");
    
    sb.append("    actor: ").append(toIndentedString(actor)).append("\n");
    sb.append("    definition: ").append(toIndentedString(definition)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
    sb.append("    verb: ").append(toIndentedString(verb)).append("\n");
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

