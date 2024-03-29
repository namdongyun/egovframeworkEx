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
		
		// 전체 게시글 데이터 수 조회
        int totalElements = boardDAO.countTotalBoardElements();
		
        log.info("totalElements : {}", totalElements);
        // 전체 데이터 수 설정
        boardVO.setTotalElements(totalElements);
        
		// 현재 페이지 번호와 페이지당 게시글 수를 기반으로 offset 값을 계산
	    boardVO.calculateOffset();
	    
	    // offset를 기반으로 총 페이지 수를 계산하고 설정
	    boardVO.calculateTotalPages();
	    
		return boardDAO.loadBoard(boardVO);
	}
	
	// 게시글 등록
	@Override
	public void createBoard(BoardVO boardVO) throws Exception {
		
		log.info("createBoard service 실행");
		
		boardDAO.createBoard(boardVO);
		
		log.info("createBoard service 실행완료");
	}

	// 게시글 상세보기
	@Override
	public BoardVO getBoard(int id) throws Exception {
		
		return boardDAO.getBoard(id);
	}

	// 게시글 삭제
	@Override
	public void deleteBoard(int id) throws Exception {
		
		boardDAO.deleteBoard(id);
	}
	
	// 게시글 수정
	@Override
	public void editBoard(int id, BoardVO boardVO) throws Exception {
		
		boardVO.setId(id);
		boardDAO.editBoard(boardVO);
		
	}
	
}
