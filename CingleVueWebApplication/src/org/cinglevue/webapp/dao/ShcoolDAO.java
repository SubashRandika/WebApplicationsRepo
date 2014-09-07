package org.cinglevue.webapp.dao;

import java.io.IOException;
import java.io.StringReader;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.cinglevue.webapp.pojo.School;
import org.cinglevue.webapp.pojo.SchoolInformation;
import org.cinglevue.webapp.util.Util;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class ShcoolDAO {
	
	private Util util;
	
	public ShcoolDAO(){
		util = new Util();
	}

	public List<SchoolInformation> getAllSchoolInformation() {

		List<SchoolInformation> schoolDataList = new ArrayList<SchoolInformation>();
		MongoClient mongoClient = null;

		try {
			
			mongoClient = new MongoClient();
			DB db = mongoClient.getDB(util.readPropertyFile().getProperty("database"));
			DBCollection collection = db.getCollection(util.readPropertyFile().getProperty("collection"));
			DBCursor cursor = collection.find();
			schoolDataList = processDataList(schoolDataList, cursor);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			mongoClient.close();
		}

		return schoolDataList;

	}

	public List<SchoolInformation> findByName(String query) {
		
		List<SchoolInformation> schoolDataList = new ArrayList<SchoolInformation>();
		MongoClient mongoClient = null;

		try {
			
			mongoClient = new MongoClient();
			DB db = mongoClient.getDB(util.readPropertyFile().getProperty("database"));
			DBCollection collection = db.getCollection(util.readPropertyFile().getProperty("collection"));

			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("subject", query);
			DBCursor cursor = collection.find(whereQuery);
			schoolDataList = processDataList(schoolDataList, cursor);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mongoClient.close();
		}

		return schoolDataList;

	}

	public List<SchoolInformation> processDataList(
			List<SchoolInformation> schoolDataList, DBCursor cursor) {

		try {
			while (cursor.hasNext()) {
				DBObject obj = cursor.next();
				JsonReader jsonReader = Json.createReader(new StringReader(obj.toString()));
				JsonObject jsonObject = jsonReader.readObject();
				jsonReader.close();

				JsonObject innerJsonObject = jsonObject.getJsonObject("school");
				School school = new School();
				school.setSchoolName(innerJsonObject.getString("schoolName"));

				SchoolInformation info = new SchoolInformation();
				info.setSchool(school);
				info.setSubject(jsonObject.getString("subject"));
				info.setFactoredGainY3Y5(jsonObject.getJsonNumber("factoredGainY3Y5").doubleValue());
				info.setGlgY3Y5(jsonObject.getJsonNumber("glgY3Y5").doubleValue());
				info.setLatestGainInGainY3Y5(jsonObject.getJsonNumber("latestGainInGainY3Y5").doubleValue());
				info.setLatestY3(jsonObject.getJsonNumber("latestY3").doubleValue());
				info.setLatestY5(jsonObject.getJsonNumber("latestY5").doubleValue());
				info.setLatestY7(jsonObject.getJsonNumber("latestY7").doubleValue());
				info.setLatestY9(jsonObject.getJsonNumber("latestY9").doubleValue());
				info.setRawGainY3Y5(jsonObject.getJsonNumber("rawGainY3Y5").doubleValue());

				schoolDataList.add(info);
			}
		} finally {
			cursor.close();
		}

		return schoolDataList;
	}

}
