package ex.board.service;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import ex.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	List<BoardVO> loadBoard(BoardVO boardVO) throws Exception;
}
