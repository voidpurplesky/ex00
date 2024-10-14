package org.zerock.boardreply.service;

import java.util.List;

import org.zerock.boardreply.vo.BoardReplyVO;
import org.zerock.util.PageObject;

public interface BoardReplyService {

	public List<BoardReplyVO> list(PageObject pageObject, Long no);
	public Integer write(BoardReplyVO vo);
	//public BoardReplyVO view(Long rno);
	public Integer update(BoardReplyVO vo);
	public Integer delete(Long rno);
}
