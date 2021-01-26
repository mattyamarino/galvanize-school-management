package model;

import java.util.List;
import java.util.Objects;

public class Course {
    private Instructor instructor;
    private List<Student> students;

    public Course(Instructor instructor, List<Student> students) {
        this.instructor = instructor;
        this.students = students;
    }

    public Course() {
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
