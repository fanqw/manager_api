package com.fqw.auto;

import java.sql.Date;

public class Resident {
   
	//姓名
   private String  name;
	//性别
   private Boolean sex;
   //出生日期
   private Date birthday;
   //身份证号
   private Integer id_card;
   // 户主关系
   private Family relationship;
   //户号
   private Integer code;  
   //地址
   private String adress;  
   //组别
   private Group group;  
   
   //电话号码
   private String  phone_number;
   
   public Resident() {
		super();
	}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Boolean getSex() {
	return sex;
}

public void setSex(Boolean sex) {
	this.sex = sex;
}

public Date getBirthday() {
	return birthday;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

public Integer getId_card() {
	return id_card;
}

public void setId_card(Integer id_card) {
	this.id_card = id_card;
}

public Family getRelationship() {
	return relationship;
}

public void setRelationship(Family relationship) {
	this.relationship = relationship;
}

public Integer getCode() {
	return code;
}

public void setCode(Integer code) {
	this.code = code;
}

public String getAdress() {
	return adress;
}

public void setAdress(String adress) {
	this.adress = adress;
}

public Group getGroup() {
	return group;
}

public void setGroup(Group group) {
	this.group = group;
}

public String getPhone_number() {
	return phone_number;
}

public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
}
   
   
   
   
}
