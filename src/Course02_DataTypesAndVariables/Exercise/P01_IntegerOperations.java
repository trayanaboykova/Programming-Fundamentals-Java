package Module02_Fundamentals.Course02_DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P01_IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int fourthNumber = Integer.parseInt(scanner.nextLine());
        //Add first to the second,
        // divide (integer) the sum by the third number,
        // and multiply the result by the fourth number.
        // Print the result.
        int sum = firstNumber + secondNumber;
        int divide = sum / thirdNumber;
        int multiply = divide *fourthNumber;
        System.out.println(multiply);
    }
}
