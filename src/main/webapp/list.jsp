<%@page import="java.util.List"%>
<%@page import="com.app.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
   <table border='1'>
      <tr>
         <th>선택</th>
         <th>상품번호</th>
         <th>상품명</th>
         <th>상품가격</th>
         <th>상품재고</th>
      </tr>
   </table>
   
   <form id="orderForm" action="write-ok.order">
      <table border='1' id="order"></table>
      <button type="button" style="display:none;">주문하기</button>
   </form>
   
</body>
<script type="text/javascript">
   const table = document.querySelector("table");
   const products = JSON.parse(`${products}`);
   
   products.forEach((product) => {
      table.innerHTML += (
         "<tr>" +
            "<td>" + "<input name='productId' type='radio' value='" + product.id + "' />" + "</td>"   +
            "<td>" + product.id + "</td>" +
            "<td>" + product.productName + "</td>" +
            "<td>" + product.productPrice + "</td>" +
            "<td>" + product.productStock + "</td>" +
         "</tr>"
      )
   })
   
   const orderForm = document.querySelector("#orderForm");
   const order = document.querySelector("#order");
   const radios = document.querySelectorAll("table input[type='radio']");
   const productIdInput = document.querySelector("input[name='productId']");
   const button = document.querySelector("button")

   radios.forEach((input, i) => {
      input.addEventListener("click", () => {
         console.log(products[i])
         if(!products[i].productStock){
            alert("상품 품절")
            return;
         }
         
         order.innerHTML = (
            "<tr>" +
               "<th>상품번호</th>" + 
               "<th>상품명</th>" + 
               "<th>상품가격</th>" + 
               "<th>주문수량</th>" + 
            "</tr>" +
            "<tr>" +
               "<input name='productId' type='hidden' value='" + products[i].id + "' />" +
               "<td>" + products[i].id + "</td>" +
               "<td>" + products[i].productName + "</td>" +
               "<td>" + products[i].productPrice + "</td>" +
               "<td>" + "<input name='productCount' value='1' placeholder='주문수량' required />" + "</td>"   +
            "</tr>"
         )
         button.style.display = "block";
      })
   })
   
   NodeList.prototype.filter = Array.prototype.filter;
   
   button.addEventListener("click", (e) => {
	   e.preventDefault();
	   const inputs = document.querySelectorAll("#order input");
	   console.log(inputs)
	   if(inputs.filter((input) => input.value) != 0){
		   orderForm.submit();
	   }
   })
   
   </script>
</html>

















