package Module02_Fundamentals.Course02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class P01_ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meters = Integer.parseInt(scanner.nextLine());
        double kilometers = meters / 1000.00;
        System.out.printf("%.2f", kilometers);
    }
}
