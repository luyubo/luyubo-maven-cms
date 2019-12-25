package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.Tag;


/**
 * 标签表Dao层接口
 * @author 77028
 *
 */
public interface TagDao {
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	Tag selectById(@Param("id") Integer id);
	/**
	 * 查询所有数据集合
	 * @param user
	 * @return
	 */
	List<Tag> select(@Param("tag") Tag tag);
	/**
	 * 查询多少条
	 * @param user
	 * @return
	 */
	int count(@Param("tag") Tag tag);
	
	/**
	 * 插入一条记录
	 * @param user
	 * @return
	 */
	int insert(@Param("tag") Tag tag);
	
	/**
	 * 根据id更新记录
	 * @param user
	 * @return
	 */
	int update(@Param("tag") Tag tag);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	int deleteById(@Param("id") Integer id);
	
	/**
	 *根据id集合删除 
	 * @param ids
	 * @return
	 */
	int deleteByIds(@Param("ids") String ids);
}
