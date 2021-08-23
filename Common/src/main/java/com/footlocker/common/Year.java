package com.footlocker.common;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public enum Year {
	CURRENT_YEAR, LAST_YEAR, TWO_YEARS_AGO;
	
	public int getNumeric() {
		switch(this) {
		case CURRENT_YEAR: 
			return ZonedDateTime.now(ZoneOffset.UTC).getYear();
		case LAST_YEAR:
			return ZonedDateTime.now(ZoneOffset.UTC).getYear() - 1;
		case TWO_YEARS_AGO:
			return ZonedDateTime.now(ZoneOffset.UTC).getYear() - 2;
		default:
			return ZonedDateTime.now(ZoneOffset.UTC).getYear();
		}
			
	}
}