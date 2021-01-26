package model;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SchoolTest{
    School school;

    @Before
    public void setup() {
        school = new School();
    }

    @Test
    public void addInstructor_addsInstructorToSchool() {
        Instructor instructor = new Instructor();
        Instructor result = school.addInstructor(instructor);
        assertEquals(instructor, result);
        assertEquals(instructor, school.instructors.get(0));
    }

    @Test
    public void terminateInstructor_removesInstructorFromList_andReturnsList(){
        Instructor instructor1 = new Instructor();
        Instructor instructor2 = new Instructor();
        school.instructors.add(instructor1);
        school.instructors.add(instructor2);
        List<Instructor> expected = Collections.singletonList(instructor2);
        List<Instructor> result = school.terminateInstructor(instructor1);
        assertEquals(expected, result);
    }

    @Test
    public void addStudent_addsStudentToSchool() {
        Student student = new Student();
        Student result = school.addStudent(student);
        assertEquals(student, result);
        assertEquals(student, school.students.get(0));
    }

    @Test
    public void removeStudent_removesStudentFromList_andReturnsList() {
        Student student1 = new Student();
        Student student2 = new Student();
        school.students.add(student1);
        school.students.add(student2);
        List<Student> expected = Collections.singletonList(student1);
        List<Student> result = school.removeStudent(student2);
        assertEquals(expected, result);
    }

    @Test
    public void addCourse_addsCourseToSchool() {
        Course course = new Course();
        Course result = school.addCourse(course);
        assertEquals(course, result);
        assertEquals(course, school.courses.get(0));
    }

    @Test
    public void removeCourse_removesCourseFromList_andReturnsList() {
        Course course1 = new Course();
        Course course2 = new Course();
        school.courses.add(course1);
        school.courses.add(course2);
        List<Course> expected = Collections.singletonList(course1);
        List<Course> result = school.removeCourse(course2);
        assertEquals(expected, result);
    }

    @Test
    public void generateCourse_addsFieldsToCourse_andCallsAddCourse() {
        Instructor instructor = new Instructor();
        Student student1 = new Student();
        Student student2 = new Student();
        List<Student> students = Arrays.asList(student1, student2);
        Course result = school.generateCourse("mockCourse", instructor, students);
        Course expected = new Course("mockCourse", instructor, students);
        assertEquals(expected, result);
    }

    @Test
    public void getCoursesForInstructor_returnsListOfCoursesInstructorTeaches() {
        Instructor instructor1 = new Instructor(1);
        Instructor instructor2 = new Instructor(2);
        List<Student> students = new ArrayList<>();
        Course course1 = school.generateCourse("mockCourse1", instructor1, students);
        Course course2 = school.generateCourse("mockCourse2", instructor1, students);
        school.generateCourse("mockCourse3", instructor2, students);
        List<Course> expected = Arrays.asList(course1, course2);
        List<Course> result = school.getCoursesForInstructor(1);
        assertEquals(expected, result);
    }

    @Test
    public void getsStudentsForCourse_returnsEmptyList_ifNoStudentsInCourse() {
        Instructor instructor1 = new Instructor(1);
        List<Student> students = new ArrayList<>();
        Course course1 = school.generateCourse("mockCourse", instructor1, students);
        school.courses.add(course1);
        List<Student> expected = new ArrayList<>();
        List<Student> result = school.getStudentsForCourse("mockCourse");
        assertEquals(expected, result);
    }

    @Test
    public void getsStudentsForCourse_returnsListOfStudentsInCourse() {
        Instructor instructor1 = new Instructor(1);
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        students.add(student);
        Course course1 = school.generateCourse("mockCourse", instructor1, students);
        school.courses.add(course1);
        List<Student> expected = Collections.singletonList(student);
        List<Student> result = school.getStudentsForCourse("mockCourse");
        assertEquals(expected, result);
    }

    @Test
    public void getCoursesForStudent_returnsListOfCoursesForWhichSelectedStudentIsEnrolled() {
        Instructor instructor1 = new Instructor(1);
        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        Student student1 =  new Student(1);
        students1.add(student1);
        Student student2 =  new Student(2);
        students2.add(student2);
        Course course1 = school.generateCourse("mockCourse1", instructor1, students1);
        school.generateCourse("mockCourse2", instructor1, students2);
        Course course3 = school.generateCourse("mockCourse3", instructor1, students1);
        List<Course> expected = Arrays.asList(course1, course3);
        List<Course> result = school.getCoursesForStudent(1);
        assertEquals(expected, result);
    }

    @Test
    public void removeOverCommitedStudents_removesStudentsEnrolledInFiveOrMoreCoursesFromList() {
        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        List<Student> students3 = new ArrayList<>();
        Student student1 =  new Student(1);
        Student student2 =  new Student(2);
        students1.add(student1);
        students2.add(student2);
        students3.add(student1);
        students3.add(student2);
        Instructor instructor1 = new Instructor(1);
        school.generateCourse("mockCourse1", instructor1, students1);
        school.generateCourse("mockCourse2", instructor1, students1);
        school.generateCourse("mockCourse3", instructor1, students1);
        school.generateCourse("mockCourse4", instructor1, students1);
        school.generateCourse("mockCourse5", instructor1, students1);
        school.generateCourse("mockCourse6", instructor1, students2);

        List<Student> expected = Collections.singletonList(student2);
        List<Student> result = school.removeOverCommitedStudents(students3);
        assertEquals(expected, result);
    }


}