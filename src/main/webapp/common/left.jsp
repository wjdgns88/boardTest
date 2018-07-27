<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/boardList">게시판 생성 <span class="sr-only">(current)</span></a></li>
<!-- 		<li class="active"><a href="#">사용자</a></li> -->
		<c:forEach items="${boardList }" var="list">
		
			<c:if test="${list.board_delet == '1'.charAt(0)}">
				<li><a href="/postList?page=1&pageSize=10&boardId=${list.board_id }">${list.board_name }</a></li>
			</c:if>
		</c:forEach>
<!-- 		<li><a href="/studentList?page=1&pageSize=10">학생</a></li> -->
	</ul>
</div>