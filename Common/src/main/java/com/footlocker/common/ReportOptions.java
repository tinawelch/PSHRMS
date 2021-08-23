package com.footlocker.common;

public enum ReportOptions {
	DISTRICT_REGION_MONTH("Stores by District & Region - Month"), 
	DISTRICT_REGION_ROLLING("Stores by District & Region - Rolling 12 Months"), 
	DEPARTMENT_REGION_ROLLING("Department by Region - Rolling 12 Months"), 
	TOTAL_SUMMARY("Total Summary - month & rolling 12 months"),
	BEST_TO_WORST("Best to Worst Stores - rolling 12 months"),
	DEPARTMENT_BY_DIVISION("Department by Division - rolling 12 months"),
	RVP_BY_MONTH("RVP - month & rolling 12 months"),
	ALL("All Reports");
	
	private final String displayName;
	
	private ReportOptions(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}	
}