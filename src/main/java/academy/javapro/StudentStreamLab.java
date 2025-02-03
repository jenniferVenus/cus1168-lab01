package academy.javapro;

import java.util.*;
import java.util.stream.*;

public class StudentStreamLab {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.5, "Junior"),
                new Student("Bob", 3.8, "Senior"),
                new Student("Charlie", 2.9, "Sophomore"),
                new Student("David", 3.1, "Freshman"),
                new Student("Eve", 3.9, "Junior")
        );

        // TODO - Filtering: Students with GPA > 3.0

        double gpaFilter = 3.0;

        List<Student> gpaFilteredStudents = students.stream()
        .filter(s -> s.getGpa() > gpaFilter)
        .collect(Collectors.toList());
        
        // TODO - Mapping: Extract names of students with GPA > 3.0

        List<String> filteredStudentNames = gpaFilteredStudents.stream()
        .map(s -> s.getName())
        .collect(Collectors.toList());
        
        // TODO - Reducing: Calculate the average GPA of all students

        OptionalDouble averageGPA = students.stream()
        .mapToDouble(s -> s.getGpa())
        .average();

        // TODO Collecting: Collect all "Junior" students into a list


        List<Student> juniorStudents = students.stream()
        .filter(s -> s.getCollegeYear().equals("Junior"))
        .collect(Collectors.toList());

        System.out.println("Students with GPA > 3.0:" + gpaFilteredStudents);
        System.out.println("High GPA student names: " + filteredStudentNames);
        System.out.println("Average GPA: " + averageGPA.orElse(0));
        System.out.println("Juniors: " + juniorStudents);
    }
}
