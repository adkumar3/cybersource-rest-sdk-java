package com.visa.payments.model;

import com.visa.payments.model.SelfLink;
import java.math.BigDecimal;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class ErrorResource   {
  
  private String correlationId = null;
  private String requestTimestamp = null;
  private BigDecimal status = null;
  private String resource = null;
  private String method = null;
  private String originalRequest = null;
  private String originalResponse = null;
  private SelfLink links = null;

  
  /**
   * Correlation ID.
   **/
  @ApiModelProperty(value = "Correlation ID.")
  @JsonProperty("correlationId")
  public String getCorrelationId() {
    return correlationId;
  }
  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  
  /**
   * Time in UTC when the request was logged.
   **/
  @ApiModelProperty(value = "Time in UTC when the request was logged.")
  @JsonProperty("requestTimestamp")
  public String getRequestTimestamp() {
    return requestTimestamp;
  }
  public void setRequestTimestamp(String requestTimestamp) {
    this.requestTimestamp = requestTimestamp;
  }

  
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
   * API resource.
   **/
  @ApiModelProperty(value = "API resource.")
  @JsonProperty("resource")
  public String getResource() {
    return resource;
  }
  public void setResource(String resource) {
    this.resource = resource;
  }

  
  /**
   * HTTP Method.
   **/
  @ApiModelProperty(value = "HTTP Method.")
  @JsonProperty("method")
  public String getMethod() {
    return method;
  }
  public void setMethod(String method) {
    this.method = method;
  }

  
  /**
   * Original request when the error occurred.
   **/
  @ApiModelProperty(value = "Original request when the error occurred.")
  @JsonProperty("originalRequest")
  public String getOriginalRequest() {
    return originalRequest;
  }
  public void setOriginalRequest(String originalRequest) {
    this.originalRequest = originalRequest;
  }

  
  /**
   * Original response when the error occurred.
   **/
  @ApiModelProperty(value = "Original response when the error occurred.")
  @JsonProperty("originalResponse")
  public String getOriginalResponse() {
    return originalResponse;
  }
  public void setOriginalResponse(String originalResponse) {
    this.originalResponse = originalResponse;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("_links")
  public SelfLink getLinks() {
    return links;
  }
  public void setLinks(SelfLink links) {
    this.links = links;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResource {\n");
    
    sb.append("  correlationId: ").append(correlationId).append("\n");
    sb.append("  requestTimestamp: ").append(requestTimestamp).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  resource: ").append(resource).append("\n");
    sb.append("  method: ").append(method).append("\n");
    sb.append("  originalRequest: ").append(originalRequest).append("\n");
    sb.append("  originalResponse: ").append(originalResponse).append("\n");
    sb.append("  links: ").append(links).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


