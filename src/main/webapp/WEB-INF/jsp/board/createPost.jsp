<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 생성</title>
</head>
<body>
<h2>게시글 생성</h2>

<form:form modelAttribute="post" method="post">
    <form:label path="title">제목</form:label>
    <form:input path="title" />

    <form:label path="content">내용</form:label>
    <form:textarea path="content" />

    <button type="submit">게시글 생성</button>
</form:form>

</body>
</html>
