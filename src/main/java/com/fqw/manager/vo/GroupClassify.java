package com.fqw.manager.vo;

import com.fqw.manager.util.Group;

public class GroupClassify {

	//类型
	private Group x;
	//总数
	private Integer y;
	
	public GroupClassify() {
		super();
	}

	public GroupClassify(Group x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Group getX() {
		return x;
	}

	public void setX(Group x) {
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
		return "GroupClassify [x=" + x + ", y=" + y + "]";
	}
	
}
