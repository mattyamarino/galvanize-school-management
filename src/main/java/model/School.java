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

    public Course generateCourse(String name, Instructor instructor, List<Student> students) {
        Course course = new Course(name, instructor, students);
        return addCourse(course);
    }

    public List<Course> getCoursesForInstructor(int instructorId) {
        List<Course> coursesForInstructor = new ArrayList<>();

        for(Course course: courses) {
            if(instructorId == course.getInstructor().getId()) {
                coursesForInstructor.add(course);
            }
        }

        return coursesForInstructor;
    }

    public List<Student> getStudentsForCourse(String mockCourse) {
        List<Student> students = new ArrayList<>();
        for(Course course: courses) {
            if(mockCourse == course.getName()) {
                students = course.getStudents();
            }
        }
        return students;
    }

    public List<Course> getCoursesForStudent(int studentId) {
        List<Course> coursesForStudent= new ArrayList<>();

        for(Course course: courses) {
            for(Student student: course.getStudents()) {
                if(studentId == student.getId()) {
                    coursesForStudent.add(course);
                }
            }
        }

        return coursesForStudent;
    }

    public List<Student> removeOverCommitedStudents(List<Student> studentsToEnroll) {
        List<Student> eligibleStudents = new ArrayList<>();

        for(Student student: studentsToEnroll) {
            int numberOfCoursesEnrolled =  getCoursesForStudent(student.getId()).size();
            if(numberOfCoursesEnrolled < 5) {
                eligibleStudents.add(student);
            }
        }
        return eligibleStudents;
    }
}
