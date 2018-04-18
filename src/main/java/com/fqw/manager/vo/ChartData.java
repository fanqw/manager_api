package com.fqw.manager.vo;

import com.alibaba.fastjson.JSON;

public class ChartData {

	//图表一
	private Object residentsData;
	//总人口
	private Integer residentCount;
	//图表二 按年龄分
	private Object ageClassify;
    //图表二，按性别分
	private Object genderClassify;
	//图表二，按收入分
	private Object incomeClassify;
	//图表二，按分组分
	private Object groupClassify;
	
	public ChartData() {
		super();
	}

	public Object getResidentsData() {
		return residentsData;
	}

	public void setResidentsData(Object residentsData) {
		this.residentsData = residentsData;
	}

	public Integer getResidentCount() {
		return residentCount;
	}

	public void setResidentCount(Integer residentCount) {
		this.residentCount = residentCount;
	}

	public Object getAgeClassify() {
		return ageClassify;
	}

	public void setAgeClassify(Object ageClassify) {
		this.ageClassify = ageClassify;
	}

	public Object getGenderClassify() {
		return genderClassify;
	}

	public void setGenderClassify(Object genderClassify) {
		this.genderClassify = genderClassify;
	}

	public Object getIncomeClassify() {
		return incomeClassify;
	}

	public void setIncomeClassify(Object incomeClassify) {
		this.incomeClassify = incomeClassify;
	}

	public Object getGroupClassify() {
		return groupClassify;
	}

	public void setGroupClassify(Object groupClassify) {
		this.groupClassify = groupClassify;
	}

	public String toJson() {
		return JSON.toJSONString(this);
	}

	@Override
	public String toString() {
		return "ChartData [residentsData=" + residentsData + ", residentCount=" + residentCount + ", ageClassify="
				+ ageClassify + ", genderClassify=" + genderClassify + "]";
	}
	
	
}
