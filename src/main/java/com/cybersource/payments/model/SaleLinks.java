package com.cybersource.payments.model;

import java.util.*;





import io.swagger.annotations.*;

import com.cybersource.payments.model.Link;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SaleLinks   {
  
  private Link self = null;
  private List<Link> _void = new ArrayList<Link>();

  
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
  @JsonProperty("void")
  public List<Link> getVoid() {
    return _void;
  }
  public void setVoid(List<Link> _void) {
    this._void = _void;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaleLinks {\n");
    
    sb.append("  self: ").append(self).append("\n");
    sb.append("  _void: ").append(_void).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
