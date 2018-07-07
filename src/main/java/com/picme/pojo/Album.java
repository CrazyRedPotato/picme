package com.picme.pojo;

import java.sql.Timestamp;

public class Album {
	private int id;                  /* album id */
	private int user_id;/* 用户 id */
	private String name;/* 相册名 */
	private Timestamp createtime;/* 相册建立时间 */
	private int right;/* 相册访问权限 */
	private String comments;/* 相册描述 */
	private String cover_url;/* 相册封面图片 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCover_url() {
		return cover_url;
	}
	public void setCover_url(String cover_url) {
		this.cover_url = cover_url;
	}
}
