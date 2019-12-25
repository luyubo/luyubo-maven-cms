package com.luyubo.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.commons.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luyubo.cms.dao.ArticleDao;
import com.luyubo.cms.dao.CommentDao;
import com.luyubo.cms.pojo.Comment;
import com.luyubo.cms.service.CommentService;
/**
 * service层实现类
 * @author 77028
 *
 */
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private ArticleDao ArticleDao;
	@Override
	public boolean add(Comment comment) {
		// TODO Auto-generated method stub
		String format = DateUtil.dateTimeFormat.format(new Date());
		comment.setCreated(format);
		comment.setDeleted(0);
		boolean flag=commentDao.insert(comment)>0;
		ArticleDao.updateCommentCnt(comment.getArticleId());
		return flag;
	}

	@Override
	public PageInfo<Comment> getPageInfo(Integer articleId, int pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 5);
		Comment comment=new Comment();
		comment.setArticleId(articleId);
		List<Comment> commentList=commentDao.select(comment);
		return new PageInfo<Comment>(commentList);
	}

	@Override
	public PageInfo<Comment> getByUserId(Comment comment, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Comment> commentList=commentDao.getByUserId(comment);
		return new PageInfo<Comment>(commentList);
	}


	@Override
	public boolean delByIds(String ids) {
		// TODO Auto-generated method stub
		return commentDao.delUpdateByIds(ids)>0;
	}
}
