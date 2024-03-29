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
            <c:forEach var="board" items="${list}">
                <tr>
                    <td>${board.id}</td>
                    <td><a href="/board/detail/${board.id}">${board.title}</a></td>
                    <td>${board.name}</td>
                    <td>${board.date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <!-- 페이징 처리 -->
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pageVO.pageNum != 1}">
                <li class="page-item"><a class="page-link" href="?page=${pageVO.pageNum - 1}">이전</a></li>
            </c:if>
            <c:forEach begin="1" end="${pageVO.totalPages}" var="i">
                <li class="page-item ${pageVO.pageNum == i ? 'active' : ''}">
                    <a class="page-link" href="?page=${i}">${i}</a>
                </li>
            </c:forEach>
            <c:if test="${pageVO.pageNum < pageVO.totalPages}">
                <li class="page-item"><a class="page-link" href="?page=${pageVO.pageNum + 1}">다음</a></li>
            </c:if>
        </ul>
    </nav>
    
    <div class="create-button">
    <a href="/board/create">게시글 생성</a>
	</div>
    
</div>
</body>
</html>
