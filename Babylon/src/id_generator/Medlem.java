package id_generator;

public class Medlem{
    private String ID;
    private String fornavn;
    private String efternavn;
    private String fødselsdato;
    private String adresse;
    private String postnummer;
    private String by;
    private String indmeldingsdato;
    private String telefonnummer;
    private String email;

    public Medlem(
        String ID,
        String fornavn, 
        String efternavn, 
        String fødslesdato, 
        String adresse, 
        String postnummer,
        String by,
        String indmeldingsdato,
        String telefonnummer,
        String email){
            this.ID = ID;
            this.fornavn = fornavn;
            this.efternavn = efternavn;
            this.fødselsdato = fødslesdato;
            this.adresse = adresse;
            this.postnummer = postnummer;
            this.by = by;
            this.indmeldingsdato = indmeldingsdato;
            this.telefonnummer = telefonnummer;
            this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getFødselsdato() {
        return fødselsdato;
    }

    public void setFødselsdato(String fødselsdato) {
        this.fødselsdato = fødselsdato;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(String postnummer) {
        this.postnummer = postnummer;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getIndmeldingsdato() {
        return indmeldingsdato;
    }

    public void setIndmeldingsdato(String indmeldingsdato) {
        this.indmeldingsdato = indmeldingsdato;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

}