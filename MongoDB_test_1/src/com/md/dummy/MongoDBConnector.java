package com.md.dummy;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBConnector {

	public static void main(String[] args) throws UnknownHostException {

		MongoClient mongoClient = new MongoClient("172.20.33.226");

		DB db = mongoClient.getDB("clmsit_tmp");
		boolean b = db.authenticate("admin", "admin".toCharArray());
		// db.addUser("admin","admin".toCharArray();
		if (b) {
			System.out.println("Authenticated .......");
		}
		System.out.println(db);
		System.out.println("Connected");

		DBCollection collection = db.getCollection("Service");

		DBObject query = new BasicDBObject("_id", "5652ee13cd107d930c597b4f");
		DBCursor cursor = collection.find(query);

		while (cursor.hasNext()) {
			DBObject dbObject = (DBObject) cursor.next();
			String s = (String) dbObject.get("serviceCode");
			System.out.println("Service code" + s);

		}

	}
}
