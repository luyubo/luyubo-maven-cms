package com.luyubo.cms.pojo;
/**
 * 投诉表的实体类
 * @author 77028
 *
 */
public class Complain {
	private Integer id;
	private Integer articleId;
	private Integer userId;
	private String complaintype;
	private String urlip;
	private String created;
	private Integer min;
	private Integer max;
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
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
	public String getComplaintype() {
		return complaintype;
	}
	public void setComplaintype(String complaintype) {
		this.complaintype = complaintype;
	}
	public String getUrlip() {
		return urlip;
	}
	public void setUrlip(String urlip) {
		this.urlip = urlip;
	}
	@Override
	public String toString() {
		return "Complain [id=" + id + ", articleId=" + articleId + ", userId=" + userId + ", complaintype="
				+ complaintype + ", urlip=" + urlip + ", created=" + created + ", min=" + min + ", max=" + max + "]";
	}
	public Complain(Integer id, Integer articleId, Integer userId, String complaintype, String urlip, String created) {
		super();
		this.id = id;
		this.articleId = articleId;
		this.userId = userId;
		this.complaintype = complaintype;
		this.urlip = urlip;
		this.created = created;
	}
	public Complain() {
		super();
		// TODO Auto-generated constructor stub
	}
}
