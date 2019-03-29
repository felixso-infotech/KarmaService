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
 * Agent
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class Agent {
	@JsonProperty("@context")
	private String context = null;

	@JsonProperty("@id")
	private String id = null;

	@JsonProperty("@type")
	private String type = null;

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

	public Agent context(String context) {
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

	public Agent id(String id) {
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

	public Agent type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Get @type
	 * 
	 * @return @type
	 **/
	@ApiModelProperty(value = "")

	public String getType()

	{
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Agent dateCreated(OffsetDateTime dateCreated) {
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

	public Agent dateModified(OffsetDateTime dateModified) {
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

	public Agent description(String description) {
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

	public Agent extensions(Map<String, String> extensions) {
		this.extensions = extensions;
		return this;
	}

	public Agent putExtensionsItem(String key, String extensionsItem) {
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

	public Agent name(String name) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Agent agent = (Agent) o;
		return Objects.equals(this.context, agent.context) && Objects.equals(this.id, agent.id)
				&& Objects.equals(this.type, agent.type) && Objects.equals(this.dateCreated, agent.dateCreated)
				&& Objects.equals(this.dateModified, agent.dateModified)
				&& Objects.equals(this.description, agent.description)
				&& Objects.equals(this.extensions, agent.extensions) && Objects.equals(this.name, agent.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(context, id, type, dateCreated, dateModified, description, extensions, name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Agent {\n");

		sb.append("    @context: ").append(toIndentedString(context)).append("\n");
		sb.append("    @id: ").append(toIndentedString(id)).append("\n");
		sb.append("    @type: ").append(toIndentedString(type)).append("\n");
		sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
		sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
