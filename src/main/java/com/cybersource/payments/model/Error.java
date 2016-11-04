package com.cybersource.payments.model;





import io.swagger.annotations.*;

import com.cybersource.payments.model.Links;
import com.cybersource.payments.model.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Error   {
  
  private ResponseStatus responseStatus = null;
  private Links links = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("responseStatus")
  public ResponseStatus getResponseStatus() {
    return responseStatus;
  }
  public void setResponseStatus(ResponseStatus responseStatus) {
    this.responseStatus = responseStatus;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("_links")
  public Links getLinks() {
    return links;
  }
  public void setLinks(Links links) {
    this.links = links;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("  responseStatus: ").append(responseStatus).append("\n");
    sb.append("  links: ").append(links).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
