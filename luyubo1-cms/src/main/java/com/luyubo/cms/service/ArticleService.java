package com.luyubo.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Category;
import com.luyubo.cms.pojo.Channel;
import com.luyubo.cms.pojo.Complain;

/**
 * 文章service层
 * @author 77028
 *
 */
public interface ArticleService {
	
	/**
	 * 查询频道列表
	 * @return
	 */
	List<Channel> getChannelList();

	/**
	 * 修改状态
	 * @param id
	 * @param status
	 * @return
	 */
	boolean updateStatus(Integer id, Integer status);

	/**
	 * 分页列表
	 * @param article
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Article> getPageInfo(Article article, Integer pageNum, Integer pageSize);

	/**
	 * 加热每次点击热度+1
	 * @param id
	 * @return
	 */
	boolean addHot(Integer id);

	/**
	 * 根据id查询分类列表
	 * @param channelId
	 * @return
	 */
	List<Category> getCateListByChannelId(Integer channelId);

	/**
	 * 根据id查询
	 * @param i
	 * @return
	 */
	Article selectById(int id);

	/**
	 * 保存到数据库
	 * @param article
	 * @return
	 */
	boolean save(Article article);

	/**
	 * 根据id判断文章是否审核
	 * @param ids
	 * @return
	 */
	boolean isAllCheck(String ids);

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	boolean delByIds(String ids);

	/**
	 * 根据热度查询文章
	 * @param pageNum
	 * @return
	 */
	PageInfo<Article> getHotList(Integer pageNum);

	/**
	 * 根据频道id和分类id查询和分页文章
	 * @param channelId
	 * @param cateId
	 * @param pageNo
	 * @return
	 */
	PageInfo<Article> getListByChannelIdAndCateId(Integer channelId, Integer cateId, Integer pageNo);

	/**
	 * 根据频道id查询分类列表
	 * @param channelId
	 * @param id
	 * @param i
	 * @return
	 */
	List<Article> getListByChannelId(Integer channelId, Integer id, int i);

	/**
	 * 根据最新查询
	 * @param i
	 * @return
	 */
	List<Article> getNewList(int num);

	/**
	 * 修改文章点击量
	 * @param id
	 * @return
	 */
	boolean updateHits(Integer id);

	PageInfo<Article> selectByTousu(Complain complain, Integer pageNum, Integer pageSize);

	List<Article> selectComplain(int i);
	/**
	 * 修改状态为禁止
	 * @param id
	 * @return
	 */
	boolean updateStatus3(Integer id);

	/**
	 * 根据文章id查询用户信息和投诉内容
	 * @param articleId
	 * @return
	 */
	List<Article> selectByTousuUser(Integer articleId);

	List<Complain> selectComplain();

	List<Article> select(Article article);

}
