

public enum Region {
	TURKEY("Turkey", "090", "067"), PORTUGAL("Portugal", "351", "074"),
	GREECE("Greece", "030", "058"), SIDESTEP_NE("Sidestep NE", "031", "044"), SWEDEN("Sweden", "046", "039"),
	RUNNERS_PT_SWITZ("RP SWITZERLAND", "041", "093"), UK("UNITED KINGDOM", "044", "034"), RUNNERS_PT_GE("Runners Point GE", "049", "047"),
	SWITZERLAND("SWITZERLAND", "041", "093"), SIDESTEP_SWITZ("SIDESTEP SWITZERLAND", "041", "093"),
	SIDESTEP_AUSTRIA("SIDESTEP AUSTRIA", "043", "045"), LUXEMBOURG("LUXEMBOURG", "352", "038"),
	ITALY("ITALY", "039","036"), IRELAND("IRELAND", "353", "092"), CZECH_REPUBLIC("CZECH REPUBLIC", "420", "054"),
	CANARY("ISLAS CANARIAS", "348", "089"), AUSTRIA("AUSTRIA", "043", "094"), 
	SPAIN("SPAIN", "034", "041"), NETHERLANDS("THE NETHERLANDS", "031", "031"), HUNGARY("HUNGARY", "036", "061"),
	RUNNERS_PT_AUSTRIA("RUNNERS POINT AUSTRI", "043", "046"), BELGIUM("BELGIUM", "032", "032"),
	FRANCE("FRANCE", "033", "035"), SIDESTEP_GE("SIDESTEP GERMANY", "049", "043"), 
	POLAND("POLAND", "048", "088"), DENMARK("DENMARK", "045", "055"), GERMANY("GERMANY", "049", "033"),
	AUSTRALIA("AUSTRALIA", "061","024"), NEW_ZEALAND("NEW ZEALAND", "064", "028"), UNITED_STATES("UNITED STATES", "001", "001"),
	CANADA("CANADA", "028", "028");
	
	private final String name;
	private final String countryCode;
	private final String displayCode;
	
	private Region(String name, String countryCode, String displayCode) {
		this.name = name;
		this.countryCode = countryCode;
		this.displayCode = displayCode;
	}

	public String getDisplayCode() {
		return displayCode;
	}

	public String getCode() {
		return countryCode;
	}

	public String getName() {
		return name;
	}
	
	public static final String getDisplayCodeByName(String regionName) {
		for (Region r : Region.values()) {
			if (r.getName().equalsIgnoreCase(regionName))
				return r.getDisplayCode();
		}
		
		return null;
	}
	
	public static final Region getRegionByName(String regionName) {
		for (Region r : Region.values()) {
			if (r.getName().equalsIgnoreCase(regionName))
				return r;
		}
		
		throw new IllegalArgumentException("No region with name '" + regionName +"' exists.");
	}

}
