package com.luyubo.cms.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 文章实体类
 * @author 77028
 *
 */
@Document(indexName = "cms_article",type = "article")
public class Article implements Serializable{
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID=1L;
	@Id
	private Integer id;
	@Field(index=true,store=true,analyzer="ik_smart",searchAnalyzer="ik_smart",type=FieldType.text)
    private String title;

    private String picture;

    private Integer channelId;

    private Integer categoryId;
    
    private String channelName;

    private String categoryName;

    private Integer userId;

    private Integer hits;

    private Integer hot;

    private Integer status;

    private Integer deleted;

    private Date created;

    private Date updated;

    private Integer commentCnt;

    private String content;
    
    private String statusIds;
    
    private String nickname;
    
    private Integer tousuCnt;

    private Integer complainid;
    
    private String complaintype;
    
	private String urlip;
	
	private Integer tousuId;
	
	private String tousuTime;


	public Integer getTousuId() {
		return tousuId;
	}


	public void setTousuId(Integer tousuId) {
		this.tousuId = tousuId;
	}


	public String getTousuTime() {
		return tousuTime;
	}


	public void setTousuTime(String tousuTime) {
		this.tousuTime = tousuTime;
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
		return "Article [id=" + id + ", title=" + title + ", picture=" + picture + ", channelId=" + channelId
				+ ", categoryId=" + categoryId + ", channelName=" + channelName + ", categoryName=" + categoryName
				+ ", userId=" + userId + ", hits=" + hits + ", hot=" + hot + ", status=" + status + ", deleted="
				+ deleted + ", created=" + created + ", updated=" + updated + ", commentCnt=" + commentCnt
				+ ", content=" + content + ", statusIds=" + statusIds + ", nickname=" + nickname + ", tousuCnt="
				+ tousuCnt + "]";
	}


	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Article(Integer id, String title, String picture, Integer channelId, Integer categoryId, String channelName,
			String categoryName, Integer userId, Integer hits, Integer hot, Integer status, Integer deleted,
			Date created, Date updated, Integer commentCnt, String content, String statusIds, String nickname,
			Integer tousuCnt) {
		super();
		this.id = id;
		this.title = title;
		this.picture = picture;
		this.channelId = channelId;
		this.categoryId = categoryId;
		this.channelName = channelName;
		this.categoryName = categoryName;
		this.userId = userId;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
		this.commentCnt = commentCnt;
		this.content = content;
		this.statusIds = statusIds;
		this.nickname = nickname;
		this.tousuCnt = tousuCnt;
	}

	public Integer getComplainid() {
		return complainid;
	}


	public void setComplainid(Integer complainid) {
		this.complainid = complainid;
	}


	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getStatusIds() {
		return statusIds;
	}



	public void setStatusIds(String statusIds) {
		this.statusIds = statusIds;
	}


	public Integer getCommentCnt() {
		return commentCnt;
	}



	public void setCommentCnt(Integer commentCnt) {
		this.commentCnt = commentCnt;
	}



	public Integer getTousuCnt() {
		return tousuCnt;
	}



	public void setTousuCnt(Integer tousuCnt) {
		this.tousuCnt = tousuCnt;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
