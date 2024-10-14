package org.zerock.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.board.vo.BoardVO;
import org.zerock.util.PageObject;

import lombok.extern.log4j.Log4j;

public interface BoardService {
	
	public List<BoardVO> list(PageObject pageObject);
	
	public Integer write(BoardVO vo);
	
	public BoardVO view(Long no);
	
	public Integer increase(Long no);
	
	public Integer update(BoardVO vo);
	
	public Integer delete(Long no);
}
