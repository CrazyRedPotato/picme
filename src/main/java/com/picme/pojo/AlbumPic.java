package com.picme.pojo;

public class AlbumPic extends Picture{
	private int id;
	private int user_id;
	private int album_id;
	private int upload_time;
	private String pic_hash;
	private String pic_size;
	private String pic_url;
	private String pic_Thumbnail_url;
	
	private int first_upload_user_id;/* T.B.D */
	private String first_upload_time;/* T.B.D */
	
	
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
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public String getPic_hash() {
		return pic_hash;
	}
	public void setPic_hash(String pic_hash) {
		this.pic_hash = pic_hash;
	}
	public int getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(int upload_time) {
		this.upload_time = upload_time;
	}

	public String getPic_size() {
		return pic_size;
	}
	public void setPic_size(String pic_size) {
		this.pic_size = pic_size;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getPic_Thumbnail_url() {
		return pic_Thumbnail_url;
	}
	public void setPic_Thumbnail_url(String pic_Thumbnail_url) {
		this.pic_Thumbnail_url = pic_Thumbnail_url;
	}
}
