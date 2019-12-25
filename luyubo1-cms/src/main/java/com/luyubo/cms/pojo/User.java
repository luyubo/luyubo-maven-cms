package com.luyubo.cms.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * User实体类
 */
public class User implements Serializable{
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID=1L;
	private Integer id;
	private String username;
	private String password;
	private String password1;
	private String nickname;
	private Date birthday;
	private Integer gender;
	private Integer locked;
	private Date create_time;
	private Date update_time;
	private String url;
	private Integer score;
	private String role;
	private String birthdayStr;
	private String headimg;
	private String isMima;
	public String getIsMima() {
		return isMima;
	}
	public void setIsMima(String isMima) {
		this.isMima = isMima;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public String getBirthdayStr() {
		return birthdayStr;
	}
	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getLocked() {
		return locked;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public User(Integer id, String username, String password, String password1, String nickname, Date birthday,
			Integer gender, Integer locked, Date create_time, Date update_time, String url, Integer score,
			String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.password1 = password1;
		this.nickname = nickname;
		this.birthday = birthday;
		this.gender = gender;
		this.locked = locked;
		this.create_time = create_time;
		this.update_time = update_time;
		this.url = url;
		this.score = score;
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", password1=" + password1
				+ ", nickname=" + nickname + ", birthday=" + birthday + ", gender=" + gender + ", locked=" + locked
				+ ", create_time=" + create_time + ", update_time=" + update_time + ", url=" + url + ", score=" + score
				+ ", role=" + role + ", birthdayStr=" + birthdayStr + ", headimg=" + headimg + "]";
	}
	//判断是否是管理员
	public boolean isAdmin() {
    	return "1".equals(getRole());
    }

}
