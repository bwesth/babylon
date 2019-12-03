package id_generator;
import java.sql.*;
import java.util.ArrayList;

public class Mariadb{
static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
static final String DB_URL = "localhost:3306/Babylon";
private Connection connection;

public Mariadb(){

}

public void insertRecord(String fornavn, String efternavn, String fødselsdato, String adresse, String postnummer, String by, String indmeldingsdato, String telefonnummer, String email ) throws SQLException{
    openConnection();
    Statement statement = connection.createStatement();
    ArrayList<String> memberArrayList = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("select Brugernavn from Babylon");
    while (resultSet.next()){
        memberArrayList.add(resultSet.getString("Brugernavn"));
    }
    String sql = "insert into Babylon"
                +" (Brugernavn, Fornavn, Efternavn, Fødselsdato, Adresse, Postnummer, By, Indmeldingsdato, Telefonnummer, Email)"
                +" values ('"+Database.generateID(fornavn, efternavn, memberArrayList)+"', '"+fornavn+"', '"+efternavn+"', '"+fødselsdato+"', '"+adresse+"', '"+postnummer+"', '"+by+"', '"+indmeldingsdato+"', '"+telefonnummer+"', '"+efternavn+"')";
    statement.executeUpdate(sql);
    System.out.println("Record inserted");
    closeConnection(statement);
}

public void insertRecord(String brugernavn, String fornavn, String efternavn, String fødselsdato, String adresse, String postnummer, String by, String indmeldingsdato, String telefonnummer, String email) throws SQLException{
    openConnection();
    Statement statement = connection.createStatement();
    String sql = "INSERT INTO Babylon"
                +" (Brugernavn, Fornavn, Efternavn, Fødselsdato, Adresse, Postnummer, By, Indmeldingsdato, Telefonnummer, Email)"
                +" VALUES ('"+brugernavn+"', '"+fornavn+"', '"+efternavn+"', '"+fødselsdato+"', '"+adresse+"', '"+postnummer+"', '"+by+"', '"+indmeldingsdato+"', '"+telefonnummer+"', '"+efternavn+"')";
                System.out.println(sql);
    statement.executeUpdate(sql);
    System.out.println("Record inserted");
    closeConnection(statement);
}

public void updateRecord(String brugernavn, String fornavn, String efternavn, String fødselsdato, String adresse, String postnummer, String by, String indmeldingsdato, String telefonnummer, String email)
            throws SQLException {
    openConnection();
    Statement statement = connection.createStatement();
    String sql = "update Babylon"
                +" set fornavn='"+fornavn+"'"
                +" set efternavn='"+efternavn+"'"
                +" set fødselsdato='"+fødselsdato+"'"
                +" set adresse='"+adresse+"'"
                +" set postnummer='"+postnummer+"'"
                +" set by='"+by+"'"
                +" set Indmeldingsdato='"+indmeldingsdato+"'"
                +" set Telefonnummer='"+telefonnummer+"'"
                +" set Email='"+email+"')"
                +" where Brugernavn="+brugernavn;
    statement.executeUpdate(sql);
    System.out.println("Record updated");
    closeConnection(statement);
}

private void openConnection(){
    try {
        Class.forName(JDBC_DRIVER);
        System.out.println("Connecting to a selected database...");
        connection = DriverManager.getConnection(
                "jdbc:mariadb://"+DB_URL, "root", "LoneErEnBaby");
        System.out.println("Connected database successfully...");            
    } catch (SQLException se) {
        se.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void closeConnection(Statement statement){
    try {
    if (statement != null) {
        connection.close();
    }
} catch (SQLException se) {
    se.printStackTrace();
}
try {
    if (statement != null) {
        connection.close();
    }
} catch (SQLException se) {
    se.printStackTrace();
}
System.out.println("Closing connection");
}



}