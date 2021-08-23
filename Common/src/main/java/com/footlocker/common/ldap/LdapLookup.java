package com.footlocker.common.ldap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class LdapLookup {

	@Autowired
	LdapProperties ldapProps;

    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());        
    }
    
    @Bean
    public LdapContextSource contextSource () {
        LdapContextSource contextSource= new LdapContextSource();
        contextSource.setUrls(ldapProps.getUrls());
        contextSource.setBase(ldapProps.getSearchBase());
        
        contextSource.setUserDn(ldapProps.getSearchDn());
        contextSource.setPassword(ldapProps.getSearchPassword());
        
        Map<String, Object> baseEnvironmentProperties = new HashMap<String, Object>();
        baseEnvironmentProperties.put("java.naming.referral", "follow");
        
        contextSource.setBaseEnvironmentProperties(baseEnvironmentProperties);
        return contextSource;
    }
    
    

	@SuppressWarnings("unchecked")
	private String lookupCommonName(String samAccountName) {
		AndFilter filter = new AndFilter();
		samAccountName = samAccountName.substring(samAccountName.indexOf("\\") + 1);
		filter.and(new EqualsFilter("objectclass", "user"));
		filter.and(new EqualsFilter("sAMAccountName", samAccountName));
		ldapTemplate().setIgnorePartialResultException(true);
		List list = ldapTemplate().search("", filter.encode(), new AttributesMapper() {
			public Object mapFromAttributes(Attributes attrs) throws NamingException {
				return attrs.get("CN").get();
			}
		});
		
		return list.size() > 0 ? list.get(0).toString() : "NO CN FOUND";
	}
	
	@SuppressWarnings("unchecked")
	public String lookupLoginName(String commonName) {
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "user"));
		filter.and(new EqualsFilter("CN", commonName));
		ldapTemplate().setIgnorePartialResultException(true);
		List list = ldapTemplate().search("", filter.encode(), new AttributesMapper() {
			public Object mapFromAttributes(Attributes attrs) throws NamingException {
				return attrs.get("sAMAccountName").get();
			}
		});
		
		return list.size() > 0 ? list.get(0).toString() : "NO CN FOUND";
	}
	
	public String getCommonName() {
    	String samAccountName = SecurityContextHolder.getContext().getAuthentication().getName();

    	return lookupCommonName(samAccountName);
    	
    }
	
	public String getUserId() {
    	String samAccountName = SecurityContextHolder.getContext().getAuthentication().getName();
    	if(samAccountName.contains("\\")){
    		samAccountName = samAccountName.substring(samAccountName.lastIndexOf("\\")+1);
		}
    	return samAccountName;
    }
	
	public boolean isUserInRole(String role) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals(role));
		
		return hasUserRole;
    }
	
	public Set<String> listUserInRole(String role) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Set<String> roles = authentication.getAuthorities().stream()
		     .map(r -> r.getAuthority()).collect(Collectors.toSet());
		
		return roles;
    }
	
	public boolean isUserWithThisRole(String roleName) {
		
		boolean userRole = false;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Set<String> roles = authentication.getAuthorities().stream()
		     .map(r -> r.getAuthority()).collect(Collectors.toSet());

		for(String role: roles){
			if(role.startsWith(roleName)){
				userRole = true;
				break;
			}
		}

		return userRole;
    }
	
	public String getRegionNumber(String roleName) {
		
		List<String> regionList = new ArrayList<>(); 
		String regionalIds = "";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Set<String> roles = authentication.getAuthorities().stream()
		     .map(r -> r.getAuthority()).collect(Collectors.toSet());
	/*		roles.add("ROLE_CORP\\STORETRAVEL_REGION34");
		roles.add("ROLE_CORP\\StoreTravel_R14");
		roles.add("ROLE_CORP\\StoreTravel_R16");*/
		
		for(String role: roles){
			if(role.startsWith(roleName)){
				regionList.add(role.replace(roleName, ""));
			}
		}
		
		regionalIds = String.join(",", regionList);

		return regionalIds;
    }
	
}
