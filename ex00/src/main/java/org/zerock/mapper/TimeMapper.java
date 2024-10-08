package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeMapper {

	@Select("select sysdate from dual")
	public String getTime();
	public String getTime2(); // TimeMapper.xml과 연결되어있음
	//public String getOneOne();
}
