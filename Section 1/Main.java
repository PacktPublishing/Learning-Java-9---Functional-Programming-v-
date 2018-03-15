package Product3.GenericDataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {
        Student student1 = new Student("Joe", "Bloggs", 21, "joe.bloggs@gmail.com");
        Student student2 = new Student("Janice", "Bloggs", 23, "janice.bloggs@gmail.com");
        Student student3 = new Student("Tom", "Hanks", 45, "tom.hanks@gmail.com");
        Student student4 = new Student("George", "Clooney", 55, "george.clooney@gmail.com");

        Grade grade1 = new Grade(1, "D");
        Grade grade2 = new Grade(3, "C");
        Grade grade3 = new Grade(6, "B");
        Grade grade4 = new Grade(9, "A");


        TrainingCourse learningJava9 = new TrainingCourse("Learning Java 9");
        learningJava9.addStudent(student1, grade1);
        learningJava9.addStudent(student2, grade2);
        learningJava9.addStudent(student3, grade3);
        learningJava9.addStudent(student4, grade4);

        System.out.println("These are the students enrolled in the " + learningJava9.getCourseName() + " course");
        System.out.println(learningJava9.getListOfStudents().stream()
            .map(student -> student.getFirstName() + " " + student.getLastName())
            .collect(Collectors.toList()));

        System.out.println("The best grade is " + learningJava9.getMaxGrade());
        System.out.println("The average grade is " + learningJava9.getAverageGrade());

        //Create another training course
        TrainingCourse handsOnPython3 = new TrainingCourse("Hands on Python 3");
        handsOnPython3.addStudent(student1, grade1);
        handsOnPython3.addStudent(student2, grade2);
        handsOnPython3.addStudent(student3, grade3);
        handsOnPython3.addStudent(student4, grade4);

        //Create a map of instructor to training course
        Map<String, TrainingCourse> instructorCourseMap = new HashMap<>();
        instructorCourseMap.put("James Cross", learningJava9);
        instructorCourseMap.put("Andrei Ruse", handsOnPython3);
        instructorCourseMap.put("Andrei Ruse", handsOnPython3);

        //Convert map keys to a unique set
        Set<String> instructors = instructorCourseMap.keySet();

        System.out.println("Printing course instructors");

        //Print out the instructors - note Andrei will only appear once
        instructors.stream().forEach(instructor -> System.out.println(instructor));
    }
}
