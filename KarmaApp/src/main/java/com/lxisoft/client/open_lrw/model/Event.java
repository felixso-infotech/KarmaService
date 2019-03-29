package com.lxisoft.client.open_lrw.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Event
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class Event {
	@JsonProperty("@context")
	private String context = null;

	@JsonProperty("@type")
	private String type = null;

	@JsonProperty("action")
	private String action = null;

	@JsonProperty("actor")
	private Agent actor = null;

	@JsonProperty("edApp")
	private Agent edApp = null;

	@JsonProperty("eventTime")
	private OffsetDateTime eventTime = null;

	@JsonProperty("federatedSession")
	private String federatedSession = null;

	@JsonProperty("generated")
	private Entity generated = null;

	@JsonProperty("group")
	private Group group = null;

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("membership")
	private Membership membership = null;

	@JsonProperty("object")
	private Entity object = null;

	@JsonProperty("target")
	private Entity target = null;

	@JsonProperty("timeZoneOffset")
	private Long timeZoneOffset = null;

	public Event context(String context) {
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

	public Event type(String type) {
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

	public Event action(String action) {
		this.action = action;
		return this;
	}

	/**
	 * Get action
	 * 
	 * @return action
	 **/
	@ApiModelProperty(value = "")

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Event actor(Agent actor) {
		this.actor = actor;
		return this;
	}

	/**
	 * Get actor
	 * 
	 * @return actor
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Agent getActor() {
		return actor;
	}

	public void setActor(Agent actor) {
		this.actor = actor;
	}

	public Event edApp(Agent edApp) {
		this.edApp = edApp;
		return this;
	}

	/**
	 * Get edApp
	 * 
	 * @return edApp
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Agent getEdApp() {
		return edApp;
	}

	public void setEdApp(Agent edApp) {
		this.edApp = edApp;
	}

	public Event eventTime(OffsetDateTime eventTime) {
		this.eventTime = eventTime;
		return this;
	}

	/**
	 * Get eventTime
	 * 
	 * @return eventTime
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public OffsetDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(OffsetDateTime eventTime) {
		this.eventTime = eventTime;
	}

	public Event federatedSession(String federatedSession) {
		this.federatedSession = federatedSession;
		return this;
	}

	/**
	 * Get federatedSession
	 * 
	 * @return federatedSession
	 **/
	@ApiModelProperty(value = "")

	public String getFederatedSession() {
		return federatedSession;
	}

	public void setFederatedSession(String federatedSession) {
		this.federatedSession = federatedSession;
	}

	public Event generated(Entity generated) {
		this.generated = generated;
		return this;
	}

	/**
	 * Get generated
	 * 
	 * @return generated
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Entity getGenerated() {
		return generated;
	}

	public void setGenerated(Entity generated) {
		this.generated = generated;
	}

	public Event group(Group group) {
		this.group = group;
		return this;
	}

	/**
	 * Get group
	 * 
	 * @return group
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Event id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Event membership(Membership membership) {
		this.membership = membership;
		return this;
	}

	/**
	 * Get membership
	 * 
	 * @return membership
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public Event object(Entity object) {
		this.object = object;
		return this;
	}

	/**
	 * Get object
	 * 
	 * @return object
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Entity getObject() {
		return object;
	}

	public void setObject(Entity object) {
		this.object = object;
	}

	public Event target(Entity target) {
		this.target = target;
		return this;
	}

	/**
	 * Get target
	 * 
	 * @return target
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Entity getTarget() {
		return target;
	}

	public void setTarget(Entity target) {
		this.target = target;
	}

	public Event timeZoneOffset(Long timeZoneOffset) {
		this.timeZoneOffset = timeZoneOffset;
		return this;
	}

	/**
	 * Get timeZoneOffset
	 * 
	 * @return timeZoneOffset
	 **/
	@ApiModelProperty(value = "")

	public Long getTimeZoneOffset() {
		return timeZoneOffset;
	}

	public void setTimeZoneOffset(Long timeZoneOffset) {
		this.timeZoneOffset = timeZoneOffset;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Event event = (Event) o;
		return Objects.equals(this.context, event.context) && Objects.equals(this.type, event.type)
				&& Objects.equals(this.action, event.action) && Objects.equals(this.actor, event.actor)
				&& Objects.equals(this.edApp, event.edApp) && Objects.equals(this.eventTime, event.eventTime)
				&& Objects.equals(this.federatedSession, event.federatedSession)
				&& Objects.equals(this.generated, event.generated) && Objects.equals(this.group, event.group)
				&& Objects.equals(this.id, event.id) && Objects.equals(this.membership, event.membership)
				&& Objects.equals(this.object, event.object) && Objects.equals(this.target, event.target)
				&& Objects.equals(this.timeZoneOffset, event.timeZoneOffset);
	}

	@Override
	public int hashCode() {
		return Objects.hash(context, type, action, actor, edApp, eventTime, federatedSession, generated, group, id,
				membership, object, target, timeZoneOffset);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Event {\n");

		sb.append("    @context: ").append(toIndentedString(context)).append("\n");
		sb.append("    @type: ").append(toIndentedString(type)).append("\n");
		sb.append("    action: ").append(toIndentedString(action)).append("\n");
		sb.append("    actor: ").append(toIndentedString(actor)).append("\n");
		sb.append("    edApp: ").append(toIndentedString(edApp)).append("\n");
		sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
		sb.append("    federatedSession: ").append(toIndentedString(federatedSession)).append("\n");
		sb.append("    generated: ").append(toIndentedString(generated)).append("\n");
		sb.append("    group: ").append(toIndentedString(group)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    membership: ").append(toIndentedString(membership)).append("\n");
		sb.append("    object: ").append(toIndentedString(object)).append("\n");
		sb.append("    target: ").append(toIndentedString(target)).append("\n");
		sb.append("    timeZoneOffset: ").append(toIndentedString(timeZoneOffset)).append("\n");
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
