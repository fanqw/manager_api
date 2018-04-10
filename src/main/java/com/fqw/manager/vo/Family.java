package com.fqw.manager.vo;

import com.fqw.manager.util.Group;

public class Family {
   
	//排名
	private int index;
	//组别
	private Group group;
	//户号
	private String family_code;
	//户主
	private String master;
	//家庭成员
	private String family_group;
	public Family() {
		super();
	}
	
	public Family(int index, Group group, String family_code, String master, String family_group) {
		super();
		this.index = index;
		this.group = group;
		this.family_code = family_code;
		this.master = master;
		this.family_group = family_group;
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public String getFamily_code() {
		return family_code;
	}
	public void setFamily_code(String family_code) {
		this.family_code = family_code;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	public String getFamily_group() {
		return family_group;
	}
	public void setFamily_group(String family_group) {
		this.family_group = family_group;
	}
	@Override
	public String toString() {
		return "Family [index=" + index + ", group=" + group + ", family_code=" + family_code + ", master=" + master
				+ ", family_group=" + family_group + "]";
	}
	
}
