package com.company;
public class t_person {

    private String nachname;
    private String vorname;
    private String geburtsdatum;

    private int englisch;
    private int mathematik;
    private int deutsch;
    private int physik;
    private int chemie;

    public String getNachname()            { return nachname; }
    public void   setNachname(String s)    { this.nachname = s; }

    public String getVorname()             { return vorname; }
    public void   setVorname(String s)     { this.vorname = s; }

    public String getGeburtsdatum()        { return geburtsdatum; }
    public void   setGeburtsdatum(String s){ this.geburtsdatum = s; }

    public int  getEnglisch()              { return englisch; }
    public void setEnglisch(int n)         { this.englisch = n; }

    public int  getMathematik()            { return mathematik; }
    public void setMathematik(int n)       { this.mathematik = n; }

    public int  getDeutsch()               { return deutsch; }
    public void setDeutsch(int n)          { this.deutsch = n; }

    public int  getPhysik()                { return physik; }
    public void setPhysik(int n)           { this.physik = n; }

    public int  getChemie()                { return chemie; }
    public void setChemie(int n)           { this.chemie = n; }


    public double getSchnitt() {
        return (englisch + mathematik + deutsch + physik + chemie) / 5.0;
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
        System.out.printf ("* %-20s  Note: %d%n", "Englisch",    englisch);
        System.out.printf ("* %-20s  Note: %d%n", "Mathematik",  mathematik);
        System.out.printf ("* %-20s  Note: %d%n", "Deutsch",     deutsch);
        System.out.printf ("* %-20s  Note: %d%n", "Physik",      physik);
        System.out.printf ("* %-20s  Note: %d%n", "Chemie",      chemie);
        System.out.println(line2);
        System.out.printf ("Notendurchschnitt: %.2f%n", getSchnitt());
        System.out.println(line);
        System.out.println();
    }


    @Override
    public String toString() {
        return String.format(
                "%-15s %-15s  Geb.: %-12s  |  Eng:%d  Mat:%d  Deu:%d  Phy:%d  Che:%d  |  Schnitt: %.2f",
                nachname, vorname, geburtsdatum,
                englisch, mathematik, deutsch, physik, chemie,
                getSchnitt()
        );
    }
}
