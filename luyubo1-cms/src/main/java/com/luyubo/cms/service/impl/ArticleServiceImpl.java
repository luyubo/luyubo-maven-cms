package com.luyubo.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luyubo.cms.dao.ArticleDao;
import com.luyubo.cms.dao.CategoryDao;
import com.luyubo.cms.dao.ChannelDao;
import com.luyubo.cms.dao.TousuDao;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Category;
import com.luyubo.cms.pojo.Channel;
import com.luyubo.cms.pojo.Complain;
import com.luyubo.cms.service.ArticleService;
/**
 * 文章service层
 * @author 77028
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ChannelDao channelDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private TousuDao tousuDao;
	
	@Override
	public List<Channel> getChannelList() {
		// TODO Auto-generated method stub
		return channelDao.select(null);
	}

	@Override
	public boolean updateStatus(Integer id, Integer status) {
		// TODO Auto-generated method stub
		return articleDao.updateStatus(id,status)>0;
	}

	@Override
	public PageInfo<Article> getPageInfo(Article article, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Article> articleList = articleDao.select(article);
		return new PageInfo<Article>(articleList);
	}

	@Override
	public boolean addHot(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.addHot(id)>0;
	}

	@Override
	public List<Category> getCateListByChannelId(Integer channelId) {
		// TODO Auto-generated method stub
		return categoryDao.getCateListByChannelId(channelId);
	}

	@Override
	public Article selectById(int id) {
		// TODO Auto-generated method stub
		return articleDao.selectById(id);
	}

	@Override
	public boolean save(Article article) {
		// TODO Auto-generated method stub
		if(article.getId()==null) {
			article.setDeleted(0);
			article.setCreated(new Date());
			article.setUpdated(new Date());
			article.setCommentCnt(0);
			article.setHits(0);
			article.setHot(0);
			if(article.getStatus()==0) {
				articleDao.insert(article);
			}else {
				article.setStatus(2);
				articleDao.insert(article);
			}
		}else {
			article.setUpdated(new Date());
			articleDao.update(article);
		}
		return true;
	}

	@Override
	public boolean isAllCheck(String ids) {
		// TODO Auto-generated method stub
		List<Article> articleList=articleDao.selectByIds(ids);
		for (Article article : articleList) {
			if(article.getStatus()==1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean delByIds(String ids) {
		// TODO Auto-generated method stub
		return articleDao.updateDeleteByIds(ids)>0;
	}

	@Override
	public PageInfo<Article> getHotList(Integer pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 6);
		List<Article> articleList=articleDao.selectByHot();
		return new PageInfo<>(articleList);
	}

	
	@Override
	public PageInfo<Article> getListByChannelIdAndCateId(Integer channelId, Integer cateId, Integer pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 6);
		List<Article> articleList=articleDao.getListByChannelIdAndCateId(channelId,cateId);
		return new PageInfo<Article>(articleList);
	}

	@Override
	public List<Article> getListByChannelId(Integer channelId, Integer articleId, int num) {
		// TODO Auto-generated method stub
		return articleDao.getListByChannelId(channelId,articleId,num);
	}

	@Override
	public List<Article> getNewList(int num) {
		// TODO Auto-generated method stub
		return articleDao.getNewList(num);
	}

	@Override
	public boolean updateHits(Integer id) {
		// TODO Auto-generated method stub
		int i=articleDao.updateHit(id);
		return i>0;
	}

	@Override
	public PageInfo<Article> selectByTousu(Complain complain, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Article> list=articleDao.selectByTousu(complain);
		return new PageInfo<Article>(list);
	}

	

	@Override
	public boolean updateStatus3(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.updateStatus3(id);
	}

	@Override
	public List<Article> selectByTousuUser(Integer articleId) {
		// TODO Auto-generated method stub
		return articleDao.selectByTousuUser(articleId);
	}

	@Override
	public List<Article> selectComplain(int i) {
		// TODO Auto-generated method stub
		return articleDao.selecttouSu(i);
	}

	@Override
	public List<Complain> selectComplain() {
		// TODO Auto-generated method stub
		return tousuDao.select();
	}

	@Override
	public List<Article> select(Article article) {
		// TODO Auto-generated method stub
		return articleDao.select(article);
	}

}
