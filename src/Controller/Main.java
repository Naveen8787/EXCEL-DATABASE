package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import Dao.ExcelDAO;
import Dao.TableDAO;

//Main class controls all other classes
public class Main {
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		TableDAO table=new TableDAO();
		ExcelDAO excel=new ExcelDAO();
		String yes = null;
		do {	
		System.out.println("------------------DATA MIGRATION-------------------");
		System.out.println("Enter your Option");
		System.out.println("1. MIGRATION OF DATA FROM EXCEL TO DATABASE");
		System.out.println("2. DATA TRANSFERED TO DATABASE");
		System.out.println("3. EXIT");
		System.out.println("------------------------------------------------------");
		int option = 0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//option is given by user and option is of integer type
		option =Integer.parseInt(br.readLine());
		switch(option) {
		case 1:
			System.out.println("------------1. MIGRATION OF DATA FROM EXCEL TO DATABASE------------");
			excel.ExceltoDB();
			table.getAllStatus();
			break;
		case 2:
			System.out.println("------------2. DATA TRANSFERED TO DATABASE------------");
			table.getAllStatus();
			break;
		case 3:
			System.out.println("------------------Thank You------------------");
			System.exit(0);//this statement is used to exit.				
		}
		System.out.println("Do you want to continue");
		yes=br.readLine();	
		}while(yes.equals("yes"));		
	}
}

	
