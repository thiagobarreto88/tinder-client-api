package com.brrt.tinder.client.domain.message;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Message {
	
	private String message;
	
	private String from;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}