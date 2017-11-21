<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script> -->
<script type="text/javascript">
	$(function() {

		var showImg = ${showImg}
		console.log("쇼이미지 : " + showImg);
		if (showImg == 1) {
			//alert("넘어왓다");
			$("#loginImg").attr("src", "./resources/assets/img/avatar.jpg");
		} else {
			$("#loginImg").attr("src", "./resources/assets/img/avatar_2x.png");
		}
	})
	
	function logOutSubmit(){
		$("#logOutForm").submit();
	}
</script>

</head>
<body>

	<nav class="navbar navbar-default custom-header">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand navbar-link" href="index">Company<span>logo
				</span>
				</a>
				<button class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#navbar-collapse">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav links">
					<li role="presentation"><a href="index">이력사항 </a></li>
					<li role="presentation"><a href="boardList">Portfolio게시판 </a></li>
					<li id="uploadView" role="presentation"><a href="uploadForm">
							업로드</a></li>
					<!--  <li role="presentation"><a href="#" class="custom-navbar"> Roles<span class="badge">new</span></a></li> -->
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false" href="#"> <span
							class="caret"></span><img id="loginImg"
							src="./resources/assets/img/avatar_2x.png" class="dropdown-image"></a>
						<ul class="dropdown-menu dropdown-menu-right" role="menu">
							<li role="presentation"><a href="#"> &nbsp; </a></li>
							<li role="presentation"><a href="#"> &nbsp; </a></li>
							<c:if test="${showImg == 0 || showImg==undefi}">
								<li role="presentation" class="active"><a href="login">login</a></li>
							</c:if>
							<c:if test="${showImg == 1 }">
								<form id="logOutForm" action="${pageContext.request.contextPath }/mylogout" method="post">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									<li role="presentation" class="active"><a href="#" onclick="logOutSubmit()">logout</a></li>
								</form>
							</c:if>							
						</ul></li>
				
				</ul>
			</div>
		</div>
	</nav>

</body>
</html>