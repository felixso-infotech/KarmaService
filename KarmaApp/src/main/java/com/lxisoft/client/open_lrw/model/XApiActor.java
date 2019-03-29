package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lxisoft.client.open_lrw.model.XApiAccount;
import com.lxisoft.client.open_lrw.model.XApiActor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * XApiActor
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class XApiActor   {
  @JsonProperty("account")
  private XApiAccount account = null;

  @JsonProperty("mbox")
  private String mbox = null;

  @JsonProperty("mbox_sha1sum")
  private String mboxSha1sum = null;

  @JsonProperty("member")
  @Valid
  private List<XApiActor> member = null;

  @JsonProperty("name")
  private String name = null;

  /**
   * Gets or Sets objectType
   */
  public enum ObjectTypeEnum {
    AGENT("Agent"),
    
    GROUP("Group");

    private String value;

    ObjectTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ObjectTypeEnum fromValue(String text) {
      for (ObjectTypeEnum b : ObjectTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("objectType")
  private ObjectTypeEnum objectType = null;

  @JsonProperty("openid")
  private String openid = null;

  public XApiActor account(XApiAccount account) {
    this.account = account;
    return this;
  }

  /**
   * Get account
   * @return account
  **/
  @ApiModelProperty(value = "")

  @Valid

  public XApiAccount getAccount() {
    return account;
  }

  public void setAccount(XApiAccount account) {
    this.account = account;
  }

  public XApiActor mbox(String mbox) {
    this.mbox = mbox;
    return this;
  }

  /**
   * Get mbox
   * @return mbox
  **/
  @ApiModelProperty(value = "")


  public String getMbox() {
    return mbox;
  }

  public void setMbox(String mbox) {
    this.mbox = mbox;
  }

  public XApiActor mboxSha1sum(String mboxSha1sum) {
    this.mboxSha1sum = mboxSha1sum;
    return this;
  }

  /**
   * Get mboxSha1sum
   * @return mboxSha1sum
  **/
  @ApiModelProperty(value = "")


  public String getMboxSha1sum() {
    return mboxSha1sum;
  }

  public void setMboxSha1sum(String mboxSha1sum) {
    this.mboxSha1sum = mboxSha1sum;
  }

  public XApiActor member(List<XApiActor> member) {
    this.member = member;
    return this;
  }

  public XApiActor addMemberItem(XApiActor memberItem) {
    if (this.member == null) {
      this.member = new ArrayList<XApiActor>();
    }
    this.member.add(memberItem);
    return this;
  }

  /**
   * Get member
   * @return member
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<XApiActor> getMember() {
    return member;
  }

  public void setMember(List<XApiActor> member) {
    this.member = member;
  }

  public XApiActor name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public XApiActor objectType(ObjectTypeEnum objectType) {
    this.objectType = objectType;
    return this;
  }

  /**
   * Get objectType
   * @return objectType
  **/
  @ApiModelProperty(value = "")


  public ObjectTypeEnum getObjectType() {
    return objectType;
  }

  public void setObjectType(ObjectTypeEnum objectType) {
    this.objectType = objectType;
  }

  public XApiActor openid(String openid) {
    this.openid = openid;
    return this;
  }

  /**
   * Get openid
   * @return openid
  **/
  @ApiModelProperty(value = "")


  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XApiActor xapiActor = (XApiActor) o;
    return Objects.equals(this.account, xapiActor.account) &&
        Objects.equals(this.mbox, xapiActor.mbox) &&
        Objects.equals(this.mboxSha1sum, xapiActor.mboxSha1sum) &&
        Objects.equals(this.member, xapiActor.member) &&
        Objects.equals(this.name, xapiActor.name) &&
        Objects.equals(this.objectType, xapiActor.objectType) &&
        Objects.equals(this.openid, xapiActor.openid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, mbox, mboxSha1sum, member, name, objectType, openid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XApiActor {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    mbox: ").append(toIndentedString(mbox)).append("\n");
    sb.append("    mboxSha1sum: ").append(toIndentedString(mboxSha1sum)).append("\n");
    sb.append("    member: ").append(toIndentedString(member)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
    sb.append("    openid: ").append(toIndentedString(openid)).append("\n");
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

