package org.zerock.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.board.service.BoardService;
import org.zerock.board.vo.BoardVO;
import org.zerock.util.PageObject;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	//public String list(HttpServletRequest request) {
	public String list(Model model, HttpServletRequest request) {
		log.info("list");
		//request.setAttribute("list", service.list());
		
		PageObject pageObject = PageObject.getInstance(request);
		model.addAttribute("pageObject", pageObject);
		
		model.addAttribute("list", service.list(pageObject));
		return "board/list";
		//3
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("list");
		//4
		/*ModelAndView mav = new ModelAndView("list");
		mav.addObject("list", service.list());
		
		return mav;*/
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(BoardVO vo) {
		log.info(vo);
		service.write(vo);
		return "redirect:/board/list";
	}
	
	//http://localhost/board/view?no=41
	@GetMapping("view")
	public String view(Model model, Long no) {
		service.increase(no);
		model.addAttribute("vo", service.view(no));
		return "board/view";
	}
}
