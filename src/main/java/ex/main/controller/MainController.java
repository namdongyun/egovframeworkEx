package ex.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/testList.do")
	public String testListDo() {
		return "test/testList";
	}
	
	@RequestMapping("/mainPage.do")
	public String mainPageDo() {
		return "mainPage/mainPage";
	}
}
