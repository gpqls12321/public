<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bizpoll Shop</title>
<link href="css/shopping.css" rel="stylesheet">
<script type="text/javascript" src="js/member.js"></script>
<!-- <script type="text/javascript" src="js/mypage.js"></script> -->

</head>
<body>
	<div id="wrap">
		<header>
			<div id="logo">
				<a href="index.bizpoll">
					<img alt="" src="images/product_img/w-12.jpg" width="100" height="100">
				</a>
			</div>
			<nav id="catagory_menu">
				<ul>
					<c:choose>
						<c:when test="${empty sessionScope.loginUser}">
							<li><a href="login_form.bizpoll">LOGIN</a></li>
							<li>│</li>
							<li><a href="contract.bizpoll">JOIN</a></li>
						</c:when>
						<c:otherwise>
							<li style="color:orange">
								${sessionScope.loginUser.name}(${sessionScope.loginUser.name})
							</li>
							<li><a href="logout.bizpoll">LOGOUT</a></li>
						</c:otherwise>
					</c:choose>
					<li>│</li>
					<li><a>CART</a></li>
					<li>│</li>
					<li><a>MY PAGE</a></li>
					<li>│</li>
					<li><a>Q&amp;A(1:1)</a></li>
					<li>│</li>
					<li><a>APP</a></li>
					<li>│</li>
					<li><a href="boardList.bizpoll">BOARD</a></li>
					<li>│</li>
					<c:choose>
						<c:when test="${empty sessionScope.loginUser}">
						</c:when>
						<c:otherwise>
							<li><a href="delete_form.bizpoll">탈퇴</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</header>
	</div>
</body>
</html>