package views;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ProductSalesReportItem;
import services.ProductService;
import services.ProductServiceImpl;

@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {

  private ProductService productService = new ProductServiceImpl();

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      String action = request.getParameter("action");
    if (action.isEmpty()) {
      action = "";
    }

    switch (action) {
      case "create":
        break;
      case "edit":
        break;
      case "delete":
        break;
      case "sales-report":
        listSalesReport(request, response);
      default:
        break;
    }
  }

  private void listSalesReport(HttpServletRequest request,
      HttpServletResponse response) {
    try {
      List<ProductSalesReportItem> salesReport = this.productService.getSalesReport();
      request.setAttribute("salesReport", salesReport);

      RequestDispatcher dispatcher = request.getRequestDispatcher("products/sales-report.jsp");
      dispatcher.forward(request, response);
    } catch (ClassNotFoundException | SQLException | IOException | ServletException e) {
      e.printStackTrace();
    }
  }
}
