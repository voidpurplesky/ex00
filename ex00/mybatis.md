https://mybatis.org/mybatis-3/ko/getting-started.html

스프링 관련: spring-jdbc, spring-tx
Mybatis 관련: mybatis 3.4.6(latest: 3.5.16), mybatis-spring 1.3.2(latest: 3.0.4)
`pom.xml`
```xml
        <dependency>
		    <groupId>org.mybatis</groupId>
		    <artifactId>mybatis</artifactId>
		    <version>3.4.6</version>
		</dependency>
		<dependency>
		    <groupId>org.mybatis</groupId>
		    <artifactId>mybatis-spring</artifactId>
		    <version>1.3.2</version>
		</dependency>
```
`root-context.xml`
Namespace V mybatis-spring
```xml
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"></property>
	</bean>
```
`+ Interface : org.zerock.mapper.TimeMapper`
```java
package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeMapper {

	@Select("select sysdate from dual")
	public String getTime();
}
```

`+ src/main/resources/org.zerock.mapper.TimeMapper.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.zerock.mapper.TimeMapper">
  <select id="getTime2" resultType="string">
  select sysdate from dual
  </select>
  <!-- 256 -->
</mapper>
```

```java
	@Test
	public void testGetTime2() {
		log.info("-----[Mapper 어노테이션 테스트2]--------------");
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime2());
	}
```
log4jdbc-log4j2-jdbc4

`pom.xml`
```xml
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4</artifactId>
    <version>1.16</version>
</dependency>
```
+log4jdbc.log4j2.properties
```
log4jdbc.spylogdelegater.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator
```
root-context.xml
```
		<property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"/>
		<property name="jdbcUrl" value="jdbc:log4jdbc:oracle:thin:@localhost:1521:XE"/>
		```
		
		```
Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'hikariConfig' defined in URL [file:src/main/webapp/WEB-INF/spring/root-context.xml]: Error setting property values; nested exception is org.springframework.beans.PropertyBatchUpdateException; nested PropertyAccessExceptions (1) are:
PropertyAccessException 1: org.springframework.beans.MethodInvocationException: Property 'driverClassName' threw exception; nested exception is java.lang.NoClassDefFoundError: Unable to find Log4j2 as default logging library. Please provide a logging library and configure a valid spyLogDelegator name in the properties file.
ERROR: org.springframework.test.context.TestContextManager - Caught exception while allowing TestExecutionListener [org.springframework.test.context.support.DependencyInjectionTestExecutionListener@49438269] to prepare test instance [org.zerock.sample.TimeMapperTests@5e77f0f4]
java.lang.IllegalStateException: Failed to load ApplicationContext
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:125)
```
Please provide a logging library and configure a valid spyLogDelegator name in the properties file.

로깅 라이브러리를 제공하고 속성 파일에 유효한 spyLogDelegator 이름을 구성하세요.
```
		<dependency>
		    <groupId>org.apache.logging.log4j</groupId>
		    <artifactId>log4j-api</artifactId>
		    <version>2.0.1</version>
		</dependency>
		
		<dependency>
		    <groupId>org.apache.logging.log4j</groupId>
		    <artifactId>log4j-core</artifactId>
		    <version>2.0.1</version>
		</dependency>
```
		
https://jwj1699.tistory.com/14
		
```
INFO : com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Starting...
INFO : com.zaxxer.hikari.pool.PoolBase - HikariPool-1 - Driver does not support get/set network timeout for connections. (Receiver class net.sf.log4jdbc.sql.jdbcapi.ConnectionSpy does not define or inherit an implementation of the resolved method abstract getNetworkTimeout()I of interface java.sql.Connection.)
INFO : com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Start completed.
INFO : org.zerock.sample.TimeMapperTests - -----[Mapper 어노테이션 테스트2]--------------
INFO : org.zerock.sample.TimeMapperTests - com.sun.proxy.$Proxy37
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.apache.ibatis.reflection.Reflector (file:/C:/Users/EZEN/.m2/repository/org/mybatis/mybatis/3.4.6/mybatis-3.4.6.jar) to method java.lang.String.value()
WARNING: Please consider reporting this to the maintainers of org.apache.ibatis.reflection.Reflector
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
INFO : org.zerock.sample.TimeMapperTests - 2024-10-08 11:02:57.0
INFO : com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Shutdown initiated...
INFO : com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Shutdown completed.
```		
Driver does not support get/set network timeout for connections.
https://sh0seo.tistory.com/8
ojdbc6

BoardService
```
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
```

+src/main/resources/org/zerock/board/mapper/BoardMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.zerock.board.mapper.BoardMapper">
  <select id="list" resultType="org.zerock.board.vo.BoardVO">
  select no, title, writer, writedate, hit 
  from board
  order by no desc
  </select>
</mapper>
```

```
package org.zerock.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.board.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		log.info("list");
		request.setAttribute("list", service.list());
		return "list";
	}
}
```

HttpServletRequest vs model
https://www.inflearn.com/community/questions/975065/request-setattribute-vs-model-addattribute?srsltid=AfmBOoq2YnCas-0DjnDF4Hjkv3kcCbsZD68-9JdgU-W50yo7lsfRZ72c
https://medium.com/webeveloper/modelattribute-%EC%99%80-%EC%BB%A4%EB%A7%A8%EB%93%9C-%EA%B0%9D%EC%B2%B4-command-object-42c14f268324

servlet 3.1.0

```
<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
			<scope>provided</scope>
		</dependency>
```
spring 5 servlet 2.5,(3+) jdk 8+
https://spring.io/blog/2015/06/10/feedback-welcome-spring-5-system-requirements