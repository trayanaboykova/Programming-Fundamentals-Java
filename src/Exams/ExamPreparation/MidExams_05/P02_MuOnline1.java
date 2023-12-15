package ExamsExercises.MidExams_05;

import java.util.Scanner;

public class P02_MuOnline1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dungeonArr = scanner.nextLine().split("\\|");

        int health = 100;
        int bitcoin = 0;
        boolean isKilled = false;

        for (int i = 0; i < dungeonArr.length; i++) {
            String[] dungeon = dungeonArr[i].split(" ");
            String command = dungeon[0];
            int number = Integer.parseInt(dungeon[1]);

            switch (command) {
                case "potion":
                    int diffHealth = 100 - health;
                    health = health + number;
                    if (health > 100) {
                        number = diffHealth;
                        health = 100;
                    }
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;

                case "chest":
                    System.out.printf("You found %d bitcoins.%n", number);
                    bitcoin += number;
                    break;

                default:
                    health = health - number;
                    if (health <= 0) {
                        isKilled = true;
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d", i + 1);
                    } else {
                        System.out.printf("You slayed %s.%n", command);
                    }
                    break;
            }
            if (isKilled) {
                break;
            }
        }
        if (!isKilled) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoin);
            System.out.printf("Health: %d%n", health);
        }

    }
}
