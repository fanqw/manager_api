package com.fqw.manager.vo;

import com.alibaba.fastjson.JSON;

public class ChartData {

	//图表一
	private Object searchData;
	//总人口
	private Integer residentCount;
	//图表二 按年龄分
	private Object ageClassify;
    //图表二，按性别分
	private Object genderClassify;
	
	public ChartData() {
		super();
	}

	public Object getSearchData() {
		return searchData;
	}


	public void setSearchData(Object searchData) {
		this.searchData = searchData;
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

	@Override
	public String toString() {
		return "ChartData [searchData=" + searchData + ", residentCount=" + residentCount + ", ageClassify="
				+ ageClassify + ", genderClassify=" + genderClassify + "]";
	}

	public String toJson() {
		return JSON.toJSONString(this);
	}
}
