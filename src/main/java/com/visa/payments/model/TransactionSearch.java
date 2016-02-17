package com.visa.payments.model;

import java.util.*;
import com.visa.payments.model.SearchResult;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class TransactionSearch   {
  
  private List<SearchResult> results = new ArrayList<SearchResult>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("results")
  public List<SearchResult> getResults() {
    return results;
  }
  public void setResults(List<SearchResult> results) {
    this.results = results;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionSearch {\n");
    
    sb.append("  results: ").append(results).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
