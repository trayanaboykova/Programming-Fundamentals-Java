package ExamsExercises.MidExams_05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> craftingItems = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Craft!")){
            String command = commandLine.split(" - ")[0];
            String item = commandLine.split(" - ")[1];
            switch (command){
                case "Collect":
                    if (!craftingItems.contains(item)){
                        craftingItems.add(item);
                    }
                    break;
                case "Drop":
                        craftingItems.remove(item);
                    break;
                case "Combine Items":
                    String oldItem = item.split(":")[0];
                    String newItem = item.split(":")[1];
                    if (craftingItems.contains(oldItem)){
                       int index = craftingItems.indexOf(oldItem);
                       craftingItems.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (craftingItems.contains(item)){
                        craftingItems.remove(item);
                        craftingItems.add(item);
                    }
                    break;
            }




            commandLine = scanner.nextLine();
        }
        for (int i = 0; i < craftingItems.size() - 1; i++) {
            System.out.print(craftingItems.get(i) + ", ");
        }
        System.out.print(craftingItems.get(craftingItems.size() - 1));
    }
}
