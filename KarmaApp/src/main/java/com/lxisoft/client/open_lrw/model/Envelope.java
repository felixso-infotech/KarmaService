package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.lxisoft.client.open_lrw.model.Event;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Envelope
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class Envelope   {
  @JsonProperty("data")
  @Valid
  private List<Event> data = null;

  @JsonProperty("sendTime")
  private OffsetDateTime sendTime = null;

  @JsonProperty("sensor")
  private String sensor = null;

  public Envelope data(List<Event> data) {
    this.data = data;
    return this;
  }

  public Envelope addDataItem(Event dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<Event>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Event> getData() {
    return data;
  }

  public void setData(List<Event> data) {
    this.data = data;
  }

  public Envelope sendTime(OffsetDateTime sendTime) {
    this.sendTime = sendTime;
    return this;
  }

  /**
   * Get sendTime
   * @return sendTime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getSendTime() {
    return sendTime;
  }

  public void setSendTime(OffsetDateTime sendTime) {
    this.sendTime = sendTime;
  }

  public Envelope sensor(String sensor) {
    this.sensor = sensor;
    return this;
  }

  /**
   * Get sensor
   * @return sensor
  **/
  @ApiModelProperty(value = "")


  public String getSensor() {
    return sensor;
  }

  public void setSensor(String sensor) {
    this.sensor = sensor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Envelope envelope = (Envelope) o;
    return Objects.equals(this.data, envelope.data) &&
        Objects.equals(this.sendTime, envelope.sendTime) &&
        Objects.equals(this.sensor, envelope.sensor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, sendTime, sensor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Envelope {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    sendTime: ").append(toIndentedString(sendTime)).append("\n");
    sb.append("    sensor: ").append(toIndentedString(sensor)).append("\n");
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

