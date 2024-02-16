package Lesson02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class P05_ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        String result = firstName + delimiter + secondName;
        System.out.println(result);
    }
}
