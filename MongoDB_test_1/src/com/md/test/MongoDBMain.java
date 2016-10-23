package com.md.test;

import java.io.ObjectInputStream.GetField;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.md.beans.Address;
import com.md.beans.Person;
import com.md.util.OracleDBConnectionManager;
import com.md.util.PersonAdapter;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

/**
 * @author bharagu
 *
 */
public class MongoDBMain {

	static Set<String>  mobileSet=new HashSet<String>();
	
	static Set<String> mobileFromOracle=new HashSet<String>();
	
	public static void main(String[] args) throws UnknownHostException, SQLException {

		// connect to MongoDB

		MongoClient mongoCient = new MongoClient();
		DB database = mongoCient.getDB("mydb");

		DBCollection collection = database.getCollection("person");

		System.out.println(collection.count());

		// inserting collection into MongoDb

		Person person = new Person();
		person.setPersonId(1);
		person.setName("Raghuvir");
		person.setMobileNumber("9861499188");

		
		Person person2=new Person();
		person2.setPersonId(2);
		person2.setName("Gunanidhi");
		person2.setMobileNumber("9071119986");
		
		Person person3=new Person();
		person3.setPersonId(3);
		person3.setName("Chandrakanta");
		person3.setMobileNumber("9071119985");
		
		
		Address address = new Address();
		address.setPlotNo(36);
		address.setCity("Bangalore");
		address.setCountry("India");

		// person.setAddress(address);

		//Remove document from Collection
	/*	collection.remove(new BasicDBObject("_id",person.getPersonId()));
		collection.remove(new BasicDBObject("_id",person2.getPersonId()));
		collection.remove(new BasicDBObject("_id",person3.getPersonId()));
		*/
		//Insert document to Collection
/*		collection.insert(PersonAdapter.toDbObject(person));
		collection.insert(PersonAdapter.toDbObject(person2));
		collection.insert(PersonAdapter.toDbObject(person3));*/
		

		// RETRIEVE document from Collection now.

		DBObject dbObjectQuery = new BasicDBObject("_id", person.getPersonId());

		DBCursor cursor = collection.find();
		/*while (cursor.hasNext()) {
			DBObject dbObject = (DBObject) cursor.next();
			System.out.println("-------------------------");
			String name = (String) dbObject.get("name");
			System.out.println("-------------------------");
			System.out.println(dbObject);
			System.out.println("-------------------------");
			System.out.println("NAME :" + name);

		}*/
		
		while (cursor.hasNext()) {
			DBObject dbObject = (DBObject) cursor.next();
			String mobileNumber=(String)dbObject.get("mobileNumber");
			mobileSet.add(mobileNumber);
			System.out.println("Mobile Number added to SET Collection "+ mobileNumber);
			
		}
		
		getMobileNumberFromOracle();
		
		
		

	}
	
	
	public static Set<String> getMobileNumberFromOracle() throws SQLException
	{
		//getConnection from DB
		Connection con=OracleDBConnectionManager.getConnection();
		int count =0;
		if(con!=null)
		{
			PreparedStatement statment=con.prepareStatement("select mobl_num_voice_v   from gsm_service_mast  where status_code_v='AC' ");
			ResultSet resultSet=statment.executeQuery();
			
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:hhh");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			while (resultSet.next()) {
				
				String mobile=resultSet.getString("mobl_num_voice_v");
				System.out.println("MOBILE FROM ORACLE"+ mobile);
				/*count++;
				if(count==5)
				{
					break;
				}*/
				
			}
			System.out.println(dateFormat.format(date));
			
			
		}
		
		return null;
	}
	

}
