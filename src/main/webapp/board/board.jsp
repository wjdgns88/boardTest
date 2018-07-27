<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/common/top.jsp"%>

	<form id="frm" action="/boardUpdate" method="get">
		<input type="hidden" name="id" id="id">

		<div class="container-fluid">
			<div class="row">
	
				<%@ include file="/common/left.jsp"%>
	
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	
					<div class="text-center">
						게시판 이름<input type="text" name="boardName">
						<select name="select">
							<option value="1">사용</option>
							<option value="0">미사용</option>
						</select> <input type="submit" name="button" value="insert">
					</div>
					</div>
				</div>
			</div>
	</form>
		<div class="container-fluid">
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<c:forEach items="${boardList }" var="list">
						<form id="frm" action="/boardUpdate" method="get">
					<br>
						<div class="text-center">
							게시판 이름<input type="text" name="upboardName" value="${list.board_name }">
						<select name="select">
							<option value="1">사용</option>
							<option value="0">미사용</option>
						</select> 
						<input type="hidden" name="boardnum" value="${list.board_id }">
						<input type="submit" name="button" value="update">
					</div>
					</form>
					</c:forEach>
					</div>
			</div>
	<%@ include file="/common/top.jsp"%>
	<%@ include file="/common/left.jsp"%>
</body>
</html>