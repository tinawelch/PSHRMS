package com.footlocker.common.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTimeUtil {
	
	public static ZonedDateTime currentGMT() {
		return ZonedDateTime.now(ZoneOffset.UTC);
	}
	
	public static LocalDateTime localTime() {
		return LocalDateTime.now();
	}
	
	public static ZonedDateTime convertToGMT(LocalDateTime timestamp) {
		return ZonedDateTime.of(timestamp, ZoneOffset.UTC);
	}
	
	public static ZonedDateTime convertToGMT(LocalDate date) {
		return ZonedDateTime.of(date, LocalTime.MIDNIGHT, ZoneOffset.UTC);
	}
	
	public static ZonedDateTime convertStringDateToZDT(String dateString){
		ZonedDateTime  zonedDateTime = null;
		try{
		zonedDateTime = ZonedDateTime.ofInstant(new SimpleDateFormat("MM/dd/yyyy").parse(dateString).toInstant(), ZoneId.of("GMT-5"));
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return zonedDateTime;
		
	}
	
	public static java.util.Date convertStringToDate(String dateString){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
	    java.util.Date convertedDate = null;
	    try {
	        convertedDate = df.parse(dateString);
	        
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
		return convertedDate;
	}
	
}
