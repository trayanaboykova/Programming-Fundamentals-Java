package Module02_Fundamentals.ExamsExercises.MidExams_04;

import java.util.Arrays;
import java.util.Scanner;

public class P03_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] neighborhood = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String commandLine = scanner.nextLine();
        int position = 0;
        boolean isFailed = false;

        while (!commandLine.equals("Love!")) {
            int length = Integer.parseInt(commandLine.split(" ")[1]);
            if (position + length >= neighborhood.length) {
                position = 0;
            } else {
                position = position + length;
            }
            if (neighborhood[position] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", position);
            } else {
                neighborhood[position] -= 2;
                if (neighborhood[position] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", position);
                }
            }
            commandLine = scanner.nextLine();
        }
        int counter = 0;
        for (int i = 0; i < neighborhood.length; i++) {
            if (neighborhood[i] > 0) {
                isFailed = true;
                counter++;
            }
        }
        System.out.printf("Cupid's last position was %d.%n", position);
        if (isFailed) {
            System.out.printf("Cupid has failed %d places.%n", counter);
        } else {
            System.out.print("Mission was successful.");
        }
    }
}
