package com.brrt.tinder.client.domain.updates;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.brrt.tinder.client.domain.message.Message;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true) 
public class Match {

	@JsonProperty(value="_id")
	private String id;
	 
	private List<Message> messages;
	
	@JsonProperty(value="is_new_message")
	private String isNewMessage;
	
	@JsonProperty(value="last_activity_date")
	private String lastActivityDate;
	
	public String getLastActivityDate() {
		return lastActivityDate;
	}

	public void setLastActivityDate(String lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	public String getIsNewMessage() {
		return isNewMessage;
	}

	public void setIsNewMessage(String isNewMessage) {
		this.isNewMessage = isNewMessage;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
}