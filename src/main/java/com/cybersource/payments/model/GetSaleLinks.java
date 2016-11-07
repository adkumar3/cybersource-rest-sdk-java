package com.cybersource.payments.model;

import java.util.*;





import io.swagger.annotations.*;

import com.cybersource.payments.model.Link;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetSaleLinks   {
  
  private Link self = null;
  private List<Link> refund = new ArrayList<Link>();

  
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
  @JsonProperty("refund")
  public List<Link> getRefund() {
    return refund;
  }
  public void setRefund(List<Link> refund) {
    this.refund = refund;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSaleLinks {\n");
    
    sb.append("  self: ").append(self).append("\n");
    sb.append("  refund: ").append(refund).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
