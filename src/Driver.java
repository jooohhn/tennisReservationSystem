import java.sql.*;

/**
 * Run this class to drop/create the tables for the database.
 * Make sure that you have created a database named cs157a
 *
 */
public class Driver {
	// JDBC driver name and database URL
	static final String DB_URL = "jdbc:mysql://localhost:3306/cs157a";

	//  Database credentials
	static final String USER = "root";

	// PUT YOUR PASSWORD HERE
	static final String PASS = "...";
	private static Connection conn = null;
	private static Statement statement = null;

	public static void main(String[] args)
	{
		try
		{
			// create a connection to database
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			// create a statement object to execute sql commands
			statement = conn.createStatement();

			// delete first - in order to avoid key constraints
			deleteArchiveTable();
			deleteReservationTable();
			deleteTennisCourtTable();
			deletePaymentTable();
			deleteRecreationCenterTable();
			deleteUserTable();

			// create tables - in order to avoid key constraints
			createUserTable();
			createRecreationCenterTable();
			createPaymentTable();
			createTennisCourtTable();
			createReservationTable();
			createArchiveTable();

			// create triggers and procedures
			createDeleteUserTrigger();
			createAdminTrigger();
			createArchiveProcedure();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}

	private static void deleteRecreationCenterTable() throws SQLException
	{
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		String queryDrop = "DROP TABLE IF EXISTS RecreationCenter";
		Statement stmtDrop = conn.createStatement();
		stmtDrop.execute(queryDrop);
	}

	private static void deleteUserTable() throws SQLException
	{
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		String queryDrop = "DROP TABLE IF EXISTS User";
		Statement stmtDrop = conn.createStatement();
		stmtDrop.execute(queryDrop);
	}

	private static void deleteTennisCourtTable() throws SQLException
	{
		String queryDrop = "DROP TABLE IF EXISTS TennisCourt";
		Statement stmtDrop = conn.createStatement();
		stmtDrop.execute(queryDrop);
	}

	private static void deletePaymentTable() throws SQLException
	{
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		String queryDrop = "DROP TABLE IF EXISTS Payment";
		Statement stmtDrop = conn.createStatement();
		stmtDrop.execute(queryDrop);
	}

	private static void deleteReservationTable() throws SQLException
	{
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		String queryDrop = "DROP TABLE IF EXISTS Reservation";
		Statement stmtDrop = conn.createStatement();
		stmtDrop.execute(queryDrop);
	}

	private static void deleteArchiveTable() throws SQLException
	{
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		String queryDrop = "DROP TABLE IF EXISTS Archive";
		Statement stmtDrop = conn.createStatement();
		stmtDrop.execute(queryDrop);
	}

	private static void createRecreationCenterTable() throws SQLException
	{

		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = conn.createStatement();
		String createTableSQL = "create table RecreationCenter"
		 + "(recCenterId INT AUTO_INCREMENT, "
		 + "name VARCHAR(30), "
		 + "rentalPricePerHour INT,"
		 + "PRIMARY KEY(recCenterId));";
		statement.execute(createTableSQL);
		System.out.println("Table called RecreationCenter created successfully...");
	}

	private static void createUserTable() throws SQLException
	{
		// Open a connection and select the database named CS

		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = conn.createStatement();
		String createTableSQL = "CREATE TABLE User"
		 + "(username VARCHAR(255), "
		 + "password VARCHAR(255), "
		 + "isAdmin BOOLEAN,"
		 + "PRIMARY KEY (username));";
		statement.execute(createTableSQL);
		System.out.println("Table called User created successfully...");
	}

	private static void createTennisCourtTable() throws SQLException
	{
		// Open a connection and select the database named CS

		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = conn.createStatement();

		String createTableSQL = "create table TennisCourt "
		 + "(tennisCourtId INT AUTO_INCREMENT, "
		 + "recCenterId INT, "
		 + "type VARCHAR(255),"
		 + "PRIMARY KEY(tennisCourtId),"
		 + "FOREIGN KEY (recCenterId) REFERENCES RecreationCenter(recCenterId));";
		statement.execute(createTableSQL);
		System.out.println("Table called TennisCourt created successfully...");
	}

	private static void createReservationTable() throws SQLException
	{
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = conn.createStatement();

		String createTableSQL = "create table Reservation "
		 + "(reservationId INT AUTO_INCREMENT,"
		 + "username VARCHAR(255),"
		 + "tennisCourtId INT,"
		 + "paymentId INT,"
		 + "reservationTimeStart TIMESTAMP,"
		 + "reservationTimeEnd TIMESTAMP,"
		 + "updateAt TIMESTAMP,"
		 + "PRIMARY KEY(reservationId),"
		 + "FOREIGN KEY (username) REFERENCES User(username),"
		 + "FOREIGN KEY (tennisCourtId) REFERENCES TennisCourt(tennisCourtId),"
		 + "FOREIGN KEY (paymentId) REFERENCES Payment(paymentId));";
		statement.execute(createTableSQL);
		System.out.println("Table called Reservation created successfully...");
	}

	private static void createPaymentTable() throws SQLException
	{
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = conn.createStatement();
		String createTableSQL = "create table Payment "
		 + "(paymentId INT AUTO_INCREMENT, "
		 + "cost INTEGER, "
		 + "method VARCHAR(255),"
		 + "PRIMARY KEY(paymentId));";
		statement.execute(createTableSQL);
		System.out.println("Table called Payment created successfully...");
	}

	private static void createArchiveTable() throws SQLException
	{
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = conn.createStatement();
		String createTableSQL = "create table Archive "
		 + "(reservationId INT,"
		 + "username VARCHAR(255),"
		 + "tennisCourtId INT,"
		 + "paymentId INT,"
		 + "reservationTimeStart TIMESTAMP,"
		 + "reservationTimeEnd TIMESTAMP,"
		 + "updateAt TIMESTAMP,"
		 + "PRIMARY KEY(reservationId),"
		 + "FOREIGN KEY(username) REFERENCES User(username),"
		 + "FOREIGN KEY(tennisCourtId) REFERENCES TennisCourt(tennisCourtId),"
		 + "FOREIGN KEY (paymentId) REFERENCES Payment(paymentId));";
		statement.execute(createTableSQL);
		System.out.println("Table called Archive created successfully...");
	}

	private static void createDeleteUserTrigger() throws SQLException
	{
		String deleteTrigger = "DROP TRIGGER IF EXISTS deleteUser";
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = conn.createStatement();
		statement.executeUpdate(deleteTrigger);
		String createTrigger = "CREATE TRIGGER deleteUser "
		 + "BEFORE DELETE ON USER "
		 + "FOR EACH ROW "
		 + "BEGIN "
		 + "DELETE FROM Reservation WHERE username = old.username;"
		 + "END;";
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = conn.createStatement();
		statement.executeUpdate(createTrigger);
		System.out.println("Created delete user trigger!");
	}

	private static void createAdminTrigger() throws SQLException
	{
		String deleteTrigger = "DROP TRIGGER IF EXISTS adminSignup;";
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = conn.createStatement();
		statement.executeUpdate(deleteTrigger);
		String createTrigger = "CREATE TRIGGER adminSignup "
		 + "BEFORE INSERT ON User "
		 + "FOR EACH ROW "
		 + "BEGIN "
		 + "If new.isAdmin = true AND (select count(*) from User where isAdmin = true) > 5 THEN "
		 + "SET new.isAdmin = false; "
		 + "END IF; "
		 + "END;";
		statement = conn.createStatement();
		statement.executeUpdate(createTrigger);
		System.out.println("Created createAdmin trigger!");
	}

	private static void createArchiveProcedure() throws SQLException
	{
		String deleteProcedure = "DROP PROCEDURE IF EXISTS archive;";
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = conn.createStatement();
		statement.executeUpdate(deleteProcedure);
		String procedure = "CREATE PROCEDURE archive(IN cutOff TIMESTAMP) "
		 + "BEGIN "
		 + "INSERT INTO Archive"
		 + " SELECT * FROM Reservation WHERE reservationTimeEnd < cutOff; "
		 + "DELETE FROM Reservation WHERE reservationTimeEnd < cutOff; "
		 + "END;";
		statement = conn.createStatement();
		statement.executeUpdate(procedure);
		System.out.println("created archive procedure!");

	}
}
