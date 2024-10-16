root-context.xml
+ namespace tx

```
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
	</bean>
<tx:annotation-driven/>
```

BoardMapper.xml
```
<insert id="writeTx">
  	  insert into board(no, title, content, writer, pw)
  	values (#{no}, #{title}, #{content}, #{writer}, #{pw})
  </insert>
```
BoardServiceImpl 같은 pk 에러상황만들기
```
	@Transactional
	public Integer write(BoardVO vo) {
		Integer result = mapper.write(vo);
		mapper.writeTx(vo); // ThrowERROR 글번호 재사용 : pk 예외
		return mapper.write(vo);
	}
```
web error log

```
### Error updating database. Cause: java.sql.SQLIntegrityConstraintViolationException: ORA-00001: unique constraint (JAVA.SYS_C007001) violated ### The error may involve defaultParameterMap ### The error occurred while setting parameters ### SQL: insert into board(no, title, content, writer, pw) values (?, ?, ?, ?, ?) ### Cause: java.sql.SQLIntegrityConstraintViolationException: ORA-00001: unique constraint (JAVA.SYS_C007001) violated ; ]; ORA-00001: unique constraint (JAVA.SYS_C007001) violated ; nested exception is java.sql.SQLIntegrityConstraintViolationException: ORA-00001: unique constraint (JAVA.SYS_C007001) violated
```
console
```
INFO : jdbc.sqlonly - insert into board(no, title, content, writer, pw) values (82, 'a', 'aaaaa', 'id2', '1') 

INFO : jdbc.sqlonly - insert into board(no, title, content, writer, pw) values (82, 'a', 'aaaaa', 'id2', '1') 

java.sql.SQLIntegrityConstraintViolationException: ORA-00001: unique constraint (JAVA.SYS_C007001) violated

; ]; ORA-00001: unique constraint (JAVA.SYS_C007001) violated
; nested exception is java.sql.SQLIntegrityConstraintViolationException: ORA-00001: unique constraint (JAVA.SYS_C007001) violated
```

