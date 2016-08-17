package com.visa.payments.model;

import com.visa.payments.model.SelfLink;
import java.math.BigDecimal;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class ReversedAuthorization   {
  
  private String id = null;
  public enum StatusEnum {
     AuthReversed, 
  };
  private StatusEnum status = null;
  private BigDecimal amount = null;
  private String currency = null;
  private String referenceId = null;
  private String requestDateTime = null;
  private String vcOrderId = null;
  private String paymentSolution = null;
  private SelfLink links = null;

  
  /**
   * Unique identifier for the transaction
   **/
  @ApiModelProperty(value = "Unique identifier for the transaction")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Status of reverted authorization
   **/
  @ApiModelProperty(value = "Status of reverted authorization")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  
  /**
   * Amount of the transaction
   **/
  @ApiModelProperty(value = "Amount of the transaction")
  @JsonProperty("amount")
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  
  /**
   * Currency used for the transaction
   **/
  @ApiModelProperty(value = "Currency used for the transaction")
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  
  /**
   * Merchant reference ID for the transaction
   **/
  @ApiModelProperty(value = "Merchant reference ID for the transaction")
  @JsonProperty("referenceId")
  public String getReferenceId() {
    return referenceId;
  }
  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  
  /**
   * Time in UTC when the transaction was reversed
   **/
  @ApiModelProperty(value = "Time in UTC when the transaction was reversed")
  @JsonProperty("requestDateTime")
  public String getRequestDateTime() {
    return requestDateTime;
  }
  public void setRequestDateTime(String requestDateTime) {
    this.requestDateTime = requestDateTime;
  }

  
  /**
   * Identifier for the Visa Checkout order. Obtain this value from the callIDfield from Visa Checkout
   **/
  @ApiModelProperty(value = "Identifier for the Visa Checkout order. Obtain this value from the callIDfield from Visa Checkout")
  @JsonProperty("vcOrderId")
  public String getVcOrderId() {
    return vcOrderId;
  }
  public void setVcOrderId(String vcOrderId) {
    this.vcOrderId = vcOrderId;
  }

  
  /**
   * Type of payment solution that is being used for the transaction
   **/
  @ApiModelProperty(value = "Type of payment solution that is being used for the transaction")
  @JsonProperty("paymentSolution")
  public String getPaymentSolution() {
    return paymentSolution;
  }
  public void setPaymentSolution(String paymentSolution) {
    this.paymentSolution = paymentSolution;
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
    sb.append("class ReversedAuthorization {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  currency: ").append(currency).append("\n");
    sb.append("  referenceId: ").append(referenceId).append("\n");
    sb.append("  requestDateTime: ").append(requestDateTime).append("\n");
    sb.append("  vcOrderId: ").append(vcOrderId).append("\n");
    sb.append("  paymentSolution: ").append(paymentSolution).append("\n");
    sb.append("  links: ").append(links).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


