# 📋 Schulzeugnis-Generator - Java Console Application

[![CI](https://github.com/itsmrroot/Zeugniss/actions/workflows/ci.yml/badge.svg)](https://github.com/itsmrroot/Zeugniss/actions/workflows/ci.yml)

> **Title:** Schulzeugnis-Generator mit Add, Delete und Anzeige-Funktion
> **Purpose:** A fully functional school certificate manager with interactive console UI

---

## 📋 Projektinformationen

| Feld                   | Inhalt                                                                        |
|------------------------|-------------------------------------------------------------------------------|
| **Projektname**        | Schulzeugnis-Generator                                                        |
| **Beschreibung**       | Zeugnisverwaltung mit Erstellen, Löschen und Anzeige aller Zeugnisse         |
| **Typ**                | Schulaufgabe / JAVA – Anwendung                                               |
| **Programmiersprache** | Java                                                                          |
| **Version**            | 1.0                                                                           |
| **Status**             | ✅ Produktionsreife                                                            |
| **Datum**              | 2026                                                                          |
| **Entwickler**         | Bashar Salmo                                                                  |
| **Lehrer**             | G.Jarz                                                                        |
| **Institution**        | BFI-Leoben                                                                    |

---

## 🎯 Project Description

The **Schulzeugnis-Generator** is a Java console application for creating, managing, and printing school certificates (Schulzeugnisse). Users can add students with any number of custom subjects and grades interactively, then view, delete, or print all certificates using a simple menu.

### 📈 Program Functionality

1. **Neues Zeugnis erstellen (1)** – Enter student info, then enter subjects and grades one at a time until done — certificate is printed immediately
2. **Zeugnis löschen (2)** – Remove a certificate by number with confirmation prompt
3. **Alle Zeugnisse anzeigen (3)** – Print every saved certificate in full format
4. **App beenden (4)** – Exit the application

### 📝 Data Management

| Field          | Type                        | Description                              |
|----------------|-----------------------------|-------------------------------------------|
| **nachname**   | String                      | Student's family name                    |
| **vorname**    | String                      | Student's first name                     |
| **geburtsdatum** | String                    | Date of birth in `DD.MM.YYYY` format     |
| **faecher**    | `LinkedHashMap<String, Integer>` | Subject name → grade (1–6), any number of entries, insertion order preserved |
| **zeugnisse**  | `LinkedList<t_person>`      | Runtime storage for all students          |

Subjects are entered freely — there's no fixed list. You can add "Mathematik", "Sport", "Kunst", or anything else, one at a time, until you type `fertig`.

---

## 🛠️ Development Environment

| Tool / Software      | Version    | Purpose                                    |
|----------------------|------------|--------------------------------------------|
| **IntelliJ IDEA**    | 2025+      | Integrated Development Environment (IDE)  |
| **Java JDK**         | 17+        | Programming language & compiler (uses text blocks) |
| **Maven**            | 3.x        | Build tool, dependency management         |

### 📦 Dependencies

- **No external runtime dependencies** — pure Java standard library at runtime
- JUnit 5 (test-only dependency, for the project's automated tests)

---

## 📥 Installation & Setup

### Option 1 — Download the prebuilt JAR

Grab the latest `zeugniss.jar` from the [Releases](../../releases) page and run:
```bash
java -jar zeugniss.jar
```

### Option 2 — Build from source

Requires [Maven](https://maven.apache.org/) and Java 17+.

```bash
git clone https://github.com/itsmrroot/Zeugniss.git
cd Zeugniss
mvn package
java -jar target/zeugniss.jar
```

---

## 🚀 Usage Guide

### 📘 Program Flow

```
START
  ↓
printWelcome() – Display welcome banner
  ↓
WHILE running:
  │
  ├─ printMenu() – Display menu & read selection (1–4)
  │
  ├─ SWITCH selection:
  │  ├─ 1: add()          – Collect student data, then loop entering subjects/grades → save → print certificate
  │  ├─ 2: delete()       – Show list → pick number → confirm → remove
  │  ├─ 3: alleAnzeigen() – Print all saved certificates
  │  └─ 4: printGoodbye() – Print exit message → running = false
  │
  └─ Back to menu
  ↓
ENDE
```

### 📊 Example Execution

```
========================================
  Willkommen beim Schulzeugnis-Generator!
========================================

        (1) Neues Zeugnis erstellen
        (2) Zeugnis löschen
        (3) Alle Zeugnisse anzeigen
        (4) App beenden
        Wählen Sie eine Option (1–4): 1

=== Neues Zeugnis erstellen ===
Nachname des Schülers  : Muster
Vorname des Schülers   : Max
Geburtsdatum (DD.MM.YYYY): 15.03.2010

Geben Sie nun die Fächer und Noten ein.
Fach eingeben (oder 'fertig' um zu beenden): Mathematik
Note für Mathematik (1–6): 1
Fach eingeben (oder 'fertig' um zu beenden): Sport
Note für Sport (1–6): 2
Fach eingeben (oder 'fertig' um zu beenden): fertig

=== Zeugnis erfolgreich gespeichert! ===

-----------------------------------
------------SCHULZEUGNIS-----------
-----------------------------------
  Name:          Max Muster
  Geburtsdatum:  15.03.2010
-----------------------------------
FÄCHER & NOTEN
───────────────────────────────────
* Mathematik            Note: 1
* Sport                 Note: 2
───────────────────────────────────
Notendurchschnitt: 1.50
-----------------------------------

        Wählen Sie eine Option (1–4): 4

Geschafft! Ihre Zeugnisse sind fertig.
Vielen Dank, dass Sie den Schulzeugnis-Generator genutzt haben.
Bis zum nächsten Halbjahr!
```

---

## 💻 Code Structure & Explanation

### 📂 File Overview

#### **t_person.java** – Data model for a student certificate

```java
public class t_person {
    private String nachname, vorname, geburtsdatum;
    private LinkedHashMap<String, Integer> faecher = new LinkedHashMap<>();

    public void addFach(String name, int note) { ... }
    public LinkedHashMap<String, Integer> getFaecher() { ... }
    public double getSchnitt() { ... }        // Average across all entered subjects
    public void printCertificate() { ... }    // Prints the full formatted Zeugnis
    public String toString() { ... }          // One-line summary for list view
}
```

#### **Main.java** – Entry point and user interface

```java
public class Main {
    public static void main(String[] args)     { ... } // Entry point & menu loop
    public static void add()                   { ... } // Collect student info, then call holeFaecher()
    private static void holeFaecher(t_person)  { ... } // Loop: ask for subject name + grade until 'fertig'
    public static void delete()                { ... } // Show list, confirm, remove
    public static void alleAnzeigen()          { ... } // Print all certificates
    public static String holeGueltigesDatum()  { ... } // Validated DD.MM.YYYY date input
    public static int holeGueltigeNote(String) { ... } // Validated grade input (1–6) for a named subject
}
```

---

### 🎯 Key Concepts in the Code

#### 1. `LinkedHashMap<String, Integer>` – Dynamic subject storage

```java
private LinkedHashMap<String, Integer> faecher = new LinkedHashMap<>();
```

A `Map` pairs each subject name with its grade. `LinkedHashMap` specifically (not plain `HashMap`) preserves the order subjects were entered in, so the printed certificate lists them in the order the user typed them, not an arbitrary hash order.

#### 2. Subject entry loop

```java
while (true) {
    System.out.print("Fach eingeben (oder 'fertig' um zu beenden): ");
    String fach = scanner.nextLine().trim();

    if (fach.equalsIgnoreCase("fertig")) {
        if (person.getFaecher().isEmpty()) { continue; }
        break;
    }
    // ...
}
```

Loops indefinitely, collecting subject/grade pairs, until the user types `fertig` — and refuses to finish with zero subjects entered.

#### 3. Grade Average – `getSchnitt()`

```java
public double getSchnitt() {
    if (faecher.isEmpty()) return 0.0;
    int summe = 0;
    for (int note : faecher.values()) summe += note;
    return summe / (double) faecher.size();
}
```

Averages across however many subjects were entered — not a fixed count of 5.

#### 4. Date Validation – Format + Calendar Checks

```java
if (!eingabe.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
    System.out.println("Fehler: Bitte im Format DD.MM.YYYY eingeben.");
    continue;
}
```

The regex enforces exactly `DD.MM.YYYY` before any calendar checks run. Then month range, max days per month, and leap year are all verified separately.

#### 5. `nextLine()` + `parseInt()` – No Scanner Buffer Bug

```java
String line = scanner.nextLine().trim();
option = Integer.parseInt(line);
```

`nextInt()` leaves `\n` in the buffer, causing the next `nextLine()` to return an empty string. Using `nextLine()` + `parseInt()` everywhere eliminates this entirely.

---

## ⚠️ Error Handling

- ✅ Invalid date format rejected — must match `DD.MM.YYYY` exactly
- ✅ Invalid calendar values caught (month 13, day 32, Feb 29 on non-leap year)
- ✅ Grade out of range (< 1 or > 6) rejected with re-prompt
- ✅ Empty subject name rejected with re-prompt
- ✅ Finishing subject entry with zero subjects rejected — at least one required
- ✅ Non-numeric input for grades and menu handled via `NumberFormatException`
- ✅ Delete on empty list returns a friendly message without crashing
- ✅ Delete index out of range re-prompts the user
- ✅ Invalid menu option handled by `default` case

---

## 📄 Project Structure

```
src/
├── main/java/com/company/
│   ├── Main.java       # UI & program flow – menu, add, delete, show all
│   └── t_person.java   # Student data model – dynamic subjects, printCertificate()
└── test/java/com/company/
    (tests, if/when added)
```

---

## 🔧 Troubleshooting

### First `nextLine()` after menu returns empty

This is the classic Scanner `nextInt()` buffer bug — it leaves `\n` in the stream. This project uses `nextLine()` + `parseInt()` everywhere so this cannot happen.

### Date `29.02.XXXX` keeps being rejected

Only leap years accept February 29. A year is a leap year if:
- Divisible by 4 **AND** not by 100, **OR**
- Divisible by 400

Example: 2024 ✅ | 2023 ✗ | 1900 ✗ | 2000 ✅

### "Fehler: Bitte geben Sie mindestens ein Fach ein."

You typed `fertig` before entering any subjects. Enter at least one subject/grade pair first.

---

## 📚 Concepts Used (School Material)

| Concept                  | Usage in Project                                              |
|--------------------------|-----------------------------------------------------------------|
| **Classes & Objects**    | `t_person`, `Main`                                            |
| **Encapsulation**        | Private fields with getter/setter methods in `t_person`       |
| **Collections**          | `LinkedList<t_person>`, `LinkedHashMap<String, Integer>`      |
| **Loops (while)**        | Main menu loop, subject-entry loop, date input loop            |
| **Switch Statement**     | Menu option routing (cases 1–4)                               |
| **If / Try-Catch**       | Input validation, `NumberFormatException` handling            |
| **String Methods**       | `matches()`, `split()`, `trim()`, `equalsIgnoreCase()`         |
| **printf / format**      | Aligned certificate output with `%-20s`, `%.2f`               |
| **Regex**                | Date format validation with `\d{2}\.\d{2}\.\d{4}`             |
| **Override**             | `toString()` in `t_person`                                    |

---

## ✅ Usage Checklist

- [ ] Java 17+ and Maven are installed
- [ ] `mvn package` builds successfully
- [ ] Program starts without errors
- [ ] Student can be added with valid name, date, and any number of subjects
- [ ] Certificate prints correctly after adding, with all entered subjects
- [ ] All certificates show with option 3
- [ ] Delete works with confirmation (j/n)
- [ ] Invalid dates and grades are rejected with re-prompt
- [ ] App exits cleanly with option 4

---

## 📜 License

MIT — see [LICENSE](LICENSE).

---

**Version:** 1.0 | **Status:** ✅ Production Ready
