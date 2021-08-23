package com.footlocker.common.ldap;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(locations = "classpath:application.properties", ignoreUnknownFields = false, prefix = "ldap")
public class LdapProperties {

	@NotBlank
    private String domain;
	@NotEmpty
	private String[] urls;
	@NotBlank
	private String searchDn;
	@NotBlank
	private String searchPassword;
	private String searchFilter;
	private String searchBase;
    private int httpPort;
    private int httpsPort; 
    
    public LdapProperties(){}
    
    public String getDomain() {
		return domain;
	}
    
    public void setDomain(String domain) {
		this.domain = domain;
	}

	public String[] getUrls() {
		return urls;
	}
	
	public void setUrls(String[] urls) {
		this.urls = urls;
	}
	
	public String getSearchDn() {
		return searchDn;
	}
	
	public void setSearchDn(String searchDn) {
		this.searchDn = searchDn;
	}
	
	public String getSearchPassword() {
		return searchPassword;
	}
	
	public void setSearchPassword(String searchPassword) {
		this.searchPassword = searchPassword;
	}
	
	public String getSearchFilter() {
		return searchFilter;
	}
	
	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	public String getSearchBase() {
		return searchBase;
	}
	
	public void setSearchBase(String ldapsearchBase) {
		this.searchBase = ldapsearchBase;
	}

	public int gethttpPort() {
		return httpPort;
	}
	
	public void sethttpPort(int httpPort) {
		this.httpPort = httpPort;
	}

	public int gethttpsPort() {
		return httpsPort;
	}
	
	public void sethttpsPort(int httpsPort) {
		this.httpsPort = httpsPort;
	}
    
}
