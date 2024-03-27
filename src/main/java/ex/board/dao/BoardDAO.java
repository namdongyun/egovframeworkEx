package ex.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ex.board.service.BoardMapper;
import ex.board.vo.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVO> loadBoard(BoardVO boardVO) throws Exception {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.loadBoard(boardVO);
	}
}
