package com.luyubo.cms.pojo;

import java.io.Serializable;

/**
 * 标签表
 * 
 * @author 77028
 *
 */
public class Tag implements Serializable{
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID=1L;
	private Integer id;
	private String tagname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public Tag(Integer id, String tagname) {
		super();
		this.id = id;
		this.tagname = tagname;
	}
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagname=" + tagname + "]";
	}
}
