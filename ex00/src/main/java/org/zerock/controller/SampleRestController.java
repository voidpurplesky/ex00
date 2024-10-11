package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.vo.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sampleRest")
@Log4j
public class SampleRestController {

	@GetMapping(value = "/getText", produces = "text/plane;charset=UTF-8")
	public String getText() {
		//mime type
		log.info(MediaType.TEXT_PLAIN_VALUE);
		log.info(MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
	//xml: http://localhost/sampleRest/getSample or getSample.xml 
	//json: http://localhost/sampleRest/getSample.json 
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO("홍길동", 30);
	}
	
	@GetMapping(value = "/getSample2")
	public SampleVO getSample2() {
		return new SampleVO("홍길동", 30);
	}
	
	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO("홍길돌", 10));
		list.add(new SampleVO("이순신", 20));
		list.add(new SampleVO("손흥믄", 30));
		list.add(new SampleVO("김석진", 40));
		
		return list;
	}
	
	@GetMapping(value = "/getMap")
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vo", new SampleVO("홍길송", 10));
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO("홍길돌", 10));
		list.add(new SampleVO("이순신", 20));
		list.add(new SampleVO("손흥믄", 30));
		list.add(new SampleVO("김석진", 40));
		
		map.put("list", list);
		
		return map;
	}
	/*
<Map>
	<vo>
		<name>홍길송</name>
		<age>10</age>
	</vo>
	<list>
		<name>홍길돌</name>
		<age>10</age>
	</list>
	<list>
		<name>이순신</name>
		<age>20</age>
	</list>
	<list>
		<name>손흥믄</name>
		<age>30</age>
	</list>
	<list>
		<name>김석진</name>
		<age>40</age>
	</list>
</Map>
	 */
	//http://localhost/sampleRest/product/aaa/bbb
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") String pid) {
		return new String[] {"category:" + cat, "product:"+pid}; 
	}
	/*
<Strings>
	<item>category:aaa</item>
	<item>product:bbb</item>
</Strings>
	 */
	
	@PostMapping("/sample")
	public SampleVO convert(@RequestBody SampleVO vo) {
		log.info(vo);
		return vo;
	}
}
