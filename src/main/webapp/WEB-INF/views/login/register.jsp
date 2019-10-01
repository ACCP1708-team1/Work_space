<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>
	<form:form action="${pageContext.request.contextPath }/user/register"
		method="post" modelAttribute="account" methodParam="repassword">
		<table class="table">
			<tr>
				<td>User name</td>
				<td><form:input path="username" placeholder="Your user name" /></td>
			</tr>
			<tr>
				<td>Pasword</td>
				<td><form:password path="password" placeholder="*******" /></td>
			</tr>
			<tr>
				<td>Re-Pasword</td>
				<td><form:password path="repassword" placeholder="*******" /></td>
			</tr>
		</table>
		<input type="submit" value="Register" />
	</form:form>
</div>