package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.ProductSalesReportItem;

public class ProductServiceImpl implements ProductService {

  private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

  private static final String DB_URL = "jdbc:mysql://localhost:3306/classicmodels";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "123456";

  private static final String SQL_GET_SALES_REPORT = "SELECT\n"
      + "  pl.productLine,\n"
      + "  p.productVendor,\n"
      + "  p.productCode,\n"
      + "  p.productName,\n"
      + "  p.quantityInStock,\n"
      + "  SUM(od.quantityOrdered) AS salesQuantity,\n"
      + "  SUM(od.quantityOrdered * od.priceEach) salesTrade\n"
      + "FROM products p\n"
      + "  INNER JOIN productlines pl ON p.productLine = pl.productLine\n"
      + "  INNER JOIN orderdetails od ON p.productCode = od.productCode\n"
      + "GROUP BY pl.productLine, p.productVendor, p.productCode, p.productName, p.quantityInStock;";

  @Override
  public List<ProductSalesReportItem> getSalesReport() throws ClassNotFoundException, SQLException {
    Class.forName(JDBC_DRIVER);

    log("Dang ket noi toi co so du lieu ...");
    Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

    Statement stmt = conn.createStatement();

    log("Dang thuc hien truy van...");
    ResultSet rs = stmt.executeQuery(SQL_GET_SALES_REPORT);

    log("Dang thu thap ket qua...");
    List<ProductSalesReportItem> products = new ArrayList<>();
    while (rs.next()) {
      ProductSalesReportItem report = new ProductSalesReportItem();
      report.setGetProductLine(rs.getString("productLine"));
      report.setProductVendor(rs.getString("productVendor"));
      report.setProductCode(rs.getString("productCode"));
      report.setProductName(rs.getString("productName"));
      report.setQuantityInStock(rs.getInt("quantityInStock"));
      report.setSalesQuantity(rs.getInt("salesQuantity"));
      report.setSalesTrade(rs.getDouble("salesTrade"));

      products.add(report);
    }

    log("Hoan thanh thu thap ket qua. Dang dong cac ket noi...");
    rs.close();
    stmt.close();
    conn.close();

    log("Thanh cong!");
    return products;
  }

  private void log(String message) {
    System.out.println("ProductServiceImpl: " + message);
  }
}
