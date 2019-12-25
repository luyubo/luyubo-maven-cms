package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.Link;

/**
 * link友情链接dao层接口
 * @author 77028
 *
 */
public interface LinkDao {

	List<Link> select(@Param("link")Link link);

	Link selectById(@Param("id")Integer id);

	int insert(@Param("link")Link link);

	int update(@Param("link")Link link);

	int delByIds(@Param("ids")String ids);

	
}
