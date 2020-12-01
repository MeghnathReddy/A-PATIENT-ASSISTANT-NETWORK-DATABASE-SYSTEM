//Import statements
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Time;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//Class
public class finalproject {
	// Database credentials
	final static String HOSTNAME = "chal0018-sql-server.database.windows.net";
	final static String DBNAME = "HW-2";
	final static String USERNAME = "chal0018";
	final static String PASSWORD = "Sridevi$123";
	// Database connection string
	final static String URL = String.format(
			"jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
			HOSTNAME, DBNAME, USERNAME, PASSWORD);
	// Query templates
	final static String QUERY_TEMPLATE_1 = "{call insertintoTeam(?,?,?)}";
	final static String QUERY_TEMPLATE_2 = "{call insertintoClient(?,?,?,?,?,?)}";
	final static String QUERY_TEMPLATE_3 = "{call insertintoCare(?,?,?)}";
	final static String QUERY_TEMPLATE_4 = "{call insertintoPerson(?,?,?,?,?,?,?,?,?,?,?,?)}";
	final static String QUERY_TEMPLATE_5 = "{call insertintoVolunteer(?,?,?,?)}";
	final static String QUERY_TEMPLATE_6 = "{call insertintoServes(?,?,?,?,?)}";
	final static String QUERY_TEMPLATE_7 = "{call insertintoEmployee(?,?,?,?)}";
	final static String QUERY_TEMPLATE_8 = "{call insertintoReports(?,?,?,?)}";
	final static String QUERY_TEMPLATE_9 = "{call insertintoExpense(?,?,?,?)}";
	final static String QUERY_TEMPLATE_10 = "{call insertintoExternal_Org(?,?,?,?)}";
	final static String QUERY_TEMPLATE_11 = "{call insertintoSponsors(?,?)}";
	final static String QUERY_TEMPLATE_12 = "{call insertintoDonor(?,?)}";
	final static String QUERY_TEMPLATE_13 = "{call insertintoCheck(?,?,?,?,?,?)}";
	final static String QUERY_TEMPLATE_14 = "{call insertintoCredit(?,?,?,?,?,?,?,?)}";
	final static String QUERY_TEMPLATE_15 = "{call insertintoExternalDonor(?,?)}";
	final static String QUERY_TEMPLATE_16 = "{call insertintoExCheck(?,?,?,?,?,?)}";
	final static String QUERY_TEMPLATE_17 = "{call insertintoExCredit(?,?,?,?,?,?,?,?)}";
	final static String QUERY_TEMPLATE_18 = "select * from Employees";
	final static String QUERY_TEMPLATE_19 = "select * from Client";
	// User input prompt//
	final static String PROMPT = "\nPlease select one of the options below: \n" + "1) Insert new Team: \n"
			+"2) Insert new Client and associate him/her to Team \n" + "3) Insert new Volunteer and associate him/her to Team  \n" +
			"4) Enter number of hrs volunteer worked for a Team  \n"+"5) Insert new Employee and associate him/her to Team  \n" +
			"6) Enter a new Expense charged by Employee  \n"+
			"7) Insert new Organization and associate it to one/more Teams \n"+
			"8) Insert new Donors and associate it to one/more donations \n"+
			"9) Insert new Organization and associate it to one/more donations \n"+
			"10) Retrieve Doctor Name and Phone for particular client \n"+
			"11) Retrieve total amount of expenses for particular period of an employee date format-YYYYMMDD \n"+
			"12) Retrieve list of Volunteers that are members of team that support particular client \n"+
			"13) Retrieve Name,Contact info of Client supported by an Org with name starts between B & K \n"+
			"14) yet to implement \n"+
			"15) Retrieve Team Name that are found after a particular date(yyyymmdd)  \n"+
			"16) Update Salary of Employee who has more than one team reporting \n"+
			"17) Delete Employee who does not have Insurance and type is transportation \n"+
			"18) Import file \n"+"19) Export File \n"+"20) Exit!";

	public static void main(String[] args) throws SQLException{
		System.out.println("Welcome to the sample application!");
		final Scanner sc = new Scanner(System.in); // Scanner is used to collect the user input
		String option = ""; // Initialize user option selection as nothing
		Connection conn = DriverManager.getConnection(URL); //establish connection
		Statement stmt = conn.createStatement(); //to execute sql queries
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //used for export/ import read input from user
		
		//Insert a person at the start
		/*
		System.out.println("Please enter SSN:");
		final int SSN_P= sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter Person Name:");
		final String P_Name = sc.nextLine();
		System.out.println("Please enter Birth Date:");
		final String Birthdate=sc.nextLine();
		Date Bdate=Date.valueOf(Birthdate);
		System.out.println("Please enter Race:");
		final String Race = sc.nextLine();
		System.out.println("Please enter Gender:");
		final String Gender = sc.nextLine();
		System.out.println("Please enter Profession:");
		final String Profession = sc.nextLine();
		System.out.println("Please enter Mail_address:");
		final String Mail_address = sc.nextLine();
		System.out.println("Please enter Email_address:");
		final String Email_address = sc.nextLine();
		System.out.println("Please enter Home_phone:");
		final int Home_phone= sc.nextInt();
		System.out.println("Please enter Work_phone:");
		final int Work_phone= sc.nextInt();
		System.out.println("Please enter Cell_phone:");
		final int Cell_phone= sc.nextInt();
		System.out.println("Please enter Mailing_list state:");
		final int Mailing_list= sc.nextInt();
		
		try (final Connection connection = DriverManager.getConnection(URL)) {
			try (final CallableStatement statement = connection.prepareCall(QUERY_TEMPLATE_4)) {
				// Populate the query template with the data collected from the user
				statement.setInt(1,SSN_P );
				statement.setString(2, P_Name);
				statement.setDate(3, Bdate);
				statement.setString(4, Race);
				statement.setString(5, Gender);
				statement.setString(6, Profession);
				statement.setString(7, Mail_address);
				statement.setString(8, Email_address);
				statement.setInt(9, Home_phone);
				statement.setInt(10, Work_phone);
				statement.setInt(11, Cell_phone);
				statement.setInt(12, Mailing_list);
				System.out.println("Dispatching the query...");
				// Actually execute the populated query
				final int rows_inserted = statement.executeUpdate();
				System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
			}
		}
		*/
		while (!option.equals("20")) { // Ask user for options until option 20 is selected
			System.out.println(PROMPT); // Print the available options
			option = sc.next(); // Read in the user option selection
			switch (option) { // Switch between different options
			
			case "1": // Insert a new Team option
				System.out.println("Please enter Team Name:");
				try {
				sc.nextLine();
				final String T_Name = sc.nextLine(); // Read in the user input of Team Name
				System.out.println("Please enter Team Type:");
				// We call nextLine to consume that newline character, so that subsequent
				// nextLine doesn't return nothing.
				final String Type  = sc.nextLine(); // Read in user input of faculty Name (white-spaces allowed).
				System.out.println("Please Date assigned in format YYYYMMDD:");
				final int date_a=sc.nextInt();
				System.out.println("Connecting to the database...");
				// Get a database connection and prepare a query statement
				try (final Connection connection = DriverManager.getConnection(URL)) {
					try (final CallableStatement statement = connection.prepareCall(QUERY_TEMPLATE_1)) {
						// Populate the query template with the data collected from the user
						statement.setString(1,T_Name );
						statement.setString(2, Type);
						statement.setInt(3, date_a);
						System.out.println("Dispatching the query...");
						// Actually execute the populated query
						final int rows_inserted = statement.executeUpdate();
						System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
					}
				}
				}
				//Error handling
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch -- ");
					sc.nextLine();
					
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
				break;
			case "2": // Insert a new Client 
				try {
				System.out.println("Please enter SSN:");
				final int SSN = sc.nextInt();
				sc.nextLine();
				System.out.println("Please enter Doctor name:");
				final String Doctor_Name = sc.nextLine();
				System.out.println("Please enter Attor Name:");
				final String Attor_Name= sc.nextLine();
				System.out.println("Please Doctor Phone:");
				final int Doctor_phone = sc.nextInt();
				System.out.println("Please enter Attor Phone:");
				final int Attor_Phone= sc.nextInt();
				sc.nextLine();
				System.out.println("Please Date assigned:");
				final String date_a=sc.nextLine();
				Date date=Date.valueOf(date_a);//converting string into sql date  
				System.out.println("Connecting to the database...");
				// Get a database connection and prepare a query statement
				try (final Connection connection = DriverManager.getConnection(URL)) {
					try (final CallableStatement statement = connection.prepareCall(QUERY_TEMPLATE_2)) 
					{
						// Populate the query template with the data collected from the user
						statement.setInt(1,SSN );
						statement.setString(2, Doctor_Name);
						statement.setString(3, Attor_Name);
						statement.setInt(4, Doctor_phone);
						statement.setInt(5, Attor_Phone);
						statement.setDate(6, date);
						System.out.println("Dispatching the query...");
						// Actually execute the populated query
						final int rows_inserted = statement.executeUpdate();
						System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
					}
					
				}
				}
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
			
				
				//for care
				System.out.println("Number of teams to assosciate to");
				int count=sc.nextInt();
				sc.nextLine();
				while (count!=0) {
					System.out.println("Please enter SSN:");
					final int SSN = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter Team Name to which you want to assosciate:");
					final String Team_Name= sc.nextLine();
					int C_ActiveState=0;
					try (final Connection connection = DriverManager.getConnection(URL)) {
						try (final CallableStatement statement1 = connection.prepareCall(QUERY_TEMPLATE_3)) 
						{
							// Populate the query template with the data collected from the user
							statement1.setInt(1,SSN );
							statement1.setString(2, Team_Name);
							statement1.setInt(3, C_ActiveState);
							System.out.println("Dispatching the query...");
							// Actually execute the populated query
							final int rows_inserted = statement1.executeUpdate();
							System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
						}
						}
					count--;}
				break;
				
					
			case "3": // Insert a new Volunteer 
				
				try {
				System.out.println("Please enter SSN:");
				final int SSN = sc.nextInt();
				sc.nextLine();
				System.out.println("Please enter Joining Date:");
				final String date_J=sc.nextLine();
				Date date=Date.valueOf(date_J);
				System.out.println("Please Training Date:");
				final String date_T = sc.nextLine();
				Date date1=Date.valueOf(date_T);
				System.out.println("Please enter Training Loc :");
				final String  Training_Loc = sc.nextLine();
				
				//converting string into sql date  
				System.out.println("Connecting to the database...");
				// Get a database connection and prepare a query statement
				try (final Connection connection = DriverManager.getConnection(URL)) {
					try (final CallableStatement statement = connection.prepareCall(QUERY_TEMPLATE_5)) 
					{
						// Populate the query template with the data collected from the user
						statement.setInt(1,SSN );
						statement.setDate(2, date);
						statement.setDate(3, date1);
						statement.setString(4, Training_Loc);
						System.out.println("Dispatching the query...");
						// Actually execute the populated query
						final int rows_inserted = statement.executeUpdate();
						System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
					}
					
				}
				}
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
			
				
				//for SERVES
				System.out.println("Number of teams to assosciate to");
				int count1=sc.nextInt();
				sc.nextLine();
				while (count1!=0) {
					System.out.println("Please enter SSN:");
					final int SSN = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter Team Name to which you want to assosciate:");
					final String Team_Name= sc.nextLine();
					System.out.println("Please enter HOURS:");
					final int hours = sc.nextInt();
					sc.nextLine();
					int C_ActiveState=0;
					System.out.println("Please enter Specific month:");
					final String month=sc.nextLine();
					try (final Connection connection = DriverManager.getConnection(URL)) {
						try (final CallableStatement statement1 = connection.prepareCall(QUERY_TEMPLATE_6)) 
						{
							// Populate the query template with the data collected from the user
							statement1.setInt(1,SSN );
							statement1.setString(2, Team_Name);
							statement1.setInt(3, hours);
							statement1.setInt(4, C_ActiveState);
							statement1.setString(5, month);
							System.out.println("Dispatching the query...");
							// Actually execute the populated query
							final int rows_inserted = statement1.executeUpdate();
							System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
						}
						}
					count1--;}
				break;
					
			case "4":
				try {
				//for SERVES
				
					System.out.println("Please enter SSN:");
					final int SSN = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter Team Name to which you want to assosciate:");
					final String Team_Name= sc.nextLine();
					System.out.println("Please enter HOURS:");
					final int hours = sc.nextInt();
					sc.nextLine();
					int C_ActiveState=0;
					System.out.println("Please enter Specific month:");
					final String month=sc.nextLine();
					try (final Connection connection = DriverManager.getConnection(URL)) {
						try (final CallableStatement statement1 = connection.prepareCall(QUERY_TEMPLATE_6)) 
						{
							// Populate the query template with the data collected from the user
							statement1.setInt(1,SSN );
							statement1.setString(2, Team_Name);
							statement1.setInt(3, hours);
							statement1.setInt(4, C_ActiveState);
							statement1.setString(5, month);
							System.out.println("Dispatching the query...");
							// Actually execute the populated query
							final int rows_inserted = statement1.executeUpdate();
							System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
						}
						}
					}
				
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
				break;
			
			case "5": // Insert a new Employee 
				// Collect the new Employee data from the user
				
				try {
				System.out.println("Please enter SSN:");
				final int SSN = sc.nextInt();
				sc.nextLine();
				System.out.println("Please enter Salary of Employee:");
				final Float Salary=sc.nextFloat();
				sc.nextLine();
				System.out.println("Please enter Marital Status:");
				final String Status = sc.nextLine();
				System.out.println("Please enter Hire Date:");
				final String date_J=sc.nextLine();
				Date date=Date.valueOf(date_J);
				
				
				//converting string into sql date  
				System.out.println("Connecting to the database...");
				// Get a database connection and prepare a query statement
				try (final Connection connection = DriverManager.getConnection(URL)) {
					try (final CallableStatement statement = connection.prepareCall(QUERY_TEMPLATE_7)) 
					{
						// Populate the query template with the data collected from the user
						statement.setInt(1,SSN );
						statement.setFloat(2, Salary);
						statement.setString(3, Status);
						statement.setDate(4, date);
						System.out.println("Dispatching the query...");
						// Actually execute the populated query
						final int rows_inserted = statement.executeUpdate();
						System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
					}
					
				}
				}
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
			
				
				//for Reports
				System.out.println("Number of teams to assosciate to");
				int count2=sc.nextInt();
				sc.nextLine();
				while (count2!=0) {
					System.out.println("Please enter SSN:");
					final int SSN = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter Team Name to which you want to assosciate:");
					final String Team_Name= sc.nextLine();
					System.out.println("Please enter Report Date:");
					final String date_J=sc.nextLine();
					Date date=Date.valueOf(date_J);
					System.out.println("Please enter Report Description:");
					final String Desc=sc.nextLine();
					try (final Connection connection = DriverManager.getConnection(URL)) {
						try (final CallableStatement statement1 = connection.prepareCall(QUERY_TEMPLATE_8)) 
						{
							// Populate the query template with the data collected from the user
							statement1.setInt(1,SSN );
							statement1.setString(2, Team_Name);
							statement1.setDate(3, date);
							statement1.setString(4, Desc);
							System.out.println("Dispatching the query...");
							// Actually execute the populated query
							final int rows_inserted = statement1.executeUpdate();
							System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
						}
						}
					count2--;}
				break;
			
				
			case "6":
				try {
				//for Expense
					System.out.println("Please enter SSN:");
					final int SSN = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter Expense Amount:");
					final Float Expense_A= sc.nextFloat();
					sc.nextLine();
					System.out.println("Please enter Expense Description:");
					final String Description=sc.nextLine();
					System.out.println("Please enter Expense Date:");
					final int date_J=sc.nextInt();
					//Date date=Date.valueOf(date_J);
					try (final Connection connection = DriverManager.getConnection(URL)) {
						try (final CallableStatement statement1 = connection.prepareCall(QUERY_TEMPLATE_9)) 
						{
							// Populate the query template with the data collected from the user
							statement1.setInt(1,SSN );
							statement1.setFloat(2, Expense_A);
							statement1.setString(3, Description);
							statement1.setInt(4, date_J);
							
							System.out.println("Dispatching the query...");
							// Actually execute the populated query
							final int rows_inserted = statement1.executeUpdate();
							System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
						}
						}
					}
				
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
				break;
			
				
			case "7": // Insert a new Organization 
				// Collect the new Organization data from the user
				System.out.println("Please enter Organization Name:");
				try {
				sc.nextLine();
				final String Org_Name = sc.nextLine();
				System.out.println("Please enter Organization Address:");
				final String Org_Address = sc.nextLine();
				System.out.println("Please Org Number:");
				final int Org_Number = sc.nextInt();
				sc.nextLine();
				System.out.println("Please enter Org Contact :");
				final String  Org_Contact = sc.nextLine();
				
				//converting string into sql date  
				System.out.println("Connecting to the database...");
				// Get a database connection and prepare a query statement
				try (final Connection connection = DriverManager.getConnection(URL)) {
					try (final CallableStatement statement = connection.prepareCall(QUERY_TEMPLATE_10)) 
					{
						// Populate the query template with the data collected from the user
						statement.setString(1,Org_Name );
						statement.setString(2, Org_Address);
						statement.setInt(3, Org_Number);
						statement.setString(4, Org_Contact);
						System.out.println("Dispatching the query...");
						// Actually execute the populated query
						final int rows_inserted = statement.executeUpdate();
						System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
					}
					
				}
				}
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
			
				
				//for Sponsor
				System.out.println("Number of teams to assosciate to");
				int count3=sc.nextInt();
				sc.nextLine();
				while (count3!=0) {
					
					System.out.println("Please enter Team Name to which you want to assosciate:");
					final String Team_Name= sc.nextLine();
					System.out.println("Please enter Organization Name:");
					final String Org_Name = sc.nextLine();
					try (final Connection connection = DriverManager.getConnection(URL)) {
						try (final CallableStatement statement1 = connection.prepareCall(QUERY_TEMPLATE_11)) 
						{
							// Populate the query template with the data collected from the user
							statement1.setString(1,Team_Name );
							statement1.setString(2, Org_Name);
							System.out.println("Dispatching the query...");
							// Actually execute the populated query
							final int rows_inserted = statement1.executeUpdate();
							System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
						}
						}
					count3--;}
				break;
				
			case "8": // Insert a new Donor 
				// Collect the new Donor data from the user
				
				try {
				System.out.println("Please enter SSN:");
				final int SSN = sc.nextInt();
				sc.nextLine();
				System.out.println("Please enter Anonymous state of Donor :");
				final String Anonymous_S = sc.nextLine();
				//converting string into sql date  
				System.out.println("Connecting to the database...");
				// Get a database connection and prepare a query statement
				try (final Connection connection = DriverManager.getConnection(URL)) {
					try (final CallableStatement statement = connection.prepareCall(QUERY_TEMPLATE_12)) 
					{
						// Populate the query template with the data collected from the user
						statement.setInt(1,SSN );
						statement.setString(2,Anonymous_S );
						System.out.println("Dispatching the query...");
						// Actually execute the populated query
						final int rows_inserted = statement.executeUpdate();
						System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
					}
					
				}
				}
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
			
				
				//for Donations
				System.out.println("Number of donations to assosciate to");
				int count4=sc.nextInt();
				sc.nextLine();
				while (count4!=0) {
					
					System.out.println("Please enter Donation payment 1:check and 2:Credit:");
					int Don_type= sc.nextInt();
					if (Don_type==1) {
					System.out.println("Please enter SSN:");
					final int SSN = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter Date of Donation:");
					final String date_J=sc.nextLine();
					Date date=Date.valueOf(date_J);
					System.out.println("Please enter Donation Amount:");
					final float D_amount=sc.nextFloat();
					sc.nextLine();
					System.out.println("Please enter Donation type:");
					final String D_Type = sc.nextLine();
					System.out.println("Please enter Campaign Name:");
					final String Camp_Name = sc.nextLine();
					System.out.println("Please enter Cheque Number:");
					final int Check_Num = sc.nextInt();
					try (final Connection connection = DriverManager.getConnection(URL)) {
						try (final CallableStatement statement1 = connection.prepareCall(QUERY_TEMPLATE_13)) 
						{
							// Populate the query template with the data collected from the user
							statement1.setInt(1,SSN );
							statement1.setDate(2, date);
							statement1.setFloat(3, D_amount);
							statement1.setString(4, D_Type);
							statement1.setString(5, Camp_Name);
							statement1.setInt(6, Check_Num);

							System.out.println("Dispatching the query...");
							// Actually execute the populated query
							final int rows_inserted = statement1.executeUpdate();
							System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
						}
						}
					}
					else {
						System.out.println("Please enter SSN:");
						final int SSN = sc.nextInt();
						sc.nextLine();
						System.out.println("Please enter Date of Donation:");
						final String date_J=sc.nextLine();
						Date date=Date.valueOf(date_J);
						System.out.println("Please enter Donation Amount:");
						final float D_amount=sc.nextFloat();
						sc.nextLine();
						System.out.println("Please enter Donation type:");
						final String D_Type = sc.nextLine();
						System.out.println("Please enter Campaign Name:");
						final String Camp_Name = sc.nextLine();
						System.out.println("Please enter Card Number:");
						final int Check_Num = sc.nextInt();
						sc.nextLine();
						System.out.println("Please enter Card Type:");
						final String CardType= sc.nextLine();
						System.out.println("Please enter Expiry Date:");
						final String date_E=sc.nextLine();
						Date dateE=Date.valueOf(date_E);
						try (final Connection connection = DriverManager.getConnection(URL)) {
							try (final CallableStatement statement1 = connection.prepareCall(QUERY_TEMPLATE_14)) 
							{
								// Populate the query template with the data collected from the user
								statement1.setInt(1,SSN );
								statement1.setDate(2, date);
								statement1.setFloat(3, D_amount);
								statement1.setString(4, D_Type);
								statement1.setString(5, Camp_Name);
								statement1.setInt(6, Check_Num);
								statement1.setString(7, CardType);
								statement1.setDate(8, dateE);
								

								System.out.println("Dispatching the query...");
								// Actually execute the populated query
								final int rows_inserted = statement1.executeUpdate();
								System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
							}
							}
					
						
					}
					count4--;}
				break;
				
			
			case "9": // Insert a new Organization+Donations 
				// Collect the new Organization data from the user
				
				System.out.println("Please enter Organization Name:");
				try {
				sc.nextLine();
				final String Org_Name = sc.nextLine();
				System.out.println("Please enter Organization Address:");
				final String Org_Address = sc.nextLine();
				System.out.println("Please Org Number:");
				final int Org_Number = sc.nextInt();
				sc.nextLine();
				System.out.println("Please enter Org Contact :");
				final String  Org_Contact = sc.nextLine();
				
				//converting string into sql date  
				System.out.println("Connecting to the database...");
				// Get a database connection and prepare a query statement
				try (final Connection connection = DriverManager.getConnection(URL)) {
					try (final CallableStatement statement = connection.prepareCall(QUERY_TEMPLATE_10)) 
					{
						// Populate the query template with the data collected from the user
						statement.setString(1,Org_Name );
						statement.setString(2, Org_Address);
						statement.setInt(3, Org_Number);
						statement.setString(4, Org_Contact);
						System.out.println("Dispatching the query...");
						// Actually execute the populated query
						final int rows_inserted = statement.executeUpdate();
						System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
					}
					
				}
				}
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
			
				try {
					System.out.println("Please enter Organization Name:");
					final String Organization_N = sc.nextLine();
					System.out.println("Please enter Anonymous state of Donor :");
					final String Anonymous_S = sc.nextLine();
					//converting string into sql date  
					System.out.println("Connecting to the database...");
					// Get a database connection and prepare a query statement
					try (final Connection connection = DriverManager.getConnection(URL)) {
						try (final CallableStatement statement = connection.prepareCall(QUERY_TEMPLATE_15)) 
						{
							// Populate the query template with the data collected from the user
							statement.setString(1,Organization_N );
							statement.setString(2,Anonymous_S );
							System.out.println("Dispatching the query...");
							// Actually execute the populated query
							final int rows_inserted = statement.executeUpdate();
							System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
						}
						
					}
					}
					catch(InputMismatchException e)
					{
						System.out.println("Caught Input mismatch");
						sc.nextLine();
						break;
					}
					catch (Exception e)
					{
						System.out.println("Couldn't execute the above query!");
						System.out.println("Reason -- ");
						System.out.println(e.getMessage());
						System.out.println("Try again !!!");
					}
				
				//for Donations
				System.out.println("Number of donations to assosciate to");
				int count5=sc.nextInt();
				sc.nextLine();
				while (count5!=0) {
					
					System.out.println("Please enter Donation payment 1:check and 2:Credit:");
					int Don_type= sc.nextInt();
					sc.nextLine();
					if (Don_type==1) {
					System.out.println("Please enter Org Name:");
					final String Org_Name = sc.nextLine();
					System.out.println("Please enter Date of Donation:");
					final String date_J=sc.nextLine();
					Date date=Date.valueOf(date_J);
					System.out.println("Please enter Donation Amount:");
					final float D_amount=sc.nextFloat();
					sc.nextLine();
					System.out.println("Please enter Donation type:");
					final String D_Type = sc.nextLine();
					System.out.println("Please enter Campaign Name:");
					final String Camp_Name = sc.nextLine();
					System.out.println("Please enter Cheque Number:");
					final int Check_Num = sc.nextInt();
					try (final Connection connection = DriverManager.getConnection(URL)) {
						try (final CallableStatement statement1 = connection.prepareCall(QUERY_TEMPLATE_16)) 
						{
							// Populate the query template with the data collected from the user
							statement1.setString(1,Org_Name );
							statement1.setDate(2, date);
							statement1.setFloat(3, D_amount);
							statement1.setString(4, D_Type);
							statement1.setString(5, Camp_Name);
							statement1.setInt(6, Check_Num);

							System.out.println("Dispatching the query...");
							// Actually execute the populated query
							final int rows_inserted = statement1.executeUpdate();
							System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
						}
						}
					}
					else {
						System.out.println("Please enter Org Name:");
						final String Org_Name = sc.nextLine();
						System.out.println("Please enter Date of Donation:");
						final String date_J=sc.nextLine();
						Date date=Date.valueOf(date_J);
						System.out.println("Please enter Donation Amount:");
						final float D_amount=sc.nextFloat();
						sc.nextLine();
						System.out.println("Please enter Donation type:");
						final String D_Type = sc.nextLine();
						System.out.println("Please enter Campaign Name:");
						final String Camp_Name = sc.nextLine();
						System.out.println("Please enter Card Number:");
						final int Check_Num = sc.nextInt();
						sc.nextLine();
						System.out.println("Please enter Card Type:");
						final String CardType= sc.nextLine();
						System.out.println("Please enter Expiry Date:");
						final String date_E=sc.nextLine();
						Date dateE=Date.valueOf(date_E);
						try (final Connection connection = DriverManager.getConnection(URL)) {
							try (final CallableStatement statement1 = connection.prepareCall(QUERY_TEMPLATE_17)) 
							{
								// Populate the query template with the data collected from the user
								statement1.setString(1,Org_Name );
								statement1.setDate(2, date);
								statement1.setFloat(3, D_amount);
								statement1.setString(4, D_Type);
								statement1.setString(5, Camp_Name);
								statement1.setInt(6, Check_Num);
								statement1.setString(7, CardType);
								statement1.setDate(8, dateE);
								

								System.out.println("Dispatching the query...");
								// Actually execute the populated query
								final int rows_inserted = statement1.executeUpdate();
								System.out.println(String.format("Done. %d rows inserted.", rows_inserted));
							}
							}
					
						
					}
					count5--;}
				break;
				
			case "10": //Retrieve data of the client
					try {
					System.out.println("Please enter SSN:");
					final int SSN = sc.nextInt();
					//converting string into sql date  
					ResultSet resultSet=stmt.executeQuery("select  Doctor_Name,Doctor_phone from Client WHERE SSN="+SSN+"");
					System.out.println("Contents of the Client table:");
					System.out.println("Doctor Name | Doctor Phone");
					while (resultSet.next()) {
						System.out.println(
								String.format("%s | %s ", resultSet.getString(1), resultSet.getInt(2)));
					}}
					catch(InputMismatchException e)
					{
						System.out.println("Caught Input mismatch");
						sc.nextLine();
						break;
					}
					catch (Exception e)
					{
						System.out.println("Couldn't execute the above query!");
						System.out.println("Reason -- ");
						System.out.println(e.getMessage());
						System.out.println("Try again !!!");
					}
					break;
					
			case "11": //Retrieve the data of Expenses
				try {
				System.out.println("Please enter Start Date:");
				sc.nextLine();
				final int date_Start=sc.nextInt();			
				System.out.println("Please enter End Date:");
				final int date_End=sc.nextInt();
				ResultSet resultSet1=stmt.executeQuery("select  SSN,sum(Amount) from Expenses WHERE Expense_Date  "
						+ "between "+date_Start+" and  "+date_End+" group by SSN order by sum(Amount) asc");
				System.out.println("Contents of the Expense table:");
				System.out.println("SSN| Sum in total");
				while (resultSet1.next()) {
					System.out.println(
							String.format("%s| %s ", resultSet1.getInt(1), resultSet1.getFloat(2)));
				}}
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
				break;
	
			case "12": //Retriece list of Volunteers
				try {
				System.out.println("Please enter SSN:");
				final int SSN = sc.nextInt();
				ResultSet resultSet2=stmt.executeQuery("select SSN,Joining_Date,Training_Date,Training_Loc"
						+ " FROM Volunteers WHERE SSN in "
						+ "(SELECT C.SSN FROM Cares C,Serves S "
						+ "WHERE C.SSN="+SSN+" and S.SSN=C.SSN)");
				System.out.println("Contents of the Volunteers table:");
				System.out.println("SSN|Joining_Date|Training_Date|Training_Loc");
				if (resultSet2!=null) {
				while (resultSet2.next()) {
					System.out.println(
							String.format("%s| %s|%s|%s ", resultSet2.getInt(1), resultSet2.getDate(2),resultSet2.getDate(3),resultSet2.getString(4)));
				}}
				}
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
				break;
				
			case "13": //Retrieve info of client
				try {
				ResultSet resultSet2=stmt.executeQuery("SELECT Name,Mail_address,Email_address,Home_phone,"
						+ "Work_phone,Cell_phone from Person P,Client C "
						+ "WHERE C.SSN=P.SSN AND C.SSN IN (SELECT R.SSN FROM Cares R,Client C "
						+ "WHERE C.SSN=R.SSN AND R.T_Name IN (SELECT R.T_Name FROM Cares R,Teams T WHERE "
						+ "R.T_Name=T.T_Name AND T.T_Name IN (SELECT T.T_Name FROM Teams T,Sponsors S WHERE"
						+ " T.T_Name=S.T_Name AND S.Org_Name LIKE '[B-K]%' )))"
						+ " ORDER BY Name");
				System.out.println("Contents of the Volunteers table:");
				System.out.println("SSN|Joining_Date|Training_Date|Training_Loc");
				while (resultSet2.next()) {
					System.out.println(
							String.format("%s| %s|%s|%s|%s|%s ", resultSet2.getString(1), resultSet2.getString(2),resultSet2.getString(3),resultSet2.getInt(4),resultSet2.getInt(5),resultSet2.getInt(6)));
				}}
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
				break;
				
			case "14": //Retrieve info of employees who are donors
				try {
				ResultSet resultSet2=stmt.executeQuery("select   distinct cc.SSN,Amount as Sum_amount,Anonymous  from Person P,Donors D,Check_1 CC,Employees E\r\n"
						+ "WHERE  CC.SSN=D.SSN AND E.SSN=CC.SSN  UNION select   distinct cc.SSN,CC_Amount as Sum_amount,Anonymous  from Person P,Donors D,Credit_Card CC,Employees E\r\n"
						+ "WHERE  CC.SSN=D.SSN AND E.SSN=CC.SSN ");
				System.out.println("Contents of the  table:");
				System.out.println("SSN|Sum_amount|Anonymous State");
				while (resultSet2.next()) {
					System.out.println(
							String.format("%s| %s|%s", resultSet2.getInt(1), resultSet2.getFloat(2),resultSet2.getString(3)));
				}}
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
				break;
			
			case "15": //Retrieve info of teams
				try {
				System.out.println("Please enter found Date:");
				final int date_Start=sc.nextInt();			
				ResultSet resultSet1=stmt.executeQuery("select T_Name from Teams WHERE Date_T > "+date_Start+"   ");
				System.out.println("Contents of the Team table:");
				System.out.println("Team Name");
				while (resultSet1.next()) {
					System.out.println(
							String.format("%s", resultSet1.getString(1)));
				}}
				catch(InputMismatchException e)
				{
					System.out.println("Caught Input mismatch");
					sc.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println("Couldn't execute the above query!");
					System.out.println("Reason -- ");
					System.out.println(e.getMessage());
					System.out.println("Try again !!!");
				}
				break;
				
			case "16": //Increase salary
				int resultSet2 =stmt.executeUpdate("Update Employees SET E_Salary=E_Salary+0.1*E_Salary WHERE "
						+ "SSN IN (SELECT E.SSN FROM Reports R,Employees E WHERE "
						+ "E.SSN=R.SSN GROUP BY E.SSN HAVING COUNT(E.SSN)>1)");
				System.out.println(String.format("Done. %d rows inserted.", resultSet2));
				System.out.println("Connecting to the database...");
				// Get the database connection, create statement and execute it right away, as
				// no user input need be collected
				try (final Connection connection = DriverManager.getConnection(URL)) {
					System.out.println("Dispatching the query...");
					try (final Statement statement = connection.createStatement();
							final ResultSet resultSet = statement.executeQuery(QUERY_TEMPLATE_18)) {
						System.out.println("Contents of the Employee table:");
						System.out.println("SSN | E_Salary | M_Status | HireDate ");
						// Unpack the tuples returned by the database and print them out to the user
						while (resultSet.next()) {
							System.out.println(
									String.format("%s | %s | %s | %s", resultSet.getInt(1), resultSet.getFloat(2),
											resultSet.getString(3), resultSet.getDate(4)));
						}
					}
				}
				break;
				
			case "17": //Delete the client info
				int resultSet3 =stmt.executeUpdate("DELETE FROM Client  WHERE "
						+ "SSN IN (SELECT C.SSN FROM Client C,Needs N WHERE "
						+ "Imp_Value<5 AND Type='transportation' ) AND SSN NOT IN"
						+ " (SELECT SSN FROM Insurance_Policy  )");
				
				System.out.println(String.format("Done. %d rows inserted.", resultSet3));
				System.out.println("Connecting to the database...");
				// Get the database connection, create statement and execute it right away, as
				// no user input need be collected
				try (final Connection connection = DriverManager.getConnection(URL)) {
					System.out.println("Dispatching the query...");
					try (final Statement statement = connection.createStatement();
							final ResultSet resultSet = statement.executeQuery(QUERY_TEMPLATE_19)) {
						System.out.println("Contents of the Client table:");
						System.out.println("SSN | Doctor_Name | Attor_Name | Doctor_Phone |Attor_Phone| Date_assigned ");
						// Unpack the tuples returned by the database and print them out to the user
						while (resultSet.next()) {
							System.out.println(
									String.format("%s | %s | %s | %s|%s|%s", resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3), resultSet.getInt(4),
											resultSet.getInt(5), resultSet.getDate(6)));
						}
					}
				}
				break;
				
			case "18": //Import option
				try {
				 System.out.println("Enter the source file name: ");
				 final String sourcefile=br.readLine();
				 FileInputStream fis = new FileInputStream("C:/Users/meghnath reddy/Desktop/DBMS Individual project1/" +sourcefile);
				 DataInputStream dis = new DataInputStream(fis);
				 BufferedReader br1 = new BufferedReader(new InputStreamReader(dis));
				 String s;
				 while((s = br1.readLine())!= null) 
				 {
				 String a[] = s.split(",");
				 stmt.executeUpdate("Insert into Teams values ('"+a[0]+ "','"+a[1]+"','"+a[2]+"')");
				 System.out.println("Team/s has been added");
				 }}
				catch(FileNotFoundException e) {
						e.printStackTrace();
				}
				catch(IOException ie){
						ie.printStackTrace();
				}
				 break;
				 
			case "19": //Export option
				try {
				System.out.println("Enter the source destination file name: ");
				final String destfile=br.readLine();
				BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/meghnath reddy/Desktop/DBMS Individual project1/" +destfile));
				ResultSet res = stmt.executeQuery("select Name,Mail_address,Email_address from Person WHERE Mailing_list=0");
				while (res.next()) {
					bw.write(res.getString(1)+"\t");
					bw.write(res.getString(2)+"\t");
					bw.write(res.getString(3)+"\n");
				}bw.close();}
				catch(FileNotFoundException e) {
						e.printStackTrace();
				}
				catch(IOException ie){
						ie.printStackTrace();
				}
				 break;
			
			case "20": // Do nothing, the while loop will terminate upon the next iteration
				System.out.println("Exiting! Goodbuy!");
				break;
			default: // Unrecognized option, re-prompt the user for the correct one
				System.out.println(String.format("Unrecognized option: %s\n" + "Please try again!", option));
				break;
			}
			}
		
		sc.close(); // Close the scanner before exiting the application
	}
}