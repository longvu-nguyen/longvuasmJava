/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package searchstudentASM2;

/**
 *
 * @author nguye
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> studentArray = new ArrayList<>();

    // Bubble Sort algorithm
    public static void bubbleSort(ArrayList<Student> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j).getMarks() > arr.get(j + 1).getMarks()) {
                    Student temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    // Quick Sort algorithm
    public static void quickSort(ArrayList<Student> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(ArrayList<Student> arr, int low, int high) {
        double pivot = arr.get(high).getMarks();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j).getMarks() <= pivot) {
                i++;
                Student temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        Student temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }

    // Linear Search algorithm
    public static Student linearSearch(ArrayList<Student> arr, int id) {
        for (Student student : arr) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of students: ");
            int n = Integer.parseInt(scanner.nextLine());
            if (n <= 0) throw new IllegalArgumentException("The number must be greater than 0");

            for (int i = 0; i < n; i++) {
                System.out.println("\nStudent " + (i + 1) + ":");
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter marks (0-10): ");
                double marks = Double.parseDouble(scanner.nextLine());

                Student student = new Student(id, name, marks);
                tree.insert(student);
                studentArray.add(student);
            }

            tree.inOrder();
            tree.preOrder();
            tree.postOrder();

            ArrayList<Student> bubbleSorted = new ArrayList<>(studentArray);
            bubbleSort(bubbleSorted);
            System.out.println("\nList after Bubble Sort:");
            for (Student s : bubbleSorted) {
                System.out.println(s);
            }

            ArrayList<Student> quickSorted = new ArrayList<>(studentArray);
            quickSort(quickSorted, 0, quickSorted.size() - 1);
            System.out.println("\nList after Quick Sort:");
            for (Student s : quickSorted) {
                System.out.println(s);
            }

            System.out.print("\nEnter student ID to search: ");
            int searchId = Integer.parseInt(scanner.nextLine());

            System.out.println("\nLinear Search (ArrayList):");
            Student linearResult = linearSearch(studentArray, searchId);
            System.out.println(linearResult != null ? linearResult : "Not found");

            System.out.println("\nSearch in BST:");
            Student bstResult = tree.searchBST(searchId);
            System.out.println(bstResult != null ? bstResult : "Not found");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}