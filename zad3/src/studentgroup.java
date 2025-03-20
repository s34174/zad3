import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StudentGroup {
    public String nazwa;
    private List<Student> students;
    private static final int MAX_STUDENTS = 15;

    // Konstruktor - tworzenie nowej grupy studenckiej
    public StudentGroup(String nazwa) {
        this.nazwa = nazwa;
        this.students = new ArrayList<>();
    }

    // Metoda do dodawania studenta do grupy
    public void addStudent(Student student) {
        if (students.size() >= MAX_STUDENTS) {
            throw new IllegalStateException("Grupa może mieć maksymalnie 15 studentów.");
        }
        if (students.contains(student)) {
            throw new IllegalStateException("Ten student już jest w grupie.");
        }
        students.add(student);
        System.out.println("Student " + student.fname + " " + student.lname + " został dodany do grupy :");
    }
}