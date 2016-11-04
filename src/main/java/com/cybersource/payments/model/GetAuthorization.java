package com.cybersource.payments.model;

import java.math.BigDecimal;





import io.swagger.annotations.*;

import com.cybersource.payments.model.BillTo;
import com.cybersource.payments.model.GetAuthorizationLinks;
import com.cybersource.payments.model.Payment;
import com.cybersource.payments.model.ShipTo;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class GetAuthorization   {
  
  private String id = null;
  public enum StatusEnum {
     PendingCapture, 
  };
  private StatusEnum status = null;
  private BigDecimal amount = null;
  private String currency = null;
  private String authCode = null;
  private String referenceId = null;
  private String createDateTime = null;
  private String paymentSolution = null;
  private Payment payment = null;
  private BillTo billTo = null;
  private ShipTo shipTo = null;
  private GetAuthorizationLinks links = null;

  
  /**
   * Unique identifier for the transaction.
   **/
  @ApiModelProperty(value = "Unique identifier for the transaction.")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Status of authorization.
   **/
  @ApiModelProperty(value = "Status of authorization.")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  
  /**
   * Amount of the transaction.
   **/
  @ApiModelProperty(value = "Amount of the transaction.")
  @JsonProperty("amount")
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  
  /**
   * Currency used for the transaction.
   **/
  @ApiModelProperty(value = "Currency used for the transaction.")
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  
  /**
   * Authorization code for the transaction.
   **/
  @ApiModelProperty(value = "Authorization code for the transaction.")
  @JsonProperty("authCode")
  public String getAuthCode() {
    return authCode;
  }
  public void setAuthCode(String authCode) {
    this.authCode = authCode;
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
  @JsonProperty("payment")
  public Payment getPayment() {
    return payment;
  }
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("billTo")
  public BillTo getBillTo() {
    return billTo;
  }
  public void setBillTo(BillTo billTo) {
    this.billTo = billTo;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("shipTo")
  public ShipTo getShipTo() {
    return shipTo;
  }
  public void setShipTo(ShipTo shipTo) {
    this.shipTo = shipTo;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("_links")
  public GetAuthorizationLinks getLinks() {
    return links;
  }
  public void setLinks(GetAuthorizationLinks links) {
    this.links = links;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAuthorization {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  currency: ").append(currency).append("\n");
    sb.append("  authCode: ").append(authCode).append("\n");
    sb.append("  referenceId: ").append(referenceId).append("\n");
    sb.append("  createDateTime: ").append(createDateTime).append("\n");
    sb.append("  paymentSolution: ").append(paymentSolution).append("\n");
    sb.append("  payment: ").append(payment).append("\n");
    sb.append("  billTo: ").append(billTo).append("\n");
    sb.append("  shipTo: ").append(shipTo).append("\n");
    sb.append("  links: ").append(links).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


