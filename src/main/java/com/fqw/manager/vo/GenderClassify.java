package com.fqw.manager.vo;

public class GenderClassify {

	//类型
	private String x;
	//人数
	private Integer y;
	
	public GenderClassify() {
		super();
	}

	public GenderClassify(String x, Integer y) {
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
		return "GenderClassify [x=" + x + ", y=" + y + "]";
	}
	
	
}
