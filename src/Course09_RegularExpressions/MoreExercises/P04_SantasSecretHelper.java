package Course09_RegularExpressions.MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)([^-@!:>]+)?!G!");

        int key = Integer.parseInt(scanner.nextLine());
        String input;

        while (!(input = scanner.nextLine()).equals("end")) {

            String decryptedMessage = String.valueOf(decryptMessage(input, key));
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                System.out.println(matcher.group("name"));
            }
        }
    }

    private static StringBuilder decryptMessage(String input, int key) {

        StringBuilder decryptedMessage = new StringBuilder(input);
        for (int i = 0; i < decryptedMessage.length(); i++) {
            char currentSymbol = decryptedMessage.charAt(i);
            currentSymbol -= key;
            decryptedMessage.setCharAt(i, currentSymbol);
        }

        return decryptedMessage;
    }
}

