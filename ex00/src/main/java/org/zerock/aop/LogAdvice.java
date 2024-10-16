package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
@Aspect
public class LogAdvice {

	/**
	 * 
	 * @param pjp 실행객체, 넘어가는 데이터 
	 * - 실행해야할 객체: ServiceImpl
	 * - 넘어가는데이터 parameter - no, pageObject, vo, ..
	 * @throws Throwable 
	 */
	@Around("execution(* org.zerock.*.service.*ServiceImpl.*(..))") // 실행객체 양쪽에 표시
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis(); // 1/1000초 ms msec
		Object result = null;
		
		log.info(pjp.getTarget()); // 실행객체이름
		log.info(pjp.getSignature());// 실행메서드
		log.info(Arrays.toString(pjp.getArgs())); // parameters
		
		result = pjp.proceed();
		
		log.info(result);
		long end = System.currentTimeMillis();
		log.info(end-start);
		return result;
	}
	
}

/*
INFO : org.zerock.aop.LogAdvice - org.zerock.board.service.BoardServiceImpl@62d06440
INFO : org.zerock.aop.LogAdvice - List org.zerock.board.service.BoardService.list(PageObject)
INFO : org.zerock.aop.LogAdvice - [PageObject [page=1, perPageNum=10, startRow=1, endRow=10, perGroupPageNum=10, startPage=1, endPage=1, totalPage=0, totalRow=0, key=null, word=null, period=pre]]


INFO : org.zerock.aop.LogAdvice - [BoardVO(no=61, title=!한글!, content=null, writer=한글!, writedate=Fri Oct 11 09:46:52 KST 2024, hit=165, pw=null), BoardVO(no=21, title=java, content=null, writer=아링ㄹ, writedate=Thu Aug 08 15:36:34 KST 2024, hit=1, pw=null), BoardVO(no=18, title=title, content=null, writer=name2, writedate=Wed Aug 07 14:37:19 KST 2024, hit=0, pw=null), BoardVO(no=17, title=title, content=null, writer=writer, writedate=Wed Aug 07 14:37:19 KST 2024, hit=0, pw=null), BoardVO(no=16, title=title, content=null, writer=writer, writedate=Wed Aug 07 14:37:19 KST 2024, hit=0, pw=null), BoardVO(no=15, title=title, content=null, writer=writer, writedate=Wed Aug 07 14:37:19 KST 2024, hit=0, pw=null), BoardVO(no=14, title=oracle2, content=null, writer=작성자, writedate=Wed Aug 07 14:37:19 KST 2024, hit=0, pw=null), BoardVO(no=13, title=title, content=null, writer=writer, writedate=Wed Aug 07 14:37:19 KST 2024, hit=0, pw=null), BoardVO(no=12, title=title, content=null, writer=writer, writedate=Wed Aug 07 14:37:19 KST 2024, hit=0, pw=null), BoardVO(no=11, title=title, content=null, writer=writer, writedate=Wed Aug 07 14:37:19 KST 2024, hit=0, pw=null)]
INFO : org.zerock.aop.LogAdvice - 8

*/