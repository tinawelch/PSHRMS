package com.footlocker.common.document;

import java.time.ZonedDateTime;

public interface Document {
	
	public String getFileName();
	
	public void setFileName(String fileName);
	
	public ZonedDateTime getLastModified();
	
	public ZonedDateTime getDateCreated();

}