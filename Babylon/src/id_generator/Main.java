package id_generator;

public class Main {
    public static void main(String[] args) throws Exception {
        new Webserver(Webserver.getPort());
        Mariadb db = new Mariadb();        
        db.insertRecord("brugernavn", "fornavn", "efternavn", "fødselsdato", "adresse", "2100", "by", "indmeldingsdato", "10203040", "email");
    }
}