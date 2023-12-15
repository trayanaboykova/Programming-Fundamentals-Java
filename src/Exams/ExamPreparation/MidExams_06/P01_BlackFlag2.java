package ExamsExercises.MidExams_06;

import java.util.Scanner;

public class P01_BlackFlag2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysOfPlunder = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        int expectedPlunder = Integer.parseInt(scanner.nextLine());

        double totalPlunder = 0;
        for (int day = 1; day <= daysOfPlunder; day++) {
            totalPlunder += dailyPlunder;
            if (day % 3 == 0){
                totalPlunder = totalPlunder + (dailyPlunder / 2.0);
            }
            if (day % 5 == 0){
                totalPlunder = totalPlunder - (totalPlunder * 0.30);
            }
        }
        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else  {
            double percent = (totalPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percent);
        }
    }
}

