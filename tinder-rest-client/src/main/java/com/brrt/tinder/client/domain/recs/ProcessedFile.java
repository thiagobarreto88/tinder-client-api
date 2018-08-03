package com.brrt.tinder.client.domain.recs;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ProcessedFile {
	
	private String url;
	private String width;
	private String height;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}