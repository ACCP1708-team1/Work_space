<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="home" tagdir="/WEB-INF/tags/default/home"%>
<!-- banner -->
<div class="banner_w3lspvt" id="home">
	<div class="csslider infinity" id="slider1">
		<input type="radio" name="slides" checked="checked" id="slides_1" />
		<input type="radio" name="slides" id="slides_2" /> <input
			type="radio" name="slides" id="slides_3" /> <input type="radio"
			name="slides" id="slides_4" />

		<ul class="banner_slide_bg">
			<li>
				<div class="slider-info bg1">
					<div class="bs-slider-overlay">
						<div class="banner-text">
							<div class="container">
								<h2 class="movetxt agile-title text-capitalize">We Create
									and Renovate Hair Style Trends</h2>
								<p>Lorem Ipsum is simply dummy text of the printing and
									typesetting industry. It has survived not only five centuries.</p>
								<a href="contact.html" class="btn"> Get appointment </a>
							</div>
						</div>
					</div>
				</div>
			</li>
			<li>
				<div class="slider-info bg2">
					<div class="bs-slider-overlay1">
						<div class="banner-text">
							<div class="container">
								<h4 class="movetxt agile-title text-capitalize">We Help to
									grow your hair as well beard</h4>
								<p>Lorem Ipsum is simply dummy text of the printing and
									typesetting industry. It has survived not only five centuries.</p>
								<a href="contact.html" class="btn">Get appointment </a>
							</div>
						</div>
					</div>
				</div>
			</li>
			<li>
				<div class="slider-info bg3">
					<div class="bs-slider-overlay1">
						<div class="banner-text">
							<div class="container">
								<h2 class="movetxt agile-title text-capitalize">We Design
									and Create Hair Style Latest</h2>
								<p>Lorem Ipsum is simply dummy text of the printing and
									typesetting industry. It has survived not only five centuries.</p>
								<a href="contact.html" class="btn"> Get appointment</a>
							</div>
						</div>
					</div>
				</div>
			</li>
			<li>
				<div class="slider-info bg4">
					<div class="bs-slider-overlay1">
						<div class="banner-text">
							<div class="container">
								<h4 class="movetxt agile-title text-capitalize">We design
									latest trending haircuts</h4>
								<p>Lorem Ipsum is simply dummy text of the printing and
									typesetting industry. It has survived not only five centuries.</p>
								<a href="contact.html" class="btn"> Get appointment </a>
							</div>
						</div>
					</div>
				</div>
			</li>
		</ul>
		<div class="navigation">
			<div>
				<label for="slides_1"></label> <label for="slides_2"></label> <label
					for="slides_3"></label> <label for="slides_4"></label>
			</div>
		</div>
	</div>
</div>
<!-- //banner -->
<!-- banner bottom grids -->
<section class="content-info py-5" id="about">
	<div class="container py-md-5">
		<h3 class="heading text-center mb-3 mb-sm-5">About us</h3>

		<div class="info-w3pvt-mid text-center px-lg-5">

			<div class="title-desc text-center px-lg-5">
				<img
					src="${pageContext.request.contextPath }/resources/image/about1.png"
					alt="news image" class="img-fluid">
				<p class="px-lg-5">Praesent ullamcorper dui turpis.At vero eos
					et accusam et justo duo dolores et ea rebum.Integer sit amet mattis
					quam, sit amet ultricies velit. Praesent ullamcorper dui turpis.
					Praesent ullamcorper dui turpis.At vero eos et accusam et justo duo
					dolores et ea rebum.Integer sit amet mattis quam, sit amet
					ultricies velit. Praesent ullamcorper dui turpis.</p>
				<a class="btn mt-lg-4 mt-3 read scroll" href="#services"
					role="button">Learn More</a>
			</div>
		</div>
	</div>
</section>
<!-- //banner bottom grids -->

<!-- /Category -->
<section class="services py-5" id="services">
	<div class="container py-md-5">
		<h3 class="heading text-center mb-3 mb-sm-5">Services</h3>
		<div class="row ab-info">
			<!-- 			Show List category -->
			<c:forEach items="${categories }" var="category">
				<home:home_category category="${category }"></home:home_category>
			</c:forEach>
		</div>
	</div>
</section>
<!-- /Category -->

<!-- Project -->
<section class="pricing py-5">
	<div class="container py-md-5">
		<h3 class="heading text-capitalize text-center mb-3 mb-sm-5">List
			Project</h3>
		<div class="row pricing-grids">
			<!-- 			Show Project  -->
			<c:if test="${projectStatus!=null }">
				<c:forEach var="projectStatu" items="${projectStatus }">
					<home:home_project projectStatus="${projectStatu }"></home:home_project>
				</c:forEach>
			</c:if>
		</div>
	</div>
</section>
<!-- //Project -->
<!--/order-now-->
<section class="order-sec py-5">
	<div class="container py-md-5">
		<div class="test-info text-center">
			<h3 class="tittle order">
				<span>CALL US TO BOOK An APPOINTMENT</span>Our team will call back
				immediately and Book the Appointment
			</h3>
			<h4 class="tittle my-2">123456789</h4>

			<div class="read-more mx-auto m-0 text-center">
				<a href="contact.html" class="read-more scroll btn">Click here</a>
			</div>
		</div>
	</div>
</section>
<!--//order-now-->

<!--/testimonials-->
<section class="testimonials py-5" id="testimonials">
	<!-- 	Client review -->
	<home:home_review></home:home_review>
</section>

<!--//testimonials-->
<!-- subscribe -->
<section class="subscribe" id="subscribe">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-5 d-flex subscribe-left p-lg-5 py-sm-5 py-4">
				<div class="news-icon mr-3">
					<span class="fa fa-paper-plane" aria-hidden="true"></span>
				</div>
				<div class="text">
					<h3>Subscribe To Our Newsletter</h3>
				</div>
			</div>
			<div class="col-md-7 subscribe-right p-lg-5 py-sm-5 py-4">
				<form action="#" method="post">
					<input type="email" name="email"
						placeholder="Enter your email here" required="">
					<button class="btn1">
						<span class="fa fa-paper-plane" aria-hidden="true"></span>
					</button>
				</form>
				<p>we never share your email with anyone else</p>
			</div>
		</div>
	</div>
</section>
<!-- //subscribe -->