<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시판 목록</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="list.css"> <!-- 여기에 CSS 파일을 참조하는 코드를 추가합니다 -->
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
            <c:forEach var="result" items="${list }">
                <tr>
                    <td>${result.id}</td>
                    <td><a href="/board/detail?id=${result.id}">${result.title}</a></td>
                    <td>${result.name}</td>
                    <td>${result.date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
