package com.footlocker.common;

import org.springframework.http.MediaType;

public enum ContentType {

	PDF(new MediaType("application", "pdf"), ".pdf"),
	DOC(new MediaType("application", "msword"), ".doc"),
	DOCX(new MediaType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document"), ".docx"),
	XLS(new MediaType("application", "vnd.ms-excel"), ".xls"),
	XLSX(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"), ".xlsx"),
	PPT(new MediaType("application", "vnd.ms-powerpoint"), ".ppt"),
	PPTX(new MediaType("application", "vnd.openxmlformats-officedocument.presentationml.presentation"), ".pptx");
	
	private final MediaType type;
	private final String fileExtension;
	
	private ContentType(MediaType type, String fileExtension) {
		this.type = type;
		this.fileExtension = fileExtension;
	}
	
	public static MediaType toMediaType(String filename) {
		if (filename.contains(".")) {
			String ext = filename.substring(filename.indexOf("."));
			for (ContentType t : ContentType.values()) {
				if (t.fileExtension.equals(ext)) {
					return t.type;
				}
			}
			
			//Return null if it's an unlisted type
			return null;
		}
		
		throw new IllegalArgumentException("Cannot determine file extension for file '" + filename + "'");
	}
}
