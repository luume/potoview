<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="/WEB-INF/custom-tags/boardPaging.tld"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border-radius: 5px;
}

.pagination a:hover:not (.active ) {
	background-color: #ddd;
	border-radius: 5px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">


		<h2>포트폴리오 게시판</h2>
		<br>
		<table class="table table-hover">
			<thead>
				<tr>
					<th style="width: 25%">글번호</th>
					<th style="width: 50%">제목</th>
					<th style="width: 25%">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${pageList.list }" varStatus="status">
					<c:choose>
						<c:when test="${status.count % 3 eq 0 }">
							<tr class="info">
								<td>${i.pv_board_idx }</td>
								<td><a href="selectByIdx?idx=${i.pv_board_idx }">${i.title }</a></td>
								<td>${i.regDate }</td>
							</tr>
						</c:when>
						<c:when test="${status.count % 3 eq 1 }">
							<tr class="warning">
								<td>${i.pv_board_idx }</td>
								<td><a href="selectByIdx?idx=${i.pv_board_idx }">${i.title }</a></td>
								<td>${i.regDate }</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr class="active">
								<td>${i.pv_board_idx }</td>
								<td><a href="selectByIdx?idx=${i.pv_board_idx }">${i.title }</a></td>
								<td>${i.regDate }</td>
							</tr>
						</c:otherwise>
					</c:choose>

				</c:forEach>


			</tbody>
		</table>
		<div style="text-align: center;">
			<my:paging endPage="${pageList.endPage }" startPage="${pageList.startPage }" pageList="${pageList }" />
		</div>
		
		<div class="row">    
        <div class="col-xs-8 col-xs-offset-2">
            <div class="input-group">
                <div class="input-group-btn search-panel">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <span id="search_concept">검색조건</span> <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                      <li><a href="#contains">내용</a></li>
                      <li><a href="#its_equal">제목</a></li>
                      <li><a href="#less_than">날짜 </a></li>
                      <li class="divider"></li>
                      <li><a href="#all">모두</a></li>
                    </ul>
                </div>
                <input type="hidden" name="search_param" value="all" id="search_param">         
                <input type="text" class="form-control" name="x" placeholder="검색어를 넣어주세요..">
                <span class="input-group-btn">
                    <button class="btn btn-info" type="button"><span class="glyphicon glyphicon-search"></span></button>
                </span>
            </div>
        </div>
    </div>
		
		
	</div>
</body>
</html>