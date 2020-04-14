package com.atlassian.jira.intigration;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import org.apache.commons.io.IOUtils;

public class CreateIssue {

	public void createIssue(String summary, String description) throws IOException {

		String createIssueUrl = "http://localhost:8080/rest/api/2/issue";
		String createIssueJsonInfo = " { \"fields\": {\n        \"project\": {\n            \"id\": \"10500\"\n        },\n        \"summary\": \""
				+ summary
				+ "\",\n        \"issuetype\": {\n            \"id\": \"10004\"\n        },\n        \"assignee\": {\n            \"name\": \"BhagyarajK\"\n        },\n       \"description\" : \""
				+ description + "\"\n}}";
		Authentication authentication = new Authentication();

		HttpURLConnection createIssueConnection = authentication.authenticate(createIssueUrl);
		createIssueConnection.setRequestMethod("POST");
		OutputStream outputStream = createIssueConnection.getOutputStream();
		outputStream.write(createIssueJsonInfo.getBytes("UTF-8"));
		// Response Code
		System.out.println(createIssueConnection.getResponseCode());
		System.out.println(createIssueConnection.getResponseMessage());

		InputStream inputStream = new BufferedInputStream(createIssueConnection.getInputStream());
		String jsonResponse = IOUtils.toString(inputStream, "UTF-8");

		System.out.println(jsonResponse);

	}

}
