package com.footlocker.common;

public enum Week {
	ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5");
	
	private String num;
	
	private Week(String num) {
		this.num = num;
	}
	
	public String getNum() {
		return num;
	}
	
}
