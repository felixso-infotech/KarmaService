package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.lxisoft.client.open_lrw.model.XApiActor;
import com.lxisoft.client.open_lrw.model.XApiContext;
import com.lxisoft.client.open_lrw.model.XApiObject;
import com.lxisoft.client.open_lrw.model.XApiResult;
import com.lxisoft.client.open_lrw.model.XApiVerb;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Statement
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class Statement   {
  @JsonProperty("actor")
  private XApiActor actor = null;

  @JsonProperty("authority")
  private XApiActor authority = null;

  @JsonProperty("context")
  private XApiContext context = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("object")
  private XApiObject object = null;

  @JsonProperty("result")
  private XApiResult result = null;

  @JsonProperty("stored")
  private String stored = null;

  @JsonProperty("timestamp")
  private String timestamp = null;

  @JsonProperty("verb")
  private XApiVerb verb = null;

  @JsonProperty("version")
  private String version = null;

  public Statement actor(XApiActor actor) {
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

  public Statement authority(XApiActor authority) {
    this.authority = authority;
    return this;
  }

  /**
   * Get authority
   * @return authority
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiActor getAuthority() {
    return authority;
  }

  public void setAuthority(XApiActor authority) {
    this.authority = authority;
  }

  public Statement context(XApiContext context) {
    this.context = context;
    return this;
  }

  /**
   * Get context
   * @return context
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiContext getContext() {
    return context;
  }

  public void setContext(XApiContext context) {
    this.context = context;
  }

  public Statement id(String id) {
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

  public Statement object(XApiObject object) {
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

  public Statement result(XApiResult result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiResult getResult() {
    return result;
  }

  public void setResult(XApiResult result) {
    this.result = result;
  }

  public Statement stored(String stored) {
    this.stored = stored;
    return this;
  }

  /**
   * Get stored
   * @return stored
  **/
  @ApiModelProperty(value = "")


  public String getStored() {
    return stored;
  }

  public void setStored(String stored) {
    this.stored = stored;
  }

  public Statement timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(value = "")


  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public Statement verb(XApiVerb verb) {
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

  public Statement version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Statement statement = (Statement) o;
    return Objects.equals(this.actor, statement.actor) &&
        Objects.equals(this.authority, statement.authority) &&
        Objects.equals(this.context, statement.context) &&
        Objects.equals(this.id, statement.id) &&
        Objects.equals(this.object, statement.object) &&
        Objects.equals(this.result, statement.result) &&
        Objects.equals(this.stored, statement.stored) &&
        Objects.equals(this.timestamp, statement.timestamp) &&
        Objects.equals(this.verb, statement.verb) &&
        Objects.equals(this.version, statement.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actor, authority, context, id, object, result, stored, timestamp, verb, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Statement {\n");
    
    sb.append("    actor: ").append(toIndentedString(actor)).append("\n");
    sb.append("    authority: ").append(toIndentedString(authority)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    stored: ").append(toIndentedString(stored)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    verb: ").append(toIndentedString(verb)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

