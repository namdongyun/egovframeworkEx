package ex.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ex.board.service.BoardService;
import ex.board.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	@Autowired
	private BoardService boardService;

    // 게시글 목록 조회
    @GetMapping("/list")
    public String list(BoardVO boardVO, Model model) throws Exception {
    	// 로그
    	log.info("started GET /list");
    
        // 게시글 목록을 조회하는 서비스 로직을 호출하여 Model에 추가
    	model.addAttribute("list", boardService.loadBoard(boardVO));
    	
    	log.info("ended GET /list");
    	
        return "board/list";
    }
    
    // 게시글 생성 페이지
    @GetMapping("/create")
    public String showCreateForm(Model model) throws Exception {
    	// 로그
    	log.info("started GET /create");
    	
    	model.addAttribute("boardVO", new BoardVO());
    	
    	log.info("ended GET /create");
    	
    	return "board/createBoard";
    }
    
    // 게시글 생성 버튼 클릭
    @PostMapping("/createBoard")
    public String createBoard(@ModelAttribute BoardVO boardVO) throws Exception {
    	// 로그
    	log.info("게시글 생성 시작 POST /createBoard");
    	System.out.println(boardVO.toString());
        boardService.createBoard(boardVO);
    	
    	log.info("게시글 생성 완료 POST /createBoard");
    	
        return "redirect:/board/list";
    }
}
