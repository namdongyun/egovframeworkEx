package ex.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @GetMapping("/create")
    public String showCreateForm(Model model) throws Exception {
    	
    	model.addAttribute("post", new BoardVO());
    	return "board/createPost";
    }
    
    @PostMapping("/create")
    public String createPost(@ModelAttribute BoardVO boardVO) {
        // 여기에서 postDto에 바인딩된 데이터를 사용하여 게시글을 생성하는 로직을 구현합니다.
        // 예제에서는 단순히 생성 로직을 생략하고, 생성 완료 후 게시판 목록 페이지로 리다이렉트합니다.
        return "redirect:/board/list";
    }
}
