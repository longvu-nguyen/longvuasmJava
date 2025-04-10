/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package searchstudentASM2;

/**
 *
 * @author nguye
 */
public class Search {
    public class LinearSearch {

    public static Student linearSearch(Student[] students, int targetId) {
        for (Student student : students) {
            if (student.id == targetId) {
                return student; // Trả về sinh viên nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
}
}
