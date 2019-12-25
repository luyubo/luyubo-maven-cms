package com.luyubo.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.luyubo.cms.pojo.Link;

/**
 * link友情链接service层接口
 * @author 77028
 *
 */
public interface LinkService {

	/**
	 * 分页查询链接表
	 * @param link
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Link> getPageInfo(Link link, int pageNum, int pageSize);

	/**
	 * 通过id获得link表
	 * @param id
	 * @return
	 */
	Link getById(Integer id);

	/**
	 * 保存连接到数据库
	 * @param link
	 */
	boolean save(Link link);

	/**
	 * 删除数据
	 * @param ids
	 * @return
	 */
	boolean delByIds(String ids);

	/**
	 * 查询全部的友情链接
	 * @return
	 */
	List<Link> select();
	
}
