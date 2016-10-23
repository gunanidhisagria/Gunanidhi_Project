package com.md.util;

import com.md.beans.Person;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class PersonAdapter {

	public static DBObject toDbObject(Person person) {
		DBObject dbObject = new BasicDBObject("_id", person.getPersonId()).append("id", person.getPersonId())
				.append("name", person.getName()).append("address", person.getAddress()).append("mobileNumber",person.getMobileNumber());
		return dbObject;
	}

}
