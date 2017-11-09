package com.lzy.parttime.entity;

/**
 * 
 * @author 李兆阳
 * @description : [招聘用户实体类]
 *
 * @时间: 2017年10月19日 上午10:55:54
 */
public class SeekUser {

	private int id;
	private String password;  //密码
	private String phone; //电话
	private String seekNm; //名称
	private int delFlag; //删除标志位 0未删除,1已删除
	
	
	//=========G/S=============
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSeekNm() {
		return seekNm;
	}
	public void setSeekNm(String seekNm) {
		this.seekNm = seekNm;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
}
