package com.visa.payments.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class MerchantDescriptor   {
  
  private String primary = null;
  private String alternate = null;
  private String city = null;
  private String contact = null;
  private String country = null;
  private String postalCode = null;
  private String state = null;
  private String street = null;

  
  /**
   * Merchant description that is displayed on the cardholders statement
   **/
  @ApiModelProperty(value = "Merchant description that is displayed on the cardholders statement")
  @JsonProperty("primary")
  public String getPrimary() {
    return primary;
  }
  public void setPrimary(String primary) {
    this.primary = primary;
  }

  
  /**
   * Alternate merchant contact information.
   **/
  @ApiModelProperty(value = "Alternate merchant contact information.")
  @JsonProperty("alternate")
  public String getAlternate() {
    return alternate;
  }
  public void setAlternate(String alternate) {
    this.alternate = alternate;
  }

  
  /**
   * Merchant city that is displayed on the cardholders statement.
   **/
  @ApiModelProperty(value = "Merchant city that is displayed on the cardholders statement.")
  @JsonProperty("city")
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }

  
  /**
   * Merchant contact information, such as a phone number  that is displayed on the cardholders statement.
   **/
  @ApiModelProperty(value = "Merchant contact information, such as a phone number  that is displayed on the cardholders statement.")
  @JsonProperty("contact")
  public String getContact() {
    return contact;
  }
  public void setContact(String contact) {
    this.contact = contact;
  }

  
  /**
   * Merchant country that is displayed on the cardholders statement.
   **/
  @ApiModelProperty(value = "Merchant country that is displayed on the cardholders statement.")
  @JsonProperty("country")
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }

  
  /**
   * Merchant postal code that is displayed on the cardholders statement
   **/
  @ApiModelProperty(value = "Merchant postal code that is displayed on the cardholders statement")
  @JsonProperty("postalCode")
  public String getPostalCode() {
    return postalCode;
  }
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  
  /**
   * Merchant state that is displayed on the cardholders statement.
   **/
  @ApiModelProperty(value = "Merchant state that is displayed on the cardholders statement.")
  @JsonProperty("state")
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }

  
  /**
   * Merchant street address that is displayed on the cardholders statement.
   **/
  @ApiModelProperty(value = "Merchant street address that is displayed on the cardholders statement.")
  @JsonProperty("street")
  public String getStreet() {
    return street;
  }
  public void setStreet(String street) {
    this.street = street;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MerchantDescriptor {\n");
    
    sb.append("  primary: ").append(primary).append("\n");
    sb.append("  alternate: ").append(alternate).append("\n");
    sb.append("  city: ").append(city).append("\n");
    sb.append("  contact: ").append(contact).append("\n");
    sb.append("  country: ").append(country).append("\n");
    sb.append("  postalCode: ").append(postalCode).append("\n");
    sb.append("  state: ").append(state).append("\n");
    sb.append("  street: ").append(street).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
