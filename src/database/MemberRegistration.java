package database;

import java.sql.*;


public class MemberRegistration {

    public void registerMember(String username, String firstName, String lastName, String birthdate, String address, int postalCode, String city, String phoneNumber, String email, String card_printed)
            throws SQLException {
        Connection conn = DB.getConnection();
        try {
            conn.setAutoCommit(false);
            Statement st = conn.prepareStatement("");
        } finally {
            conn.setAutoCommit(true);
        } 
    }

}