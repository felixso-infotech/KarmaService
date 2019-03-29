package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.lxisoft.client.open_lrw.model.XApiActor;
import com.lxisoft.client.open_lrw.model.XApiContextActivities;
import com.lxisoft.client.open_lrw.model.XApiStatementRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * XApiContext
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class XApiContext   {
  @JsonProperty("contextActivities")
  private XApiContextActivities contextActivities = null;

  @JsonProperty("extensions")
  @Valid
  private Map<String, Object> extensions = null;

  @JsonProperty("instructor")
  private XApiActor instructor = null;

  @JsonProperty("language")
  private String language = null;

  @JsonProperty("platform")
  private String platform = null;

  @JsonProperty("registration")
  private String registration = null;

  @JsonProperty("revision")
  private String revision = null;

  @JsonProperty("statement")
  private XApiStatementRef statement = null;

  @JsonProperty("team")
  private XApiActor team = null;

  public XApiContext contextActivities(XApiContextActivities contextActivities) {
    this.contextActivities = contextActivities;
    return this;
  }

  /**
   * Get contextActivities
   * @return contextActivities
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiContextActivities getContextActivities() {
    return contextActivities;
  }

  public void setContextActivities(XApiContextActivities contextActivities) {
    this.contextActivities = contextActivities;
  }

  public XApiContext extensions(Map<String, Object> extensions) {
    this.extensions = extensions;
    return this;
  }

  public XApiContext putExtensionsItem(String key, Object extensionsItem) {
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

  public XApiContext instructor(XApiActor instructor) {
    this.instructor = instructor;
    return this;
  }

  /**
   * Get instructor
   * @return instructor
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiActor getInstructor() {
    return instructor;
  }

  public void setInstructor(XApiActor instructor) {
    this.instructor = instructor;
  }

  public XApiContext language(String language) {
    this.language = language;
    return this;
  }

  /**
   * Get language
   * @return language
  **/
  @ApiModelProperty(value = "")


  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public XApiContext platform(String platform) {
    this.platform = platform;
    return this;
  }

  /**
   * Get platform
   * @return platform
  **/
  @ApiModelProperty(value = "")


  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  public XApiContext registration(String registration) {
    this.registration = registration;
    return this;
  }

  /**
   * Get registration
   * @return registration
  **/
  @ApiModelProperty(value = "")


  public String getRegistration() {
    return registration;
  }

  public void setRegistration(String registration) {
    this.registration = registration;
  }

  public XApiContext revision(String revision) {
    this.revision = revision;
    return this;
  }

  /**
   * Get revision
   * @return revision
  **/
  @ApiModelProperty(value = "")


  public String getRevision() {
    return revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public XApiContext statement(XApiStatementRef statement) {
    this.statement = statement;
    return this;
  }

  /**
   * Get statement
   * @return statement
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiStatementRef getStatement() {
    return statement;
  }

  public void setStatement(XApiStatementRef statement) {
    this.statement = statement;
  }

  public XApiContext team(XApiActor team) {
    this.team = team;
    return this;
  }

  /**
   * Get team
   * @return team
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiActor getTeam() {
    return team;
  }

  public void setTeam(XApiActor team) {
    this.team = team;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XApiContext xapiContext = (XApiContext) o;
    return Objects.equals(this.contextActivities, xapiContext.contextActivities) &&
        Objects.equals(this.extensions, xapiContext.extensions) &&
        Objects.equals(this.instructor, xapiContext.instructor) &&
        Objects.equals(this.language, xapiContext.language) &&
        Objects.equals(this.platform, xapiContext.platform) &&
        Objects.equals(this.registration, xapiContext.registration) &&
        Objects.equals(this.revision, xapiContext.revision) &&
        Objects.equals(this.statement, xapiContext.statement) &&
        Objects.equals(this.team, xapiContext.team);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contextActivities, extensions, instructor, language, platform, registration, revision, statement, team);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XApiContext {\n");
    
    sb.append("    contextActivities: ").append(toIndentedString(contextActivities)).append("\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    instructor: ").append(toIndentedString(instructor)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    platform: ").append(toIndentedString(platform)).append("\n");
    sb.append("    registration: ").append(toIndentedString(registration)).append("\n");
    sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
    sb.append("    statement: ").append(toIndentedString(statement)).append("\n");
    sb.append("    team: ").append(toIndentedString(team)).append("\n");
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

