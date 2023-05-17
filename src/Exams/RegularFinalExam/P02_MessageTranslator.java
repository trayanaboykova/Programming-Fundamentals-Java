package Module02_Fundamentals.Exams.RegularFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]");

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                String command = matcher.group("command");
                String message = matcher.group("message");
                StringBuilder result = new StringBuilder(command + ":");
                for (int j = 0; j < message.length(); j++) {
                    int ascii = message.charAt(j);
                    result.append(" ").append(ascii);
                }
                System.out.println(result.toString());
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}

