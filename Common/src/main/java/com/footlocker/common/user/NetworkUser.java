package com.footlocker.common.user;

public class NetworkUser implements User {

	private String loginName;
	private String commonName;
	
	public NetworkUser(String loginName, String commonName) {
		this.loginName = loginName;
		this.commonName = commonName;
	}
	
	@Override
	public String getId() {
		return loginName;
	}

	@Override
	public String getFullName() {
		return commonName;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof NetworkUser)) 
			return false;
		
		NetworkUser user = (NetworkUser)o;
		return user.getId().equals(loginName)
				&& user.getFullName().equals(commonName);
	}

	

}
