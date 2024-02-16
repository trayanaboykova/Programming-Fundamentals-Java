package Lesson02_DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class P03_FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber = Double.parseDouble(scanner.nextLine());
        double secondNumber = Double.parseDouble(scanner.nextLine());
        double eps = 0.000001;
        boolean isEqual = Math.abs(firstNumber - secondNumber) < eps;

        if (isEqual) {
            System.out.println("True");

        } else {
            System.out.println("False");

        }
    }
}
