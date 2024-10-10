package org.zerock.board.mapper;

import java.util.List;

import org.zerock.board.vo.BoardVO;
import org.zerock.util.PageObject;

public interface BoardMapper {

	public List<BoardVO> list(PageObject pageObject);
	public Integer write(BoardVO vo);
	public BoardVO view(Long no);
	public Integer increase(Long no);
	public Long getTotalRow(PageObject pageObject);
}
