package com.md.dummy;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DBTest {

	
	public static void main(String[] args) throws SQLException {
		/*int count=0;
		Connection con=OracleDBConnectionManager.getConnection();
		
		PreparedStatement statment=con.prepareStatement("select mobl_num_voice_v   from gsm_service_mast  where status_code_v='AC' and contract_type_v='P'");
		ResultSet resultSet=statment.executeQuery();
		System.out.println("Query Executed Successfully");
		
		System.out.println();
		while (resultSet.next()) {
			System.out.println(resultSet);
			String mobile=resultSet.getString("mobl_num_voice_v");
			System.out.println("MOBILE FROM ORACLE"+ mobile);
			count++;
			if(count==5)
			{
				break;
			}
			*/
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:hhh");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		
			System.out.println(Calendar.getInstance().toString());
			
		System.out.println();
		
		
	}
	
}

