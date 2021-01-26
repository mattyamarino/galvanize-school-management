package model;


import org.junit.Before;
import org.junit.Test;

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
        Course result = school.generateCourse(instructor, students);
        Course expected = new Course(instructor, students);
        assertEquals(expected, result);
    }
}