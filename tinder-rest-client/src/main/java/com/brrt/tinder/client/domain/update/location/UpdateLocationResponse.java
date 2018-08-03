package com.brrt.tinder.client.domain.update.location;

import org.apache.commons.lang.builder.ToStringBuilder;

public class UpdateLocationResponse {
	
	private String status;
	
	private String error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
