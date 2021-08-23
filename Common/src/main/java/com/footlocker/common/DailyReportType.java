package com.footlocker.common;

public enum DailyReportType {
	DS4("4", "Daily Sales by Department", true, CalendarType.DEFAULT, "dailyReport4"),
	DS4A("4A", "Alshaya Daily Sales by Department", false, CalendarType.DEFAULT, "dailyReport4A"),
	DS4DTC("4-DTC", "Direct to Customer Daily Sales by Department", false, CalendarType.DEFAULT, "dailyReport4DTC"),
	DS4EQ("4EQ", "Europe Quarter-to-Date and Year-to-Date Sales", false, CalendarType.SUNDAY_ONLY, "dailyReport4EQ"),
	DS4FRPG("4F-RPG", "Runners Point Group Franchise Daily Sales by Department", false, CalendarType.DEFAULT, "dailyReport4FRPG"),
	DS4S("4S", "Supplemental Daily Sales by Department", true, CalendarType.SATURDAY_ONLY, "dailyReport4S"),
	DS5("5", "Daily Receipts by Department", true, CalendarType.DEFAULT, "dailyReport5"),
	DS6("6", "Daily Markdowns by Department", true, CalendarType.DEFAULT, "dailyReport6"),
	DS7("7", "Daily Sales Flash", false, CalendarType.DEFAULT, "dailyReport7"),
	DS7E("7E", "Europe Daily Sales Flash", false, CalendarType.WEEK_ONLY, "dailyReport7E"),
	DS8("8", "Daily Sales by State", true, CalendarType.DEFAULT, "dailyReport8"),
	DS9("9", "9 Weekly Sales by State, Store", false, CalendarType.SATURDAY_ONLY, "dailyReport9"),
	DS15("15", "Daily Top Volume Stores", false, CalendarType.WEEK_ONLY, "dailyReport15"),
	DS22E("22E", "Europe Daily Sales by Country, League, Type", false, CalendarType.DEFAULT, "dailyReport22E"),
	DS22ERPG("22E-RPG", "Runner Point Group Daily Sales by Country, League, Type", false, CalendarType.DEFAULT, "dailyReport22ERPG"),
	DS22F("22F", "Franchise Daily Sales", false, CalendarType.DEFAULT, "dailyReport22F"),
	DS22FRPG("22F-RPG", "Runners Point Group Franchise Daily Sales", false, CalendarType.DEFAULT, "dailyReport22FRPG"),
	DS24("24", "Daily Sales by Region and League", true, CalendarType.DEFAULT, "dailyReport24"),
	DS26("26", "Daily Sales by Store Type", false, CalendarType.DEFAULT, "dailyReport26"),
	DS27("27", "Stock Locator Sales - Domestic Stores", false, CalendarType.DEFAULT, "dailyReport27"),
	DS27AP("27AP", "Stock Locator Sales - Asia Pacific Stores", false, CalendarType.SATURDAY_ONLY, "dailyReport27AP"),
	DS27A("27A", "Stock Locator Sales - Asia Stores", false, CalendarType.SATURDAY_ONLY, "dailyReport27A"),
	DS27P("27P", "Stock Locator Sales - Pacific Stores", false, CalendarType.DEFAULT, "dailyReport27P"),
	DS27C("27C", "Stock Locator Sales - Canadian Stores", false, CalendarType.DEFAULT, "dailyReport27C"),
	DS27E("27E", "Stock Locator Sales - Europe by Country", false, CalendarType.SATURDAY_ONLY, "dailyReport27E");
	

	private final String id;
	private final String description;
	private final boolean hasDivision;
	private final CalendarType calType;
	private final String functionName;
	
	private DailyReportType(String id, String description, boolean hasDivision, CalendarType calType, String functionName) {
		this.id = id;
		this.description = description;
		this.hasDivision = hasDivision;
		this.calType = calType;
		this.functionName = functionName;
	}
	
	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public boolean hasDivision() {
		return hasDivision;
	}

	public CalendarType getCalType() {
		return calType;
	}
	
	public static final DailyReportType getReportTypeById(String id) {
		for (DailyReportType type : DailyReportType.values()) {
			if (id.equals(type.getId()))
				return type;
		}
		
		throw new IllegalArgumentException("No DailyReportType with an id of '" + id + "' exists.");
	}

	public String getFunctionName() {
		return functionName;
	}

	public static enum CalendarType {
		DEFAULT, SIX_DAY, SATURDAY_ONLY, WEEK_ONLY, SUNDAY_ONLY, NONE;
	}
}
