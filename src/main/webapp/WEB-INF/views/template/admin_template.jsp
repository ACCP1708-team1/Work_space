<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Admin Panel</h3>
	<table border="1">
		<tr>
			<td>
				<ul>
					<li> <a href="${pageContext.request.contextPath }/admin/account">Account Management</a> </li>
					<li> <a href="${pageContext.request.contextPath }/admin/category">Category Management</a> </li>
					<li> <a href="${pageContext.request.contextPath }/admin/product">Product Management</a> </li>
				</ul>
			</td>
			<td>
				<div><tiles:insertAttribute name="content"></tiles:insertAttribute> </div>
			</td>
		</tr>
	</table>
</body>
</html>