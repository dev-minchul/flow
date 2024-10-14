<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>주문번호</th>
			<th>회원이름</th>
			<th>상품이름</th>
			<th>상품가격</th>
			<th>상품수량</th>
			<th>주문가격</th>
		</tr>
		<c:forEach var="order" items="${orderList}">
			<tr>
				<td><c:out value="${order.id}"/></td>
				<td><c:out value="${order.memberName}"/></td>
				<td><c:out value="${order.productName}"/></td>
				<td><c:out value="${order.productPrice}"/></td>
				<td><c:out value="${order.productCount}"/></td>
				<td><c:out value="${order.totalPrice}"/></td>
			</tr>
		</c:forEach>	
	</table>
</body>
<script type="text/javascript">
	console.log(`${orderList}`)
</script>
</html>