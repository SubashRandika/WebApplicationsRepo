package org.cinglevue.webapp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonException;
import javax.json.JsonObjectBuilder;

import org.cinglevue.webapp.pojo.SchoolInformation;

public class Util {

	public String getFormattedJsonString(List<SchoolInformation> dataList) {

		JsonObjectBuilder topObjectBuilder = Json.createObjectBuilder();
		JsonArrayBuilder infoArrayBuilder = Json.createArrayBuilder();

		try {
			
			List<SchoolInformation> infoList = dataList;
			
			for (SchoolInformation tList : infoList) {
				JsonObjectBuilder schoolBilder = Json.createObjectBuilder();
				schoolBilder.add("schoolName", "Royal");

				JsonObjectBuilder dataBuilder = Json.createObjectBuilder();
				dataBuilder.add("school", schoolBilder.build());
				dataBuilder.add("subject", tList.getSubject());
				dataBuilder.add("latestY3", tList.getLatestY3());
				dataBuilder.add("latestY5", tList.getLatestY5());
				dataBuilder.add("latestY7", tList.getLatestY7());
				dataBuilder.add("latestY9", tList.getLatestY9());
				dataBuilder.add("rawGainY3Y5", tList.getRawGainY3Y5());
				dataBuilder.add("factoredGainY3Y5", tList.getFactoredGainY3Y5());
				dataBuilder.add("glgY3Y5", tList.getGlgY3Y5());
				dataBuilder.add("latestGainInGainY3Y5", tList.getLatestGainInGainY3Y5());
				infoArrayBuilder.add(dataBuilder.build());
			}

			topObjectBuilder.add("schools", infoArrayBuilder.build());
			
		} catch (JsonException e) {
			e.printStackTrace();
		}

		return topObjectBuilder.build().toString();
	}

	public Properties readPropertyFile() throws IOException {

		Properties properties = new Properties();
		final Path path = Paths.get("cinglevue.properties");

		if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			properties.load(new FileInputStream("cinglevue.properties"));
		} else {
			properties.load(getClass().getClassLoader().getResourceAsStream("cinglevue.properties"));
		}

		return properties;
	}
}
