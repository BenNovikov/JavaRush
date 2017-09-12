package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double grade) {
        for (Student s : students)
            if (s.getAverageGrade() == grade)
                return s;
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxGrade = 0.0;
        Student maxGradeStudent = null;
        for (Student s : students)
            if (s.getAverageGrade() > maxGrade) {
                maxGrade = s.getAverageGrade();
                maxGradeStudent = s;
            }
        return maxGradeStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        double minGrade = 100.0;
        Student minGradeStudent = null;
        for (Student s : students)
            if (s.getAverageGrade() < minGrade) {
                minGrade = s.getAverageGrade();
                minGradeStudent = s;
            }
        return minGradeStudent;
    }

    public void expel(Student student) {
        if (student != null)
            students.remove(student);
    }
}