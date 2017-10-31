package com.lzy.parttime.entity;

/**
 * 
 * @author 李兆阳
 * @description : [公司实体类]
 *
 * @时间: 2017年10月19日 上午10:55:54
 */
public class Advertising {

	private int id;
	private String name;
	private Double salary;  //工资
	private String sex;//性别
	private String age;
	private String detail;  //详情
	private int companyId; //公司id
	private int delFlag; //删除标志位 0未删除,1已删除
	
	//=========G/S=============
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	
}
