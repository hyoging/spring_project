<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/img_view.js"></script>

</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ include file="../default/header.jsp"%>
		<h1>글쓰기</h1>
		
		<form action="writeSave" method="post" enctype="multipart/form-data">
			<h3>작성자</h3>
			<input type="text" name=id value="${login }" readonly><br>
			<hr>
			<h3>제목</h3>
			<input type="text" name=title><br>
			<hr>
			<h3>내용</h3>
			<textarea name="content"></textarea><br>
			<hr>
			<h3>이미지 파일 첨부</h3>
			<input type="file" name="image_file_name" onchange="readURL(this)"><br>
			 <img id="preview" width="100" height="100" alt="선택없음">
			<hr>
			<input type="submit" value="등록"><br>
			<a href="boardAllList">목록이동</a>
			
		</form>
</body>
</html>