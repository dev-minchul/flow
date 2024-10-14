<%@page import="java.util.Optional"%>
<%@page import="com.app.vo.ProductVO"%>
<%@page import="com.app.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
</head>
<body>
   <% 
      ProductVO product = (ProductVO)request.getAttribute("product");
       
   %>
 <table border="1">
      <tr>
         <th>상품 번호</th>
         <th>상품 이름</th>
         <th>상품 가격</th>
         <th>상품 재고</th>
      </tr>
      <tr>
         <td><%=product.getId() %></td>
         <td><%=product.getProductName() %></td>
         <td><%=product.getProductPrice() %></td>
         <td><%=product.getProductStock() %></td>
      </tr>
   </table>
   <a href="update.product?id=<%=request.getParameter("id")%>"><button>수정하기</button></a>
   <a href="delete-ok.product?id=<%= product.getId() %>"><button>삭제하기</button></a>
 
</body>
</html>