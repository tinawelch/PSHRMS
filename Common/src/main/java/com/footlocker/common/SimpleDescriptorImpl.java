package com.footlocker.common;

import javax.validation.constraints.NotNull;

public class SimpleDescriptorImpl implements SimpleDescriptor {

	private int id;
	
	@NotNull(message="Enter a name")
	private String name;
	
	public SimpleDescriptorImpl() {}
	
	public SimpleDescriptorImpl(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof SimpleDescriptorImpl)) 
			return false;
		
		SimpleDescriptorImpl sm = (SimpleDescriptorImpl)o;
		return sm.getName().equals(this.name) && sm.getId() == this.id;
	}
	
	@Override
	public int hashCode() {
		int result = 13;
		result = 31 * result + id;
		result = 31 * result + name.hashCode();
		return result;
	}
	
	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
