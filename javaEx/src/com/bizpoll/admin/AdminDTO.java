package com.bizpoll.admin;

public class AdminDTO {

	public AdminDTO() {
	}
	
	public AdminDTO(String id, String pwd, String name, String phone) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
	}

	public AdminDTO(String id, String pwd, String phone) {
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
	}

	private String id;
	private String pwd;
	private String name;
	private String phone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
