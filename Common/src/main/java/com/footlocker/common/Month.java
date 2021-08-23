package com.footlocker.common;

public enum Month {
	January("Jan", 1), February("Feb", 2), March("Mar", 3), April("Apr", 4), May("May", 5), 
	June("Jun", 6), July("Jul", 7), August("Aug", 8), September("Sep", 9), October("Oct", 10),
	November("Nov", 11), December("Dec", 12);
	
	private final String shortName;
	private final int num;
	
	private Month(String shortName, int num) {
		this.shortName = shortName;
		this.num = num;
	}
	
	public String getShortName() {
		return shortName;
	}

	public static Month fromJavaEnum(java.time.Month m) {
		return Month.values()[m.getValue() - 1];
	}

	public int getNum() {
		return num;
	}
}