package Module02_Fundamentals.ExamsExercises.MidExams_06;

import java.util.Scanner;

public class P01_BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double totalPlunder = 0;
        int dayCounter = 0;

        while (dayCounter < days) {
            dayCounter++;
            totalPlunder += dailyPlunder;
            if (dayCounter % 3 == 0) {
                totalPlunder += (dailyPlunder * 0.5);
            }
            if (dayCounter % 5 == 0) {
                totalPlunder = totalPlunder * 0.70;
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", totalPlunder / expectedPlunder * 100);
        }

    }
}

