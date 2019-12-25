package com.luyubo.cms.pojo;
/**
 * 投票内容表
 * @author 77028
 *
 */
public class VoteContent {
	private Integer id;
	private Integer content;
	private Integer title;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getContent() {
		return content;
	}
	public void setContent(Integer content) {
		this.content = content;
	}
	public Integer getTitle() {
		return title;
	}
	public void setTitle(Integer title) {
		this.title = title;
	}
	public VoteContent(Integer id, Integer content, Integer title) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
	}
	public VoteContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VoteContent [id=" + id + ", content=" + content + ", title=" + title + "]";
	}
}
