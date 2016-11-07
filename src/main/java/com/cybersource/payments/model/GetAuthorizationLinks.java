package com.cybersource.payments.model;

import java.util.*;






import io.swagger.annotations.*;

import com.cybersource.payments.model.Link;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class GetAuthorizationLinks   {
  
  private Link self = null;
  private List<Link> capture = new ArrayList<Link>();
  private List<Link> reversal = new ArrayList<Link>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("self")
  public Link getSelf() {
    return self;
  }
  public void setSelf(Link self) {
    this.self = self;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("capture")
  public List<Link> getCapture() {
    return capture;
  }
  public void setCapture(List<Link> capture) {
    this.capture = capture;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("reversal")
  public List<Link> getReversal() {
    return reversal;
  }
  public void setReversal(List<Link> reversal) {
    this.reversal = reversal;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAuthorizationLinks {\n");
    
    sb.append("  self: ").append(self).append("\n");
    sb.append("  capture: ").append(capture).append("\n");
    sb.append("  reversal: ").append(reversal).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


