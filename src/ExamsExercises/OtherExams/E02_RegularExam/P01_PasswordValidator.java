package Module02_Fundamentals.ExamsExercises.OtherExams.E02_RegularExam;

import java.util.Scanner;

public class P01_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String command = scanner.nextLine();

        String substring = "";


        while (!command.equals("Complete")) {
            if (command.contains("Make Upper")) {
                int index = Integer.parseInt(command.split(" ")[2]);
                substring = password.substring(index);
                password = password.replace(substring, substring.toUpperCase());
                if (isValidContent(password) && (isValidLength(password)) && (isValidCountDigits(password))){
                    System.out.println(password);
                }
            } else if (command.contains("Make Lower")) {
                int index = Integer.parseInt(command.split(" ")[2]);
                substring = password.substring(index);
                password = password.replace(substring, substring.toLowerCase());
                if (isValidContent(password) && (isValidLength(password)) && (isValidCountDigits(password))){
                    System.out.println(password);
                }
            } else if (command.contains("Insert")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                char symbol = password.charAt(index+1);
                if (isValidIndex(password, index)) {
                    symbol = password.charAt(index);
                }
                if (isValidContent(password) && (isValidLength(password)) && (isValidCountDigits(password))){
                    System.out.println(password);
                }
            } else if (command.contains("Replace")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                char symbol = password.charAt(index+1);

                if (isValidContent(password) && (isValidLength(password)) && (isValidCountDigits(password))){
                    System.out.println(password);
                }
            } else if (command.contains("Validation")) {

            } else {
                continue;
            }


            command = scanner.nextLine();
        }
    }

    private static boolean isValidIndex(String password, int index) {
        if (index >= 0 && index < password.length()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidLength(String password) {
        if (password.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidContent(String password) {
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
            if (!Character.isUpperCase(symbol) || !Character.isLowerCase(symbol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCountDigits(String password) {
        int countDigits = 0;
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                countDigits++;
            }
        }
        return countDigits >= 1;
    }
}
