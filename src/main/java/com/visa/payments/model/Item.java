package com.visa.payments.model;





import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;



@ApiModel(description = "")
public class Item   {
  
  private String productSKU = null;
  private String productCode = null;
  private String productName = null;
  private String quantity = null;
  private String taxAmount = null;
  private String amount = null;

  
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
   * Product Code
   **/
  @ApiModelProperty(value = "Product Code")
  @JsonProperty("productCode")
  public String getProductCode() {
    return productCode;
  }
  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  
  /**
   * Product Name
   **/
  @ApiModelProperty(value = "Product Name")
  @JsonProperty("productName")
  public String getProductName() {
    return productName;
  }
  public void setProductName(String productName) {
    this.productName = productName;
  }

  
  /**
   * Quantity
   **/
  @ApiModelProperty(value = "Quantity")
  @JsonProperty("quantity")
  public String getQuantity() {
    return quantity;
  }
  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  
  /**
   * Tax Amount
   **/
  @ApiModelProperty(value = "Tax Amount")
  @JsonProperty("taxAmount")
  public String getTaxAmount() {
    return taxAmount;
  }
  public void setTaxAmount(String taxAmount) {
    this.taxAmount = taxAmount;
  }

  
  /**
   * Amount.
   **/
  @ApiModelProperty(value = "Amount.")
  @JsonProperty("amount")
  public String getAmount() {
    return amount;
  }
  public void setAmount(String amount) {
    this.amount = amount;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Item {\n");
    
    sb.append("  productSKU: ").append(productSKU).append("\n");
    sb.append("  productCode: ").append(productCode).append("\n");
    sb.append("  productName: ").append(productName).append("\n");
    sb.append("  quantity: ").append(quantity).append("\n");
    sb.append("  taxAmount: ").append(taxAmount).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


