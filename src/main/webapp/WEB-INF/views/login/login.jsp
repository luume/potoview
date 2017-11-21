<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>




<div class="login-card"><img src="./resources/assets/img/avatar_2x.png" class="profile-img-card" />
    <p class="profile-name-card"> </p>
    <form class="form-signin" method="post" action="${pageContext.request.contextPath}/mylogin"><span class="reauth-email"> </span>
    <div>이 페이지는 관리자 전용 화면입니다.</div>
    <div>로그인해주세요.(adim/0000)</div>
        <input class="form-control" type="text" required placeholder="계정명" autofocus id="userName" name="userName" />
        <input class="form-control" type="password" required placeholder="비밀번호" id="password" name="password" />
        <button class="btn btn-primary btn-block btn-lg btn-signin" type="submit">로그인</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
 
    </form></div>


</body>
</html>