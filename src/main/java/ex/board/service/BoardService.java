package ex.board.service;

import java.util.List;

import ex.board.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> loadBoard(BoardVO boardVO) throws Exception;
	public void createBoard(BoardVO boardVO) throws Exception;

}
