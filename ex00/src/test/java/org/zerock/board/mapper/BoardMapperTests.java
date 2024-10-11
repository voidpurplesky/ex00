package org.zerock.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.util.PageObject;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void list() {
		log.info("list");
		PageObject pageObject = new PageObject();
		log.info(mapper.list(pageObject));
	}
	
	@Test
	public void getTotalRow() {
		PageObject pageObject = new PageObject();
		log.info(mapper.getTotalRow(pageObject));
	}
	
	@Test
	public void write() {
		
	}
	
}
