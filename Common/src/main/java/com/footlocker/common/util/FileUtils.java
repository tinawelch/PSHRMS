package com.footlocker.common.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class FileUtils {

	static Logger logger = LogManager.getLogger(FileUtils.class.getClass());
	//IE, and perhaps other non-Chrome, non-Mozilla browsers, include the full path in the file name on file uploads.
	//This method cleans that out.
	public static String cleanPathFromFileName(String fileName) {
		logger.info("Entered into cleanPathFromFileName method");
		logger.info("File Name: "+ fileName);
		try{
		if(fileName.contains("\\")){
			return fileName.substring(fileName.lastIndexOf("\\")+1);
		}
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		logger.info("Exit from cleanPathFromFileName method");
		return fileName;
	}
}
