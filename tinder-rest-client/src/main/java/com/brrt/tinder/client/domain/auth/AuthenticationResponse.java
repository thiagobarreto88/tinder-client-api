package com.brrt.tinder.client.domain.auth;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {
	
	@JsonProperty(value="token")
	private String authToken;
	
	private AuthUser user;
	
	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public AuthUser getUser() {
		return user;
	}

	public void setUser(AuthUser user) {
		this.user = user;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}