package com.cybersource.payments.model;





import io.swagger.annotations.*;

import com.cybersource.payments.model.CollectionLinks;
import com.cybersource.payments.model.TransactionSearch;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class CreditCollection   {
  
  private CollectionLinks links = null;
  private TransactionSearch embedded = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("_links")
  public CollectionLinks getLinks() {
    return links;
  }
  public void setLinks(CollectionLinks links) {
    this.links = links;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("_embedded")
  public TransactionSearch getEmbedded() {
    return embedded;
  }
  public void setEmbedded(TransactionSearch embedded) {
    this.embedded = embedded;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCollection {\n");
    
    sb.append("  links: ").append(links).append("\n");
    sb.append("  embedded: ").append(embedded).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
