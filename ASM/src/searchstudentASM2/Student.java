/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package searchstudentASM2;

public class Student {
    int id;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public double getMarks() {
        return marks;
    }

    public String getRank() {
        if (marks >= 0 && marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Average";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else if (marks <= 10.0) return "Excellent";
        else throw new IllegalArgumentException("Marks must be between 0 and 10");
    }

    @Override
    public String toString() {
        return "Student {ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Rank: " + getRank() + "}";
    }
}