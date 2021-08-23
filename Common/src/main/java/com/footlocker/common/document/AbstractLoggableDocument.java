package com.footlocker.common.document;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.footlocker.common.AccessLog;
import com.footlocker.common.user.User;
import com.footlocker.common.util.DateTimeUtil;

public abstract class AbstractLoggableDocument implements Document, AccessLog {
	
	private String fileName;
	private ZonedDateTime lastModified;
	private ZonedDateTime dateCreated;
	private Map<User, List<ZonedDateTime>> userAccessLog;
	
	public AbstractLoggableDocument() {}
	
	public AbstractLoggableDocument(String fileName, ZonedDateTime dateCreated, ZonedDateTime lastModified, Map<User, List<ZonedDateTime>> userAccessLog) {
		this.fileName = fileName;
		this.lastModified = lastModified;
		this.dateCreated = dateCreated;
		this.userAccessLog = userAccessLog;	
	}

	@Override
	public Map<User, List<ZonedDateTime>> getUserAccessLog() {
		return userAccessLog;
	}

	@Override
	public void clearUserAccessLog() {
		userAccessLog.clear();
	}

	@Override
	public void logUserAccess(User user) {
		List<ZonedDateTime> dateList = userAccessLog.get(user);

		// A user entry for this doc already exists. Add a new access date.
		if (dateList != null) {
			dateList.add(DateTimeUtil.currentGMT());
			userAccessLog.put(user, dateList);
		}
		// No user access before. Log this date.
		else {
			dateList = new Vector<ZonedDateTime>();
			dateList.add(DateTimeUtil.currentGMT());
			userAccessLog.put(user, dateList);
		}

	}

	@Override
	public String getFileName() {
		return fileName;
	}
	
	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public ZonedDateTime getLastModified() {
		return lastModified;
	}

	@Override
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

}
