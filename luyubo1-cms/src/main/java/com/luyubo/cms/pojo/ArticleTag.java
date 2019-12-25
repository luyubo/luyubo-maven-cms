package com.luyubo.cms.pojo;

import java.io.Serializable;

/**
 * 文章标签关联实体类
 * @author 77028
 *
 */
public class ArticleTag implements Serializable{
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID=1L;
	private Integer aid;
	private Integer tid;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public ArticleTag(Integer aid, Integer tid) {
		super();
		this.aid = aid;
		this.tid = tid;
	}
	public ArticleTag() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ArticleTag [aid=" + aid + ", tid=" + tid + "]";
	}
}
