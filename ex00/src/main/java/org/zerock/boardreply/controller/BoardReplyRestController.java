package org.zerock.boardreply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.boardreply.service.BoardReplyService;
import org.zerock.boardreply.vo.BoardReplyVO;
import org.zerock.util.PageObject;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/boardreply")
@Log4j
public class BoardReplyRestController {
	
	@Autowired
	@Qualifier("boardReplyServiceImpl")
	private BoardReplyService service;
	
	//PageObject [page=1, perPageNum=10, startRow=1, endRow=10, perGroupPageNum=10, startPage=1, endPage=1, totalPage=0, totalRow=0, key=null, word=null, period=pre]
	//http://localhost/boardreply/list?no=61
	@GetMapping(value = "list", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Map<String, Object>> list(PageObject pageObject, Long no) {
		log.info("list");
		log.info(pageObject);
		
		List<BoardReplyVO> list = service.list(pageObject, no);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		log.info(map);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@GetMapping(value = "/get", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<String> get() {
		 
		return null;
	}

	// json으로 보낼때는 @RequestBody 어노테이션을 붙여야함
	@PostMapping(value = "/write", consumes = "application/json", produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> write(@RequestBody BoardReplyVO vo, HttpSession session) {
		log.info("write");
		log.info(vo); 
		// BoardReplyVO(rno=null, no=null, content=null, id=null, writedate=null, name=null)
		//BoardReplyVO(rno=null, no=61, content=dgz, id=null, writedate=null, name=null)
		if (vo.getNo() == null) {
			return new ResponseEntity<String>("전송오류", HttpStatus.BAD_REQUEST);
		}
		vo.setId(getId(session));
		service.write(vo);
		
		return new ResponseEntity<String>("댓글등록완", HttpStatus.OK);
	}

	// rno, content
	@PostMapping(value = "/update", consumes = "application/json", produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> update(@RequestBody BoardReplyVO vo, HttpSession session) {
		
		log.info("update");
		log.info(vo);
		if (vo.getRno() == null) {
			return new ResponseEntity<String>("전송오류", HttpStatus.BAD_REQUEST);
		}
		vo.setId(getId(session));
		Integer result = service.update(vo);
		if (result != 1) return new ResponseEntity<String>("처리오류", HttpStatus.NOT_MODIFIED);
		return new ResponseEntity<String>("댓글수정완", HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete", produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> delete(BoardReplyVO vo, HttpSession session) {
		log.info("delete");
		log.info(vo);
		
		if (vo.getRno() == null) {
			return new ResponseEntity<String>("전송오류", HttpStatus.BAD_REQUEST);
		}
		
		vo.setId(getId(session));
		Integer result = service.delete(vo);
		if (result != 1) return new ResponseEntity<String>("처리오류", HttpStatus.NOT_MODIFIED);
		return new ResponseEntity<String>("댓삭완", HttpStatus.OK);
	}
	
	private String getId(HttpSession session) {
		// LoginVO vo = (LoginVO) session.getAttribute("login");
		// String id = vo.getId();
		return "id1";
	}
}
