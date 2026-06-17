# 📋 Schulzeugnis-Generator - Java Console Application

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

The **Schulzeugnis-Generator** is a Java console application for creating, managing, and printing school certificates (Schulzeugnisse). Users can add students with their grades interactively, then view, delete, or print all certificates using a simple menu.

### 📈 Program Functionality

1. **Neues Zeugnis erstellen (1)** – Enter student info and grades, certificate is printed immediately
2. **Zeugnis löschen (2)** – Remove a certificate by number with confirmation prompt
3. **Alle Zeugnisse anzeigen (3)** – Print every saved certificate in full format
4. **App beenden (4)** – Exit the application

### 📝 Data Management

| Field          | Type     | Description                              |
|----------------|----------|------------------------------------------|
| **nachname**   | String   | Student's family name                    |
| **vorname**    | String   | Student's first name                     |
| **geburtsdatum** | String | Date of birth in `DD.MM.YYYY` format     |
| **englisch**   | int      | Grade for English (1–6)                  |
| **mathematik** | int      | Grade for Mathematics (1–6)              |
| **deutsch**    | int      | Grade for German (1–6)                   |
| **physik**     | int      | Grade for Physics (1–6)                  |
| **chemie**     | int      | Grade for Chemistry (1–6)                |
| **zeugnisse**  | LinkedList\<t_person\> | Runtime storage for all students |

---

## 🛠️ Development Environment

### Software & Tools Used

| Tool / Software      | Version    | Purpose                                    |
|----------------------|------------|--------------------------------------------|
| **IntelliJ IDEA**    | 2025+      | Integrated Development Environment (IDE)  |
| **Java JDK**         | 8, 11, 17, 21+ | Programming language & compiler        |
| **Terminal/Console** | Windows/Linux/macOS | Program execution                 |

### 💻 Operating System

- ✅ **Windows** 10/11
- ✅ **macOS** 10.13+
- ✅ **Linux** (Ubuntu, Debian, CentOS, etc.)

### 📦 Dependencies

- **No external dependencies!** Uses only the Java Standard Library
- `java.util.Scanner` – Reading user input
- `java.util.LinkedList` – Runtime storage of all certificates
- Works with **Java 8 and newer**

---

## 📥 Installation & Setup

### Prerequisites

- **Java JDK 8+** installed ([Download](https://www.oracle.com/java/technologies/downloads/))
- **IDE** (IntelliJ IDEA, Eclipse, VS Code) or **Terminal/Command Prompt**

### Step 1: Set up project structure

```bash
mkdir SchulzeugnisGenerator
cd SchulzeugnisGenerator
```

### Step 2: Prepare Java files

```
SchulzeugnisGenerator/
└── src/
    ├── t_person.java
    └── Main.java
```

### Step 3: Compile the program

**In IntelliJ IDEA:**
```
Build → Build Project
```

**In Terminal:**
```bash
javac t_person.java Main.java
```

### Step 4: Run the program

**In IntelliJ IDEA:**
```
Right-click on main() → Run 'Main.main()'
or Shortcut: Shift+F10 (Windows) / Ctrl+R (macOS)
```

**In Terminal:**
```bash
java Main
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
  │  ├─ 1: add()          – Collect student data & grades → save → print certificate
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
Note für Englisch (1–6): 2
Note für Mathematik (1–6): 1
Note für Deutsch (1–6): 3
Note für Physik (1–6): 2
Note für Chemie (1–6): 1

=== Zeugnis erfolgreich gespeichert! ===

-----------------------------------
------------SCHULZEUGNIS-----------
-----------------------------------
  Name:          Max Muster
  Geburtsdatum:  15.03.2010
-----------------------------------
FÄCHER & NOTEN
───────────────────────────────────
* Englisch              Note: 2
* Mathematik            Note: 1
* Deutsch               Note: 3
* Physik                Note: 2
* Chemie                Note: 1
───────────────────────────────────
Notendurchschnitt: 1.80
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
    private String nachname;
    private String vorname;
    private String geburtsdatum;
    private int englisch, mathematik, deutsch, physik, chemie;

    // Getters & Setters for all fields

    public double getSchnitt()       { ... } // Average of all 5 grades
    public void printCertificate()   { ... } // Prints the full formatted Zeugnis

    @Override
    public String toString()         { ... } // One-line summary for list view
}
```

#### **Main.java** – Entry point and user interface

```java
public class Main {
    public static Scanner scanner          = new Scanner(System.in);
    public static LinkedList<t_person> zeugnisse = new LinkedList<>();

    public static void main(String[] args)     { ... } // Entry point & menu loop
    public static void printWelcome()          { ... } // Welcome banner
    public static void printGoodbye()          { ... } // Exit message
    public static int  printMenu()             { ... } // Display & read menu option (1–4)
    public static void add()                   { ... } // Collect data, save, print certificate
    public static void delete()                { ... } // Show list, confirm, remove
    public static void alleAnzeigen()          { ... } // Print all certificates
    public static void printListe()            { ... } // Numbered summary list (used by delete)
    public static String holeGueltigesDatum()  { ... } // Validated DD.MM.YYYY date input
    public static int holeGueltigeNote()       { ... } // Validated grade input (1–6)
}
```

---

### 🔍 Code Analysis – t_person.java

| Code Element         | Explanation                                        | Type     |
|----------------------|----------------------------------------------------|----------|
| `nachname`           | Student's family name                              | Variable |
| `vorname`            | Student's first name                               | Variable |
| `geburtsdatum`       | Date of birth (`DD.MM.YYYY`)                       | Variable |
| `englisch` … `chemie`| Individual subject grades (1–6)                   | Variable |
| `getSchnitt()`       | Returns average of all 5 grades as `double`        | Method   |
| `printCertificate()` | Prints the full formatted certificate to console   | Method   |
| `toString()`         | One-line summary used in the numbered list view    | Override |

### 🔍 Code Analysis – Main.java

| Method                  | Description                                                                 |
|-------------------------|-----------------------------------------------------------------------------|
| `main()`                | Entry point: calls `printWelcome()`, then runs `while(running)` menu loop  |
| `printMenu()`           | Prints option block, reads one line, validates range 1–4, returns choice   |
| `add()`                 | Reads name, date, and 5 grades → saves `t_person` to list → prints certificate |
| `delete()`              | Lists all students, asks for index, confirms with j/n, removes from list   |
| `alleAnzeigen()`        | Iterates the `LinkedList` and calls `printCertificate()` on each entry     |
| `printListe()`          | Prints a numbered one-line summary of all students (used inside `delete()`) |
| `holeGueltigesDatum()`  | Loops until a valid `DD.MM.YYYY` date is entered (regex + range checks)    |
| `holeGueltigeNote()`    | Loops until an integer between 1 and 6 is entered                          |

---

### 🎯 Key Concepts in the Code

#### 1. `LinkedList<t_person>` – Runtime Storage

```java
public static LinkedList<t_person> zeugnisse = new LinkedList<>();
```

A `LinkedList` is used instead of `ArrayList` because certificates are frequently added and removed — `LinkedList` provides O(1) insertion and deletion at both ends with no array resizing overhead.

#### 2. Date Validation – Format + Calendar Checks

```java
if (!eingabe.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
    System.out.println("Fehler: Bitte im Format DD.MM.YYYY eingeben.");
    continue;
}
```

The regex enforces exactly `DD.MM.YYYY` before any calendar checks run. Then month range, max days per month, and leap year are all verified separately.

#### 3. Grade Average – `getSchnitt()`

```java
public double getSchnitt() {
    return (englisch + mathematik + deutsch + physik + chemie) / 5.0;
}
```

Dividing by `5.0` (not `5`) forces floating-point division so the average is always a decimal value.

#### 4. `nextLine()` + `parseInt()` – No Scanner Buffer Bug

```java
String line = scanner.nextLine().trim();
option = Integer.parseInt(line);
```

`nextInt()` leaves `\n` in the buffer, causing the next `nextLine()` to return an empty string. Using `nextLine()` + `parseInt()` everywhere eliminates this entirely.

---

## 🧪 Testing & Validation

| # | Input                          | Expected Output                              | Status |
|---|--------------------------------|----------------------------------------------|--------|
| 1 | Add student "Max Muster"       | Certificate printed with all grades          | ✅     |
| 2 | Add second student             | Both stored in list                          | ✅     |
| 3 | Alle Zeugnisse anzeigen        | Both certificates printed in full            | ✅     |
| 4 | Delete student 1, confirm "j"  | Student removed, count decremented           | ✅     |
| 5 | Delete, confirm "n"            | `Löschen abgebrochen.`                       | ✅     |
| 6 | Delete on empty list           | `Keine Zeugnisse gespeichert`                | ✅     |
| 7 | Date `abc`                     | `Fehler: Bitte im Format DD.MM.YYYY eingeben`| ✅     |
| 8 | Date `32.01.2010`              | `Fehler: Tag 32 ist ungültig für Monat 1`    | ✅     |
| 9 | Date `29.02.2023`              | `Fehler: 2023 ist kein Schaltjahr`           | ✅     |
| 10 | Date `29.02.2024`             | ✅ Accepted (2024 is a leap year)             | ✅     |
| 11 | Grade `7`                     | `Fehler: Die Note muss zwischen 1 und 6 liegen` | ✅  |
| 12 | Grade `abc`                   | `Fehler: Bitte eine gültige Zahl eingeben`   | ✅     |
| 13 | Menu option `5`               | `Fehler: Nummer muss zwischen 1 und 4 liegen`| ✅     |
| 14 | Menu option `abc`             | `Fehler: Nummer muss zwischen 1 und 4 liegen`| ✅     |

---

## 📚 Concepts Used (School Material)

| Concept                  | Usage in Project                                              |
|--------------------------|---------------------------------------------------------------|
| **Classes & Objects**    | `t_person`, `Main`                                            |
| **Constructors**         | `t_person()` default constructor with setters                 |
| **Encapsulation**        | Private fields with getter/setter methods in `t_person`       |
| **LinkedList**           | `LinkedList<t_person>` stores all certificates at runtime     |
| **Loops (while)**        | Main menu loop, grade input loop, date input loop             |
| **Switch Statement**     | Menu option routing (cases 1–4)                               |
| **If / Try-Catch**       | Input validation, `NumberFormatException` handling            |
| **Static Methods & Fields** | All methods and state in `Main`                            |
| **String Methods**       | `matches()`, `split()`, `trim()`, `toLowerCase()`             |
| **printf / format**      | Aligned certificate output with `%-20s`, `%.2f`               |
| **Regex**                | Date format validation with `\d{2}\.\d{2}\.\d{4}`            |
| **Override**             | `toString()` in `t_person`                                    |

---

## ⚠️ Error Handling

- ✅ Invalid date format rejected — must match `DD.MM.YYYY` exactly
- ✅ Invalid calendar values caught (month 13, day 32, Feb 29 on non-leap year)
- ✅ Grade out of range (< 1 or > 6) rejected with re-prompt
- ✅ Non-numeric input for grades and menu handled via `NumberFormatException`
- ✅ Delete on empty list returns a friendly message without crashing
- ✅ Delete index out of range re-prompts the user
- ✅ Invalid menu option handled by `default` case

### Error Messages

```
Fehler: Bitte im Format DD.MM.YYYY eingeben (z.B. 15.03.2010).
Fehler: Monat muss zwischen 01 und 12 liegen.
Fehler: Tag 32 ist ungültig für Monat 1.
Fehler: 2023 ist kein Schaltjahr – Februar hat nur 28 Tage.
Fehler: Jahr muss zwischen 1900 und 2100 liegen.
Fehler: Die Note muss zwischen 1 und 6 liegen!
Fehler: Bitte eine gültige Zahl eingeben!
Fehler: Nummer muss zwischen 1 und 4 liegen.
Keine Zeugnisse gespeichert – nichts zu löschen.
Löschen abgebrochen.
```

---

## 📄 Project Structure

```
SchulzeugnisGenerator/
│
├── src/
│   ├── t_person.java     # Student data model – fields, grades, printCertificate()
│   └── Main.java         # UI & program flow – menu, add, delete, show all
│
└── README.md
```

---

## 🔧 Troubleshooting

### Compilation error `cannot find symbol`

```bash
# Make sure both files are in the same directory
javac t_person.java Main.java
java Main
```

### First `nextLine()` after menu returns empty

This is the classic Scanner `nextInt()` buffer bug — it leaves `\n` in the stream. This project uses `nextLine()` + `parseInt()` everywhere so this cannot happen.

### Certificate shows `0` for all grades

Make sure all five `setEnglisch()` / `setMathematik()` / etc. setter calls complete before `zeugnisse.add(person)` is reached. This happens automatically in `add()`.

### Date `29.02.XXXX` keeps being rejected

Only leap years accept February 29. A year is a leap year if:
- Divisible by 4 **AND** not by 100, **OR**
- Divisible by 400

Example: 2024 ✅ | 2023 ✗ | 1900 ✗ | 2000 ✅

---

## 📊 Method Complexity

| Method                  | Time Complexity | Notes                              |
|-------------------------|-----------------|------------------------------------|
| `add()`                 | O(1)            | `LinkedList.add()` appends to tail |
| `delete()`              | O(n)            | `LinkedList.remove(index)`         |
| `alleAnzeigen()`        | O(n)            | Full list traversal                |
| `getSchnitt()`          | O(1)            | Fixed 5-field sum                  |
| `holeGueltigesDatum()`  | O(1)            | Regex match + int parsing          |
| `holeGueltigeNote()`    | O(1) per attempt| Loops only on invalid input        |

---

## ✅ Usage Checklist

- [ ] Java 8+ is installed
- [ ] Both files (`t_person.java`, `Main.java`) are present in `src/`
- [ ] Compilation successful (`javac`)
- [ ] Program starts without errors
- [ ] Student can be added with valid name, date, and grades
- [ ] Certificate prints correctly after adding
- [ ] All certificates show with option 3
- [ ] Delete works with confirmation (j/n)
- [ ] Invalid dates and grades are rejected with re-prompt
- [ ] App exits cleanly with option 4

---

## 📜 License

```
School Project – JAVA Application
Not intended for commercial use
Freely available for educational purposes
```

---

**Version:** 1.0 | **Status:** ✅ Production Ready