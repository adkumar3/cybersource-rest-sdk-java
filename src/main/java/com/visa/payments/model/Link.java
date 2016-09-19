package com.visa.payments.model;





import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class Link   {
  
  private String href = null;
  private String title = null;
  private String method = null;

  
  /**
   * URI of the linked resource.
   **/
  @ApiModelProperty(value = "URI of the linked resource.")
  @JsonProperty("href")
  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }

  
  /**
   * Label of the linked resource.
   **/
  @ApiModelProperty(value = "Label of the linked resource.")
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  /**
   * HTTP method of the linked resource.
   **/
  @ApiModelProperty(value = "HTTP method of the linked resource.")
  @JsonProperty("method")
  public String getMethod() {
    return method;
  }
  public void setMethod(String method) {
    this.method = method;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Link {\n");
    
    sb.append("  href: ").append(href).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  method: ").append(method).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


