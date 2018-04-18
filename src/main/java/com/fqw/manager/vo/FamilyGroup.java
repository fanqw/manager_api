package com.fqw.manager.vo;

import com.fqw.manager.util.Group;

public class FamilyGroup {
   
	//排名
	private Integer index;
	//组别
	private Group group;
	//户号
	private String family_id;
	//户主
	private String master;
	//家庭成员数
	private Integer family_count;
	public FamilyGroup() {
		super();
	}
	
	public FamilyGroup(Integer index, Group group, String family_id, String master, Integer family_count) {
		super();
		this.index = index;
		this.group = group;
		this.family_id = family_id;
		this.master = master;
		this.family_count = family_count;
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
	public String getFamily_id() {
		return family_id;
	}
	public void setFamily_id(String family_id) {
		this.family_id = family_id;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	public Integer getFamily_count() {
		return family_count;
	}
	public void setFamily_count(Integer family_count) {
		this.family_count = family_count;
	}
	@Override
	public String toString() {
		return "Family [index=" + index + ", group=" + group + ", family_id=" + family_id + ", master=" + master
				+ ", family_count=" + family_count + "]";
	}
	
}
