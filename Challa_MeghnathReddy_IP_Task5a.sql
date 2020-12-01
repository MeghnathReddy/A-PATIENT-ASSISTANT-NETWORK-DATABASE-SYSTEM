----------QUERIES----------------
--To add a Person
DROP PROCEDURE IF EXISTS insertintoPerson 
GO
CREATE PROCEDURE insertintoPerson
--Parameters to be taken as input are declared
@SNN INT ,@Name VARCHAR(30) ,
@Birthdate DATE,
@Race VARCHAR(20) ,@Gender VARCHAR(10),
@Profession VARCHAR(20) ,
@Mail_address Varchar(100),@Email_address Varchar(30),@Home_phone INT,
@Work_phone INT,@Cell_phone INT,@Mailing_list INT
AS
BEGIN
  INSERT INTO Person VALUES(@SNN,@Name,@Birthdate,@Race,
  @Gender,@Profession,@Mail_address,@Email_address,@Home_phone,@Work_phone,@Cell_phone,@Mailing_list);
END
GO


--FOR OPTION-1
DROP PROCEDURE IF EXISTS insertintoTeam 
GO
CREATE PROCEDURE insertintoTeam
--Parameters to be taken as input are declared
@T_Name VARCHAR(30) ,
@Type VARCHAR(20) ,
@Date_T INT
AS
BEGIN
  INSERT INTO Teams VALUES(@T_Name,@Type,@Date_T);
END
GO

--FOR OPTION-2
DROP PROCEDURE IF EXISTS insertintoClient
GO
CREATE PROCEDURE insertintoClient
--Parameters to be taken as input are declared
@SSN INT,
@Doctor_Name  VARCHAR(30) ,
@Attor_Name  VARCHAR(30) ,
@Doctor_phone INT ,
@Attor_phone INT ,
@Date_assigned DATE 
AS
BEGIN
  INSERT INTO Client VALUES(@SSN,@Doctor_Name,@Attor_Name,@Doctor_phone,@Attor_phone,@Date_assigned);
END
GO


DROP PROCEDURE IF EXISTS insertintoCare
GO
CREATE PROCEDURE insertintoCare
--Parameters to be taken as input are declared
@SSN INT,
@T_Name VARCHAR(30),
@C_ActiveState INT
AS
BEGIN
  INSERT INTO Cares VALUES(@SSN,@T_Name,@C_ActiveState);
END
GO




---For option 3
DROP PROCEDURE IF EXISTS insertintoVolunteer
GO
CREATE PROCEDURE insertintoVolunteer
--Parameters to be taken as input are declared
@SSN INT,
@Joining_Date DATE,
@Training_Date DATE,
@Training_Loc Varchar(30)
AS
BEGIN
  INSERT INTO Volunteers VALUES(@SSN,@Joining_Date,@Training_Date,@Training_Loc);
END
GO

---For option 3,4
DROP PROCEDURE IF EXISTS insertintoServes
GO
CREATE PROCEDURE insertintoServes
--Parameters to be taken as input are declared
@SSN INT,
@T_Name VARCHAR(30),
@Hours INT,
@ActiveState INT,
@Specific_Month Varchar(20)
AS
BEGIN
  INSERT INTO Serves VALUES(@SSN,@T_Name,@Hours,@ActiveState,@Specific_Month);
END
GO


---For option 5
DROP PROCEDURE IF EXISTS insertintoEmployee
GO
CREATE PROCEDURE insertintoEmployee
--Parameters to be taken as input are declared
@SSN INT,
@Salary FLOAT,
@M_Status VARCHAR(20),
@Hire_Date DATE
AS
BEGIN
  INSERT INTO Employees VALUES(@SSN,@Salary,@M_Status,@Hire_Date);
END
GO



DROP PROCEDURE IF EXISTS insertintoReports
GO
CREATE PROCEDURE insertintoReports
--Parameters to be taken as input are declared
@SSN INT,
@T_Name VARCHAR(30),
@R_DATE DATE,
@Desc_1 VARCHAR(30)
AS
BEGIN
  INSERT INTO Reports VALUES(@SSN,@T_Name,@R_DATE,@Desc_1);
END
GO

---For option 6
DROP PROCEDURE IF EXISTS insertintoExpense
GO
CREATE PROCEDURE insertintoExpense
--Parameters to be taken as input are declared
@SSN INT,
@Amount FLOAT,
@Desc_1 VARCHAR(30),
@Expense_Date INT

AS
BEGIN
  INSERT INTO Expenses VALUES(@SSN,@Amount,@Desc_1,@Expense_Date);
END
GO

---For option 7

DROP PROCEDURE IF EXISTS insertintoExternal_Org
GO
CREATE PROCEDURE insertintoExternal_Org
--Parameters to be taken as input are declared
@Org_Name Varchar (20),
@Org_address Varchar (30),
@Org_Number INT,
@Org_Contact Varchar(20)

AS
BEGIN
  INSERT INTO External_Org VALUES(@Org_Name,@Org_address,@Org_Number,@Org_Contact);
END
GO


DROP PROCEDURE IF EXISTS insertintoSponsors
GO
CREATE PROCEDURE insertintoSponsors
--Parameters to be taken as input are declared
@T_Name VARCHAR(30),
@Org_Name VARCHAR(20)

AS
BEGIN
  INSERT INTO Sponsors VALUES(@T_Name,@Org_Name);
END
GO



---For option 8
DROP PROCEDURE IF EXISTS insertintoDonor
GO
CREATE PROCEDURE insertintoDonor
--Parameters to be taken as input are declared
@SSN INT,
@Anonymous VARCHAR(30)

AS
BEGIN
  INSERT INTO Donors VALUES(@SSN,@Anonymous);
END
GO



DROP PROCEDURE IF EXISTS insertintoCheck
GO
CREATE PROCEDURE insertintoCheck
--Parameters to be taken as input are declared
@SSN INT,
@Date DATE,
@DAmount FLOAT,
@DTYPE VARCHAR(30),
@CampaignName VARCHAR(30),
@ChequeNumber INT
AS
BEGIN
  INSERT INTO Check_1 VALUES(@SSN,@Date,@DAmount,@DTYPE,@CampaignName,@ChequeNumber);
END
GO

DROP PROCEDURE IF EXISTS insertintoCredit
GO
CREATE PROCEDURE insertintoCredit
--Parameters to be taken as input are declared
@SSN INT,
@Date DATE,
@DAmount FLOAT,
@DTYPE VARCHAR(30),
@CampaignName VARCHAR(30),
@CardNumber INT,
@CardType VARCHAR(20),
@ExpDate DATE
AS
BEGIN
  INSERT INTO Credit_Card VALUES(@SSN,@Date,@DAmount,@DTYPE,@CampaignName,@CardNumber,@CardType,@ExpDate);
END
GO

----For option 9
DROP PROCEDURE IF EXISTS insertintoExternalDonor
GO
CREATE PROCEDURE insertintoExternalDonor
--Parameters to be taken as input are declared
@Org_Name VARCHAR(20),
@Anonymous VARCHAR(20)

AS
BEGIN
  INSERT INTO External_Donor VALUES(@Org_Name,@Anonymous);
END
GO


DROP PROCEDURE IF EXISTS insertintoExCheck
GO
CREATE PROCEDURE insertintoExCheck
--Parameters to be taken as input are declared
@Org_Name Varchar (20),
@Date DATE,
@DAmount FLOAT,
@DTYPE VARCHAR(30),
@CampaignName VARCHAR(30),
@ChequeNumber INT
AS
BEGIN
  INSERT INTO Ex_check VALUES(@Org_Name,@Date,@DAmount,@DTYPE,@CampaignName,@ChequeNumber);
END
GO

DROP PROCEDURE IF EXISTS insertintoExCredit
GO
CREATE PROCEDURE insertintoExCredit
--Parameters to be taken as input are declared
@Org_Name Varchar (20),
@Date DATE,
@DAmount FLOAT,
@DTYPE VARCHAR(30),
@CampaignName VARCHAR(30),
@CardNumber INT,
@CardType VARCHAR(20),
@ExpDate DATE
AS
BEGIN
  INSERT INTO Ex_creditcard VALUES(@Org_Name,@Date,@DAmount,@DTYPE,@CampaignName,@CardNumber,@CardType,@ExpDate);
END
GO

