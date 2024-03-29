<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>게시글 상세</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Noto Sans KR', sans-serif;
            background-color: #f9f9f9;
            color: #333;
        }
        .board-detail {
            width: 80%;
            margin: 40px auto;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            padding: 20px;
            border-radius: 8px;
        }
        .board-detail h2 {
            font-size: 24px;
            color: #333;
            border-bottom: 2px solid #eee;
            padding-bottom: 10px;
            margin-bottom: 20px;
        }
        .board-detail .meta {
            font-size: 14px;
            color: #666;
            text-align: left;
            margin-bottom: 20px;
        }
        .board-detail .content {
            white-space: pre-wrap;
            line-height: 1.6;
            font-size: 16px;
        }
        .navigation {
            text-align: center;
            margin-top: 30px;
        }
        .navigation a {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .navigation a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="board-detail">
    <h2>${boardVO.title}</h2>
    <div class="meta">
        <span>작성자: ${boardVO.name}</span><br>
        <span>작성일: ${boardVO.date}</span>
    </div>
    <div class="content">
        ${boardVO.content}
    </div>
    <form action="/board/delete/${boardVO.id}" method="post">
        <input type="hidden" name="_method" value="delete" />
        <button type="submit" onclick="return confirm('정말로 삭제하시겠습니까?');">게시글 삭제</button>
    </form>
    <form action="/board/edit/${boardVO.id}" method="get">
    	<button type="submit">게시글 수정</button>
	</form>
    <div class="navigation">
        <a href="/board/list">목록으로 돌아가기</a>
    </div>
</div>

</body>
</html>
