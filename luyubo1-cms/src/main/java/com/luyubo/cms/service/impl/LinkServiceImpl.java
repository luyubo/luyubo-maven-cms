package com.luyubo.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luyubo.cms.dao.LinkDao;
import com.luyubo.cms.pojo.Link;
import com.luyubo.cms.service.LinkService;
/**
 * link友情链接service层实现类
 * @author 77028
 *
 */
@Service
public class LinkServiceImpl implements LinkService {
	@Autowired
	private LinkDao linkDao;

	@Override
	public PageInfo<Link> getPageInfo(Link link, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Link> linkList=linkDao.select(link);
		return new PageInfo<Link>(linkList);
	}

	@Override
	public Link getById(Integer id) {
		// TODO Auto-generated method stub
		return linkDao.selectById(id);
	}

	@Override
	public boolean save(Link link) {
		// TODO Auto-generated method stub
		link.setCreated(new Date());
		//判断是否id值进行添加或修改
		if(link.getId()==null) {
			return linkDao.insert(link)>0;
		}
		return linkDao.update(link)>0;
	}

	@Override
	public boolean delByIds(String ids) {
		// TODO Auto-generated method stub
		return linkDao.delByIds(ids)>0;
	}

	@Override
	public List<Link> select() {
		// TODO Auto-generated method stub
		return linkDao.select(new Link());
	}
}
