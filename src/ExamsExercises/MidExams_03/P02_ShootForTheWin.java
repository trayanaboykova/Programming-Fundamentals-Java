package Module02_Fundamentals.ExamsExercises.MidExams_03;

import java.util.Arrays;
import java.util.Scanner;

public class P02_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] targets = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();
        String commandLine = scanner.nextLine();
        int counter = 0;
        while (!commandLine.equals("End")) {
            int index = Integer.parseInt(commandLine);
            if (index >= 0 && index <= targets.length - 1) {
                if (targets[index] != -1) {
                    int currentTarget = targets[index];
                    targets[index] = -1;
                    counter++;

                    for (int i = 0; i <= targets.length - 1; i++) {
                        if (targets[i] > currentTarget && targets[i] != -1) {
                            targets[i] -= currentTarget;
                        } else if (targets[i] <= currentTarget && targets[i] != -1) {
                            targets[i] += currentTarget;
                        }
                    }
                }
            }
            commandLine = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", counter);
        for (int item:targets) {
            System.out.print(item + " ");
        }
    }

}
