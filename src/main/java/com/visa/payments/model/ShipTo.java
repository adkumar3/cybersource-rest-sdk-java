package com.visa.payments.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ShipTo   {
  
  private String firstName = null;
  private String lastName = null;
  private String street1 = null;
  private String street2 = null;
  private String city = null;
  private String state = null;
  private String postalCode = null;
  private String country = null;
  private String phoneNumber = null;
  private String shippingMethod = null;

  
  /**
   * First name
   **/
  @ApiModelProperty(value = "First name")
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  
  /**
   * Last name
   **/
  @ApiModelProperty(value = "Last name")
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  
  /**
   * Street address
   **/
  @ApiModelProperty(value = "Street address")
  @JsonProperty("street1")
  public String getStreet1() {
    return street1;
  }
  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  
  /**
   * Street address 2
   **/
  @ApiModelProperty(value = "Street address 2")
  @JsonProperty("street2")
  public String getStreet2() {
    return street2;
  }
  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  
  /**
   * City
   **/
  @ApiModelProperty(value = "City")
  @JsonProperty("city")
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }

  
  /**
   * State
   **/
  @ApiModelProperty(value = "State")
  @JsonProperty("state")
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }

  
  /**
   * Postal code
   **/
  @ApiModelProperty(value = "Postal code")
  @JsonProperty("postalCode")
  public String getPostalCode() {
    return postalCode;
  }
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  
  /**
   * Country
   **/
  @ApiModelProperty(value = "Country")
  @JsonProperty("country")
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }

  
  /**
   * Phone Number
   **/
  @ApiModelProperty(value = "Phone Number")
  @JsonProperty("phoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  
  /**
   * Shipping method for the product
   **/
  @ApiModelProperty(value = "Shipping method for the product")
  @JsonProperty("shippingMethod")
  public String getShippingMethod() {
    return shippingMethod;
  }
  public void setShippingMethod(String shippingMethod) {
    this.shippingMethod = shippingMethod;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShipTo {\n");
    
    sb.append("  firstName: ").append(firstName).append("\n");
    sb.append("  lastName: ").append(lastName).append("\n");
    sb.append("  street1: ").append(street1).append("\n");
    sb.append("  street2: ").append(street2).append("\n");
    sb.append("  city: ").append(city).append("\n");
    sb.append("  state: ").append(state).append("\n");
    sb.append("  postalCode: ").append(postalCode).append("\n");
    sb.append("  country: ").append(country).append("\n");
    sb.append("  phoneNumber: ").append(phoneNumber).append("\n");
    sb.append("  shippingMethod: ").append(shippingMethod).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
