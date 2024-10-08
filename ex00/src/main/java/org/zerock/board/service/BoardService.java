package org.zerock.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.board.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> list() {
		log.info("list");
		return mapper.list();
	}
}
