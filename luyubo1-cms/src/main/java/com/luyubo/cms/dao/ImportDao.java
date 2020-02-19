package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.Import;

public interface ImportDao {

	int toimport(@Param("import")Import import1);

	void delete(@Param("id")Integer id);

	List<Import> select(@Param("userid")Integer userid);

	List<Import> selectAll(@Param("text")String text);
	
}
