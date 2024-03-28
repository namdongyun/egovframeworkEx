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
	
	/**
	 * @param boardVO
	 * @return BoardVO
	 * @throws Exception
	 */
	public List<BoardVO> loadBoard(BoardVO boardVO) throws Exception {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.loadBoard(boardVO);
	}
	
	/**
	 * @param boardVO
	 * @throws Exception
	 */
	public void createBoard(BoardVO boardVO) throws Exception {
		
		log.info("BoardDAO.java -> createBoard 실행");
		
	    BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	    mapper.createBoard(boardVO);
	    
	    log.info("BoardDAO.java -> createBoard 실행완료");
	}

}
