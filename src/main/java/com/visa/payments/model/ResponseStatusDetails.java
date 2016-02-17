package com.visa.payments.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ResponseStatusDetails   {
  
  private String location = null;
  private String message = null;

  
  /**
   * Field name referred to for validation issues.
   **/
  @ApiModelProperty(value = "Field name referred to for validation issues.")
  @JsonProperty("location")
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }

  
  /**
   * Description or code of any error response.
   **/
  @ApiModelProperty(value = "Description or code of any error response.")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseStatusDetails {\n");
    
    sb.append("  location: ").append(location).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
