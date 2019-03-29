package com.lxisoft.client.open_lrw.model;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SubOrganizationOf
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class SubOrganizationOf {
	@JsonProperty("@context")
	private String context = null;

	@JsonProperty("@id")
	private String id = null;

	@JsonProperty("@type")
	private String type = null;

	@JsonProperty("academicSession")
	private String academicSession = null;

	@JsonProperty("category")
	private String category = null;

	@JsonProperty("courseNumber")
	private String courseNumber = null;

	@JsonProperty("dateCreated")
	private OffsetDateTime dateCreated = null;

	@JsonProperty("dateModified")
	private OffsetDateTime dateModified = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("extensions")
	@Valid
	private Map<String, String> extensions = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("subOrganizationOf")
	private SubOrganizationOf subOrganizationOf = null;

	public SubOrganizationOf context(String context) {
		this.context = context;
		return this;
	}

	/**
	 * Get @context
	 * 
	 * @return @context
	 **/
	@ApiModelProperty(value = "")

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public SubOrganizationOf id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get @id
	 * 
	 * @return @id
	 **/
	@ApiModelProperty(value = "")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SubOrganizationOf type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Get @type
	 * 
	 * @return @type
	 **/
	@ApiModelProperty(value = "")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SubOrganizationOf academicSession(String academicSession) {
		this.academicSession = academicSession;
		return this;
	}

	/**
	 * Get academicSession
	 * 
	 * @return academicSession
	 **/
	@ApiModelProperty(value = "")

	public String getAcademicSession() {
		return academicSession;
	}

	public void setAcademicSession(String academicSession) {
		this.academicSession = academicSession;
	}

	public SubOrganizationOf category(String category) {
		this.category = category;
		return this;
	}

	/**
	 * Get category
	 * 
	 * @return category
	 **/
	@ApiModelProperty(value = "")

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public SubOrganizationOf courseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
		return this;
	}

	/**
	 * Get courseNumber
	 * 
	 * @return courseNumber
	 **/
	@ApiModelProperty(value = "")

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public SubOrganizationOf dateCreated(OffsetDateTime dateCreated) {
		this.dateCreated = dateCreated;
		return this;
	}

	/**
	 * Get dateCreated
	 * 
	 * @return dateCreated
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public OffsetDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(OffsetDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public SubOrganizationOf dateModified(OffsetDateTime dateModified) {
		this.dateModified = dateModified;
		return this;
	}

	/**
	 * Get dateModified
	 * 
	 * @return dateModified
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public OffsetDateTime getDateModified() {
		return dateModified;
	}

	public void setDateModified(OffsetDateTime dateModified) {
		this.dateModified = dateModified;
	}

	public SubOrganizationOf description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SubOrganizationOf extensions(Map<String, String> extensions) {
		this.extensions = extensions;
		return this;
	}

	public SubOrganizationOf putExtensionsItem(String key, String extensionsItem) {
		if (this.extensions == null) {
			this.extensions = new HashMap<String, String>();
		}
		this.extensions.put(key, extensionsItem);
		return this;
	}

	/**
	 * Get extensions
	 * 
	 * @return extensions
	 **/
	@ApiModelProperty(value = "")

	public Map<String, String> getExtensions() {
		return extensions;
	}

	public void setExtensions(Map<String, String> extensions) {
		this.extensions = extensions;
	}

	public SubOrganizationOf name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SubOrganizationOf subOrganizationOf(SubOrganizationOf subOrganizationOf) {
		this.subOrganizationOf = subOrganizationOf;
		return this;
	}

	/**
	 * Get subOrganizationOf
	 * 
	 * @return subOrganizationOf
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public SubOrganizationOf getSubOrganizationOf() {
		return subOrganizationOf;
	}

	public void setSubOrganizationOf(SubOrganizationOf subOrganizationOf) {
		this.subOrganizationOf = subOrganizationOf;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SubOrganizationOf subOrganizationOf = (SubOrganizationOf) o;
		return Objects.equals(this.context, subOrganizationOf.context) && Objects.equals(this.id, subOrganizationOf.id)
				&& Objects.equals(this.type, subOrganizationOf.type)
				&& Objects.equals(this.academicSession, subOrganizationOf.academicSession)
				&& Objects.equals(this.category, subOrganizationOf.category)
				&& Objects.equals(this.courseNumber, subOrganizationOf.courseNumber)
				&& Objects.equals(this.dateCreated, subOrganizationOf.dateCreated)
				&& Objects.equals(this.dateModified, subOrganizationOf.dateModified)
				&& Objects.equals(this.description, subOrganizationOf.description)
				&& Objects.equals(this.extensions, subOrganizationOf.extensions)
				&& Objects.equals(this.name, subOrganizationOf.name)
				&& Objects.equals(this.subOrganizationOf, subOrganizationOf.subOrganizationOf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(context, id, type, academicSession, category, courseNumber, dateCreated, dateModified,
				description, extensions, name, subOrganizationOf);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SubOrganizationOf {\n");

		sb.append("    @context: ").append(toIndentedString(context)).append("\n");
		sb.append("    @id: ").append(toIndentedString(id)).append("\n");
		sb.append("    @type: ").append(toIndentedString(type)).append("\n");
		sb.append("    academicSession: ").append(toIndentedString(academicSession)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    courseNumber: ").append(toIndentedString(courseNumber)).append("\n");
		sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
		sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    subOrganizationOf: ").append(toIndentedString(subOrganizationOf)).append("\n");
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
