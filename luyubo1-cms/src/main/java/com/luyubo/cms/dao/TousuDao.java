package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.Complain;

public interface TousuDao {

	int add(@Param("complain")Complain complain);

	List<Complain> select();

}
