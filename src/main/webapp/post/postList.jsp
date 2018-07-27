<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">
<script>
	$(function(){
		$("table tbody tr").on("click", function(){
			//tr태그의 data-id 속성 값을 읽어서 input 태그의 id 값으로 설정
			//form 태그를 submit
			$("#id").val($(this).data("id"));
			$("#frm").submit();
		});
	});
</script>

</head>

<body>
	<%@ include file="/common/top.jsp"%>
	
	<form id="frm" action="/postDetail" method="get">
		<input type="hidden" name="id" id="id">
	</form>
	
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header"></h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>게시글 번호</th>
										<th>제목</th>
										<th>작성자 아이디</th>
										<th>작성일시</th>
									</tr>
								</thead>
								<%
// 									for (StudentVo vo1 : (List<StudentVo>) request.getAttribute("studentList")) {
// 										pageContext.setAttribute("vo", vo1);
								%>
<!-- 								<tr> -->
<%-- 									<td><%=vo.getId()%></td> --%>
<%-- 									<td><%=vo.getName()%></td> --%>
<%-- 									<td><%=vo.getcall_cnt()%></td> --%>
<!-- 								</tr> -->
								<tbody>
									<c:forEach items="${postList }" var="vo">
									<%-- tr 태그 클릭시 상세 페이지로 이동 --%>
									<c:choose>
										<c:when test="${vo.post_delet eq '1'.charAt(0) }">
										<tr data-id="${vo.post_id }" id="click">
											<td>${vo.post_id }</td>
											<td>${vo.post_title }</td>
											<td>${vo.id }</td>
											<td><fmt:formatDate value="${vo.post_dt }" pattern="yyyy-MM-dd"/></td>
										</tr>
										</c:when>
											<c:otherwise>
											<tr>
												<td>삭제된 게시글입니다.</td>
											<tr>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</tbody>

							</table>
						</div>
<%-- 						<input type="hidden" name="board_id" value="${postList }"> --%>
						<a class="btn btn-default pull-right" href="/SE2/index.jsp">새글 등록</a>
						<div class="text-center">
							<ul class="pagination">
								<%=request.getAttribute("pageNavi")%>
							</ul>
						</div>
						<div class="text-center">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
