package com.brrt.tinder.client.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class Util {
	
/*	public static String getUserIdByToken(String token){
		
		String userId = null;
		
		String uri = "https://graph.facebook.com/me?fields=id&access_token=";
		uri = uri + token;
		
		HttpGet getMethod = new HttpGet(uri);
		HttpResponse httpResponse;
		String strResponse = null;
		
		try {
			httpResponse = httpClient.execute(getMethod);
			
			strResponse = getStringFromInputStream(httpResponse.getEntity().getContent());
			strResponse = strResponse.replace("{\"id\":", "");
			strResponse = strResponse.replace("{", "");
			strResponse = strResponse.replace("}", "");
			strResponse = strResponse.replace("\"", "");
			System.out.println("after replace: " + strResponse);
			userId =  strResponse;
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;

	}*/
	
	// convert InputStream to String
	private static String getStringFromInputStream(InputStream is) {

			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();

			String line;
			try {

				br = new BufferedReader(new InputStreamReader(is));
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			return sb.toString();

	}
	
	public static HttpHeaders getHeaders(String authToken){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		if(authToken != null){
			headers.add("X-Auth-Token", authToken);
		}
		headers.add("Content-type", "application/json");
		//headers.add("User-agent", "Tinder Android Version 5.3.4");
		//headers.add("Facebook-ID", "100002031514194");
		//headers.add("app_version", "1625");
		//headers.add("os_version", "21");
		//headers.add("platform", "android");
		
		return headers;
	}
	

}
