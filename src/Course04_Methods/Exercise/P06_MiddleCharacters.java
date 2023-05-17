package Module02_Fundamentals.Course04_Methods.Exercise;

import java.util.Scanner;

public class P06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        printMiddleCharacters(input);
    }

    private static void printMiddleCharacters(String text) {
        if (text.length() % 2 == 1) {
            int indexOfMiddleCharacter = text.length() / 2;
            System.out.println(text.charAt(indexOfMiddleCharacter));
        }
        else {
            int indexFirstMiddleCharacter = text.length() / 2 - 1;
            int indexSecondMiddleCharacter = text.length() / 2;

            System.out.println("" + text.charAt(indexFirstMiddleCharacter) + text.charAt(indexSecondMiddleCharacter));
        }
    }
}


