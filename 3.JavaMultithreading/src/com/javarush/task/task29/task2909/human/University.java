package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.age = age;
        this.name = name;
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

    public Student getStudentWithAverageGrade(double param) {
        Student find = null;

        for (Student student : students)
            if (student.getAverageGrade() == param)
                find = student;

        return find;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student find = null;
        double max = 0;
        for (Student student : students)
            if (student.getAverageGrade() > max) {
                max = student.getAverageGrade();
                find = student;
            }

        return find;
    }

    public Student getStudentWithMinAverageGrade() {
        Student find = null;
        double min = Double.MAX_VALUE;
        for (Student student : students)
            if (student.getAverageGrade() < min) {
                min = student.getAverageGrade();
                find = student;
            }

        return find;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}