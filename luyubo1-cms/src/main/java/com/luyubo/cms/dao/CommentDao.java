package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.Comment;


/**
 * 文章评论表Dao层接口
 * @author 77028
 *
 */
public interface CommentDao {
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	Comment selectById(@Param("id") Integer id);
	/**
	 * 查询所有数据集合
	 * @param user
	 * @return
	 */
	List<Comment> select(@Param("comment") Comment comment);
	/**
	 * 查询多少条
	 * @param user
	 * @return
	 */
	int count(@Param("comment") Comment comment);
	
	/**
	 * 插入一条记录
	 * @param user
	 * @return
	 */
	int insert(@Param("comment") Comment comment);
	
	/**
	 * 根据id更新记录
	 * @param user
	 * @return
	 */
	int update(@Param("comment") Comment comment);
	
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
	
	
	List<Comment> getByUserId(@Param("comment")Comment comment);
	
	
	/**
	 * 根据id逻辑删除评论
	 * @param ids
	 * @return
	 */
	int delUpdateByIds(@Param("ids")String ids);
	
	/**
	 * 根据文章id查询该文章总共有多少个评论
	 * @param articleId
	 * @return
	 */
	int selectCommentCnt(@Param("articleId")Integer articleId);
}
