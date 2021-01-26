package model;

import java.util.List;
import java.util.Objects;

public class Course {
    private String name;
    private Instructor instructor;
    private List<Student> students;

    public Course(String name, Instructor instructor, List<Student> students) {
        this.name = name;
        this.instructor = instructor;
        this.students = students;
    }

    public Course() {
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(instructor, course.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructor);
    }
}
