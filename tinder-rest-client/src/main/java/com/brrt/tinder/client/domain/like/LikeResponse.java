package com.brrt.tinder.client.domain.like;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true) 
public class LikeResponse {
	
	@JsonProperty(value="match")
	private String match;
	
	@JsonProperty(value="likes_remaining")
	private String remainingLikes;

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}