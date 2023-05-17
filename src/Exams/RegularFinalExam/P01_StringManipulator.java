package Exams.RegularFinalExam;

import java.util.Scanner;

public class P01_StringManipulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Translate":
                    char oldChar = tokens[1].charAt(0);
                    String newString = tokens[2];
                    text = text.replace(oldChar, newString.charAt(0));
                    System.out.println(text);
                    break;
                case "Includes":
                    String substring = tokens[1];
                    boolean includes = text.contains(substring);
                    System.out.println(includes ? "True" : "False");
                    break;
                case "Start":
                    String prefix = tokens[1];
                    boolean startsWith = text.startsWith(prefix);
                    System.out.println(startsWith ? "True" : "False");
                    break;
                case "Lowercase":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    char searchChar = tokens[1].charAt(0);
                    int lastIndex = text.lastIndexOf(searchChar);
                    System.out.println(lastIndex);
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    text = text.substring(0, startIndex) + text.substring(startIndex + count);
                    System.out.println(text);
                    break;
            }
            command = scanner.nextLine();
        }
    }
}