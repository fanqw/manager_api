package com.fqw.manager.vo;

import java.sql.Date;

import com.fqw.manager.util.FamilySort;
import com.fqw.manager.util.Group;

public class Resident {
   
	//姓名
   private String  name;
	//性别
   private Integer gender;
   //出生日期
   private Date birthday;
   //身份证号
   private String user_id;
   // 户主关系
   private FamilySort relationship;
   //户号
   private String family_id;    
   //电话号码
   private String  phone_number;
   //存或
   private Integer alive;
   
   public Resident() {
		super();
	}

public Resident(String name, Integer gender, Date birthday, String user_id, FamilySort relationship, String family_id,
		String phone_number, Integer alive) {
	super();
	this.name = name;
	this.gender = gender;
	this.birthday = birthday;
	this.user_id = user_id;
	this.relationship = relationship;
	this.family_id = family_id;
	this.phone_number = phone_number;
	this.alive = alive;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getGender() {
	return gender;
}

public void setGender(Integer gender) {
	this.gender = gender;
}

public Date getBirthday() {
	return birthday;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

public String getUser_id() {
	return user_id;
}

public void setUser_id(String user_id) {
	this.user_id = user_id;
}

public FamilySort getRelationship() {
	return relationship;
}

public void setRelationship(FamilySort relationship) {
	this.relationship = relationship;
}

public String getFamily_id() {
	return family_id;
}

public void setFamily_id(String family_id) {
	this.family_id = family_id;
}

public String getPhone_number() {
	return phone_number;
}

public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
}

public Integer getAlive() {
	return alive;
}

public void setAlive(Integer alive) {
	this.alive = alive;
}

@Override
public String toString() {
	return "Resident [name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", user_id=" + user_id
			+ ", relationship=" + relationship + ", family_id=" + family_id + ", phone_number=" + phone_number
			+ ", alive=" + alive + "]";
}

   

}
