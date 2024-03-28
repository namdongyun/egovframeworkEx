<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>게시판 목록</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/resources/css/board/list.css">
</head>
<body>
<div class="container">
    <h2>게시판 목록</h2>

    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="result" items="${list}">
                <tr>
                    <td>${result.id}</td>
                    <td><a href="/board/detail/${result.id}">${result.title}</a></td>
                    <td>${result.name}</td>
                    <td>${result.date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <div class="create-button">
    <a href="/board/create">게시글 생성</a>
	</div>
    
</div>
</body>
</html>
