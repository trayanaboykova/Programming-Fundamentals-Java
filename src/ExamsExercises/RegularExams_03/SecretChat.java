package Module02_Fundamentals.ExamsExercises.RegularExams_03;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hiddenMessage = scanner.nextLine();
        String commandLine = scanner.nextLine();
        StringBuilder realMessage = new StringBuilder(hiddenMessage);
        while (!commandLine.equals("Reveal")) {
            String command = commandLine.split(":\\|:")[0];
            String textToEdit = realMessage.toString();
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandLine.split(":\\|:")[1]);
                    realMessage = new StringBuilder(textToEdit.substring(0, index).concat(" ").concat(textToEdit.substring(index)));
                    System.out.println(realMessage);
                    break;
                case "Reverse":
                    String substring = commandLine.split(":\\|:")[1];
                    if (textToEdit.contains(substring)) {
                        String reverse = new StringBuilder(substring).reverse().toString();
                        realMessage.delete(realMessage.indexOf(substring), realMessage.indexOf(substring) + substring.length());
                        realMessage.append(reverse);
                        System.out.println(realMessage);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substringForChange = commandLine.split(":\\|:")[1];
                    String replacement = commandLine.split(":\\|:")[2];
                    while (textToEdit.contains(substringForChange)) {
                        textToEdit = textToEdit.replace(substringForChange, replacement);
                    }
                    realMessage = new StringBuilder(textToEdit);
                    System.out.println(realMessage);
                    break;

            }
            commandLine = scanner.nextLine();

        }
        System.out.println("You have a new text message: " + realMessage);
    }

}
