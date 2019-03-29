package com.lxisoft.client.open_lrw.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.lxisoft.client.open_lrw.model.Statement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StatementResult
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T12:01:52.955+05:30[Asia/Calcutta]")

public class StatementResult   {
  @JsonProperty("statements")
  @Valid
  private List<Statement> statements = null;

  public StatementResult statements(List<Statement> statements) {
    this.statements = statements;
    return this;
  }

  public StatementResult addStatementsItem(Statement statementsItem) {
    if (this.statements == null) {
      this.statements = new ArrayList<Statement>();
    }
    this.statements.add(statementsItem);
    return this;
  }

  /**
   * Get statements
   * @return statements
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Statement> getStatements() {
    return statements;
  }

  public void setStatements(List<Statement> statements) {
    this.statements = statements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatementResult statementResult = (StatementResult) o;
    return Objects.equals(this.statements, statementResult.statements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatementResult {\n");
    
    sb.append("    statements: ").append(toIndentedString(statements)).append("\n");
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

