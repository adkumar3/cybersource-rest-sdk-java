package com.cybersource.payments.model;





import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class Terminal   {
  
  private String capability = null;
  private String compliance = null;
  private String terminalId = null;
  private String terminalIdAlternate = null;
  private String transactionLocalDateTime = null;

  
  /**
   * 
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("capability")
  public String getCapability() {
    return capability;
  }
  public void setCapability(String capability) {
    this.capability = capability;
  }

  
  /**
   * 
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("compliance")
  public String getCompliance() {
    return compliance;
  }
  public void setCompliance(String compliance) {
    this.compliance = compliance;
  }

  
  /**
   * 
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("terminalId")
  public String getTerminalId() {
    return terminalId;
  }
  public void setTerminalId(String terminalId) {
    this.terminalId = terminalId;
  }

  
  /**
   * 
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("terminalIdAlternate")
  public String getTerminalIdAlternate() {
    return terminalIdAlternate;
  }
  public void setTerminalIdAlternate(String terminalIdAlternate) {
    this.terminalIdAlternate = terminalIdAlternate;
  }

  
  /**
   * 
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("transactionLocalDateTime")
  public String getTransactionLocalDateTime() {
    return transactionLocalDateTime;
  }
  public void setTransactionLocalDateTime(String transactionLocalDateTime) {
    this.transactionLocalDateTime = transactionLocalDateTime;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Terminal {\n");
    
    sb.append("  capability: ").append(capability).append("\n");
    sb.append("  compliance: ").append(compliance).append("\n");
    sb.append("  terminalId: ").append(terminalId).append("\n");
    sb.append("  terminalIdAlternate: ").append(terminalIdAlternate).append("\n");
    sb.append("  transactionLocalDateTime: ").append(transactionLocalDateTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


