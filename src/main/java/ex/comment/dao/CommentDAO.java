package ex.comment.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ex.board.service.BoardMapper;
import ex.comment.service.CommentMapper;
import ex.comment.vo.CommentVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private CommentMapper mapper;
	
	@PostConstruct
    public void init() {
        mapper = sqlSession.getMapper(CommentMapper.class);
    }

	/**
	 * @param id
	 * @return 해당 id 게시글의 댓글들 불러오기
	 * @throws Exception
	 */
	public List<CommentVO> getComment(int boardId) throws Exception {
		
		return mapper.getComment(boardId);
	}

	
	/** 댓글 달기 버튼 클릭(commentVO 저장)
	 * @param commentVO
	 */
	public void create(CommentVO commentVO) {
		log.info("CommentDAO -> create 실행");
		
	    mapper.create(commentVO);
	    
	    log.info("CommentDAO -> create 실행완료");
	}

}
