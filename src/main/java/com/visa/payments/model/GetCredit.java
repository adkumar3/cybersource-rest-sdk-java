package com.visa.payments.model;

import com.visa.payments.model.Payment;
import com.visa.payments.model.SelfLink;
import com.visa.payments.model.BillTo;
import com.visa.payments.model.ShipTo;
import java.math.BigDecimal;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetCredit   {
  
  private String id = null;
  public enum StatusEnum {
     PendingSettlement,  SettledSuccessfully, 
  };
  private StatusEnum status = null;
  private BigDecimal amount = null;
  private String currency = null;
  private String referenceId = null;
  private Payment payment = null;
  private BillTo billTo = null;
  private ShipTo shipTo = null;
  private SelfLink links = null;

  
  /**
   * Unique identifier for transaction
   **/
  @ApiModelProperty(value = "Unique identifier for transaction")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Status of the credit
   **/
  @ApiModelProperty(value = "Status of the credit")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  
  /**
   * Total amount of the transaction
   **/
  @ApiModelProperty(required = true, value = "Total amount of the transaction")
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
  @ApiModelProperty(required = true, value = "Currency used for the transaction")
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
  public SelfLink getLinks() {
    return links;
  }
  public void setLinks(SelfLink links) {
    this.links = links;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCredit {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  currency: ").append(currency).append("\n");
    sb.append("  referenceId: ").append(referenceId).append("\n");
    sb.append("  payment: ").append(payment).append("\n");
    sb.append("  billTo: ").append(billTo).append("\n");
    sb.append("  shipTo: ").append(shipTo).append("\n");
    sb.append("  links: ").append(links).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
