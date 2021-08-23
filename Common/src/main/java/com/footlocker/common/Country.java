package com.footlocker.common;

public enum Country {
	TURKEY("TURKEY"), 
	PORTUGAL("PORTUGAL"),
	GREECE("GREECE"), 
	SWEDEN("SWEDEN"), 
	UK("UNITED KINGDOM"), 
	SWITZERLAND("SWITZERLAND"), 
	LUXEMBOURG("LUXEMBOURG"),
	ITALY("ITALY"), 
	IRELAND("IRELAND"),
	CZECH_REPUBLIC("CZECH REPUBLIC"),
	CANARY_ISLANDS("CANARY ISLAND"), 
	AUSTRIA("AUSTRIA"), 
	SPAIN("SPAIN"), 
	NETHERLANDS("NETHERLANDS"),
	HUNGARY("HUNGARY"),
	BELGIUM("BELGIUM"),
	FRANCE("FRANCE"),
	POLAND("POLAND"), 
	DENMARK("DENMARK"), 
	GERMANY("GERMANY"),
	AUSTRALIA("AUSTRALIA"), 
	NEW_ZEALAND("NEW ZEALAND"), 
	HONG_KONG("HONG KONG"),
	UNITED_STATES("UNITED STATES"),
	CANADA("CANADA");
	
	private final String name;
	
	private Country(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public static final Country getCountryByName(String name) {
		for (Country r : Country.values()) {
			if (r.getName().equalsIgnoreCase(name))
				return r;
		}
		
		throw new IllegalArgumentException("No country with name '" + name +"' exists.");
	}

}
