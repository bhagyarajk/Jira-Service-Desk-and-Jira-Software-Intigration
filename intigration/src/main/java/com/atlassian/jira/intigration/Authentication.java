package com.atlassian.jira.intigration;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;

public class Authentication {
	public HttpURLConnection authenticate(String postUrl) throws IOException {

		// TODO Auto-generated method stab
		String userName = "Bhagyarajk";
		String password = "admin";
		String auth = userName + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
		String authHeaderValue = "Basic " + new String(encodedAuth);
		URL url = new URL(postUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(5000);
		connection.setRequestProperty("Authorization", authHeaderValue);
		connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		return connection;
	}

}
