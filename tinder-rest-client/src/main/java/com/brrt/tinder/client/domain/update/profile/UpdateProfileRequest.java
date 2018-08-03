package com.brrt.tinder.client.domain.update.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class UpdateProfileRequest {
	
	@JsonProperty(value="age_filter_min")
	private int ageFilterMin;
	
	private int gender;
	
	@JsonProperty(value="age_filter_max")
	private int ageFilterMax;
	
	@JsonProperty(value="distance_filter")
	private int distanceFilter;

	public int getAgeFilterMin() {
		return ageFilterMin;
	}

	public void setAgeFilterMin(int ageFilterMin) {
		this.ageFilterMin = ageFilterMin;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAgeFilterMax() {
		return ageFilterMax;
	}

	public void setAgeFilterMax(int ageFilterMax) {
		this.ageFilterMax = ageFilterMax;
	}

	public int getDistanceFilter() {
		return distanceFilter;
	}

	public void setDistanceFilter(int distanceFilter) {
		this.distanceFilter = distanceFilter;
	}

}
