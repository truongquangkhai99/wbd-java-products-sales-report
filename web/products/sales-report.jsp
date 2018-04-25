<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>

<h1>Products Sales Report</h1>

<table border="1">
    <tr>
        <td>Product Line</td>
        <td>Product Vendor</td>
        <td>Product  Code</td>
        <td>ProductName</td>
        <td>Quantity In Stock</td>
        <td>Sales Quantity</td>
        <td>Sales Trade</td>
    </tr>
    <c:forEach items='${requestScope["salesReport"]}' var="reportItem">
        <tr>
            <td>${reportItem.getGetProductLine()}</td>
            <td>${reportItem.getProductVendor()}</td>
            <td><a href="/products?action=view&code=${reportItem.getProductCode()}">${reportItem.getProductCode()}</a></td>
            <td>${reportItem.getProductName()}</td>
            <td>${reportItem.getQuantityInStock()}</td>
            <td>${reportItem.getSalesQuantity()}</td>
            <td>${reportItem.getSalesTrade()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
