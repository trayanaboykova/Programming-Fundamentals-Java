package Module02_Fundamentals.Course04_Methods.Exercise;

import java.util.Scanner;

public class P05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int sumOfNumbers = sum(firstNumber, secondNumber);
        int subtractOfNumbers = subtract(sumOfNumbers, thirdNumber);

        System.out.println(subtractOfNumbers);
    }


    public static int sum(int n1, int n2) {
        return n1 + n2;
    }


    public static int subtract(int n1, int n2) {
        return n1 - n2;
    }
}

