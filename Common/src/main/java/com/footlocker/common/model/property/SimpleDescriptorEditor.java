package com.footlocker.common.model.property;

import java.beans.PropertyEditorSupport;

import com.footlocker.common.SimpleDescriptor;
import com.footlocker.common.SimpleDescriptorImpl;

public class SimpleDescriptorEditor extends PropertyEditorSupport {

	    // Converts a String to a SimpleDescriptor with the submitted text as ID (when submitting form)
	    @Override
	    public void setAsText(String text) {
	        SimpleDescriptorImpl sd = new SimpleDescriptorImpl();
	        sd.setId(Integer.valueOf(text));
	        this.setValue(sd);
	    }

	    // Converts a SimpleDescriptor to a String (when displaying form)
	    @Override
	    public String getAsText() {
	    	SimpleDescriptor sd = (SimpleDescriptor) this.getValue();
	    	if (sd == null) {
	    		return "";
	    	}
	    	else
	    		return String.valueOf(sd.getId());
	    }
}
