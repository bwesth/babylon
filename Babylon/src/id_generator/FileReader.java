package id_generator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {

    // fields

    // constructor
    public FileReader() {
    }

    // methods
    public static ArrayList<Medlem> readData() {
        ArrayList<Medlem> data = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        try {
        lines = readLinesFromFile("medlemsliste.txt");   
        } catch (Exception e) {
            System.out.println("File 'medlemsliste.txt' not found");
        }
        for (int i = 0; i < lines.size()-1; i++) {
          if (lines.get(i).startsWith("*ID")) {
            String ID = lines.get(i).substring(4);
            String fornavn = lines.get(++i);
            String efternavn = lines.get(++i);
            String fødselsdato = lines.get(++i);
            String adresse = lines.get(++i);
            String postnummer = lines.get(++i);
            String by = lines.get(++i);
            String indmeldingsdato = lines.get(++i);
            String telefonnummer = lines.get(++i);
            String email = lines.get(++i);
			data.add(new Medlem(ID, fornavn, efternavn, fødselsdato, adresse, postnummer, by, indmeldingsdato, telefonnummer, email));
            }
        }
        return data;
    }

    private static ArrayList<String> readLinesFromFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        try {
          lines.addAll(Files.readAllLines(Paths.get(filename)));
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        return lines;
      }
    

}