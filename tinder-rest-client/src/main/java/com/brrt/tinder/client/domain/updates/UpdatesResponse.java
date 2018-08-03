package com.brrt.tinder.client.domain.updates;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;


public class UpdatesResponse {
	
	private List<Match> matches;
	
	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}