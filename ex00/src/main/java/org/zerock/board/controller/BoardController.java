package org.zerock.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.service.BoardService;
import org.zerock.board.vo.BoardVO;
import org.zerock.util.PageObject;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	@Qualifier("boardServiceImpl")
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
	public String write(BoardVO vo, RedirectAttributes rttr) {
		log.info(vo);
		service.write(vo);
		rttr.addFlashAttribute("msg", "글등록완");
		return "redirect:/board/list";
	}
	
	//http://localhost/board/view?no=41
	@GetMapping("/view")
	public String view(Model model, Long no) {
		service.increase(no);
		model.addAttribute("vo", service.view(no));
		return "board/view";
	}
	
	@GetMapping("/update")
	public String update(Model model, Long no) {
		model.addAttribute("vo", service.view(no));
		return "board/update";
	}
	
	@PostMapping("/update")
	public String update(BoardVO vo, RedirectAttributes rttr) {
		if (service.update(vo) == 1)
			rttr.addFlashAttribute("msg", "글수정완");
		else
			rttr.addFlashAttribute("msg", "비밀번호가 틀림");
		
		return "redirect:/board/view/?no="+vo.getNo();
	}
	
	@GetMapping("/delete")
	public String delete(Long no, RedirectAttributes rttr) {
		
		if (service.delete(no) == 1)
			rttr.addFlashAttribute("msg", "글수정완");
		else
			rttr.addFlashAttribute("msg", "비밀번호가 틀림");
		
		return "redirect:/board/list";
	}
}
