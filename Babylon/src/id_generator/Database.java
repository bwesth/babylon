package id_generator;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;


public class Database {

    private HashMap<String, Medlem> medlemsListe;

    public Database() {
    }

    public HashMap<String, Medlem> initiateList() {
        ArrayList<Medlem> data = FileReader.readData();
        HashMap<String, Medlem> invertedIndex = new HashMap<String, Medlem>();
        for (Medlem medlem : data) {
            invertedIndex.put(medlem.getID(), medlem);
        }
        return invertedIndex;
    }

    public void addMember(HttpExchange io) {
        String test = io.getRequestURI().getRawQuery();
        System.out.println(test);
        // String[] input = io.getRequestURI().getRawQuery().split("=");
        
        // String fornavn = input[1];
        // System.out.println(fornavn);
        // String efternavn = sc.nextLine();
        // String fødselsdato = sc.nextLine();
        // String adresse = sc.nextLine();
        // String postnummer = sc.nextLine();
        // String by = sc.nextLine();
        // String indmeldingsdato = sc.nextLine();
        // String telefonnummer = sc.nextLine();
        // String email = sc.nextLine();
        // String ID = generateID(fornavn, efternavn);
        // Medlem medlem = new Medlem(ID, fornavn, efternavn, fødselsdato, adresse, postnummer, by, indmeldingsdato,
        //         telefonnummer, email);
        // medlemsListe.put(medlem.getID(), medlem);
        // sc.close();
    }

    public static String generateID(String fornavn, String efternavn, ArrayList<String> memberArrayList) {
        String fnavn = fornavn.split(" ")[0];
        String efnavn = efternavn.split(" ")[efternavn.split(" ").length - 1];
        String ID = fnavn.substring(0, 2) + efnavn.substring(0, 2);
        if (!memberArrayList.contains(ID)) {
            return ID.toUpperCase();
        } else if (efnavn.length() > 2) {
            ID = fnavn.substring(0, 1) + efnavn.substring(0, 3);
            if (!memberArrayList.contains(ID)) {
                return ID.toUpperCase();
            }
        } else if (fnavn.length() > 2) {
            ID = fnavn.substring(0, 3) + efnavn.substring(0, 2);
            if (!memberArrayList.contains(ID)) {
                return ID.toUpperCase();
            }
        }
        return "MANUEL ID PÅKRÆVET";
    }


    public void respond(HttpExchange io, int code, String mime, byte[] bs) {
        try {
            io.getResponseHeaders().set("Content-Type",
                    String.format("%s; charset=%s", mime, Webserver.getCharset().name()));
            io.sendResponseHeaders(200, bs.length);
            io.getResponseBody().write(bs);
        } catch (Exception e) {
        } finally {
            io.close();
        }
    }




}