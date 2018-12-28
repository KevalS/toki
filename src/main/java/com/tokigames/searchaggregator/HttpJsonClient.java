package com.tokigames.searchaggregator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpJsonClient extends DefaultHttpClient {
	private final HttpGet request;
	private static String type;

	public static String getJsonOutput(String url) {
		
		HttpJsonClient client = new HttpJsonClient(url, "application/json");
		try {
			return client.execute();
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getType() throws Exception{
		if(type== null){
			throw new Exception("Please provide proper URL");
		}
		return type;
	}

	private HttpJsonClient(String url, String headerType) {
		type = url.substring(url.lastIndexOf('/') + 1);
		request = new HttpGet(url);
		request.addHeader("accept", "application/json");
	}

	private String execute() throws IllegalStateException, IOException {
		HttpResponse response = execute(request);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(response.getEntity().getContent())));

		String output = "";
		String str;
		while ((str = br.readLine()) != null) {
			output += str;
		}
		getConnectionManager().shutdown();
		return output;
	}
}
