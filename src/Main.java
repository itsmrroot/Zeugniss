import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static boolean        running  = true;
    public static int            option   = 0;
    public static Scanner        scanner  = new Scanner(System.in);
    public static LinkedList<t_person> zeugnisse = new LinkedList<>();


    public static void main(String[] args) {
        printWelcome();

        while (running) {
            switch (printMenu()) {
                case 1: add();           break;
                case 2: delete();        break;
                case 3: alleAnzeigen();  break;
                case 4: printGoodbye(); running = false; break;
                default:
                    System.out.println("Bitte geben Sie eine gültige Nummer (1–4) ein.");
                    break;
            }
        }
    }


    public static void printWelcome() {
        System.out.println("========================================");
        System.out.println("  Willkommen beim Schulzeugnis-Generator!");
        System.out.println("========================================\n");
    }

    public static void printGoodbye() {
        System.out.println("\nGeschafft! Ihre Zeugnisse sind fertig.");
        System.out.println("Vielen Dank, dass Sie den Schulzeugnis-Generator genutzt haben.");
        System.out.println("Bis zum nächsten Halbjahr!");
    }


    public static int printMenu() {
        option = 0;

        System.out.print("""

                (1) Neues Zeugnis erstellen
                (2) Zeugnis löschen
                (3) Alle Zeugnisse anzeigen
                (4) App beenden
                Wählen Sie eine Option (1–4): """);

        try {
            String line = scanner.nextLine().trim();
            option = Integer.parseInt(line);

            if (option < 1 || option > 4) {
                throw new IllegalArgumentException("Nummer muss zwischen 1 und 4 liegen.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        return option;
    }


    public static void add() {
        System.out.println("\n=== Neues Zeugnis erstellen ===");

        t_person person = new t_person();

        System.out.print("Nachname des Schülers  : ");
        person.setNachname(scanner.nextLine());

        System.out.print("Vorname des Schülers   : ");
        person.setVorname(scanner.nextLine());

        person.setGeburtsdatum(holeGueltigesDatum());

        person.setEnglisch(  holeGueltigeNote("Englisch"));
        person.setMathematik(holeGueltigeNote("Mathematik"));
        person.setDeutsch(   holeGueltigeNote("Deutsch"));
        person.setPhysik(    holeGueltigeNote("Physik"));
        person.setChemie(    holeGueltigeNote("Chemie"));

        zeugnisse.add(person);

        System.out.println("\n=== Zeugnis erfolgreich gespeichert! ===");
        person.printCertificate();
    }

   
    public static void delete() {
        if (zeugnisse.isEmpty()) {
            System.out.println("\nKeine Zeugnisse gespeichert – nichts zu löschen.");
            return;
        }


        System.out.println("\n=== Zeugnis löschen ===");
        printListe();

        int choice = 0;
        boolean valid = false;

        while (!valid) {
            System.out.printf("Welches Zeugnis löschen? (1–%d, 0 = Abbrechen): ", zeugnisse.size());
            try {
                String line = scanner.nextLine().trim();
                choice = Integer.parseInt(line);

                if (choice == 0) {
                    System.out.println("Löschen abgebrochen.");
                    return;
                }
                if (choice < 1 || choice > zeugnisse.size()) {
                    System.out.printf("Fehler: Bitte eine Zahl zwischen 1 und %d eingeben.%n", zeugnisse.size());
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Fehler: Bitte eine gültige Zahl eingeben!");
            }
        }


        t_person toDelete = zeugnisse.get(choice - 1);
        System.out.printf("Wirklich löschen: %s %s? (j/n): ",
                toDelete.getVorname(), toDelete.getNachname());

        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("j")) {
            zeugnisse.remove(choice - 1);
            System.out.printf("Zeugnis von %s %s wurde gelöscht.%n",
                    toDelete.getVorname(), toDelete.getNachname());
            System.out.printf("Noch %d Zeugnis(se) im System.%n", zeugnisse.size());
        } else {
            System.out.println("Löschen abgebrochen.");
        }
    }


    public static void alleAnzeigen() {
        if (zeugnisse.isEmpty()) {
            System.out.println("\nKeine Zeugnisse gespeichert.");
            return;
        }

        System.out.printf("%n=== Alle Zeugnisse (%d) ===%n", zeugnisse.size());

        for (t_person p : zeugnisse) {
            p.printCertificate();
        }
    }


    private static void printListe() {
        System.out.println("─".repeat(80));
        for (int i = 0; i < zeugnisse.size(); i++) {
            System.out.printf("  [%d] %s%n", i + 1, zeugnisse.get(i));
        }
        System.out.println("─".repeat(80));
    }

    public static String holeGueltigesDatum() {
        while (true) {
            System.out.print("Geburtsdatum (DD.MM.YYYY): ");
            String eingabe = scanner.nextLine().trim();

            if (!eingabe.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                System.out.println("Fehler: Bitte im Format DD.MM.YYYY eingeben (z.B. 15.03.2010).");
                continue;
            }

            String[] parts = eingabe.split("\\.");
            int day   = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year  = Integer.parseInt(parts[2]);

            if (month < 1 || month > 12) {
                System.out.println("Fehler: Monat muss zwischen 01 und 12 liegen.");
                continue;
            }

            int[] maxDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (day < 1 || day > maxDays[month - 1]) {
                System.out.println("Fehler: Tag " + day + " ist ungültig für Monat " + month + ".");
                continue;
            }

            if (month == 2 && day == 29) {
                boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                if (!leap) {
                    System.out.println("Fehler: " + year + " ist kein Schaltjahr – Februar hat nur 28 Tage.");
                    continue;
                }
            }

            if (year < 1900 || year > 2100) {
                System.out.println("Fehler: Jahr muss zwischen 1900 und 2100 liegen.");
                continue;
            }

            return eingabe;
        }
    }


    public static int holeGueltigeNote(String fach) {
        int note   = 0;
        boolean ok = false;

        while (!ok) {
            System.out.print("Note für " + fach + " (1–6): ");
            try {
                String eingabe = scanner.nextLine().trim();
                note = Integer.parseInt(eingabe);

                if (note >= 1 && note <= 6) {
                    ok = true;
                } else {
                    System.out.println("Fehler: Die Note muss zwischen 1 und 6 liegen!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Fehler: Bitte eine gültige Zahl eingeben!");
            }
        }
        return note;
    }
}