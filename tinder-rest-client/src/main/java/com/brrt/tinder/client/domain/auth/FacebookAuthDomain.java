package com.brrt.tinder.client.domain.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FacebookAuthDomain {

	public FacebookAuthDomain(){}
	
	public FacebookAuthDomain(String facebookToken, String facebookId) {
		super();
		this.facebookToken = facebookToken;
		this.facebookId = facebookId;
	}

	@JsonProperty(value="facebook_token")
	private String facebookToken;
	
	@JsonProperty(value="facebook_id")
	private String facebookId;

	private String locale;
	
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getFacebookToken() {
		return facebookToken;
	}

	public void setFacebookToken(String facebookToken) {
		this.facebookToken = facebookToken;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

}
