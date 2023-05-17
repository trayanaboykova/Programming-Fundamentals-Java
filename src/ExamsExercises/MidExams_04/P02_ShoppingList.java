package ExamsExercises.MidExams_04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());
        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Go Shopping!")) {
            String command = commandLine.split(" ")[0];
            String item = commandLine.split(" ")[1];
            switch (command) {
                case "Urgent":
                    if (!groceries.contains(item)) {
                        groceries.add(0, item);
                    }
                    break;
                case "Unnecessary":
                        groceries.remove(item);
                    break;
                case "Correct":
                    String newItem = commandLine.split(" ")[2];
                    if (groceries.contains(item)) {
                        for (int i = 0; i < groceries.size(); i++) {
                            if (groceries.get(i).equals(item)) {
                                groceries.set(i, newItem);
                            }
                        }
                    }
                    break;
                case "Rearrange":
                    if (groceries.contains(item)) {
                        for (int i = 0; i < groceries.size(); i++) {
                            if (groceries.get(i).equals(item)) {
                                String currentItem = groceries.get(i);
                                groceries.remove(i);
                                groceries.add(currentItem);
                            }
                        }
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }
        System.out.println(String.join(", ", groceries));
    }
}
