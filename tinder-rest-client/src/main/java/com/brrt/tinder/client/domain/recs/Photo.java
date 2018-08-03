package com.brrt.tinder.client.domain.recs;

import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Photo {
	
	private ArrayList<ProcessedFile> processedFiles;

	public ArrayList<ProcessedFile> getProcessedFiles() {
		return processedFiles;
	}

	public void setProcessedFiles(ArrayList<ProcessedFile> processedFiles) {
		this.processedFiles = processedFiles;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
