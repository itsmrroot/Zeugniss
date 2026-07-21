package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

public class t_person {

    private String nachname;
    private String vorname;
    private String geburtsdatum;
    private LinkedHashMap<String, Integer> faecher = new LinkedHashMap<>();

    public String getNachname()             { return nachname; }
    public void   setNachname(String s)     { this.nachname = s; }

    public String getVorname()              { return vorname; }
    public void   setVorname(String s)      { this.vorname = s; }

    public String getGeburtsdatum()         { return geburtsdatum; }
    public void   setGeburtsdatum(String s) { this.geburtsdatum = s; }

    public void addFach(String name, int note) {
        faecher.put(name, note);
    }

    public LinkedHashMap<String, Integer> getFaecher() {
        return faecher;
    }

    public double getSchnitt() {
        if (faecher.isEmpty()) return 0.0;

        int summe = 0;
        for (int note : faecher.values()) {
            summe += note;
        }
        return summe / (double) faecher.size();
    }

    public void printCertificate() {
        String line  = "-".repeat(35);
        String line2 = "─".repeat(35);

        System.out.println();
        System.out.println(line);
        System.out.println("------------SCHULZEUGNIS-----------");
        System.out.println(line);
        System.out.printf ("  Name:          %s %s%n", vorname, nachname);
        System.out.printf ("  Geburtsdatum:  %s%n",    geburtsdatum);
        System.out.println(line);
        System.out.println("FÄCHER & NOTEN");
        System.out.println(line2);
        for (Map.Entry<String, Integer> eintrag : faecher.entrySet()) {
            System.out.printf("* %-20s  Note: %d%n", eintrag.getKey(), eintrag.getValue());
        }
        System.out.println(line2);
        System.out.printf ("Notendurchschnitt: %.2f%n", getSchnitt());
        System.out.println(line);
        System.out.println();
    }

    @Override
    public String toString() {
        return String.format(
                "%-15s %-15s  Geb.: %-12s  |  Fächer: %d  |  Schnitt: %.2f",
                nachname, vorname, geburtsdatum,
                faecher.size(),
                getSchnitt()
        );
    }
}
