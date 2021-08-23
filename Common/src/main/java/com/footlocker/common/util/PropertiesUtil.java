package com.footlocker.common.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(locations = "classpath:application.properties", ignoreUnknownFields = false, prefix = "util")
public class PropertiesUtil {

	private String serverName;
	private String folderName;
	private String storeinstructionfile;
	private String corpinstructionfile;
	
	
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getStoreinstructionfile() {
		return storeinstructionfile;
	}
	public void setStoreinstructionfile(String storeinstructionfile) {
		this.storeinstructionfile = storeinstructionfile;
	}
	public String getCorpinstructionfile() {
		return corpinstructionfile;
	}
	public void setCorpinstructionfile(String corpinstructionfile) {
		this.corpinstructionfile = corpinstructionfile;
	}
	
	
}

