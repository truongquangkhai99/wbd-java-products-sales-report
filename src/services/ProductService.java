package services;

import java.sql.SQLException;
import java.util.List;
import models.ProductSalesReportItem;

public interface ProductService {

  List<ProductSalesReportItem> getSalesReport() throws ClassNotFoundException, SQLException;
}
