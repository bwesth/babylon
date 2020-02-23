package database;

import java.sql.*;


public class Main {

    // Helper function
    public static void printHeader(String s) {
        String sep = "======================================\n";
        System.out.print("\n\n" + sep + s + "\n" + sep);
    }

    public static void main(String[] args) throws Exception, SQLException {
        printHeader("Introduction to Database Design: Exercise in Java");

        // Optional: It might be useful for the teaching assistants to know which Java version you are using
        System.out.println("Java version: " + System.getProperty("java.version"));
       
        // Optional: Verify that driver is available in classpath
        System.out.println("Verifying that driver is available...");
        verifyDriver();

        // Open connection
        Connection conn = DB.getConnection();
        
        // It works!
        System.out.println("Everything seems to work!");
           
        Statement st = conn.createStatement();
        st.execute("CREATE TABLE test_table(column1 int,column2 int,column3 int);");
        // Close connection
        conn.close();
    }

    static void verifyDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: The JDBC driver was not found. Please check your classpath settings.");
            System.err.println(e);
            System.exit(-1);
        }
    }


}
