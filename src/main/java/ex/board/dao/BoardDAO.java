package ex.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ex.board.service.BoardMapper;
import ex.board.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	/** 게시글 불러오기
	 * @param boardVO
	 * @return BoardVO
	 * @throws Exception
	 */
	public List<BoardVO> loadBoard(BoardVO boardVO) throws Exception {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.loadBoard(boardVO);
	}
	
	/** 전체 게시글 데이터 개수 조회
	 * @return
	 * @throws Exception
	 */
	public int countTotalBoardElements() throws Exception {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.countTotalBoardElements();
	}
	
	/** 게시글 생성
	 * @param boardVO
	 * @throws Exception
	 */
	public void createBoard(BoardVO boardVO) throws Exception {
		
		log.info("BoardDAO.java -> createBoard 실행");
		
	    BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	    mapper.createBoard(boardVO);
	    
	    log.info("BoardDAO.java -> createBoard 실행완료");
	}

	
	/**
	 * @param id
	 * @return 게시글 상세보기
	 * @throws Exception
	 */
	public BoardVO getBoard(int id) throws Exception {
		
		log.info("BoardDAO.java -> getBoard 실행");
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		log.info("BoardDAO.java -> getBoard 실행 완료");
		
		return mapper.getBoard(id);
	}

	/** 
	 * 게시글 삭제
	 * @param id
	 * @throws Exception 
	 */
	public void deleteBoard(int id) throws Exception {
		log.info("BoardDAO.java -> deleteBoard 실행");
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.deleteBoard(id);
		
		log.info("BoardDAO.java -> deleteBoard 실행 완료");
	}

	public void editBoard(BoardVO boardVO) throws Exception {
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.editBoard(boardVO);
		
	}

}
