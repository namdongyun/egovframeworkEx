package ex.comment.service;

import java.util.List;

import ex.board.vo.BoardVO;
import ex.comment.vo.CommentVO;

public interface CommentService{

	public List<CommentVO> getComment(int boardId) throws Exception;

	public void create(CommentVO commentVO);

}
