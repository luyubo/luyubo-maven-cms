package com.luyubo.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luyubo.StringUtil;
import com.luyubo.cms.dao.ImportDao;
import com.luyubo.cms.pojo.Import;
import com.luyubo.cms.service.ImportService;
@Service
public class ImportServiceImpl implements ImportService {
	@Autowired
	private ImportDao importDao;

	@Override
	public int toimport(Import import1) {
		// TODO Auto-generated method stub
		String substring = import1.getUrl().substring(0, 7);
		boolean ishttp = StringUtil.ishttp(substring);
		if (ishttp) {
			System.out.println(ishttp);
			return importDao.toimport(import1);
		}
		return 0;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		importDao.delete(id);
	}

	@Override
	public List<Import> select(Integer userid) {
		// TODO Auto-generated method stub
		return importDao.select(userid);
	}

	@Override
	public PageInfo<Import> selectAll(String text, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		List<Import> list=importDao.selectAll(text);
		return new PageInfo<Import>(list);
	}
}
