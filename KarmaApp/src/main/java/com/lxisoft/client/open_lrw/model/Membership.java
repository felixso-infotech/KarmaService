package com.lxisoft.client.open_lrw.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Membership
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class Membership {
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

	@JsonProperty("member")
	private String member = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("organization")
	private String organization = null;

	@JsonProperty("roles")
	@Valid
	private List<String> roles = null;

	@JsonProperty("status")
	private String status = null;

	public Membership context(String context) {
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

	public Membership id(String id)

	{
		this.id = id;
		return this;
	}

	/**
	 * Get @id
	 * 
	 * @return @id
	 **/
	@ApiModelProperty(value = "")

	public String getId()

	{
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Membership type(String type) {
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

	public Membership dateCreated(OffsetDateTime dateCreated) {
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

	public Membership dateModified(OffsetDateTime dateModified) {
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

	public Membership description(String description) {
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

	public Membership extensions(Map<String, String> extensions) {
		this.extensions = extensions;
		return this;
	}

	public Membership putExtensionsItem(String key, String extensionsItem) {
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

	public Membership member(String member) {
		this.member = member;
		return this;
	}

	/**
	 * Get member
	 * 
	 * @return member
	 **/
	@ApiModelProperty(value = "")

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public Membership name(String name) {
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

	public Membership organization(String organization) {
		this.organization = organization;
		return this;
	}

	/**
	 * Get organization
	 * 
	 * @return organization
	 **/
	@ApiModelProperty(value = "")

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Membership roles(List<String> roles) {
		this.roles = roles;
		return this;
	}

	public Membership addRolesItem(String rolesItem) {
		if (this.roles == null) {
			this.roles = new ArrayList<String>();
		}
		this.roles.add(rolesItem);
		return this;
	}

	/**
	 * Get roles
	 * 
	 * @return roles
	 **/
	@ApiModelProperty(value = "")

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Membership status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "")

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Membership membership = (Membership) o;
		return Objects.equals(this.context, membership.context) && Objects.equals(this.id, membership.id)
				&& Objects.equals(this.type, membership.type)
				&& Objects.equals(this.dateCreated, membership.dateCreated)
				&& Objects.equals(this.dateModified, membership.dateModified)
				&& Objects.equals(this.description, membership.description)
				&& Objects.equals(this.extensions, membership.extensions)
				&& Objects.equals(this.member, membership.member) && Objects.equals(this.name, membership.name)
				&& Objects.equals(this.organization, membership.organization)
				&& Objects.equals(this.roles, membership.roles) && Objects.equals(this.status, membership.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(context, id, type, dateCreated, dateModified, description, extensions, member, name,
				organization, roles, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Membership {\n");

		sb.append("    @context: ").append(toIndentedString(context)).append("\n");
		sb.append("    @id: ").append(toIndentedString(id)).append("\n");
		sb.append("    @type: ").append(toIndentedString(type)).append("\n");
		sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
		sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
		sb.append("    member: ").append(toIndentedString(member)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
		sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
