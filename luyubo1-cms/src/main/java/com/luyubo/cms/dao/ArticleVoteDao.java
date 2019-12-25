package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.ArticleVote;



/**
 * 投票Dao层接口
 * @author 77028
 *
 */
public interface ArticleVoteDao {
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	ArticleVote selectById(@Param("id") Integer id);
	/**
	 * 查询集合
	 * @param user
	 * @return
	 */
	List<ArticleVote> select(@Param("articleVote") ArticleVote articleVote);
	/**
	 * 查询多少条
	 * @param user
	 * @return
	 */
	int count(@Param("articleVote") ArticleVote articleVote);
	
	/**
	 * 插入一条记录
	 * @param user
	 * @return
	 */
	int insert(@Param("articleVote") ArticleVote articleVote);
	
	/**
	 * 根据id更新记录
	 * @param user
	 * @return
	 */
	int update(@Param("articleVote") ArticleVote articleVote);
	
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
