package com.luyubo.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luyubo.cms.dao.SlideDao;
import com.luyubo.cms.pojo.Slide;
import com.luyubo.cms.service.SlideService;
/**
 * slide轮播图service层实现类
 * @author 77028
 *
 */
@Service
public class SlideServiceImpl implements SlideService {
	@Autowired
	private SlideDao slideDao;
	
	@Override
	public List<Slide> getAll() {
		// TODO Auto-generated method stub
		return slideDao.select(null);
	}
}
