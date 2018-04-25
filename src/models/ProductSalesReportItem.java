package models;

public class ProductSalesReportItem {

  private String getProductLine;
  private String productVendor;
  private String productCode;
  private String productName;
  private int quantityInStock;
  private int salesQuantity;
  private double salesTrade;

  public ProductSalesReportItem() {
  }

  public String getGetProductLine() {
    return getProductLine;
  }

  public void setGetProductLine(String getProductLine) {
    this.getProductLine = getProductLine;
  }

  public String getProductVendor() {
    return productVendor;
  }

  public void setProductVendor(String productVendor) {
    this.productVendor = productVendor;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getQuantityInStock() {
    return quantityInStock;
  }

  public void setQuantityInStock(int quantityInStock) {
    this.quantityInStock = quantityInStock;
  }

  public int getSalesQuantity() {
    return salesQuantity;
  }

  public void setSalesQuantity(int salesQuantity) {
    this.salesQuantity = salesQuantity;
  }

  public double getSalesTrade() {
    return salesTrade;
  }

  public void setSalesTrade(double salesTrade) {
    this.salesTrade = salesTrade;
  }
}
