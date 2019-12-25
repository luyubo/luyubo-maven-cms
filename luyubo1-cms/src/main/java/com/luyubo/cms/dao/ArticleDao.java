package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Complain;


/**
 * 文章表Dao层接口
 * @author 77028
 *
 */
public interface ArticleDao {
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	Article selectById(@Param("id") Integer id);
	/**
	 * 查询所有数据集合
	 * @param user
	 * @return
	 */
	List<Article> select(@Param("article") Article article);
	/**
	 * 查询多少条
	 * @param user
	 * @return
	 */
	int count(@Param("article") Article article);
	
	/**
	 * 插入一条记录
	 * @param user
	 * @return
	 */
	int insert(@Param("article") Article article);
	
	/**
	 * 根据id更新记录
	 * @param user
	 * @return
	 */
	int update(@Param("article") Article article);
	
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
	
	/**
	 * 修改状态
	 * @param id
	 * @param status
	 * @return
	 */
	int updateStatus(@Param("id")Integer id, @Param("status")Integer status);
	
	/**
	 * 加热
	 * @param id
	 * @return
	 */
	int addHot(@Param("id")Integer id);
	/**
	 * 根据id查询是否过审
	 * @param ids
	 * @return
	 */
	List<Article> selectByIds(@Param("ids")String ids);
	
	/**
	 * 批量删除、逻辑删除
	 * @param ids
	 * @return
	 */
	int updateDeleteByIds(@Param("ids")String ids);
	
	/**
	 * 根据热度排行查询
	 * @return
	 */
	List<Article> selectByHot();
	
	/**
	 * 根据分类id和频道id查询分页
	 * @param channelId
	 * @param cateId
	 * @return
	 */
	List<Article> getListByChannelIdAndCateId(@Param("channelId")Integer channelId, @Param("cateId")Integer cateId);
	
	/**
	 * 根据频道id查询文章分类
	 * @param channelId
	 * @param articleId
	 * @param num
	 * @return
	 */
	List<Article> getListByChannelId(@Param("channelId")Integer channelId, @Param("articleId")Integer articleId, @Param("num")int num);
	
	/**
	 * 根据最新查询
	 * @param num
	 * @return
	 */
	List<Article> getNewList(@Param("num")int num);
	
	/**
	 * 修改文章表的评论总数
	 * @param commentcnt
	 * @return
	 */
	int updateCommentCnt(@Param("articleId")Integer articleId);
	
	/**
	 * 修改点击数
	 * @return
	 */
	int updateHit(@Param("id")Integer id);
	
	/**
	 * 根据文章id修改文章投诉数
	 * @param article
	 * @return
	 */
	int updateTousuCnt(@Param("article")Article article);
	
	
	List<Article> selectByTousu(@Param("complain")Complain complain);
	
	/**
	 * 修改文章为禁用
	 * @param id
	 * @return
	 */
	boolean updateStatus3(@Param("id")Integer id);
	
	/**
	 * 根据文章id查询素有用户的数据
	 * @param articleId
	 * @return
	 */
	List<Article> selectByTousuUser(@Param("id")Integer articleId);
	
	
	List<Article> selecttouSu(@Param("num")int i);
}
