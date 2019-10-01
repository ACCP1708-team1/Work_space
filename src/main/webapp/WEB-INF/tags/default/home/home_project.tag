<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="projectStatus" type="java.lang.Object"%>
<div class="col-lg-4  mb-lg-0 mb-5">
	<div class="padding">
		<div>
			<a href="#"><img alt="Image for project"
				src="${pageContext.request.contextPath }/image/${projectStatus.avatar}">
			</a>
		</div>
		<h3>${projectStatus.name }</h3>
		<!-- Item starts -->
		<div class="menu-item">
			<div class="row border-dot no-gutters">
				<p>${projectStatus.description }</p>
			</div>
			<div>
				<a class="read-more btn" href="${pageContext.request.contextPath }/project/listByStatus/${projectStatus.id}">Show more</a>
			</div>
		</div>
		<!-- Item ends -->
	</div>
</div>