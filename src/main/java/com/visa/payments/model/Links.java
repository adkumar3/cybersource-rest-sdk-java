package com.visa.payments.model;

import java.util.*;
import com.visa.payments.model.Link;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Links   {
  
  private Link self = null;
  private List<Link> documentation = new ArrayList<Link>();
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
  @JsonProperty("documentation")
  public List<Link> getDocumentation() {
    return documentation;
  }
  public void setDocumentation(List<Link> documentation) {
    this.documentation = documentation;
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
    sb.append("class Links {\n");
    
    sb.append("  self: ").append(self).append("\n");
    sb.append("  documentation: ").append(documentation).append("\n");
    sb.append("  next: ").append(next).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
