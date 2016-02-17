package com.visa.payments.model;

import com.visa.payments.model.Item;
import com.visa.payments.model.Payment;
import com.visa.payments.model.MerchantDescriptor;
import com.visa.payments.model.BillTo;
import com.visa.payments.model.ShipTo;
import java.util.*;
import java.math.BigDecimal;
import com.visa.payments.model.MerchantDefinedData;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class AuthCaptureRequest   {
  
  private BigDecimal amount = null;
  private String currency = null;
  private Payment payment = null;
  private BillTo billTo = null;
  private ShipTo shipTo = null;
  private String vcOrderId = null;
  private String commerceIndicator = null;
  private String ignoreAvs = null;
  private String ignoreBadCvn = null;
  private String referenceId = null;
  private String paymentSolution = null;
  private MerchantDefinedData merchantDefinedData = null;
  private List<Item> items = new ArrayList<Item>();
  private MerchantDescriptor merchantDescriptor = null;

  
  /**
   * Amount of the transaction
   **/
  @ApiModelProperty(required = true, value = "Amount of the transaction")
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
   **/
  @ApiModelProperty(required = true, value = "")
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
   * Setting to ignore Avs
   **/
  @ApiModelProperty(value = "Setting to ignore Avs")
  @JsonProperty("ignoreAvs")
  public String getIgnoreAvs() {
    return ignoreAvs;
  }
  public void setIgnoreAvs(String ignoreAvs) {
    this.ignoreAvs = ignoreAvs;
  }

  
  /**
   * Setting to ignore bad CVN
   **/
  @ApiModelProperty(value = "Setting to ignore bad CVN")
  @JsonProperty("ignoreBadCvn")
  public String getIgnoreBadCvn() {
    return ignoreBadCvn;
  }
  public void setIgnoreBadCvn(String ignoreBadCvn) {
    this.ignoreBadCvn = ignoreBadCvn;
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
  @JsonProperty("merchantDescriptor")
  public MerchantDescriptor getMerchantDescriptor() {
    return merchantDescriptor;
  }
  public void setMerchantDescriptor(MerchantDescriptor merchantDescriptor) {
    this.merchantDescriptor = merchantDescriptor;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthCaptureRequest {\n");
    
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  currency: ").append(currency).append("\n");
    sb.append("  payment: ").append(payment).append("\n");
    sb.append("  billTo: ").append(billTo).append("\n");
    sb.append("  shipTo: ").append(shipTo).append("\n");
    sb.append("  vcOrderId: ").append(vcOrderId).append("\n");
    sb.append("  commerceIndicator: ").append(commerceIndicator).append("\n");
    sb.append("  ignoreAvs: ").append(ignoreAvs).append("\n");
    sb.append("  ignoreBadCvn: ").append(ignoreBadCvn).append("\n");
    sb.append("  referenceId: ").append(referenceId).append("\n");
    sb.append("  paymentSolution: ").append(paymentSolution).append("\n");
    sb.append("  merchantDefinedData: ").append(merchantDefinedData).append("\n");
    sb.append("  items: ").append(items).append("\n");
    sb.append("  merchantDescriptor: ").append(merchantDescriptor).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
