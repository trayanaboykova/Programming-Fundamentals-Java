package ExamsExercises.MidExams_03;

import java.util.Scanner;

public class P01_CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialEnergy = Integer.parseInt(scanner.nextLine());
        int battleCount = 0;
        boolean isGameLost = false;
        String input = scanner.nextLine();

        while (!input.equals("End of battle")) {
            int enemyDistance = Integer.parseInt(input);
            if (initialEnergy >= enemyDistance) {
                initialEnergy -= enemyDistance;
                battleCount++;
            } else {
                isGameLost = true;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battleCount, initialEnergy);
                break;
            }
            if (battleCount % 3 == 0) {
                initialEnergy += battleCount;
            }

            input = scanner.nextLine();
        }
        if (!isGameLost){
            System.out.printf("Won battles: %d. Energy left: %d", battleCount, initialEnergy);

        }
    }
}
