<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>게시글 상세</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/resources/css/board/detailBoard.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
<!-- 댓글 섹션 시작 -->
<div class="comment-section">
    <h3>댓글</h3>
    
    <!-- 댓글 목록 -->
    <div class="comments-list">
        <c:forEach var="comment" items="${commentList}">
            <div class="comment-item">
                <strong>${comment.userName}</strong> <span>${comment.date}</span>
                <p>${comment.content}</p>
            </div>
        </c:forEach>
    </div>
    
    <!-- 댓글 입력 폼 -->
    <form id="createComment">
        <input type="hidden" name="boardId" value="${boardVO.id}"> <!-- 게시글 ID, 필요에 따라 수정 -->
        <div class="form-group">
            <label for="commentName">이름:</label>
            <input type="text" id="commentName" name="userName" required>
        </div>
        <div class="form-group">
            <label for="commentContent">댓글:</label>
            <textarea id="commentContent" name="content" rows="4" required></textarea>
        </div>
        <input type="button" value="댓글달기" class="create-comment"/>
    </form>
    
</div>
<!-- 댓글 섹션 끝 -->
<script type="text/javascript">
	$(document).on("click", ".create-comment", function(){
		
		var formData = {
				userName: $('#commentName').val(),
		        content: $('#commentContent').val(),
		        boardId: $('input[name=boardId]').val()
		    };
		
		$.ajax({
			url : "/comment/create",
			type : "POST",
			data : JSON.stringify(formData),
			contentType: "application/json; charset=UTF-8",
			dataType: 'json',
		})
		.done(function(response) {
			console.log("save formData : ", formData);
        	console.log(response);
        })
        .fail(function(response) {
        	console.log("formData : ", formData);
            console.error(response);
        });	
	});
</script>


</body>
</html>
