package com.cybersource.payments.model;

import java.math.BigDecimal;





import io.swagger.annotations.*;

import com.cybersource.payments.model.SelfLink;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class GetRefund   {
  
  private String id = null;
  public enum StatusEnum {
     PendingSettlement,  SettledSuccessfully, 
  };
  private StatusEnum status = null;
  private BigDecimal amount = null;
  private String currency = null;
  private String referenceId = null;
  private String createDateTime = null;
  private String paymentSolution = null;
  private SelfLink links = null;

  
  /**
   * The unique identifier for the refund.
   **/
  @ApiModelProperty(value = "The unique identifier for the refund.")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Status of the refund.
   **/
  @ApiModelProperty(value = "Status of the refund.")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  
  /**
   * The amount of the refund.
   **/
  @ApiModelProperty(value = "The amount of the refund.")
  @JsonProperty("amount")
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  
  /**
   * The currency of the refund amount.
   **/
  @ApiModelProperty(value = "The currency of the refund amount.")
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  
  /**
   * Merchant reference ID for the transaction.
   **/
  @ApiModelProperty(value = "Merchant reference ID for the transaction.")
  @JsonProperty("referenceId")
  public String getReferenceId() {
    return referenceId;
  }
  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  
  /**
   * Time in UTC when the transaction was created.
   **/
  @ApiModelProperty(value = "Time in UTC when the transaction was created.")
  @JsonProperty("createDateTime")
  public String getCreateDateTime() {
    return createDateTime;
  }
  public void setCreateDateTime(String createDateTime) {
    this.createDateTime = createDateTime;
  }

  
  /**
   * Type of payment solution that is being used for the transaction.
   **/
  @ApiModelProperty(value = "Type of payment solution that is being used for the transaction.")
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
    sb.append("class GetRefund {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  currency: ").append(currency).append("\n");
    sb.append("  referenceId: ").append(referenceId).append("\n");
    sb.append("  createDateTime: ").append(createDateTime).append("\n");
    sb.append("  paymentSolution: ").append(paymentSolution).append("\n");
    sb.append("  links: ").append(links).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


