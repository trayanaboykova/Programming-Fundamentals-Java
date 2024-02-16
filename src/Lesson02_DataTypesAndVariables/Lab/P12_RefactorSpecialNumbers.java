package Lesson02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class P12_RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int currentSum = i;
            int sum = 0;
            while (currentSum > 0) {
                sum = sum + (currentSum % 10);
                currentSum = currentSum / 10;
            }
            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True%n", i);
            }else{
                System.out.printf("%d -> False%n", i);
            }

        }

    }
}
