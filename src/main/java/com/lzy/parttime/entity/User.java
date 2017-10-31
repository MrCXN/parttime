package com.lzy.parttime.entity;

/**
 * 
 * @author 李兆阳
 * @description : [用户实体类]
 *
 * @时间: 2017年10月19日 上午10:55:54
 */
public class User {

	private int id;
	private String userNm; //用户名称
	private String pwd;  //密码
	private String userAccount;//帐号
	private String phone; //电话
	private int userType; //用户类型 0管理员,1用户
	private String addTime; //添加时间
	private int sex; //性别 0男,1女
	private int delFlag; //删除标志位 0未删除,1已删除
	
	
	//=========G/S=============
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	
}
