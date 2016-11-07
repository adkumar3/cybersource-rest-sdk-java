package com.cybersource.payments.model;

import java.util.*;
import java.math.BigDecimal;






import io.swagger.annotations.*;

import com.cybersource.payments.model.Item;
import com.cybersource.payments.model.MerchantDefinedData;
import com.cybersource.payments.model.MerchantDescriptor;
import com.cybersource.payments.model.RefundLinks;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class Refund   {
  
  private String id = null;
  public enum StatusEnum {
     PendingSettlement,  SettledSuccessfully, 
  };
  private StatusEnum status = null;
  private BigDecimal amount = null;
  private String currency = null;
  private String referenceId = null;
  private String vcOrderId = null;
  private String paymentSolution = null;
  private MerchantDefinedData merchantDefinedData = null;
  private MerchantDescriptor merchantDescriptor = null;
  private List<Item> items = new ArrayList<Item>();
  private RefundLinks links = null;

  
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
   * Identifier for the Visa Checkout order. Obtain this value from the callID field from Visa Checkout.
   **/
  @ApiModelProperty(value = "Identifier for the Visa Checkout order. Obtain this value from the callID field from Visa Checkout.")
  @JsonProperty("vcOrderId")
  public String getVcOrderId() {
    return vcOrderId;
  }
  public void setVcOrderId(String vcOrderId) {
    this.vcOrderId = vcOrderId;
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
  @JsonProperty("merchantDefinedData")
  public MerchantDefinedData getMerchantDefinedData() {
    return merchantDefinedData;
  }
  public void setMerchantDefinedData(MerchantDefinedData merchantDefinedData) {
    this.merchantDefinedData = merchantDefinedData;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("merchantDescriptor")
  public MerchantDescriptor getMerchantDescriptor() {
    return merchantDescriptor;
  }
  public void setMerchantDescriptor(MerchantDescriptor merchantDescriptor) {
    this.merchantDescriptor = merchantDescriptor;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("items")
  public List<Item> getItems() {
    return items;
  }
  public void setItems(List<Item> items) {
    this.items = items;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("_links")
  public RefundLinks getLinks() {
    return links;
  }
  public void setLinks(RefundLinks links) {
    this.links = links;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Refund {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  currency: ").append(currency).append("\n");
    sb.append("  referenceId: ").append(referenceId).append("\n");
    sb.append("  vcOrderId: ").append(vcOrderId).append("\n");
    sb.append("  paymentSolution: ").append(paymentSolution).append("\n");
    sb.append("  merchantDefinedData: ").append(merchantDefinedData).append("\n");
    sb.append("  merchantDescriptor: ").append(merchantDescriptor).append("\n");
    sb.append("  items: ").append(items).append("\n");
    sb.append("  links: ").append(links).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


