package com.share.JsonDeserialize;

import java.nio.file.Paths;

public class JsonFilePathHelper {

	private static String getResourceRoot() {
		return "src/test/resources/";
	}

	public static String getAPersonJsonFilePath() {
		return Paths.get(JsonFilePathHelper.getResourceRoot(), "APerson.json").toString();
	}

	public static String getAListOfPersonsJsonFilePath() {
		return Paths.get(JsonFilePathHelper.getResourceRoot(), "ListOfPersons.json").toString();
	}
}
