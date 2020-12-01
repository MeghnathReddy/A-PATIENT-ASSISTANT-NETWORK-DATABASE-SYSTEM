DROP TABLE IF EXISTS Employees ;
DROP TABLE IF EXISTS Volunteers ;
DROP TABLE IF EXISTS Donors ;
DROP TABLE IF EXISTS Emergency_Details;
DROP TABLE IF EXISTS Needs ;
DROP TABLE IF EXISTS Insurance_Policy ;
DROP TABLE IF EXISTS Cares ;
DROP TABLE IF EXISTS Serves ;
DROP TABLE IF EXISTS Reports ;
DROP TABLE IF EXISTS Expenses ;
DROP TABLE IF EXISTS Check_1 ;
DROP TABLE IF EXISTS Credit_Card ;
DROP TABLE IF EXISTS Sponsors  ;
DROP TABLE IF EXISTS Affliated  ;
DROP TABLE IF EXISTS Teams ;
DROP TABLE IF EXISTS Business  ;
DROP TABLE IF EXISTS Church  ;
DROP TABLE IF EXISTS External_Donor  ;
DROP TABLE IF EXISTS Ex_check  ;
DROP TABLE IF EXISTS Ex_creditcard   ;
DROP TABLE IF EXISTS Client ;
DROP TABLE IF EXISTS External_Org  ;
DROP TABLE IF EXISTS Person;



-----CREATE TABLES------------
CREATE Table Person (SSN INT PRIMARY KEY, Name Varchar(30) NOT NULL, 
Birthdate DATE NOT NULL, Race Varchar(20) NOT NULL, Gender Varchar(10) NOT NULL,
 Profession Varchar(20) NOT NULL, Mail_address Varchar(100),
 Email_address Varchar(30), Home_phone INT NOT NULL, 
 Work_phone INT NOT NULL, Cell_phone INT NOT NULL, Mailing_list INT NOT NULL);


 CREATE TABLE External_Org (Org_Name Varchar (20) PRIMARY KEY, 
Org_address Varchar (30) NOT NULL, Org_Number INT NOT NULL, Org_Contact Varchar(20) NOT NULL);


 CREATE TABLE Client (SSN INT PRIMARY KEY,
  Doctor_Name Varchar(30) NOT NULL,Attor_Name Varchar(30) NOT NULL, Doctor_phone INT NOT NULL,
  Attor_phone INT NOT NULL,
  Date_assigned DATE NOT NULL,
FOREIGN KEY (SSN) REFERENCES PERSON(SSN) );




CREATE TABLE Employees (SSN INT PRIMARY KEY, E_Salary FLOAT NOT NULL, 
M_Status Varchar(20), HireDate DATE NOT NULL, 
FOREIGN KEY (SSN) REFERENCES PERSON(SSN) ) ;



CREATE TABLE Volunteers (SSN INT PRIMARY KEY, Joining_Date DATE NOT NULL,
Training_Date DATE NOT NULL,Training_Loc Varchar(30) NOT NULL, 
FOREIGN KEY (SSN) REFERENCES PERSON(SSN) );

CREATE TABLE Donors (SSN INT PRIMARY KEY, Anonymous Varchar(30) NOT NULL,FOREIGN KEY (SSN) REFERENCES PERSON(SSN) );


CREATE TABLE Emergency_Details (SSN INT, Emer_Name Varchar(30), Contact_Info INT, Relationship Varchar(30) ,
PRIMARY KEY (Emer_Name, Contact_Info,Relationship),
FOREIGN KEY (SSN) REFERENCES PERSON(SSN) );


CREATE TABLE Needs (SSN INT, Type Varchar (30) , 
Imp_Value INT NOT NULL,FOREIGN KEY (SSN) REFERENCES PERSON(SSN),
 CONSTRAINT Value_check CHECK (Imp_Value between 1 and 10), PRIMARY KEY (SSN,Type, Imp_Value) );

 CREATE TABLE Insurance_Policy (SSN INT NOT NULL, Policy_id INT PRIMARY KEY, Provider_id INT NOT NULL, 
 Provider_address Varchar(100) NOT NULL, 
 Type VARCHAR(30) NOT NULL, 
 FOREIGN KEY (SSN) REFERENCES PERSON(SSN));

CREATE TABLE Teams ( T_Name Varchar(30) PRIMARY KEY, Type Varchar(20) NOT NULL, Date_T INT NOT NULL);




CREATE TABLE Cares (SSN INT, T_Name Varchar(30),C_ActiveState INT NOT NULL ,
 FOREIGN KEY (SSN) REFERENCES PERSON(SSN) , FOREIGN KEY (T_Name) REFERENCES Teams(T_Name)  );



CREATE TABLE Serves (SSN INT, FOREIGN KEY (SSN) REFERENCES PERSON(SSN), T_Name Varchar(30),
 FOREIGN KEY (T_Name) REFERENCES Teams(T_Name) ,Hours INT NOT NULL, Active_State INT NOT NULL, 
Specific_Month Varchar (20) NOT NULL);



 
CREATE TABLE Reports (SSN INT, T_Name Varchar(30), 
R_DATE DATE NOT NULL, Desc_1 Varchar(30) NOT NULL, FOREIGN KEY (SSN) REFERENCES PERSON(SSN) , 
FOREIGN KEY (T_Name) REFERENCES Teams(T_Name), PRIMARY KEY (T_Name,SSN) );



CREATE TABLE Expenses (SSN INT , FOREIGN KEY (SSN) REFERENCES PERSON(SSN),Amount FLOAT NOT NULL, 
Desc_1 Varchar (30) NOT NULL,Expense_Date INT NOT NULL,PRIMARY KEY (Amount,Desc_1,Expense_Date,SSN));


CREATE TABLE Check_1(SSN INT, FOREIGN KEY (SSN) REFERENCES PERSON(SSN),
C_Date DATE  , Amount FLOAT  , D_Type Varchar(30), Campaign_Name Varchar(30),Cheque_Number INT NOT NULL,
 PRIMARY KEY (SSN, C_Date, Amount, D_Type, Campaign_Name, Cheque_Number));





CREATE TABLE Sponsors (T_Name Varchar(30) , FOREIGN KEY (T_Name) REFERENCES Teams(T_Name) ,
 Org_Name Varchar (20) , FOREIGN KEY (Org_Name) REFERENCES External_Org (Org_Name));



 CREATE TABLE Affliated (SSN INT, FOREIGN KEY (SSN) REFERENCES PERSON(SSN), 
 Org_Name Varchar (20),
  FOREIGN KEY (Org_Name) REFERENCES External_Org (Org_Name),PRIMARY KEY (SSN) );



CREATE TABLE Business (Org_Name Varchar (20) PRIMARY KEY, 
FOREIGN KEY (Org_Name) REFERENCES External_Org (Org_Name), 
Type Varchar(30) NOT NULL, Size INT NOT NULL,Website Varchar (50) NOT NULL);



CREATE TABLE Church (Org_Name Varchar (20) PRIMARY KEY,
 FOREIGN KEY (Org_Name) REFERENCES External_Org (Org_Name), 
 R_affliation Varchar (20) NOT NULL);



CREATE TABLE External_Donor (Org_Name Varchar (20) PRIMARY KEY, 
FOREIGN KEY (Org_Name) REFERENCES External_Org (Org_Name), 
Anonymous Varchar(20) NOT NULL);



CREATE TABLE Ex_check (Org_Name Varchar (20), FOREIGN KEY (Org_Name) REFERENCES External_Org (Org_Name),
 Ex_Date DATE,Ex_Amount INT,Ex_Type Varchar (30), 
 Campaign_Name Varchar(30) ,Cheque_Number INT NOT NULL,
 PRIMARY KEY (Org_Name, Ex_Date, Ex_Amount, Ex_Type, Campaign_Name));


 
CREATE TABLE Ex_creditcard (Org_Name Varchar (20), FOREIGN KEY (Org_Name) REFERENCES External_Org (Org_Name),
ExCC_Date DATE, ExCC_Amount INT, ExCC_Type Varchar(30), ExCCCampaign_Name Varchar(30),
ExCard_number INT NOT NULL, ExCard_Type Varchar (20) NOT NULL,
Ex_Exp_Date DATE NOT NULL, PRIMARY KEY (Org_Name, ExCC_Date, ExCC_Amount, ExCC_Type, ExCCCampaign_Name));


------INDEX------------------------

DROP INDEX IF EXISTS Needs.Type_V;
CREATE INDEX Type_V on Needs(Type,Imp_Value);
DROP INDEX IF EXISTS Insurance_Policy.I_Type;
CREATE INDEX I_Type on Insurance_Policy(Type);
DROP INDEX IF EXISTS Teams.T_Date;
CREATE INDEX T_Date on Teams(Date_T);
DROP INDEX IF EXISTS Cares.C_TName;
CREATE INDEX C_TName on Cares(T_Name);
DROP INDEX IF EXISTS Cares.C_SSN;
CREATE INDEX C_SSN on Cares(SSN);
DROP INDEX IF EXISTS Expense.E_Date;
CREATE INDEX E_Date on Expenses(Expense_Date);
DROP INDEX IF EXISTS Sponsors.Sp_OrgName;
CREATE INDEX Sp_OrgName on Sponsors(Org_Name);
DROP INDEX IF EXISTS Serves.T_Index;
CREATE INDEX T_Index on Serves(T_Name);
