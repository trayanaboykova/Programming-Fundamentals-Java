package ExamsExercises.MidExams_03;

import java.util.Arrays;
import java.util.Scanner;

public class P02_ShootForTheWin2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int counter = 0;
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (isValidIndex(targets, index)) {
                if (targets[index] != -1) {
                    int currentTarget = targets[index];
                    targets[index] = -1;
                    counter++;

                    for (int i = 0; i < targets.length; i++) {
                        if (targets[i] > currentTarget && targets[i] != -1) {
                            targets[i] -= currentTarget;
                        } else if (targets[i] <= currentTarget && targets[i] != -1) {
                            targets[i] += currentTarget;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", counter);
        for (int item : targets) {
            System.out.print(item + " ");
        }
    }

    public static boolean isValidIndex(int[] array, int index) {
        return  (index >= 0 && index <= array.length - 1);

    }
}

