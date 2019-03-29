package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataSync
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class DataSync   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("orgId")
  private String orgId = null;

  @JsonProperty("syncDateTime")
  private OffsetDateTime syncDateTime = null;

  /**
   * Gets or Sets syncStatus
   */
  public enum SyncStatusEnum {
    FULLY_COMPLETED("fully_completed");

    private String value;

    SyncStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SyncStatusEnum fromValue(String text) {
      for (SyncStatusEnum b : SyncStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("syncStatus")
  private SyncStatusEnum syncStatus = null;

  @JsonProperty("syncType")
  private String syncType = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  public DataSync id(String id) {
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

  public DataSync orgId(String orgId) {
    this.orgId = orgId;
    return this;
  }

  /**
   * Get orgId
   * @return orgId
  **/
  @ApiModelProperty(value = "")


  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public DataSync syncDateTime(OffsetDateTime syncDateTime) {
    this.syncDateTime = syncDateTime;
    return this;
  }

  /**
   * Get syncDateTime
   * @return syncDateTime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getSyncDateTime() {
    return syncDateTime;
  }

  public void setSyncDateTime(OffsetDateTime syncDateTime) {
    this.syncDateTime = syncDateTime;
  }

  public DataSync syncStatus(SyncStatusEnum syncStatus) {
    this.syncStatus = syncStatus;
    return this;
  }

  /**
   * Get syncStatus
   * @return syncStatus
  **/
  @ApiModelProperty(value = "")


  public SyncStatusEnum getSyncStatus() {
    return syncStatus;
  }

  public void setSyncStatus(SyncStatusEnum syncStatus) {
    this.syncStatus = syncStatus;
  }

  public DataSync syncType(String syncType) {
    this.syncType = syncType;
    return this;
  }

  /**
   * Get syncType
   * @return syncType
  **/
  @ApiModelProperty(value = "")


  public String getSyncType() {
    return syncType;
  }

  public void setSyncType(String syncType) {
    this.syncType = syncType;
  }

  public DataSync tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * Get tenantId
   * @return tenantId
  **/
  @ApiModelProperty(value = "")


  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataSync dataSync = (DataSync) o;
    return Objects.equals(this.id, dataSync.id) &&
        Objects.equals(this.orgId, dataSync.orgId) &&
        Objects.equals(this.syncDateTime, dataSync.syncDateTime) &&
        Objects.equals(this.syncStatus, dataSync.syncStatus) &&
        Objects.equals(this.syncType, dataSync.syncType) &&
        Objects.equals(this.tenantId, dataSync.tenantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orgId, syncDateTime, syncStatus, syncType, tenantId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataSync {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    syncDateTime: ").append(toIndentedString(syncDateTime)).append("\n");
    sb.append("    syncStatus: ").append(toIndentedString(syncStatus)).append("\n");
    sb.append("    syncType: ").append(toIndentedString(syncType)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
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

