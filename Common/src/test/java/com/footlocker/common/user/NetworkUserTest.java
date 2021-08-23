package com.footlocker.common.user;

import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkUserTest {

	@Test
	public void testEquals() {
		String loginName = "testLogin";
		String commonName = "John Doe";
		
		NetworkUser user1 = new NetworkUser(loginName, commonName);
		NetworkUser user2 = new NetworkUser(loginName, commonName);
		NetworkUser user3 = new NetworkUser("otherLogin", "Jane Doe");
		
		assertTrue(user1.equals(user2));
		assertFalse(user3.equals(user1));
	}

}
