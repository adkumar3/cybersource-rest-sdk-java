package com.cybersource.payments.model;

import java.util.*;
import java.math.BigDecimal;






import io.swagger.annotations.*;

import com.cybersource.payments.model.BillTo;
import com.cybersource.payments.model.Item;
import com.cybersource.payments.model.MerchantDefinedData;
import com.cybersource.payments.model.MerchantDescriptor;
import com.cybersource.payments.model.Payment;
import com.cybersource.payments.model.SaleLinks;
import com.cybersource.payments.model.ShipTo;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class Sale   {
  
  private String id = null;
  public enum StatusEnum {
     PendingSettlement,  SettledSuccessfully, 
  };
  private StatusEnum status = null;
  private BigDecimal amount = null;
  private String currency = null;
  private String authCode = null;
  private String referenceId = null;
  private String ignoreAvs = null;
  private String ignoreBadCvn = null;
  private String commerceIndicator = null;
  private String vcOrderId = null;
  private String paymentSolution = null;
  private MerchantDefinedData merchantDefinedData = null;
  private MerchantDescriptor merchantDescriptor = null;
  private Payment payment = null;
  private BillTo billTo = null;
  private ShipTo shipTo = null;
  private List<Item> items = new ArrayList<Item>();
  private SaleLinks links = null;

  
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
   * Status of the transaction.
   **/
  @ApiModelProperty(value = "Status of the transaction.")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  
  /**
   * Amount for the transaction.
   **/
  @ApiModelProperty(value = "Amount for the transaction.")
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
   * Setting to ignore AVS.
   **/
  @ApiModelProperty(value = "Setting to ignore AVS.")
  @JsonProperty("ignoreAvs")
  public String getIgnoreAvs() {
    return ignoreAvs;
  }
  public void setIgnoreAvs(String ignoreAvs) {
    this.ignoreAvs = ignoreAvs;
  }

  
  /**
   * Setting to ignore bad CVN.
   **/
  @ApiModelProperty(value = "Setting to ignore bad CVN.")
  @JsonProperty("ignoreBadCvn")
  public String getIgnoreBadCvn() {
    return ignoreBadCvn;
  }
  public void setIgnoreBadCvn(String ignoreBadCvn) {
    this.ignoreBadCvn = ignoreBadCvn;
  }

  
  /**
   * Type of transaction. Some payment card companies use this information when determining discount rates.
   **/
  @ApiModelProperty(value = "Type of transaction. Some payment card companies use this information when determining discount rates.")
  @JsonProperty("commerceIndicator")
  public String getCommerceIndicator() {
    return commerceIndicator;
  }
  public void setCommerceIndicator(String commerceIndicator) {
    this.commerceIndicator = commerceIndicator;
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
  public SaleLinks getLinks() {
    return links;
  }
  public void setLinks(SaleLinks links) {
    this.links = links;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sale {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  currency: ").append(currency).append("\n");
    sb.append("  authCode: ").append(authCode).append("\n");
    sb.append("  referenceId: ").append(referenceId).append("\n");
    sb.append("  ignoreAvs: ").append(ignoreAvs).append("\n");
    sb.append("  ignoreBadCvn: ").append(ignoreBadCvn).append("\n");
    sb.append("  commerceIndicator: ").append(commerceIndicator).append("\n");
    sb.append("  vcOrderId: ").append(vcOrderId).append("\n");
    sb.append("  paymentSolution: ").append(paymentSolution).append("\n");
    sb.append("  merchantDefinedData: ").append(merchantDefinedData).append("\n");
    sb.append("  merchantDescriptor: ").append(merchantDescriptor).append("\n");
    sb.append("  payment: ").append(payment).append("\n");
    sb.append("  billTo: ").append(billTo).append("\n");
    sb.append("  shipTo: ").append(shipTo).append("\n");
    sb.append("  items: ").append(items).append("\n");
    sb.append("  links: ").append(links).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


