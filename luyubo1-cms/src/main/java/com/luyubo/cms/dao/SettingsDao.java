package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.Settings;


/**
 * 系统设置表Dao层接口
 * @author 77028
 *
 */
public interface SettingsDao {
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	Settings selectById(@Param("id") Integer id);
	/**
	 * 查询所有数据集合
	 * @param user
	 * @return
	 */
	List<Settings> select(@Param("settings") Settings settings);
	/**
	 * 查询多少条
	 * @param user
	 * @return
	 */
	int count(@Param("settings") Settings settings);
	
	/**
	 * 插入一条记录
	 * @param user
	 * @return
	 */
	int insert(@Param("settings") Settings settings);
	
	/**
	 * 根据id更新记录
	 * @param user
	 * @return
	 */
	int update(@Param("settings") Settings settings);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	int deleteById(@Param("id") Integer id);
	
	/**
	 *根据id集合删除 
	 * @param ids
	 * @return
	 */
	int deleteByIds(@Param("ids") String ids);
}
