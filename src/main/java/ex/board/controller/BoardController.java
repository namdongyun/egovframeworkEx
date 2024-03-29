package ex.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ex.board.service.BoardService;
import ex.board.vo.BoardVO;
import ex.cmmn.vo.PageVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	@Autowired
	private BoardService boardService;

    // 전체 게시글 목록 조회
    @GetMapping("/list")
    public String loadBoard(@RequestParam(value = "page", defaultValue = "1") int page, Model model) throws Exception {
    	
    	log.info("게시글 목록 조회 GET /list");
    	
    	BoardVO boardVO = new BoardVO();
    	boardVO.setPageNum(page);
    	
    	List<BoardVO> boardList = boardService.loadBoard(boardVO);
    	
    	log.info("pageVO : {}, {}", boardVO.getPageNum(), boardVO.getPageSize());
    	
    	log.info(boardList.toString());
    	
    	PageVO pageVO = (PageVO) boardVO;
    	
    	
        // 게시글 목록을 조회하는 서비스 로직을 호출하여 Model에 추가
    	model.addAttribute("list", boardList);
    	model.addAttribute("pageVO", pageVO);
    	
    	log.info("게시글 목록 조회 GET /list 완료");
    	
        return "board/list";
    }
    
    // 게시글 들어가기
    @GetMapping("/detail/{id}")
    public String boardDetail(@PathVariable("id") int id, Model model) throws Exception {
    	
    	log.info("게시글 들어가기 GET /detail/{id}");
    	
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("boardVO", boardVO);
        
        log.info("게시글 들어가기 GET /detail/{id} 완료");
        
        return "board/detailBoard";
    }
    
    // 게시글 생성 페이지
    @GetMapping("/create")
    public String showCreateBoard(Model model) throws Exception {
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
    	log.info(boardVO.toString());
        boardService.createBoard(boardVO);
    	
    	log.info("게시글 생성 완료 POST /createBoard");
    	
        return "redirect:/board/list";
    }
    
    // 게시글 수정 페이지
    @GetMapping("/edit/{id}")
    public String showEditBoard(@PathVariable("id") int id, Model model) throws Exception {
    	
    	BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("boardVO", boardVO);
        
    	return "board/editBoard";
    }
    
    // 게시글 수정 POST
    @PostMapping("/editBoard/{id}")
    public String editBoard(@PathVariable("id") int id, @ModelAttribute BoardVO boardVO) throws Exception {
    	log.info("게시글 수정 시작 POST /editBoard/{id}");
    	
    	boardService.editBoard(id, boardVO);
        
    	return "redirect:/board/detail/{id}";
    }
    
    // 게시글 삭제 버튼 클릭
    @PostMapping("/delete/{id}")
    public String deleteBoard(@PathVariable("id") int id) throws Exception {
        // 게시글 삭제 로직 수행
        boardService.deleteBoard(id);

        // 게시글 목록 페이지로 리다이렉트
        return "redirect:/board/list";
    }
}
