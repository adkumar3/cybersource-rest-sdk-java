package com.visa.payments.model;

import com.visa.payments.model.Link;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SelfLink   {
  
  private Link self = null;

  
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

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelfLink {\n");
    
    sb.append("  self: ").append(self).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
