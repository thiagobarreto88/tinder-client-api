package com.brrt.tinder.client.domain.auth;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthUser {

	@JsonProperty(value="_id")
	private String id;

	@JsonProperty(value="active_time")
	private String activeTime;
	
	@JsonProperty(value="distance_filter")
	private String distanceFilter;	

	public String getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDistanceFilter() {
		return distanceFilter;
	}

	public void setDistanceFilter(String distanceFilter) {
		this.distanceFilter = distanceFilter;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}