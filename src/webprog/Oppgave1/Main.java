package webprog.Oppgave1;


import java.util.Date;

abstract class Person {
    String navn, tlfnr, adresse, epost;

    public Person(String navn, String tlfnr, String adresse, String epost) {
        this.navn = navn;
        this.tlfnr = tlfnr;
        this.adresse = adresse;
        this.epost = epost;
    }
    abstract String string();

}

class Kunde extends Person {
    public Kunde(String navn, String tlfnr, String adresse, String epost) {
        super(navn, tlfnr, adresse, epost);
    }

    public String string() {
        return "Navn: " + super.navn + "\n" +
                "Tlfnr: " + super.tlfnr + "\n" +
                "Adresse: " + super.adresse + "\n" +
                "Epost: " + super.epost;
    }
}

class Servitor extends Person {
    int ansattNr;
    public Servitor(String navn, String tlfnr, String adresse, String epost, int ansattNr) {
        super(navn, tlfnr, adresse, epost);
        this.ansattNr = ansattNr;
    }

    public String string() {
        return "Navn: " + super.navn + "\n" +
                "Ansattnr: " + ansattNr + "\n" +
                "Tlfnr: " + super.tlfnr + "\n" +
                "Adresse: " + super.adresse + "\n" +
                "Epost: " + super.epost;
    }
}

class Bestilling {
    Servitor servitor;
    Kunde kunde;
    int bordNr;
    Date dato;

    public Bestilling(Servitor servitor, Kunde kunde, int bordNr, Date dato) {
        this.servitor = servitor;
        this.kunde = kunde;
        this.bordNr = bordNr;
        this.dato = dato;
    }
}



public class Main {

    public static void main(String[] args) {
        Servitor servitor = new Servitor("ole", "123231", "adssad 23", "asda@fdl.com", 123);
        Kunde kunde = new Kunde("Knut", "4545335", "daslk 54", "dskfj@djsk.com");
        Bestilling bestilling = new Bestilling(servitor, kunde, 10, new Date(20-24-1992));

    }
}
