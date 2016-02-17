package com.visa.payments.model;

import com.visa.payments.model.SelfLink;
import java.math.BigDecimal;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SearchResult   {
  
  private String id = null;
  private String accountSuffix = null;
  private String firstName = null;
  private String lastName = null;
  private BigDecimal amount = null;
  private String currency = null;
  private String status = null;
  private String referenceId = null;
  private String requestDateTime = null;
  private String merchantTimezone = null;
  private String cardType = null;
  private SelfLink links = null;

  
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
   * Last four digits of the card number.
   **/
  @ApiModelProperty(value = "Last four digits of the card number.")
  @JsonProperty("accountSuffix")
  public String getAccountSuffix() {
    return accountSuffix;
  }
  public void setAccountSuffix(String accountSuffix) {
    this.accountSuffix = accountSuffix;
  }

  
  /**
   * First name of the cardholder.
   **/
  @ApiModelProperty(value = "First name of the cardholder.")
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  
  /**
   * Last name of the cardholder.
   **/
  @ApiModelProperty(value = "Last name of the cardholder.")
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  
  /**
   * Total amount of the transaction.
   **/
  @ApiModelProperty(value = "Total amount of the transaction.")
  @JsonProperty("amount")
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  
  /**
   * The currency used for the transaction.
   **/
  @ApiModelProperty(value = "The currency used for the transaction.")
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  
  /**
   * Status of the transaction. E.g. PendingSettlement
   **/
  @ApiModelProperty(value = "Status of the transaction. E.g. PendingSettlement")
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
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
   * Time in UTC when the transaction was created.
   **/
  @ApiModelProperty(value = "Time in UTC when the transaction was created.")
  @JsonProperty("requestDateTime")
  public String getRequestDateTime() {
    return requestDateTime;
  }
  public void setRequestDateTime(String requestDateTime) {
    this.requestDateTime = requestDateTime;
  }

  
  /**
   * Configured timezone for the merchant.
   **/
  @ApiModelProperty(value = "Configured timezone for the merchant.")
  @JsonProperty("merchantTimezone")
  public String getMerchantTimezone() {
    return merchantTimezone;
  }
  public void setMerchantTimezone(String merchantTimezone) {
    this.merchantTimezone = merchantTimezone;
  }

  
  /**
   * Card type, e.g. Visa, Mastercard.
   **/
  @ApiModelProperty(value = "Card type, e.g. Visa, Mastercard.")
  @JsonProperty("cardType")
  public String getCardType() {
    return cardType;
  }
  public void setCardType(String cardType) {
    this.cardType = cardType;
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
    sb.append("class SearchResult {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  accountSuffix: ").append(accountSuffix).append("\n");
    sb.append("  firstName: ").append(firstName).append("\n");
    sb.append("  lastName: ").append(lastName).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  currency: ").append(currency).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  referenceId: ").append(referenceId).append("\n");
    sb.append("  requestDateTime: ").append(requestDateTime).append("\n");
    sb.append("  merchantTimezone: ").append(merchantTimezone).append("\n");
    sb.append("  cardType: ").append(cardType).append("\n");
    sb.append("  links: ").append(links).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
