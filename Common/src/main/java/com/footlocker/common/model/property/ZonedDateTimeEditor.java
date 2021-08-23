package com.footlocker.common.model.property;

import java.beans.PropertyEditorSupport;
import java.time.ZonedDateTime;

public class ZonedDateTimeEditor extends PropertyEditorSupport {
	  // Converts a String to a SimpleDescriptor with the submitted text as ID (when submitting form)
    @Override
    public void setAsText(String text) {
    	ZonedDateTime dt = ZonedDateTime.parse(text);
        this.setValue(dt);
    }

    // Converts a SimpleDescriptor to a String (when displaying form)
    @Override
    public String getAsText() {
    	ZonedDateTime dt = (ZonedDateTime) this.getValue();
    	if (dt == null) {
    		return "";
    	}
    	else
    		return dt.toString();
    }
}
