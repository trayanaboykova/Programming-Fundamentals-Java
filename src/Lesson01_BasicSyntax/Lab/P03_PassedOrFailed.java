package Lesson01_BasicSyntax.Lab;

import java.util.Scanner;

public class P03_PassedOrFailed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        if (grade >= 3.00) {
            System.out.print("Passed!");
        }else {
            System.out.print("Failed!");
        }
    }
}
