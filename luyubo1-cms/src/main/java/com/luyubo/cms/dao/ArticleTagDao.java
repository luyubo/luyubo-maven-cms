package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.ArticleTag;



/**
 * 文章标签关联Dao层接口
 * @author 77028
 *
 */
public interface ArticleTagDao {
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	ArticleTag selectById(@Param("id") Integer id);
	/**
	 * 查询集合
	 * @param user
	 * @return
	 */
	List<ArticleTag> select(@Param("articleTag") ArticleTag articleTag);
	/**
	 * 查询多少条
	 * @param user
	 * @return
	 */
	int count(@Param("articleTag") ArticleTag articleTag);
	
	/**
	 * 插入一条记录
	 * @param user
	 * @return
	 */
	int insert(@Param("articleTag") ArticleTag articleTag);
	
	/**
	 * 根据id更新记录
	 * @param user
	 * @return
	 */
	int update(@Param("articleTag") ArticleTag articleTag);
	
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
