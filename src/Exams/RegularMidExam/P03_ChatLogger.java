package Module02_Fundamentals.Exams.RegularMidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P03_ChatLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> chat = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] words = input.split("\\s+");
            String command = words[0];

            switch (command) {
                case "Chat":
                    chat.add(words[1]);
                    break;
                case "Delete":
                    chat.remove(words[1]);
                    break;
                case "Edit":
                    int index = chat.indexOf(words[1]);
                    if (index >= 0) {
                        chat.set(index, words[2]);
                    }
                    break;
                case "Pin":
                    int pinIndex = chat.indexOf(words[1]);
                    if (pinIndex >= 0) {
                        String message = chat.remove(pinIndex);
                        chat.add(message);
                    }
                    break;
                case "Spam":
                    chat.addAll(Arrays.asList(words).subList(1, words.length));
                    break;
            }

            input = scanner.nextLine();
        }

        for (String message : chat) {
            System.out.println(message);
        }
    }
}

