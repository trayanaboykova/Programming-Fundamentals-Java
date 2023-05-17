package Module02_Fundamentals.ExamsExercises.MidExams_03;

import java.util.Scanner;

public class P01_CounterStrike2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initEnergy = Integer.parseInt(scanner.nextLine());

        boolean enoughEnergy = true;
        int totalEnergy = initEnergy;
        String input = scanner.nextLine();
        int battleCount = 0;
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);

            if ((totalEnergy - distance) < 0) {
                enoughEnergy = false;
                break;
            } else {
                totalEnergy = totalEnergy - distance;
                battleCount++;
                if (battleCount % 3 == 0) {
                    totalEnergy = totalEnergy + battleCount;
                }
            }

            input = scanner.nextLine();
        }

        if (enoughEnergy) {
            System.out.printf("Won battles: %d. Energy left: %d%n", battleCount, totalEnergy);
        } else {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", battleCount, totalEnergy);
        }
    }
}
