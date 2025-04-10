package ASM;

import java.util.Scanner;
import asm.MyList;
import asm.MyStack;

public class ASM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyList List = new MyList();
        MyStack Stack = new MyStack();
        int choice;

        do {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add student");
            System.out.println("2. Edit student");
            System.out.println("3. Delete student");
            System.out.println("4. Sort by mark (Bubble Sort)");
            System.out.println("5. Sort by mark (Quick Sort)");
            System.out.println("6. Linear search by ID");
            System.out.println("7. Binary search by ID");
            System.out.println("8. Display students");
            System.out.println("9. Push to stack and display");
            System.out.println("0. Exit");
            System.out.print("Choose function: ");

            // Try-Catch for input choice
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                choice = -1; // Set choice to an invalid value to continue the loop
                continue; // Skip to the next iteration of the loop
            }

            switch (choice) {
                case 1: {
                    boolean validInput = false;
                    while (!validInput) {
                        try {
                            System.out.print("Enter the number of students to add: ");
                            String numInput = scanner.nextLine();
                            if (!numInput.matches("\\d+")) throw new Exception("Number must contain only digits!");
                            int numberOfStudents = Integer.parseInt(numInput);
                            if (numberOfStudents < 0) throw new Exception("Number of students cannot be negative!");

                            for (int i = 0; i < numberOfStudents; i++) {
                                System.out.println("Enter information for student " + (i + 1) + ":");
                                List.addStudentFromKeyBoard();
                            }
                            validInput = true;
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage() + " Please try again.");
                        }
                    }
                    break;
                }

                // Similar try-catch structures for other cases (2 to 9)...
                // Ensure to handle exceptions for editing, deleting, and searching students.

                case 0:
                    System.out.println("Exiting program!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        scanner.close();
    }
}








