package com.cybersource.payments.model;





import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class Payment   {
  
  private String cardNumber = null;
  private String cardExpirationMonth = null;
  private String cardExpirationYear = null;
  private String cardType = null;
  private String cardVerificationIndicator = null;
  private String cvn = null;
  private String encryptedData = null;
  private String encryptedDescriptor = null;
  private String encryptedEncoding = null;
  private String encryptedKey = null;
  private String cavv = null;
  private String xid = null;
  private String ucafAuthenticationData = null;
  private String ucafCollectionIndicator = null;
  private String networkTokenTransactionType = null;
  private String networkTokenRequestorId = null;

  
  /**
   * Credit card number
   **/
  @ApiModelProperty(value = "Credit card number")
  @JsonProperty("cardNumber")
  public String getCardNumber() {
    return cardNumber;
  }
  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  
  /**
   * Two-digit expiration month
   **/
  @ApiModelProperty(value = "Two-digit expiration month")
  @JsonProperty("cardExpirationMonth")
  public String getCardExpirationMonth() {
    return cardExpirationMonth;
  }
  public void setCardExpirationMonth(String cardExpirationMonth) {
    this.cardExpirationMonth = cardExpirationMonth;
  }

  
  /**
   * Four-digit expiration year
   **/
  @ApiModelProperty(value = "Four-digit expiration year")
  @JsonProperty("cardExpirationYear")
  public String getCardExpirationYear() {
    return cardExpirationYear;
  }
  public void setCardExpirationYear(String cardExpirationYear) {
    this.cardExpirationYear = cardExpirationYear;
  }

  
  /**
   * Card Type
   **/
  @ApiModelProperty(value = "Card Type")
  @JsonProperty("cardType")
  public String getCardType() {
    return cardType;
  }
  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  
  /**
   * Flag that indicates whether a CVN code was sent.
   **/
  @ApiModelProperty(value = "Flag that indicates whether a CVN code was sent.")
  @JsonProperty("cardVerificationIndicator")
  public String getCardVerificationIndicator() {
    return cardVerificationIndicator;
  }
  public void setCardVerificationIndicator(String cardVerificationIndicator) {
    this.cardVerificationIndicator = cardVerificationIndicator;
  }

  
  /**
   * Card Verification Number
   **/
  @ApiModelProperty(value = "Card Verification Number")
  @JsonProperty("cvn")
  public String getCvn() {
    return cvn;
  }
  public void setCvn(String cvn) {
    this.cvn = cvn;
  }

  
  /**
   * Encrypted Payment Data
   **/
  @ApiModelProperty(value = "Encrypted Payment Data")
  @JsonProperty("encryptedData")
  public String getEncryptedData() {
    return encryptedData;
  }
  public void setEncryptedData(String encryptedData) {
    this.encryptedData = encryptedData;
  }

  
  /**
   * Format of the encrypted payment data.
   **/
  @ApiModelProperty(value = "Format of the encrypted payment data.")
  @JsonProperty("encryptedDescriptor")
  public String getEncryptedDescriptor() {
    return encryptedDescriptor;
  }
  public void setEncryptedDescriptor(String encryptedDescriptor) {
    this.encryptedDescriptor = encryptedDescriptor;
  }

  
  /**
   * Encoding method used to encrypt the payment data.
   **/
  @ApiModelProperty(value = "Encoding method used to encrypt the payment data.")
  @JsonProperty("encryptedEncoding")
  public String getEncryptedEncoding() {
    return encryptedEncoding;
  }
  public void setEncryptedEncoding(String encryptedEncoding) {
    this.encryptedEncoding = encryptedEncoding;
  }

  
  /**
   * Encrypted key that CyberSource uses to decrypt the payment data.
   **/
  @ApiModelProperty(value = "Encrypted key that CyberSource uses to decrypt the payment data.")
  @JsonProperty("encryptedKey")
  public String getEncryptedKey() {
    return encryptedKey;
  }
  public void setEncryptedKey(String encryptedKey) {
    this.encryptedKey = encryptedKey;
  }

  
  /**
   * Cryptogram for payment network tokenization transactions. The value for this field must be 28-character base64 or 40-character hex binary.
   **/
  @ApiModelProperty(value = "Cryptogram for payment network tokenization transactions. The value for this field must be 28-character base64 or 40-character hex binary.")
  @JsonProperty("cavv")
  public String getCavv() {
    return cavv;
  }
  public void setCavv(String cavv) {
    this.cavv = cavv;
  }

  
  /**
   * Cryptogram for payment network tokenization transactions.
   **/
  @ApiModelProperty(value = "Cryptogram for payment network tokenization transactions.")
  @JsonProperty("xid")
  public String getXid() {
    return xid;
  }
  public void setXid(String xid) {
    this.xid = xid;
  }

  
  /**
   * Cryptogram for payment network tokenization transactions with MasterCard.
   **/
  @ApiModelProperty(value = "Cryptogram for payment network tokenization transactions with MasterCard.")
  @JsonProperty("ucafAuthenticationData")
  public String getUcafAuthenticationData() {
    return ucafAuthenticationData;
  }
  public void setUcafAuthenticationData(String ucafAuthenticationData) {
    this.ucafAuthenticationData = ucafAuthenticationData;
  }

  
  /**
   * Required field for payment network tokenization transactions with MasterCard.
   **/
  @ApiModelProperty(value = "Required field for payment network tokenization transactions with MasterCard.")
  @JsonProperty("ucafCollectionIndicator")
  public String getUcafCollectionIndicator() {
    return ucafCollectionIndicator;
  }
  public void setUcafCollectionIndicator(String ucafCollectionIndicator) {
    this.ucafCollectionIndicator = ucafCollectionIndicator;
  }

  
  /**
   * Type of transaction that provided the token data.
   **/
  @ApiModelProperty(value = "Type of transaction that provided the token data.")
  @JsonProperty("networkTokenTransactionType")
  public String getNetworkTokenTransactionType() {
    return networkTokenTransactionType;
  }
  public void setNetworkTokenTransactionType(String networkTokenTransactionType) {
    this.networkTokenTransactionType = networkTokenTransactionType;
  }

  
  /**
   * Value that identifies your business and indicates that the cardholderâ€™s account number is tokenized.
   **/
  @ApiModelProperty(value = "Value that identifies your business and indicates that the cardholderâ€™s account number is tokenized.")
  @JsonProperty("networkTokenRequestorId")
  public String getNetworkTokenRequestorId() {
    return networkTokenRequestorId;
  }
  public void setNetworkTokenRequestorId(String networkTokenRequestorId) {
    this.networkTokenRequestorId = networkTokenRequestorId;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("  cardNumber: ").append(cardNumber).append("\n");
    sb.append("  cardExpirationMonth: ").append(cardExpirationMonth).append("\n");
    sb.append("  cardExpirationYear: ").append(cardExpirationYear).append("\n");
    sb.append("  cardType: ").append(cardType).append("\n");
    sb.append("  cardVerificationIndicator: ").append(cardVerificationIndicator).append("\n");
    sb.append("  cvn: ").append(cvn).append("\n");
    sb.append("  encryptedData: ").append(encryptedData).append("\n");
    sb.append("  encryptedDescriptor: ").append(encryptedDescriptor).append("\n");
    sb.append("  encryptedEncoding: ").append(encryptedEncoding).append("\n");
    sb.append("  encryptedKey: ").append(encryptedKey).append("\n");
    sb.append("  cavv: ").append(cavv).append("\n");
    sb.append("  xid: ").append(xid).append("\n");
    sb.append("  ucafAuthenticationData: ").append(ucafAuthenticationData).append("\n");
    sb.append("  ucafCollectionIndicator: ").append(ucafCollectionIndicator).append("\n");
    sb.append("  networkTokenTransactionType: ").append(networkTokenTransactionType).append("\n");
    sb.append("  networkTokenRequestorId: ").append(networkTokenRequestorId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


