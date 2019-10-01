<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="category" type="java.lang.Object"%>
<c:if test="${category!=null }">
	<div class="col-md-4 ab-content ab-content1">
		<div class="ab-content-inner">
			<a href="single.html"><img
				src="${pageContext.request.contextPath }/resources/image/${category.avatar}"
				alt="news image" class="img-fluid"></a>
			<div class="ab-info-con">
				<h4>${category.categoryName }</h4>
				<a href="single.html" class="read-more two btn m-0 px-3"><span
					class="fa fa-arrow-circle-o-right"> </span></a>
			</div>
		</div>
		<div class="ab-content-inner">
			<a href="single.html"><h5>${category.categoryName }</h5></a>
			<div class="ab-info-con">
				<p>${category.description }</p>
			</div>
			<a href="#" class="read-more btn">Show more</a>
		</div>
	</div>
</c:if>
