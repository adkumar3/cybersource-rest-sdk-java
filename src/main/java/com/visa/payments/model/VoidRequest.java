package com.visa.payments.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class VoidRequest   {
  
  private String referenceId = null;

  
  /**
   * Merchant reference ID for the transaction
   **/
  @ApiModelProperty(value = "Merchant reference ID for the transaction")
  @JsonProperty("referenceId")
  public String getReferenceId() {
    return referenceId;
  }
  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoidRequest {\n");
    
    sb.append("  referenceId: ").append(referenceId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
