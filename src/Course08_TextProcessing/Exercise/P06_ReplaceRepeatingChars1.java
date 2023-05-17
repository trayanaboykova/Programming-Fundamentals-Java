package Course08_TextProcessing.Exercise;

import java.util.Scanner;

public class P06_ReplaceRepeatingChars1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String result = "";

        char firstOccurrence = input.charAt(0);
        result += firstOccurrence;

        for (int i = 1; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol != firstOccurrence) {
                result += currentSymbol;
                firstOccurrence = currentSymbol;
            }

        }

        System.out.println(result);
    }
}
