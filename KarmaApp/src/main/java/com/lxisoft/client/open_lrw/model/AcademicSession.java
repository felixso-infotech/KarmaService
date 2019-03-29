package com.lxisoft.client.open_lrw.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * AcademicSession
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class AcademicSession {
	/**
	 * Gets or Sets academicSessionType
	 */
	public enum AcademicSessionTypeEnum {
		TERM("term"),

		GRADINGPERIOD("gradingPeriod"),

		SCHOOLYEAR("schoolYear"),

		SEMESTER("semester");

		private String value;

		AcademicSessionTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static AcademicSessionTypeEnum fromValue(String text) {
			for (AcademicSessionTypeEnum b : AcademicSessionTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("academicSessionType")
	private AcademicSessionTypeEnum academicSessionType = null;

	@JsonProperty("dateLastModified")
	private OffsetDateTime dateLastModified = null;

	@JsonProperty("endDate")
	private LocalDate endDate = null;

	@JsonProperty("metadata")
	@Valid
	private Map<String, String> metadata = null;

	@JsonProperty("sourcedId")
	private String sourcedId = null;

	@JsonProperty("startDate")
	private LocalDate startDate = null;

	/**
	 * Gets or Sets status
	 */
	public enum StatusEnum {
		ACTIVE("active"),

		INACTIVE("inactive"),

		TOBEDELETED("tobedeleted");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("status")
	private StatusEnum status = null;

	@JsonProperty("title")
	private String title = null;

	public AcademicSession academicSessionType(AcademicSessionTypeEnum academicSessionType) {
		this.academicSessionType = academicSessionType;
		return this;
	}

	/**
	 * Get academicSessionType
	 * 
	 * @return academicSessionType
	 **/
	@ApiModelProperty(value = "")

	public AcademicSessionTypeEnum getAcademicSessionType() {
		return academicSessionType;
	}

	public void setAcademicSessionType(AcademicSessionTypeEnum academicSessionType) {
		this.academicSessionType = academicSessionType;
	}

	public AcademicSession dateLastModified(OffsetDateTime dateLastModified) {
		this.dateLastModified = dateLastModified;
		return this;
	}

	/**
	 * Get dateLastModified
	 * 
	 * @return dateLastModified
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public OffsetDateTime getDateLastModified() {
		return dateLastModified;
	}

	public void setDateLastModified(OffsetDateTime dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	public AcademicSession endDate(LocalDate endDate) {
		this.endDate = endDate;
		return this;
	}

	/**
	 * Get endDate
	 * 
	 * @return endDate
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public AcademicSession metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	public AcademicSession putMetadataItem(String key, String metadataItem) {
		if (this.metadata == null) {
			this.metadata = new HashMap<String, String>();
		}
		this.metadata.put(key, metadataItem);
		return this;
	}

	/**
	 * Get metadata
	 * 
	 * @return metadata
	 **/
	@ApiModelProperty(value = "")

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public AcademicSession sourcedId(String sourcedId) {
		this.sourcedId = sourcedId;
		return this;
	}

	/**
	 * Get sourcedId
	 * 
	 * @return sourcedId
	 **/
	@ApiModelProperty(value = "")

	public String getSourcedId() {
		return sourcedId;
	}

	public void setSourcedId(String sourcedId) {
		this.sourcedId = sourcedId;
	}

	public AcademicSession startDate(LocalDate startDate) {
		this.startDate = startDate;
		return this;
	}

	/**
	 * Get startDate
	 * 
	 * @return startDate
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public AcademicSession status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "")

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public AcademicSession title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * Get title
	 * 
	 * @return title
	 **/
	@ApiModelProperty(value = "")

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AcademicSession academicSession = (AcademicSession) o;
		return Objects.equals(this.academicSessionType, academicSession.academicSessionType)
				&& Objects.equals(this.dateLastModified, academicSession.dateLastModified)
				&& Objects.equals(this.endDate, academicSession.endDate)
				&& Objects.equals(this.metadata, academicSession.metadata)
				&& Objects.equals(this.sourcedId, academicSession.sourcedId)
				&& Objects.equals(this.startDate, academicSession.startDate)
				&& Objects.equals(this.status, academicSession.status)
				&& Objects.equals(this.title, academicSession.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(academicSessionType, dateLastModified, endDate, metadata, sourcedId, startDate, status,
				title);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AcademicSession {\n");

		sb.append("    academicSessionType: ").append(toIndentedString(academicSessionType)).append("\n");
		sb.append("    dateLastModified: ").append(toIndentedString(dateLastModified)).append("\n");
		sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    sourcedId: ").append(toIndentedString(sourcedId)).append("\n");
		sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
