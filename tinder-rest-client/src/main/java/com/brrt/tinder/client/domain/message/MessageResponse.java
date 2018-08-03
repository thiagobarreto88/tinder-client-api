package com.brrt.tinder.client.domain.message;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResponse {
	
	@JsonProperty(value="_id")
	private String id;
	
	private String from;
	
	private String to;
	
	@JsonProperty(value="match_id")
	private String matchId;
	
	@JsonProperty(value="sent_date")
	private String sentDate;
	
	private String message;
	
	@JsonProperty(value="created_date")	
	private String createdDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getSentDate() {
		return sentDate;
	}

	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}