package com.brrt.tinder.client.domain.recs;

import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Result {
	
	@JsonProperty(value="_id")
	private String id;
	
	@JsonProperty(value="distance_mi")
	private String distance;
	
	@JsonProperty(value="photos")
	private ArrayList<Photo> photos;
	
	private String name;
	
	public ArrayList<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<Photo> photos) {
		this.photos = photos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}