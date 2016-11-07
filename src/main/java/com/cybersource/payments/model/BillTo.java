package com.cybersource.payments.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class BillTo   {
  
  private String firstName = null;
  private String lastName = null;
  private String buildingNumber = null;
  private String street1 = null;
  private String street2 = null;
  private String city = null;
  private String county = null;
  private String district = null;
  private String state = null;
  private String postalCode = null;
  private String country = null;
  private String company = null;
  private String phoneNumber = null;
  private String email = null;
  private String ipAddress = null;

  
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
   * Building number in street address
   **/
  @ApiModelProperty(value = "Building number in street address")
  @JsonProperty("buildingNumber")
  public String getBuildingNumber() {
    return buildingNumber;
  }
  public void setBuildingNumber(String buildingNumber) {
    this.buildingNumber = buildingNumber;
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
   * County
   **/
  @ApiModelProperty(value = "County")
  @JsonProperty("county")
  public String getCounty() {
    return county;
  }
  public void setCounty(String county) {
    this.county = county;
  }

  
  /**
   * District
   **/
  @ApiModelProperty(value = "District")
  @JsonProperty("district")
  public String getDistrict() {
    return district;
  }
  public void setDistrict(String district) {
    this.district = district;
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
   * Company
   **/
  @ApiModelProperty(value = "Company")
  @JsonProperty("company")
  public String getCompany() {
    return company;
  }
  public void setCompany(String company) {
    this.company = company;
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
   * Email address
   **/
  @ApiModelProperty(value = "Email address")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  
  /**
   * IP address of the customer
   **/
  @ApiModelProperty(value = "IP address of the customer")
  @JsonProperty("ipAddress")
  public String getIpAddress() {
    return ipAddress;
  }
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillTo {\n");
    
    sb.append("  firstName: ").append(firstName).append("\n");
    sb.append("  lastName: ").append(lastName).append("\n");
    sb.append("  buildingNumber: ").append(buildingNumber).append("\n");
    sb.append("  street1: ").append(street1).append("\n");
    sb.append("  street2: ").append(street2).append("\n");
    sb.append("  city: ").append(city).append("\n");
    sb.append("  county: ").append(county).append("\n");
    sb.append("  district: ").append(district).append("\n");
    sb.append("  state: ").append(state).append("\n");
    sb.append("  postalCode: ").append(postalCode).append("\n");
    sb.append("  country: ").append(country).append("\n");
    sb.append("  company: ").append(company).append("\n");
    sb.append("  phoneNumber: ").append(phoneNumber).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  ipAddress: ").append(ipAddress).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
