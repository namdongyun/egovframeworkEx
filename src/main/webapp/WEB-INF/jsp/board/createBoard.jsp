<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>게시글 생성</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/resources/css/board/createBoard.css">
</head>
<body>

<div class="wrapper">
    <div id="contentWrapper" class="content">
        <h2>게시글 생성</h2>
        <!-- 폼 태그 추가 -->
        <form action="/board/createBoard" method="post">
            <div class="inputBox">
                <label for="name">작성자</label>
                <input type="text" id="name" name="name" placeholder="작성자 이름 입력">
            </div>
            <div class="inputBox">
                <label for="title">제목</label>
                <input type="text" id="title" name="title" placeholder="제목 입력">
            </div>
            <div class="inputBox">
                <label for="content">내용</label>
                <textarea id="content" name="content" placeholder="내용 입력"></textarea>
            </div>
            <!-- 제출 버튼 -->
            <button type="submit">게시글 생성</button>
        </form>
    </div>
</div>

</body>
</html>
