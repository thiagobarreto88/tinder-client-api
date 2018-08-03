package com.brrt.tinder.client.domain.updates;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatesRequest {
	
	@JsonProperty(value="last_activity_date")
	private String lastActivityDate;
	
	public String getLastActivityDate() {
		return lastActivityDate;
	}

	public void setLastActivityDate(String lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}