package Vjezba;

import org.w3c.dom.ls.LSOutput;

public class Student{
    private int id;
    private String name;
    private int age;
    private int grade;

    Student(int id, String name, int age, int grade){
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    public String toString(){
        return "Student [ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade + "]";
    }
}
