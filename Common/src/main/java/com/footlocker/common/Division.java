package com.footlocker.common;

import com.google.common.collect.ImmutableBiMap;

public enum Division {
	ALL("All", ""),
	FL_LFL_SIX02_KFL_FA("FL-LFL-SIX02-KFL", "003"), 
	CHP_FA("CHP-FA", "003"),
	CHAMPS("Champs", "018"), 
	CHAMPS_CANADA("Champs Canada", "077"), 
	FL_ASIA("FL Asia", ""), 
	FL_PACIFIC("FL Pacific", ""), 
	FL_CANADA("FL Canada", "076"), 
	FL_EUROPE("FL Europe", ""), 
	FOOT_LOCKER("Foot Locker", "003"), 
	FOOTACTION("Footaction", "029"),
	KIDS_FOOT_LOCKER("Kids Foot Locker", "016"), 
	LADY_FOOT_LOCKER("Lady Foot Locker", "003"), 
	SIX02("Six:02", "008"), 
	RPG("RPG", ""),
	NORTHAMERICA("North America", "");
	
	private final String displayName;
	private final String divisionNum;
	private static ImmutableBiMap<Division, String[]> dbaMap;
	
	static {
		ImmutableBiMap.Builder<Division, String[]> mapBuilder = 
				new ImmutableBiMap.Builder<Division, String[]>();
		
		mapBuilder.put(FL_LFL_SIX02_KFL_FA, new String[]{"Foot Locker", "Foot Locker Outlet", "Lady Foot Locker", "Kid's Foot Locker", "Footaction", "SIX:02"});
		mapBuilder.put(FOOT_LOCKER, new String[]{"Foot Locker", "Foot Locker Outlet"});
		mapBuilder.put(LADY_FOOT_LOCKER, new String[]{"Lady Foot Locker"});
		mapBuilder.put(SIX02, new String[]{"SIX:02"});
		mapBuilder.put(KIDS_FOOT_LOCKER, new String[]{"Kids Foot Locker"});
		mapBuilder.put(FOOTACTION, new String[]{"Footaction"});
		mapBuilder.put(FL_CANADA, new String[]{"FL Canada", "Foot Locker Canada", "Kids Foot Locker Canada"});
		mapBuilder.put(FL_EUROPE, new String[]{"FL Europe", "KIDS FOOT LOCKER FR", "FOOT LOCKER BELGIUM", "FOOT LOCKER BELGIE N.V.", "DBOT LOCKER GERMANY", "FOOT LOCKER UK", "ALSHAYA FRANCHISE OPERATN", "FOOT LOCKER ITALY S.R.L.",
				"FOOT LOCKER SWITZERLAND", "FOOT LOCKER POLAND", "FOOT LOCKER GERMANY", "FOOT LOCKER FRANCE S.A.", "FOOT LOCKER NE", "FOOT LOCKER CANARY ISLAND", "FOOT LOCKER", "KIDS FOOT LOCKER UK", "FOOT LOCKER SPAIN", 
				"FOOT LOCKER TURKEY", "FOOT LOCKER DENMARK APS", "FOOT LOCKER GREECE", "FOOT LOCKER FRANCE", "FOOT LOCKER SPAIN S.L.", "FOOT LOCKER EUROPE", "FOOT LOCKER DENMARK", "FREEDOM SPORTSLINE LTD.", "THE LOCKER ROOM FRANCE",
				"FOOT LOCKER PORTUGAL", "FOOT LOCKER FRANCE, S.A.", "KIDS FOOT LOCKER", "FOOT LOCKER U.K.", "FOOT LOCKER CZECH REPUBLI", "KIDS FOOT LOCKER FRANCE", "FOOT LOCKER GERMANY",
				"KIDS FOOT LOCKER SPAIN", "FOOT LOCKER SWEDEN", "FOOT LOCKER ITALY", "FOOT LOCKER AUSTRIA GMBH", "KIDS FOOT LOCKER NE", "FOOT LOCKER NEDERLANDS BV", "FOOT LOCKER BELGIUM", "FOOT LOCKER AUSTRIA",
				"FOOT LOCKER NETHERLANDS", "KIDS FOOT LOCKER ITALY", "KIDS FOOT LOCKER IT", "FOOT LOCKER LUXEMBOURG", "FOOT LOCKER HUNGARY", "FOOT LOCKER IRELAND"});
		mapBuilder.put(FL_ASIA, new String[]{"FL Asia", "Foot Locker Asia"});
		mapBuilder.put(FL_PACIFIC, new String[]{"FL Pacific", "Foot Locker Australia", "Foot Locker New Zealand"});
		mapBuilder.put(CHAMPS, new String[]{"Champs"});
		mapBuilder.put(CHP_FA, new String[]{"Champs", "Footaction"});
		mapBuilder.put(CHAMPS_CANADA, new String[]{"Champs Canada"});
		mapBuilder.put(RPG, new String[]{"RPG", "RUNNER POINT AUSTRIA", "RUNNER POINT GERMANY", "RUNNER POINT", "RUN2 BY RUNNERS POINT GE", "SIDESTEP AUSTRIA", "SIDESTEP GERMANY", "SIDESTEP NETHERLANDS", "WORLD OF RUNNING GERMANY",
				"RUNNERS POINT GRP, BI", "SIDESTEP SWITZERLAND", "RUNNERS POINT SWITZERLAND", "RUNNERS POINT GROUP", "FRANCHISE RUN2 GERMANY", "RUNNERS POINT GE"});
		
		dbaMap = mapBuilder.build();
	}
	
	public static Division getDivisionFromDBA(String[] dba) {	
		return dbaMap.inverse().get(dba);
	}
	
	public static Division getDivisionFromDisplayName(String displayName) {
		for (Division div : Division.values()) {
			if (div.displayName.equals(displayName))
				return div;
		}
		
		return null;
	}
	
	private Division(String displayName, String divisionNum) {
		this.displayName = displayName;
		this.divisionNum = divisionNum;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public String getDivisionNum() {
		return divisionNum;
	}
	
	public String[] getDBAObjects() {	
		return dbaMap.get(this);	
	}
	
	
	
	
	
	
}
