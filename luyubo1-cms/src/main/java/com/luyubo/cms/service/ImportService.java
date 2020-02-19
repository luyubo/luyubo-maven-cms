package com.luyubo.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.luyubo.cms.pojo.Import;

public interface ImportService {

	int toimport(Import import1);

	void delete(Integer id);

	List<Import> select(Integer userid);

	PageInfo<Import> selectAll(String title, Integer page, Integer pageSize);

}
