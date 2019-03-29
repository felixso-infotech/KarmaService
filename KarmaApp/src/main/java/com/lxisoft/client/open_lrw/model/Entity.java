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
 * Entity
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class Entity {
	@JsonProperty("@context")
	private String context = null;

	@JsonProperty("@id")
	private String id = null;

	@JsonProperty("@type")
	private String type = null;

	@JsonProperty("actor")
	private String actor = null;

	@JsonProperty("alignedLearningObjective")
	@Valid
	private List<LearningObject> alignedLearningObjective = null;

	@JsonProperty("assignable")
	private String assignable = null;

	@JsonProperty("comment")
	private String comment = null;

	@JsonProperty("currentTime")
	private String currentTime = null;

	@JsonProperty("curveFactor")
	private String curveFactor = null;

	@JsonProperty("curvedTotalScore")
	private Double curvedTotalScore = null;

	@JsonProperty("dateCreated")
	private OffsetDateTime dateCreated = null;

	@JsonProperty("dateModified")
	private OffsetDateTime dateModified = null;

	@JsonProperty("datePublished")
	private OffsetDateTime datePublished = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("duration")
	private String duration = null;

	@JsonProperty("extensions")
	@Valid
	private Map<String, String> extensions = null;

	@JsonProperty("extraCreditScore")
	private Double extraCreditScore = null;

	@JsonProperty("isPartOf")
	private Entity isPartOf = null;

	@JsonProperty("keywords")
	@Valid
	private List<String> keywords = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("normalScore")
	private Double normalScore = null;

	@JsonProperty("objectType")
	@Valid
	private List<String> objectType = null;

	@JsonProperty("penaltyScore")
	private Double penaltyScore = null;

	@JsonProperty("scoredBy")
	private Agent scoredBy = null;

	@JsonProperty("totalScore")
	private Double totalScore = null;

	@JsonProperty("version")
	private String version = null;

	public Entity context(String context) {
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

	public Entity id(String id) {
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

	public Entity type(String type) {
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

	public Entity actor(String actor) {
		this.actor = actor;
		return this;
	}

	/**
	 * Get actor
	 * 
	 * @return actor
	 **/
	@ApiModelProperty(value = "")

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Entity alignedLearningObjective(List<LearningObject> alignedLearningObjective) {
		this.alignedLearningObjective = alignedLearningObjective;
		return this;
	}

	public Entity addAlignedLearningObjectiveItem(LearningObject alignedLearningObjectiveItem) {
		if (this.alignedLearningObjective == null) {
			this.alignedLearningObjective = new ArrayList<LearningObject>();
		}
		this.alignedLearningObjective.add(alignedLearningObjectiveItem);
		return this;
	}

	/**
	 * Get alignedLearningObjective
	 * 
	 * @return alignedLearningObjective
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<LearningObject> getAlignedLearningObjective() {
		return alignedLearningObjective;
	}

	public void setAlignedLearningObjective(List<LearningObject> alignedLearningObjective) {
		this.alignedLearningObjective = alignedLearningObjective;
	}

	public Entity assignable(String assignable) {
		this.assignable = assignable;
		return this;
	}

	/**
	 * Get assignable
	 * 
	 * @return assignable
	 **/
	@ApiModelProperty(value = "")

	public String getAssignable() {
		return assignable;
	}

	public void setAssignable(String assignable) {
		this.assignable = assignable;
	}

	public Entity comment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Get comment
	 * 
	 * @return comment
	 **/
	@ApiModelProperty(value = "")

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Entity currentTime(String currentTime) {
		this.currentTime = currentTime;
		return this;
	}

	/**
	 * Get currentTime
	 * 
	 * @return currentTime
	 **/
	@ApiModelProperty(value = "")

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public Entity curveFactor(String curveFactor) {
		this.curveFactor = curveFactor;
		return this;
	}

	/**
	 * Get curveFactor
	 * 
	 * @return curveFactor
	 **/
	@ApiModelProperty(value = "")

	public String getCurveFactor() {
		return curveFactor;
	}

	public void setCurveFactor(String curveFactor) {
		this.curveFactor = curveFactor;
	}

	public Entity curvedTotalScore(Double curvedTotalScore) {
		this.curvedTotalScore = curvedTotalScore;
		return this;
	}

	/**
	 * Get curvedTotalScore
	 * 
	 * @return curvedTotalScore
	 **/
	@ApiModelProperty(value = "")

	public Double getCurvedTotalScore() {
		return curvedTotalScore;
	}

	public void setCurvedTotalScore(Double curvedTotalScore) {
		this.curvedTotalScore = curvedTotalScore;
	}

	public Entity dateCreated(OffsetDateTime dateCreated) {
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

	public Entity dateModified(OffsetDateTime dateModified) {
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

	public Entity datePublished(OffsetDateTime datePublished) {
		this.datePublished = datePublished;
		return this;
	}

	/**
	 * Get datePublished
	 * 
	 * @return datePublished
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public OffsetDateTime getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(OffsetDateTime datePublished) {
		this.datePublished = datePublished;
	}

	public Entity description(String description) {
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

	public Entity duration(String duration) {
		this.duration = duration;
		return this;
	}

	/**
	 * Get duration
	 * 
	 * @return duration
	 **/
	@ApiModelProperty(value = "")

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Entity extensions(Map<String, String> extensions) {
		this.extensions = extensions;
		return this;
	}

	public Entity putExtensionsItem(String key, String extensionsItem) {
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

	public Entity extraCreditScore(Double extraCreditScore) {
		this.extraCreditScore = extraCreditScore;
		return this;
	}

	/**
	 * Get extraCreditScore
	 * 
	 * @return extraCreditScore
	 **/
	@ApiModelProperty(value = "")

	public Double getExtraCreditScore() {
		return extraCreditScore;
	}

	public void setExtraCreditScore(Double extraCreditScore) {
		this.extraCreditScore = extraCreditScore;
	}

	public Entity isPartOf(Entity isPartOf) {
		this.isPartOf = isPartOf;
		return this;
	}

	/**
	 * Get isPartOf
	 * 
	 * @return isPartOf
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Entity getIsPartOf() {
		return isPartOf;
	}

	public void setIsPartOf(Entity isPartOf) {
		this.isPartOf = isPartOf;
	}

	public Entity keywords(List<String> keywords) {
		this.keywords = keywords;
		return this;
	}

	public Entity addKeywordsItem(String keywordsItem) {
		if (this.keywords == null) {
			this.keywords = new ArrayList<String>();
		}
		this.keywords.add(keywordsItem);
		return this;
	}

	/**
	 * Get keywords
	 * 
	 * @return keywords
	 **/
	@ApiModelProperty(value = "")

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public Entity name(String name) {
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

	public Entity normalScore(Double normalScore) {
		this.normalScore = normalScore;
		return this;
	}

	/**
	 * Get normalScore
	 * 
	 * @return normalScore
	 **/
	@ApiModelProperty(value = "")

	public Double getNormalScore() {
		return normalScore;
	}

	public void setNormalScore(Double normalScore) {
		this.normalScore = normalScore;
	}

	public Entity objectType(List<String> objectType) {
		this.objectType = objectType;
		return this;
	}

	public Entity addObjectTypeItem(String objectTypeItem) {
		if (this.objectType == null) {
			this.objectType = new ArrayList<String>();
		}
		this.objectType.add(objectTypeItem);
		return this;
	}

	/**
	 * Get objectType
	 * 
	 * @return objectType
	 **/
	@ApiModelProperty(value = "")

	public List<String> getObjectType() {
		return objectType;
	}

	public void setObjectType(List<String> objectType) {
		this.objectType = objectType;
	}

	public Entity penaltyScore(Double penaltyScore) {
		this.penaltyScore = penaltyScore;
		return this;
	}

	/**
	 * Get penaltyScore
	 * 
	 * @return penaltyScore
	 **/
	@ApiModelProperty(value = "")

	public Double getPenaltyScore() {
		return penaltyScore;
	}

	public void setPenaltyScore(Double penaltyScore) {
		this.penaltyScore = penaltyScore;
	}

	public Entity scoredBy(Agent scoredBy) {
		this.scoredBy = scoredBy;
		return this;
	}

	/**
	 * Get scoredBy
	 * 
	 * @return scoredBy
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Agent getScoredBy() {
		return scoredBy;
	}

	public void setScoredBy(Agent scoredBy) {
		this.scoredBy = scoredBy;
	}

	public Entity totalScore(Double totalScore) {
		this.totalScore = totalScore;
		return this;
	}

	/**
	 * Get totalScore
	 * 
	 * @return totalScore
	 **/
	@ApiModelProperty(value = "")

	public Double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}

	public Entity version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Get version
	 * 
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
		Entity entity = (Entity) o;
		return Objects.equals(this.context, entity.context) && Objects.equals(this.id, entity.id)
				&& Objects.equals(this.type, entity.type) && Objects.equals(this.actor, entity.actor)
				&& Objects.equals(this.alignedLearningObjective, entity.alignedLearningObjective)
				&& Objects.equals(this.assignable, entity.assignable) && Objects.equals(this.comment, entity.comment)
				&& Objects.equals(this.currentTime, entity.currentTime)
				&& Objects.equals(this.curveFactor, entity.curveFactor)
				&& Objects.equals(this.curvedTotalScore, entity.curvedTotalScore)
				&& Objects.equals(this.dateCreated, entity.dateCreated)
				&& Objects.equals(this.dateModified, entity.dateModified)
				&& Objects.equals(this.datePublished, entity.datePublished)
				&& Objects.equals(this.description, entity.description)
				&& Objects.equals(this.duration, entity.duration) && Objects.equals(this.extensions, entity.extensions)
				&& Objects.equals(this.extraCreditScore, entity.extraCreditScore)
				&& Objects.equals(this.isPartOf, entity.isPartOf) && Objects.equals(this.keywords, entity.keywords)
				&& Objects.equals(this.name, entity.name) && Objects.equals(this.normalScore, entity.normalScore)
				&& Objects.equals(this.objectType, entity.objectType)
				&& Objects.equals(this.penaltyScore, entity.penaltyScore)
				&& Objects.equals(this.scoredBy, entity.scoredBy) && Objects.equals(this.totalScore, entity.totalScore)
				&& Objects.equals(this.version, entity.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(context, id, type, actor, alignedLearningObjective, assignable, comment, currentTime,
				curveFactor, curvedTotalScore, dateCreated, dateModified, datePublished, description, duration,
				extensions, extraCreditScore, isPartOf, keywords, name, normalScore, objectType, penaltyScore, scoredBy,
				totalScore, version);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Entity {\n");

		sb.append("    @context: ").append(toIndentedString(context)).append("\n");
		sb.append("    @id: ").append(toIndentedString(id)).append("\n");
		sb.append("    @type: ").append(toIndentedString(type)).append("\n");
		sb.append("    actor: ").append(toIndentedString(actor)).append("\n");
		sb.append("    alignedLearningObjective: ").append(toIndentedString(alignedLearningObjective)).append("\n");
		sb.append("    assignable: ").append(toIndentedString(assignable)).append("\n");
		sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
		sb.append("    currentTime: ").append(toIndentedString(currentTime)).append("\n");
		sb.append("    curveFactor: ").append(toIndentedString(curveFactor)).append("\n");
		sb.append("    curvedTotalScore: ").append(toIndentedString(curvedTotalScore)).append("\n");
		sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
		sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
		sb.append("    datePublished: ").append(toIndentedString(datePublished)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
		sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
		sb.append("    extraCreditScore: ").append(toIndentedString(extraCreditScore)).append("\n");
		sb.append("    isPartOf: ").append(toIndentedString(isPartOf)).append("\n");
		sb.append("    keywords: ").append(toIndentedString(keywords)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    normalScore: ").append(toIndentedString(normalScore)).append("\n");
		sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
		sb.append("    penaltyScore: ").append(toIndentedString(penaltyScore)).append("\n");
		sb.append("    scoredBy: ").append(toIndentedString(scoredBy)).append("\n");
		sb.append("    totalScore: ").append(toIndentedString(totalScore)).append("\n");
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
