package com.brrt.tinder.client.domain.update.location;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateLocationRequest {
	
	@JsonProperty(value="lat")
	private Double latitude;
	
	@JsonProperty(value="lon")
	private Double longitude;
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}