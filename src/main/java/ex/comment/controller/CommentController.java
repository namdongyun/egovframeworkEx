package ex.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ex.comment.service.CommentService;
import ex.comment.vo.CommentVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	// 댓글 달기 버튼 클릭(commentVO 저장)
    @PostMapping("/create")
    @ResponseBody
    public CommentVO createComment(@RequestBody CommentVO commentVO) throws Exception {
    	// 로그
    	log.info("댓글 생성 시작 POST /comment/create");
    	log.info("{}", commentVO);
    	
    	commentService.create(commentVO);
    	
    	log.info("댓글 생성 완료 POST /comment/create");
    	
    	// jsp에 response 전달
    	return commentVO;
    }

}
