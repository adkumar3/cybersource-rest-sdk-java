package com.visa.payments.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Item   {
  
  private String productSKU = null;
  private String quantity = null;
  private String unitPrice = null;
  private String taxAmount = null;

  
  /**
   * Product SKU
   **/
  @ApiModelProperty(value = "Product SKU")
  @JsonProperty("productSKU")
  public String getProductSKU() {
    return productSKU;
  }
  public void setProductSKU(String productSKU) {
    this.productSKU = productSKU;
  }

  
  /**
   * Quantity.
   **/
  @ApiModelProperty(value = "Quantity.")
  @JsonProperty("quantity")
  public String getQuantity() {
    return quantity;
  }
  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  
  /**
   * Unit Price.
   **/
  @ApiModelProperty(value = "Unit Price.")
  @JsonProperty("unitPrice")
  public String getUnitPrice() {
    return unitPrice;
  }
  public void setUnitPrice(String unitPrice) {
    this.unitPrice = unitPrice;
  }

  
  /**
   * Tax Amount.
   **/
  @ApiModelProperty(value = "Tax Amount.")
  @JsonProperty("taxAmount")
  public String getTaxAmount() {
    return taxAmount;
  }
  public void setTaxAmount(String taxAmount) {
    this.taxAmount = taxAmount;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Item {\n");
    
    sb.append("  productSKU: ").append(productSKU).append("\n");
    sb.append("  quantity: ").append(quantity).append("\n");
    sb.append("  unitPrice: ").append(unitPrice).append("\n");
    sb.append("  taxAmount: ").append(taxAmount).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
