package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.Category;


/**
 * 分类表Dao层接口
 * @author 77028
 *
 */
public interface CategoryDao {
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	Category selectById(@Param("id") Integer id);
	/**
	 * 查询所有数据集合
	 * @param user
	 * @return
	 */
	List<Category> select(@Param("category") Category category);
	/**
	 * 查询多少条
	 * @param user
	 * @return
	 */
	int count(@Param("category") Category category);
	
	/**
	 * 插入一条记录
	 * @param user
	 * @return
	 */
	int insert(@Param("category") Category category);
	
	/**
	 * 根据id更新记录
	 * @param user
	 * @return
	 */
	int update(@Param("category") Category category);
	
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
	
	/**
	 * 根据id查询频道
	 * @param channelId
	 * @return
	 */
	List<Category> getCateListByChannelId(@Param("channelId")Integer channelId);
}
