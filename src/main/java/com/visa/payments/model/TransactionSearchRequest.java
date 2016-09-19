package com.visa.payments.model;





import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class TransactionSearchRequest   {
  
  private String query = null;
  private Integer offset = null;
  private Integer limit = null;

  
  /**
   * Query string to search for transactions.
   **/
  @ApiModelProperty(required = true, value = "Query string to search for transactions.")
  @JsonProperty("query")
  public String getQuery() {
    return query;
  }
  public void setQuery(String query) {
    this.query = query;
  }

  
  /**
   * This paging parameter is used to specify the page number.
   **/
  @ApiModelProperty(value = "This paging parameter is used to specify the page number.")
  @JsonProperty("offset")
  public Integer getOffset() {
    return offset;
  }
  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  
  /**
   * This paging parameter specifies the number of records per page.
   **/
  @ApiModelProperty(value = "This paging parameter specifies the number of records per page.")
  @JsonProperty("limit")
  public Integer getLimit() {
    return limit;
  }
  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionSearchRequest {\n");
    
    sb.append("  query: ").append(query).append("\n");
    sb.append("  offset: ").append(offset).append("\n");
    sb.append("  limit: ").append(limit).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


