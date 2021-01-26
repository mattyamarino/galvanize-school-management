package model;


import java.util.ArrayList;
import java.util.List;

public class School {

    List<Instructor> instructors = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Course> courses = new ArrayList<>();

    public Instructor addInstructor(Instructor instructor) {
        instructors.add(instructor);
        return instructor;
    }

    public List<Instructor> terminateInstructor(Instructor instructorToTerminate) {
        instructors.remove(instructorToTerminate);
        return instructors;
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> removeStudent(Student studentToRemove) {
        students.remove(studentToRemove);
        return students;
    }

    public Course addCourse(Course courseToAdd) {
        courses.add(courseToAdd);
        return courseToAdd;
    }

    public List<Course> removeCourse(Course courseToRemove) {
        courses.remove(courseToRemove);
        return courses;
    }
}
