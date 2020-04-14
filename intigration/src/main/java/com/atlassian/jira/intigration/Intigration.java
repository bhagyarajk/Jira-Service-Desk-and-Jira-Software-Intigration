package com.atlassian.jira.intigration;

import java.io.IOException;

public class Intigration {
	public static void main(String[] args) throws IOException {

		String getUpdateJsonInfo = "{\n    \"jql\": \"project = 10401 and status = 3 and updated > -30m\",\n         \"startAt\": 0,\n    \"maxResults\": 15,\n    \"fields\": [\n        \"summary\",\n        \"status\",\n        \"assignee\"\n    ]\n}";
		GetUpdateInfo getUpdateInfo = new GetUpdateInfo();
		getUpdateInfo.getUpdateInfo(getUpdateJsonInfo);
	}

}
