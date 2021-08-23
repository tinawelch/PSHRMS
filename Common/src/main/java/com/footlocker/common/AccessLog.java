package com.footlocker.common;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import com.footlocker.common.user.User;

public interface AccessLog {

	public Map<User, List<ZonedDateTime>> getUserAccessLog();

	public void clearUserAccessLog();

	public void logUserAccess(User user);
}
