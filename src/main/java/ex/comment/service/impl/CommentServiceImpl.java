package ex.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.board.service.impl.BoardServiceImpl;
import ex.comment.dao.CommentDAO;
import ex.comment.service.CommentService;
import ex.comment.vo.CommentVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDAO commentDAO;

	@Override
	public List<CommentVO> getComment(int boardId) throws Exception {
		
		return commentDAO.getComment(boardId);
	}

	// 댓글 달기 버튼 클릭(commentVO 저장)
	@Override
	public void create(CommentVO commentVO) {
		log.info("CommentService create 메소드 실행");
		
		commentDAO.create(commentVO);
		
		log.info("CommentService create 실행완료");
	}

}
