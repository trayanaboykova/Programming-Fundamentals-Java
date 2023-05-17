package Module02_Fundamentals.Course02_DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P04_SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int countSymbols = Integer.parseInt(scanner.nextLine());
        for (int symbol = 1; symbol <= countSymbols; symbol++) {
            sum += scanner.nextLine().charAt(0);
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
