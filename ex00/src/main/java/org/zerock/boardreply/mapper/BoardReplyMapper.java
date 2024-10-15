package org.zerock.boardreply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.boardreply.vo.BoardReplyVO;
import org.zerock.util.PageObject;

public interface BoardReplyMapper {

	public List<BoardReplyVO> list(@Param("pageObject") PageObject pageObject, @Param("no") Long no);
	public Integer write(BoardReplyVO vo);
	//public BoardReplyVO view(Long no);
	//public Integer increase(Long no);
	public Long getTotalRow(Long no);
	public Integer update(BoardReplyVO vo);
	public Integer delete(BoardReplyVO vo);
}
