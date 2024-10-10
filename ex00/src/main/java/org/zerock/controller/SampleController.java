package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.vo.SampleVO;
import org.zerock.vo.SampleVOList;
import org.zerock.vo.TodoVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {

	// 3.스프링 web MVC 기초 - 파라미터 자동 수집과 변환 270
	
	//http://localhost/sample/
	// 메시지 파일 [/WEB-INF/views/sample.jsp]을(를) 찾을 수 없습니다.
	// void 타입은 uri이름이 jsp파일이름이됨
	// forward 주소가 안바뀜 redirect 주소가바뀜// 보통은 forward, 앞에 redirect:가 붙어야 redirect
	@GetMapping("/")
	public void basic() {
		log.info("basic");
	}
	
	//http://localhost/sample
	// 메시지 파일 [/WEB-INF/views/sample.jsp]을(를) 찾을 수 없습니다.
	@GetMapping("")
	public void basic1() {
		log.info("basic1");
	}
	
	// default=get
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basicGet");
	}
	//Mapped "{[/sample/basic],methods=[GET || POST]}"
	
	@GetMapping("/basicOnly")
	public void basicGetOnly() {
		log.info("basicGetOnly");
	}
	
	@GetMapping("basiconly")
	public void basic3() {
		log.info("basic3");
	}
	//[/sample/basiconly],methods=[GET]
	
	@GetMapping("/ex01")
	public String ex01(SampleVO vo) {
		log.info("get sample vo: "+vo);
		return "ex01";
	}
	/*
http://localhost/sample/ex01
INFO : org.zerock.controller.SampleController - get sample vo: SampleVO(name=null, age=0)
http://localhost/sample/ex01?name=dfadf&age=111
INFO : org.zerock.controller.SampleController - get sample vo: SampleVO(name=dfadf, age=111)
http://localhost/sample/ex01?name=dfadf&age=jhg
400 – 잘못된 요청
설명: 클라이언트 오류로서 인지된 어떤 문제로 인하여, 서버가 해당 요청을 처리할 수 없거나, 처리하지 않을 것입니다. (예: 잘못된 요청 문법, 유효하지 않은 요청 메시지 framing, 또는 신뢰할 수 없는 요청 라우팅).
	 */
	
	@GetMapping("/ex02")
	public String ex02(String name, int age) {
		log.info(name);
		log.info(age);
		return "ex02";
	}
	/*
	 * http://localhost/sample/ex02?name=mj&age=8
http://localhost/sample/ex02
500 - 내부 서버 오류
타입: 예외 보고
메시지: Request processing failed; nested exception is java.lang.IllegalStateException: 
Optional int parameter 'age' is present but cannot be translated into a null value due to being declared as a primitive type. 
Consider declaring it as object wrapper for the corresponding primitive type.
설명: 서버가, 해당 요청을 충족시키지 못하게 하는 예기치 않은 조건을 맞닥뜨렸습니다.
	 */
	
	@GetMapping("/ex03")
	public void ex03(@RequestParam("name1") String name, @RequestParam("age1") int age) {
		log.info(name);
		log.info(age);
		
	}
	// http://localhost/sample/ex03
	//Required String parameter 'name1' is not present
	//http://localhost/sample/ex03?name1=mg
	//Required int parameter 'age1' is not present
	//http://localhost/sample/ex03?name1=mg&age1=8
	
	@GetMapping("/ex04")
	public void ex04(@RequestParam(defaultValue = "mj") String name, @RequestParam(defaultValue = "10") int age) {
		log.info(name);
		log.info(age);
	}
	/*
http://localhost/sample/ex04
INFO : org.zerock.controller.SampleController - mj
INFO : org.zerock.controller.SampleController - 10
	 */
	
	@GetMapping("/ex05List")
	public void ex05List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ex05List:"+ids);
	}
	/*http://localhost/sample/ex05List
	 * ex05List:[]
	 * http://localhost/sample/ex05List?ids=java
	 * ex05List:[]
	 * 
	 * + @RequestParam
	 * http://localhost/sample/ex05List
	 * Required ArrayList parameter 'ids' is not present

http://localhost/sample/ex05List?ids=java
ex05List:[java]

http://localhost/sample/ex05List?ids=java&ids=python&ids=oracle
ex05List:[java, python, oracle]
	 */
	
	@GetMapping("/ex06Array")
	public void ex06Array(String[] ids) {
		log.info("ex06Array:"+Arrays.toString(ids));
	}
/*
http://localhost/sample/ex06Array
ex06Array:null

http://localhost/sample/ex06Array?ids=java
ex06Array:[java]

http://localhost/sample/ex06Array?ids=java&ids=python&ids=oracle
ex06Array:[java, python, oracle]
*/
	@GetMapping("/ex07Bean")
	public void ex07Bean(SampleVOList list) {
		log.info("ex07Bean:"+list);
	}
/*
http://localhost/sample/ex07Bean
SampleVOList(list=[])

http://localhost/sample/ex07Bean?list%5B0%5D.name=java&list%5B0%5D.age=10
SampleVOList(list=[SampleVO(name=java, age=10)])
 */
	/*
	@InitBinder // 들어오는 데이터를 변환
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	*/
	@GetMapping("/ex07")
	public void ex07(TodoVO vo) {
		log.info("ex07 TodoVO:"+vo);
	}
/*
http://localhost/sample/ex07
TodoVO(title=null, dueDate=null)

http://localhost/sample/ex07?title=java&dueDate=2024/10/8
404 잘못된 요청
클라이언트 오류로서 인지된 어떤 문제로 인하여, 서버가 해당 요청을 처리할 수 없거나, 처리하지 않을 것입니다. (예: 잘못된 요청 문법, 유효하지 않은 요청 메시지 framing, 또는 신뢰할 수 없는 요청 라우팅).

http://localhost/sample/ex07?title=java&dueDate=2024-10-08
TodoVO(title=java, dueDate=Tue Oct 08 00:00:00 KST 2024)
 */
	// Model이라는 특별한 파라미터 - java Beans와 @ModelAttribute 279
	@GetMapping("/ex08")
	public String ex08(SampleVO vo, @ModelAttribute("page") int page) {
		log.info("ex08:"+vo);
		log.info(page);
		
		return "sample/ex08";
	}
	/*
http://localhost/sample/ex08?name=java&age=10&page=20

+@ModelAttribute("page")
20
	 */
	@GetMapping("/ex09")
	public @ResponseBody SampleVO ex09() {
		SampleVO vo = new SampleVO();
		vo.setName("홍길동");
		vo.setAge(30);
		return vo;
	}
	
	@GetMapping("/ex10")
	public ResponseEntity<String> ex10() {
		log.info("ex10");
		String msg = "{\"name\":\"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	

	@GetMapping("/upload")
	public void upload() {
		log.info("upload");
	}
	
	@PostMapping("/upload")
	public void postUpload(ArrayList<MultipartFile> files) {
		for(MultipartFile file:files) {
			log.info(file.getOriginalFilename());
			log.info(file.getSize());
		}
	}
	
	@GetMapping("/thEx")
	public void thEx() throws Exception {
		throw new Exception("goodEx");
	}
	
	@GetMapping("/ex11")
	public String ex11() {
		return "ex11";
	}
}
