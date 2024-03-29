package ex.board.service;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import ex.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	List<BoardVO> loadBoard(BoardVO boardVO) throws Exception;	// 게시글 불러오기
	int countTotalBoardElements() throws Exception; // 게시글 전체 데이터 개수 불러오기
	void createBoard(BoardVO boardVO) throws Exception;	// 게시글 등록하기
	BoardVO getBoard(int id) throws Exception;	// 게시글 상세보기
	void deleteBoard(int id) throws Exception;	// 게시글 삭제
	void editBoard(BoardVO boardVO) throws Exception;
}
