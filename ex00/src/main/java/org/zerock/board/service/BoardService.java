package org.zerock.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.board.vo.BoardVO;
import org.zerock.util.PageObject;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> list(PageObject pageObject) {
		log.info("list");
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.list(pageObject);
	}
	
	public Integer write(BoardVO vo) {
		return mapper.write(vo);
	}
	
	public BoardVO view(Long no) {
		return mapper.view(no);
	}
	
	public Integer increase(Long no) {
		return mapper.increase(no);
	}
}
