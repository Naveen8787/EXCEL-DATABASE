package Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import utility.ConnectionManager;

public class ExcelDAO {
	public void ExceltoDB() throws ClassNotFoundException, SQLException, IOException {
	//Change the table names as per ur requirements and values as per ur requirements see that those 
	String Query = "INSERT INTO info (id, name, email, Phone, dob) VALUES(?,?,?,?,?)";//info is the tablename in database
	PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(Query);
	System.out.println("Connection Established");
	//We should now load excel objects and loop through the worksheet data 
	FileInputStream Document = new FileInputStream(new File("C:/Users/Naveen/Desktop/Student.xls"));//location of excel sheeet 
	//Load workbook 
	HSSFWorkbook workbook = new HSSFWorkbook(Document);
	HSSFSheet sheet = workbook.getSheetAt(0);
	//Iterator
	Iterator<Row> rowIter = sheet.rowIterator();
	int length=0;
	while(rowIter.hasNext()){
	HSSFRow myRow = (HSSFRow) rowIter.next();
	String id="";
	String name ="";
	String email="";
	String phone;
	String dob="";
	id=myRow.getCell(0).toString();
	name=myRow.getCell(1).toString();
	email=myRow.getCell(2).toString();
	phone=myRow.getCell(3).toString();
	dob=myRow.getCell(4).toString();
	//Transfer of data from Excel to Database table using PreparedStatements
	ps.setString(1, id);
	ps.setString(2, name);
	ps.setString(3, email);
	ps.setString(4, phone);
	ps.setString(5, dob);
	ps.executeUpdate();
	length++;
	}
	System.out.println("Rows Length :"+length);
	// Close Document 
	Document.close();
	// Close prepared statement
	ps.close();
	// Close connection 
	ps.close();
	System.out.println("Successfully Data has been Transfered from Excel to SQL table");
}
}
