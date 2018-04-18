package com.fqw.manager.vo;

public class IncomeClassify {

	//类型
	private String x;
	//人数
	private Integer y;
	
	public IncomeClassify() {
		super();
	}

	public IncomeClassify(String x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "IncomeClassify [x=" + x + ", y=" + y + "]";
	}
	
}
