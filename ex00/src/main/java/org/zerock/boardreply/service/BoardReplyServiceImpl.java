package org.zerock.boardreply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zerock.boardreply.mapper.BoardReplyMapper;
import org.zerock.boardreply.vo.BoardReplyVO;
import org.zerock.util.PageObject;

@Service
@Qualifier("boardReplyServiceImpl")
public class BoardReplyServiceImpl implements BoardReplyService {

	@Autowired
	private BoardReplyMapper mapper;
	
	@Override
	public List<BoardReplyVO> list(PageObject pageObject, Long no) {
		pageObject.setTotalRow(mapper.getTotalRow(no));
		
		return mapper.list(pageObject, no);
	}

	@Override
	public Integer write(BoardReplyVO vo) {
		return mapper.write(vo);
	}

	@Override
	public Integer update(BoardReplyVO vo) {
		return mapper.update(vo);
	}

	@Override
	public Integer delete(BoardReplyVO vo) {
		return mapper.delete(vo);
	}

}
