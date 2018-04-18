package com.fqw.manager.vo;

import com.fqw.manager.util.Group;

public class Family {
 
	//户号
	private String family_id;
	//户主身份证号
	private String user_id;
	//组别
	private Group group_type;
	//地址
	private String adress;
	//贫富状态；0是普通居民，1是低保户，2是贫困户，3既是低保又是贫困户
	private Integer income_status;
	
	public Family() {
		super();
	}

	public Family(String family_id, String user_id, Group group, String adress, Integer status) {
		super();
		this.family_id = family_id;
		this.user_id = user_id;
		this.group_type = group;
		this.adress = adress;
		this.income_status = status;
	}

	public String getFamily_id() {
		return family_id;
	}

	public void setFamily_id(String family_id) {
		this.family_id = family_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Group getGroup_type() {
		return group_type;
	}

	public void setGroup_type(Group group_type) {
		this.group_type = group_type;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Integer getIncome_status() {
		return income_status;
	}

	public void setIncome_status(Integer income_status) {
		this.income_status = income_status;
	}

	@Override
	public String toString() {
		return "Family [family_id=" + family_id + ", user_id=" + user_id + ", group=" + group_type + ", adress=" + adress
				+ ", status=" + income_status + "]";
	}
	
	
}
