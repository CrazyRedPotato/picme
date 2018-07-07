package com.picme.pojo;

public class User {
	private int id;
	private String mail;
	private String phone;
	private String pwdsalt;
	private String pwdhash;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwdsalt() {
		return pwdsalt;
	}
	public void setPwdsalt(String pwdsalt) {
		this.pwdsalt = pwdsalt;
	}
	public String getPwdhash() {
		return pwdhash;
	}
	public void setPwdhash(String pwdhash) {
		this.pwdhash = pwdhash;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
