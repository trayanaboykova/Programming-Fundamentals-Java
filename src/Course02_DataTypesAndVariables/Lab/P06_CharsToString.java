package Course02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class P06_CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        char thirdChar = scanner.nextLine().charAt(0);
        String string = String.valueOf(firstChar) + secondChar + thirdChar;
        System.out.println(string);
    }
}
