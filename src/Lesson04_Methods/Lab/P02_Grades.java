package Lesson04_Methods.Lab;

import java.util.Scanner;

public class P02_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        printGrade(grade);

    }

    public static void printGrade(double number) {
        if (number >= 2.00 && number <= 2.99) {
            System.out.print("Fail");
        } else if (number >= 3.00 && number <= 3.49) {
            System.out.print("Poor");
        } else if (number >= 3.50 && number <= 4.49) {
            System.out.print("Good");
        } else if (number >= 4.50 && number <= 5.49) {
            System.out.print("Very good");
        } else if (number >= 5.50 && number <= 6.00) {
            System.out.print("Excellent");
        }
    }
}
