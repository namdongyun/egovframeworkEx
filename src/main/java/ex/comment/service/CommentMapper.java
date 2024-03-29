package ex.comment.service;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import ex.comment.vo.CommentVO;

@Mapper
public interface CommentMapper {

	List<CommentVO> getComment(int boardId) throws Exception;
	void create(CommentVO commentVO);

}
