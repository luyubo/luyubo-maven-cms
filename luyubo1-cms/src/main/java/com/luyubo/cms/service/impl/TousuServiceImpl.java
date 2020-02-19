package com.luyubo.cms.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luyubo.DateUtil;
import com.luyubo.StringUtil;
import com.luyubo.cms.dao.ArticleDao;
import com.luyubo.cms.dao.TousuDao;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Complain;
import com.luyubo.cms.service.TousuService;

@Service
public class TousuServiceImpl implements TousuService {
	@Autowired
	private TousuDao tousuDao;
	@Autowired
	private ArticleDao articleDao;

	@Override
	public boolean add(Complain complain) {
		// TODO Auto-generated method stub
		String format = DateUtil.dateTimeFormat.format(new Date());
		complain.setCreated(format);
		if(complain.getUrlip()!=null && !"".equals(complain.getUrlip())) {
			if(!StringUtil.ishttp(complain.getUrlip())) {
				return false;
			}
		}
		Article article = articleDao.selectById(complain.getArticleId());
		System.out.println(article+"=================");
		int i=tousuDao.add(complain);
		if(i>0) {
			i = articleDao.updateTousuCnt(article);
		}
		return i>0;
	}
}
