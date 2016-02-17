package com.visa.payments.model;

import java.util.*;
import com.visa.payments.model.Link;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class CollectionLinks   {
  
  private Link self = null;
  private List<Link> next = new ArrayList<Link>();

  
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
  @JsonProperty("next")
  public List<Link> getNext() {
    return next;
  }
  public void setNext(List<Link> next) {
    this.next = next;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollectionLinks {\n");
    
    sb.append("  self: ").append(self).append("\n");
    sb.append("  next: ").append(next).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
