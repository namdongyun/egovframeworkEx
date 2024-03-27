<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인 페이지</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .header { background-color: #f1f1f1; padding: 20px; text-align: center; }
        .nav { background-color: #333; overflow: hidden; }
        .nav a { float: left; color: white; text-align: center; padding: 14px 16px; text-decoration: none; font-size: 17px; }
        .nav a:hover { background-color: #ddd; color: black; }
        .content { padding: 20px; }
        .footer { background-color: #f1f1f1; padding: 10px; text-align: center; }
    </style>
</head>
<body>

<div class="header">
    <h1>환영합니다!</h1>
    <p>현재 시간: <%= new Date() %></p>
</div>

<div class="nav">
    <a href="board/list">게시판</a>
    <a href="#"></a>
    <a href="#"></a>
    <a href="#"></a>
</div>

<div class="content">
    <h2>메인 컨텐츠 영역</h2>
    <p>이곳은 메인 페이지의 주요 컨텐츠가 위치하는 곳입니다. 사용자가 웹 사이트에서 가장 먼저 보게 될 정보를 배치하세요.</p>
</div>

<div class="footer">
    <p>저작권 © 2024 나의 웹사이트. 모든 권리 보유.</p>
</div>

</body>
</html>
