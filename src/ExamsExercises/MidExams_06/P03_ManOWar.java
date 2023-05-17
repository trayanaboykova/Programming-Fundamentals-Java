package Module02_Fundamentals.ExamsExercises.MidExams_06;

import java.util.Arrays;
import java.util.Scanner;

public class P03_ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] warShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxHealth = Integer.parseInt(scanner.nextLine());
        String commandLine = scanner.nextLine();
        boolean end = false;
        while (!commandLine.equals("Retire") && !(end)) {
            String command = commandLine.split(" ")[0];
            if (command.equals("Status")) {
                int counter = 0;
                for (int i = 0; i < pirateShip.length; i++) {
                    if (pirateShip[i] < maxHealth * 0.2) {
                        counter++;
                    }
                }
                System.out.printf("%d sections need repair.%n", counter);
            } else {
                int index = Integer.parseInt(commandLine.split(" ")[1]);
                switch (command) {
                    case "Fire":
                        int warDamage = Integer.parseInt(commandLine.split(" ")[2]);
                        if (index >= 0 && index <= warShip.length - 1) {
                            warShip[index] -= warDamage;
                            if (warShip[index] <= 0) {
                                System.out.print("You won! The enemy ship has sunken.");
                                end = true;
                                break;
                            }
                        }
                        break;
                    case "Defend":
                        int endIndex = Integer.parseInt(commandLine.split(" ")[2]);
                        int pirateDamage = Integer.parseInt(commandLine.split(" ")[3]);
                        if (index >= 0 && index <= pirateShip.length - 1 && endIndex >=0 && endIndex <= pirateShip.length - 1) {
                            for (int i = index; i <= endIndex; i++) {
                                pirateShip[i] -= pirateDamage;
                                if (pirateShip[i] <= 0) {
                                    System.out.print("You lost! The pirate ship has sunken.");
                                    end = true;
                                    break;
                                }
                            }
                        }
                        break;
                    case "Repair":
                        int health = Integer.parseInt(commandLine.split(" ")[2]);
                        if (index >= 0 && index <= pirateShip.length - 1) {
                            if ((pirateShip[index] + health) <= maxHealth){
                                pirateShip[index] += health;
                            }else {
                                pirateShip[index] = maxHealth;
                            }
                        }
                        break;
                }
            }
            if (!(end)){
                commandLine = scanner.nextLine();
            }
        }
        if (!end){
            System.out.printf("Pirate ship status: %d%n", getStatus(pirateShip));
            System.out.printf("Warship status: %d%n", getStatus(warShip));
        }
    }
    public static int getStatus(int[] array){
        int status = 0;
        for (int i = 0; i < array.length; i++) {
            status += array[i];
        }
        return status;
    }
}
