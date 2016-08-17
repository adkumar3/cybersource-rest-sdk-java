package com.visa.payments.model;

import java.math.BigDecimal;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class ReverseAuthRequest   {
  
  private BigDecimal amount = null;
  private String currency = null;
  private String referenceId = null;
  private String vcOrderId = null;
  private String paymentSolution = null;

  
  /**
   * Amount of the transaction.
   **/
  @ApiModelProperty(required = true, value = "Amount of the transaction.")
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
  @ApiModelProperty(required = true, value = "Currency used for the transaction.")
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
   * Type of payment solution that is being used for Visa Checkout
   **/
  @ApiModelProperty(value = "Type of payment solution that is being used for Visa Checkout")
  @JsonProperty("paymentSolution")
  public String getPaymentSolution() {
    return paymentSolution;
  }
  public void setPaymentSolution(String paymentSolution) {
    this.paymentSolution = paymentSolution;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReverseAuthRequest {\n");
    
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  currency: ").append(currency).append("\n");
    sb.append("  referenceId: ").append(referenceId).append("\n");
    sb.append("  vcOrderId: ").append(vcOrderId).append("\n");
    sb.append("  paymentSolution: ").append(paymentSolution).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


