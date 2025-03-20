import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Student {
    public String fname;
    public String lname;
    public String indexNumber;
    public String email;
    public String address;
    public List<Double> grades;
    // Konstruktor - pobiera dane studenta od użytkownika przez Scannergit
    public Student(Scanner scanner) {
        System.out.println("Podaj imię studenta:");
        this.fname = scanner.nextLine();
        System.out.println("Podaj nazwisko studenta:");
        this.lname = scanner.nextLine();
        System.out.println("Podaj numer indeksu:");
        this.indexNumber = scanner.nextLine();
        System.out.println("Podaj email:");
        this.email = scanner.nextLine();
        System.out.println("Podaj adres:");
        this.address = scanner.nextLine();
        this.grades = new ArrayList<>();
    }
    // Metoda do dodawania ocen z Scannerem
    public void addGrade(Scanner scanner) {
        while (true) {
            System.out.println("Podaj ocenę studenta (lub wpisz 'q' aby zakończyć):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            try {
                double grade = Double.parseDouble(input);
                if (grades.size() >= 20) {
                    throw new IllegalStateException("Student może mieć maksymalnie 20 ocen.");
                }
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowa wartość. Wprowadź liczbę.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
    // Metoda do obliczania średniej oceny
    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            throw new IllegalArgumentException("Student nie ma żadnych ocen.");
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();
        // Zaokrąglenie do najbliższej wartości z listy [2, 2.5, 3, 3.5, 4, 4.5, 5]
        double[] possibleGrades = {2, 2.5, 3, 3.5, 4, 4.5, 5};
        double closest = possibleGrades[0];
        for (double value : possibleGrades) {
            if (Math.abs(value - average) < Math.abs(closest - average)) {
                closest = value;
            }
        }
        return closest;
    }
    // Metoda do wyświetlania informacji o studencie
    public void printStudentInfo() {
        System.out.println("\nDane studenta:");
        System.out.println("Imię: " + fname);
        System.out.println("Nazwisko: " + lname);
        System.out.println("Indeks: " + indexNumber);
        System.out.println("Email: " + email);
        System.out.println("Adres: " + address);
        System.out.println("Oceny: " + grades);
        if (!grades.isEmpty()) {
            System.out.println("Średnia ocena (zaokrąglona): " + calculateAverageGrade());
        } else {
            System.out.println("Brak ocen.");
        }
    }
    // Metoda testowa (main)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student(scanner); // Tworzenie studenta przez Scanner
        student.addGrade(scanner); // Dodawanie ocen
        student.printStudentInfo(); // Wyświetlenie danych
        scanner.close();
    }
}
