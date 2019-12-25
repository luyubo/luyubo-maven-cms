package com.luyubo.cms.pojo;

import java.io.Serializable;

/**
 * 文章评论表
 * @author 77028
 *
 */
public class Comment implements Serializable{
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID=1L;
	private Integer id;
	private Integer articleId;
	private Integer userId;
	private String content;
	private String created;
	private String created1;
	private String nickname;
    private String headimg;
    private Integer deleted;
    private String title;
	public String getCreated1() {
		return created1;
	}
	public void setCreated1(String created1) {
		this.created1 = created1;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public Comment(Integer id, Integer articleId, Integer userId, String content, String created, String nickname,
			String headimg, Integer deleted, String title) {
		super();
		this.id = id;
		this.articleId = articleId;
		this.userId = userId;
		this.content = content;
		this.created = created;
		this.nickname = nickname;
		this.headimg = headimg;
		this.deleted = deleted;
		this.title = title;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", articleId=" + articleId + ", userId=" + userId + ", content=" + content
				+ ", created=" + created + ", created1=" + created1 + ", nickname=" + nickname + ", headimg=" + headimg
				+ ", deleted=" + deleted + ", title=" + title + "]";
	}
}
