package ex.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ex.board.service.BoardService;
import ex.board.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

    // 게시글 목록 조회
    @GetMapping("/list")
    public String list(BoardVO boardVO, Model model) throws Exception {
    	
        // 게시글 목록을 조회하는 서비스 로직을 호출하여 Model에 추가
    	model.addAttribute("list", boardService.loadBoard(boardVO));
        
        return "board/list";
    }
}
