<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>

<body>
	<%@ include file="/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" class="form-horizontal" action="/postUpdate" method="get">

					<input type="hidden" name="id" value="${postVo.post_id }">

					<!-- 					<div class="form-group"> -->
					<!-- 						<label for="id" class="col-sm-2 control-label">프로필</label> -->
					<!-- 						<div class="col-sm-10"> -->
					<%-- 							<img src="/pic?id=${studentVo.id  }"> --%>
					<!-- 						</div> -->
					<!-- 					</div> -->
					<div class="form-group">
						<label for="title" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${postVo.post_title }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<label class="control-label">${postVo.post_content}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<c:forEach items="${fileList }" var="list">
<%-- 								<label class="control-label">${list.file_up}</label><br> --%>
								<a href="/fileDownload?fileName=${list.file_name }&fileup=${list.file_up}">${list.file_up }</a><br>
							</c:forEach>
							<div class="col-sm-offset-2 col-sm-10">
							<c:choose>
							<c:when test="${postVo.id == userVo.id }">
								<button type="submit" class="btn btn-default" value="updata" name="btn">수정</button>
								<button type="submit" class="btn btn-default" value="delete" name="btn">삭제</button>
							</c:when>
							<c:otherwise>
								<button type="submit" class="btn btn-default" value="updata" name="btn" disabled="disabled">수정</button>
								<button type="submit" class="btn btn-default" value="delete" name="btn" disabled="disabled">삭제</button>
							</c:otherwise>
							</c:choose>
								
								<button type="submit" class="btn btn-default" value="reply" name="btn">답글</button>
							</div>
						</div>
					</div>
				</form>

					<div class="form-group">
						<label for="content" class="col-sm-2 control-label"
							style="margin-top: 50px">댓글</label>
						<div class="col-sm-10">
							<c:forEach items="${tagList }" var="list">
								<form id="frm1" class="form-horizontal" action="/tagInsert" method="get">
								<c:choose>
									<c:when test="${list.tag_delet == '1'.charAt(0) }">
										<label class="control-label">${list.tag_content }</label>
								
								<c:forEach items="${student }" var="studentList">
									<c:if test="${list.id ==  studentList.id}">
										<label>[${studentList.std_id }</label>
									</c:if>
								</c:forEach>
								
								/<label><fmt:formatDate value="${list.tag_dt }" pattern="yy/MM/dd" /> ]</label>
								
								<c:if test="${userVo.id == list.id}">
								<input type="hidden" name="tagnum" value="${list.tag_id }">
									<input type="submit" name="delete" value="삭제" class="btn btn-default">
								</c:if>
									</c:when>
									<c:otherwise>
										<label class="control-label">삭제된 댓글입니다...</label>
									</c:otherwise>
								</c:choose>
								<br>
								</form>
							</c:forEach>
						</div>
					</div>
				<form id="frm1" class="form-horizontal" action="/tagInsert" method="get">
					<div class="form-group" style="margin-top: 50px">
						<input type="text" name="tag" style="margin-right: 10px">
						<button type="submit" class="btn btn-default">댓글 저장</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
