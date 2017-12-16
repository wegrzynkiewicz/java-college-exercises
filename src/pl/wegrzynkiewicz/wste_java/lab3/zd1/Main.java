/*
Napisz klasę Student, która przechowuje trzy pola:
• Imię
• Nazwisko
• Numer indeksu
Następnie utwórz klasę BazaStudentow, w której wykorzystasz klasę Student do utworzenia
trzech obiektów przechowujących dane studentów, wypisz dane studentów w konsoli.
 */

package pl.wegrzynkiewicz.wste_java.lab3.zd1;

import java.util.ArrayList;
import java.util.List;

class Student {
    public String name;
    public String surname;
    public String index;

    public Student(String name, String surname, String index) {
        this.name = name;
        this.surname = surname;
        this.index = index;
    }
}

class StudentBase {
    public List<Student> students;

    public StudentBase() {
        students = new ArrayList<Student>();
        students.add(new Student("Jan", "Kowalski", "136543"));
        students.add(new Student("Anna", "Nowak", "135835"));
        students.add(new Student("John", "Dae", "133245"));
    }

    public void print() {
        for (Student student : students) {
            System.out.println("---------------------------");
            System.out.println("Name: " + student.name);
            System.out.println("Surname: " + student.surname);
            System.out.println("Index: " + student.index);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        (new StudentBase()).print();
    }
}
