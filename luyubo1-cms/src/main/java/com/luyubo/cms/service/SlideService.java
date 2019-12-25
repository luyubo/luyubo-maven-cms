package com.luyubo.cms.service;

import java.util.List;

import com.luyubo.cms.pojo.Slide;

/**
 * 轮播图service层接口
 * @author 77028
 *
 */
public interface SlideService {

	/**
	 * 获得所有轮播图
	 * @return
	 */
	List<Slide> getAll();

}
