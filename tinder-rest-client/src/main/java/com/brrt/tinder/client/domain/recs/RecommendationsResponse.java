package com.brrt.tinder.client.domain.recs;

import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RecommendationsResponse {
	
	private String status;
	
	private ArrayList<Result> results;
	
	public String getStatus() {
		return status;
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}