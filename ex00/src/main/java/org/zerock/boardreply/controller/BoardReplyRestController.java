package org.zerock.boardreply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
