package ex.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.board.dao.BoardDAO;
import ex.board.service.BoardService;
import ex.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> loadBoard(BoardVO boardVO) throws Exception {
		
		return boardDAO.loadBoard(boardVO);
	}
	
}
