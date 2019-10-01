<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>
	<form:form action="${pageContext.request.contextPath }/user/login"
		method="post" modelAttribute="account">
		<table class="table">
			<tr>
				<td>User name</td>
				<td><form:input path="username" placeholder="Your user name" /></td>
			</tr>
			<tr>
				<td>Pasword</td>
				<td><form:password path="password" placeholder="*******" /></td>
			</tr>
		</table>
		<input type="submit" value="Login" />
	</form:form>
	<p><a href="${pageContext.request.contextPath }/user/register"></a></p>
</div>