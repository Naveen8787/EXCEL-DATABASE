package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utility.ConnectionManager;

public class TableDAO {
public void getAllStatus() throws ClassNotFoundException, SQLException {
	Statement st = ConnectionManager.getConnection().createStatement();//Connection
	ResultSet rs = st.executeQuery("select * from info order by id asc");//info is the tablename in database
	System.out.println("------------------------------------------------------------------------------------------------");
	System.out.println("\tID\tNAME\t\tEMAIL\t\t\t\tPhone\t\tDOB");
	System.out.println("------------------------------------------------------------------------------------------------");
	while(rs.next())
	{
		System.out.println("\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"       \t"+rs.getString(4)+"\t"+rs.getString(5));	
	}
	System.out.println("------------------------------------------------------------------------------------------------");
	}
}

