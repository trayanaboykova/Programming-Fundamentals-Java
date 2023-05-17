package Course09_RegularExpressions.MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<nonDigits>\\D+)(?<digits>\\d+)");

        String input = scanner.nextLine().toUpperCase().trim();

        Matcher matcher = pattern.matcher(input);
        StringBuilder message = new StringBuilder();

        while (matcher.find()) {

            for (int i = 0; i < Integer.parseInt(matcher.group("digits")); i++) {
                message.append(matcher.group("nonDigits"));
            }
        }

        System.out.printf("Unique symbols used: %d\n", message.chars().distinct().count());
        System.out.println(message);
    }
}

