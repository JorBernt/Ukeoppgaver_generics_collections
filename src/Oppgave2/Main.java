package Oppgave2;

import java.util.*;
import java.util.stream.Collectors;

class MobelRegister<E extends Mobel> {
    private List<E> register;
    private Comparator<E> comp;
    public MobelRegister(Comparator<E> comp) {
        register = new ArrayList<>();
        this.comp = comp;
    }

    public MobelRegister() {
        register = new ArrayList<>();
    }

    public void leggTil(E mobel) {
        register.add(mobel);
    }

    public Mobel hent(int nr) {
        for(Mobel m : register) {
            if(m.getLopeNr() == nr) return m;
        }
        return null;
    }

    public void slett(int nr) {
        Iterator<E> it = register.listIterator();
        while(it.hasNext()) {
            if(it.next().getLopeNr() == nr) {
                it.remove();
                break;
            }
        }
    }

    public void sorterAlfabetisk() {
        Collections.sort(register, new MobelCompare());
    }

    public void sorterEtterBen() {
        Collections.sort(register, comp);
    }

    public void skrivUtAlle() {
        System.out.println(register.stream().map(Object::toString).collect(Collectors.joining("\n")));
    }

    public List<E> hentListe() {
        return register;
    }

}



abstract class Mobel implements Comparable<Mobel>{
    private String navn;
    private Double vekt, pris;
    private int lopeNr;

    public Mobel(String navn, Double vekt, Double pris, int lopeNr) {
        this.navn = navn;
        this.vekt = vekt;
        this.pris = pris;
        this.lopeNr = lopeNr;
    }
    @Override
    public abstract String toString();

    @Override
    public int compareTo(Mobel o) {
        return Integer.compare(lopeNr, o.lopeNr);
    }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }


    public Double getVekt() {
        return vekt;
    }

    public void setVekt(Double vekt) {
        this.vekt = vekt;
    }

    public Double getPris() {
        return pris;
    }

    public void setPris(Double pris) {
        this.pris = pris;
    }

    public int getLopeNr() {
        return lopeNr;
    }

    public void setLopeNr(int lopeNr) {
        this.lopeNr = lopeNr;
    }
}


class MobelCompare implements Comparator<Mobel> {
    @Override
    public int compare(Mobel m1, Mobel m2) {
        return m1.getNavn().compareTo(m2.getNavn());
    }

}

class Mobellmpl extends Mobel {
    public Mobellmpl(String navn, Double vekt, Double pris, int lopeNr) {
        super(navn, vekt, pris, lopeNr);
    }
    public String toString() {
        return getLopeNr()+"_"+getNavn();
    }
}

class Stol extends Mobel {
    public Stol(String navn, Double vekt, Double pris, int lopeNr) {
        super(navn, vekt, pris, lopeNr);
    }
    @Override
    public String toString() {
        return getNavn()+"_"+getLopeNr();
    }
}

class Bord extends Mobel {
    private int antallBen;
    public Bord(String navn, Double vekt, Double pris, int lopeNr, int antallBen) {
        super(navn, vekt, pris, lopeNr);
        this.antallBen = antallBen;
    }

    public int getAntallBen() {
        return antallBen;
    }

    public void setAntallBen(int antallBen) {
        this.antallBen = antallBen;
    }

    @Override
    public String toString() {
        return getNavn()+"_"+getLopeNr();
    }
}

class BordCompare implements Comparator<Bord> {
    @Override
    public int compare(Bord b1, Bord b2) {
        return Integer.compare(b1.getAntallBen(), b2.getAntallBen());
    }
}


public class Main {
    public static void main(String[] args) {
        MobelRegister<Bord> bordRegister = new MobelRegister(new BordCompare());
        MobelRegister<Stol> stolRegister = new MobelRegister();
        stolRegister.leggTil(new Stol("Kontorstol", 10.0, 400.0, 3));
        bordRegister.leggTil(new Bord("Kontorpult", 10.0, 599.0, 1, 4));
        bordRegister.leggTil(new Bord("Skrivebord", 12.0, 499.0, 2, 2));
        bordRegister.sorterEtterBen();
        skrivUtListe(bordRegister);
        skrivUtListe(stolRegister);
    }

    static <E extends Mobel> void skrivUtListe(MobelRegister<E> register) {
        System.out.println(register.hentListe().stream().map(Object::toString).collect(Collectors.joining("\n")));
    }
}
