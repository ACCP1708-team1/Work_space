<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="home" tagdir="/WEB-INF/tags/default/home"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<head>
<title>Men spa Beauty Category Bootstrap Responsive Template |
	Home :: W3layouts</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
	content="Men spa Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- //Meta tag Keywords -->
<!-- Custom-Files -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/style.css"
	type="text/css" media="all" />
<!-- Style-CSS -->
<!-- font-awesome-icons -->
<link
	href="${pageContext.request.contextPath }/resources/css/font-awesome.css"
	rel="stylesheet
	">
<!-- //font-awesome-icons -->
<!-- /Fonts -->
<link
	href="//fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">
<!-- //Fonts -->
</head>

<body>
	<!--  data-spy="scroll" data-target=".navbar-fixed-top" -->
	<!-- header -->
	<header >
		<div class="container">
			<div
				class="header d-lg-flex justify-content-between align-items-center">
				<div class="header-agile">
					<h1>
						<a class="navbar-brand logo"
							href="${pageContext.request.contextPath}/home"> <span
							class="fa fa-scissors" aria-hidden="true"></span> Men spa <span
							class="fa fa-user-secret" aria-hidden="true"></span>
						</a>
					</h1>
				</div>
				<div class="nav_w3ls">
					<nav class="navbar navbar-default navbar-fixed-top">
						<label for="drop" class="toggle mt-lg-0 mt-1"><span
							class="fa fa-bars" aria-hidden="true"></span></label> <input
							type="checkbox" id="drop" />
						<ul class="menu">
							<li class="mr-lg-3 mr-2 active"><a
								href="${pageContext.request.contextPath}/home">Home</a></li>
							<li class="mr-lg-3 mr-2"><a
								href="${pageContext.request.contextPath}/about">About </a></li>
							<li class="mr-lg-3 mr-2 p-0">
								<!-- First Tier Drop Down --> <label for="drop-2" class="toggle">Project
									<span class="fa fa-angle-down" aria-hidden="true"></span>
							</label> <a href="${pageContext.request.contextPath}/project/findAll">Project <span
									class="fa fa-angle-down" aria-hidden="true"></span></a> <input
								type="checkbox" id="drop-2" />
								<ul class="inner-dropdown">
									<c:forEach items="${projectStatus }" var="projectStatus">
										<li><a
											href="${pageContext.request.contextPath}/project/listByStatus/${projectStatus.id}">
												${projectStatus.name } </a></li>
									</c:forEach>

								</ul>
							</li>
							<li class="mr-lg-3 mr-2p-0">
								<!-- First Tier Drop Down --> <label for="drop-2" class="toggle">Category
									<span class="fa fa-angle-down" aria-hidden="true"></span>
							</label> <a href="${pageContext.request.contextPath}/service/listAll">Category
									<span class="fa fa-angle-down" aria-hidden="true"></span>
							</a> <input type="checkbox" id="drop-2" />
								<ul class="inner-dropdown">
									<c:forEach items="${categories }" var="category">
										<li><a
											href="${pageContext.request.contextPath}/service/listByCategory/${category.id}">
												${category.categoryName } </a></li>
									</c:forEach>

								</ul>
							<li class="mr-lg-3 mr-2"><a
								href="${pageContext.request.contextPath}/contact">Contact Us</a></li>
							<li class="mr-lg-3 mr-2"><a
								href="${pageContext.request.contextPath}/gallery">FAQ</a></li>

							<c:if test="${sessionScope.user!=null }">
								<li class="mr-lg-3 mr-2"><a
									href="${pageContext.request.contextPath}/user/logout"><b><i
											class="fa fa-user-circle" aria-hidden="true"></i><i
											class="fa fa-sign-out" aria-hidden="true"></i></b> </a></li>
							</c:if>
							<c:if test="${sessionScope.user==null }">
								<li class="mr-lg-3 mr-2"><a
									href="${pageContext.request.contextPath}/user/login"><b><i
											class="fa fa-sign-in" aria-hidden="true"></i></b> </a></li>
							</c:if>

						</ul>
					</nav>
				</div>

			</div>
		</div>
	</header>
	<!-- //header -->
	<div style="margin-top: 250px">
	<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>

	<!-- footer -->
	<footer class="footer-content">
		<div class="layer footer">
			<div class="container-fluid">
				<div class="row footer-top-inner-w3ls">
					<div class="col-lg-4 col-md-6 footer-top ">
						<h2>
							<a href="${pageContext.request.contextPath}/index">Men spa</a>
						</h2>
						<p class="my-3">Donec consequat sam libero tempore, cum soluta
							nobis est eligendi optio cumque nihil impedit quo minus</p>
						<p>Id quod possimusapien ut leo cursus rhoncus. Nullam dui mi,
							vulputate ac metus at, semper varius orci.</p>
					</div>
					<div class="col-lg-4 col-md-6 mt-md-0 mt-5">
						<div class="footer-w3pvt">
							<h3 class="mb-3 w3pvt_title">Opening Hours</h3>
							<hr>
							<ul class="list-info-w3pvt last-w3ls-contact mt-lg-4">
								<li>
									<p>Monday - Friday 08.00 am - 10.00 pm</p>

								</li>
								<li class="my-2">
									<p>Saturday 08.00 am - 10.00 pm</p>

								</li>
								<li class="my-2">
									<p>Sunday 08.00 am - 10.00 pm</p>

								</li>


							</ul>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 mt-lg-0 mt-5">
						<div class="footer-w3pvt">
							<h3 class="mb-3 w3pvt_title">Contact Us</h3>
							<hr>
							<div class="last-w3ls-contact">
								<p>
									<a
										href="${pageContext.request.contextPath}/mailto:example@email.com">info@example.com</a>
								</p>
							</div>
							<div class="last-w3ls-contact my-2">
								<p>+ 456 123 7890</p>
							</div>
							<div class="last-w3ls-contact">
								<p>
									+ 90 nsequursu dsdesdc, <br>xxx Honey State 049436.
								</p>
							</div>
						</div>
					</div>

				</div>

				<p class="copy-right-grids text-li text-center my-sm-4 my-4">
					© 2019 Men spa. All Rights Reserved | Design by <a
						href="http://w3layouts.com/"> W3layouts </a>
				</p>
				<div class="w3ls-footer text-center mt-4">
					<ul class="list-unstyled w3ls-icons">
						<li><a href="${pageContext.request.contextPath}#"> <span
								class="fa fa-facebook-f"></span>
						</a></li>
						<li><a href="${pageContext.request.contextPath}#"> <span
								class="fa fa-twitter"></span>
						</a></li>
						<li><a href="${pageContext.request.contextPath}#"> <span
								class="fa fa-dribbble"></span>
						</a></li>
						<li><a href="${pageContext.request.contextPath}#"> <span
								class="fa fa-vk"></span>
						</a></li>
					</ul>
				</div>
				<div class="move-top text-right">
					<a href="#home" class="move-top"> <span
						class="fa fa-angle-up  mb-3" aria-hidden="true"></span></a>
				</div>
			</div>
			<!-- //footer bottom -->
		</div>
	</footer>
	<!-- //footer -->
</body>
</html>