// Student.java
// Mirza Zukic
// November 4, 2026
// Represents a student with a name and age.

package edu.fscj.cop3330c;

//stores the student's age and their name.
public class Student {
    private String name;
    private Integer age;

    //initailizes the information of the student.
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //this returns all of the students information as a string.
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }

    //returns the age of the student.
    public Integer getAge() {
        return age;
    }

    //returns the name of the student.
    public String getName() {
        return name;
    }
}