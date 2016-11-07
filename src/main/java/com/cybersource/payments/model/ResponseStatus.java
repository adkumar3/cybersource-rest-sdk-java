package com.cybersource.payments.model;

import java.util.*;
import java.math.BigDecimal;





import io.swagger.annotations.*;

import com.cybersource.payments.model.ResponseStatusDetails;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class ResponseStatus   {
  
  private BigDecimal status = null;
  private String reason = null;
  private String message = null;
  private String correlationId = null;
  private List<ResponseStatusDetails> details = new ArrayList<ResponseStatusDetails>();

  
  /**
   * HTTP Status code.
   **/
  @ApiModelProperty(value = "HTTP Status code.")
  @JsonProperty("status")
  public BigDecimal getStatus() {
    return status;
  }
  public void setStatus(BigDecimal status) {
    this.status = status;
  }

  
  /**
   * Error Reason Code.
   **/
  @ApiModelProperty(value = "Error Reason Code.")
  @JsonProperty("reason")
  public String getReason() {
    return reason;
  }
  public void setReason(String reason) {
    this.reason = reason;
  }

  
  /**
   * Error Message.
   **/
  @ApiModelProperty(value = "Error Message.")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  
  /**
   * API correlation ID.
   **/
  @ApiModelProperty(value = "API correlation ID.")
  @JsonProperty("correlationId")
  public String getCorrelationId() {
    return correlationId;
  }
  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("details")
  public List<ResponseStatusDetails> getDetails() {
    return details;
  }
  public void setDetails(List<ResponseStatusDetails> details) {
    this.details = details;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseStatus {\n");
    
    sb.append("  status: ").append(status).append("\n");
    sb.append("  reason: ").append(reason).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  correlationId: ").append(correlationId).append("\n");
    sb.append("  details: ").append(details).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


