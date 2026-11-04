// StudentDirectory.java
// Mirza Zukic
// November 4, 2026
// Manages a student directory using the Iterator pattern and Optional.

package edu.fscj.cop3330c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

//Creates a directory that supports the iteration over the list of students.
public class StudentDirectory implements Iterable<Student> {
    private List<Student> students;

    public StudentDirectory() {
        this.students = new ArrayList<>();
    }

    //adds three students into the directory
    public static void main(String[] args) {
        StudentDirectory directory = new StudentDirectory();

        directory.addStudent(new Student("Alice", 20));
        directory.addStudent(new Student("Bob", 22));
        directory.addStudent(new Student("Charlie", 19));

        System.out.println("Student List:");
        for (Student student : directory) {
            System.out.println(student);
        }

        //finds and stores bob in the optional
        String searchName = "Bob";
        Optional<Student> studentOpt =
                directory.findStudentByName(searchName);

        //displays either a match for the student or a message saying not found
        studentOpt.ifPresentOrElse(
                student -> System.out.println("Found student: " + student),
                () -> System.out.println("Student with name " +
                        searchName + " not found.")
        );

        // Searches for David, they are not in the directory.
        String nonExistingName = "David";
        Optional<Student> nonExistingStudentOpt =
                directory.findStudentByName(nonExistingName);

        //Uses optional to handle the information of the missing student.
        nonExistingStudentOpt.ifPresentOrElse(
                student -> System.out.println("Found student: " + student),
                () -> System.out.println("Student with name " +
                        nonExistingName + " not found.")
        );
    }

    //this is an iterator for the list of students
    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    //conducts a search for the student without the same capitlization.
    public Optional<Student> findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }
}