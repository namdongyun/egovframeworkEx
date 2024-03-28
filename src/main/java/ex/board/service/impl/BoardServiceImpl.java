package ex.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.board.dao.BoardDAO;
import ex.board.service.BoardService;
import ex.board.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	// 게시글 불러오기
	@Override
	public List<BoardVO> loadBoard(BoardVO boardVO) throws Exception {
		
		return boardDAO.loadBoard(boardVO);
	}
	
	// 게시글 등록
	@Override
	public void createBoard(BoardVO boardVO) throws Exception {
		
		log.info("createBoard service 실행");
		
		boardDAO.createBoard(boardVO);
		
		log.info("createBoard service 실행완료");
	}
	
}
