package com.luyubo.cms.service;


import com.github.pagehelper.PageInfo;
import com.luyubo.cms.pojo.Comment;

public interface CommentService {

	/**
	 * 上传评论
	 * @param comment
	 * @return
	 */
	boolean add(Comment comment);

	/**
	 * 查询评论表和分页
	 * @param articleId
	 * @param pageNum
	 * @return
	 */
	PageInfo<Comment> getPageInfo(Integer articleId, int pageNum);

	/**
	 * 查询评论列表和分页
	 * @param comment
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Comment> getByUserId(Comment comment, int pageNum, int pageSize);

	/**
	 * 根据id删除评论
	 * @param ids
	 * @return
	 */
	boolean delByIds(String ids);
	
}
