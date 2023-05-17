package ExamsExercises.OtherExams.E01_RegularMidExam;

import java.util.Scanner;

public class P01_ExperienceGaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededExperience = Double.parseDouble(scanner.nextLine());
        int battleCount = Integer.parseInt(scanner.nextLine());

        int count = 0;
        double totalExperience = 0;
        boolean success = false;
        for (int i = 0; i < battleCount; i++) {
            count++;
            double earnedExperience = Double.parseDouble(scanner.nextLine());

            if (count % 3 == 0) {
                earnedExperience *= 1.15;
            }
            if (count % 5 == 0) {
                earnedExperience *= 0.90;
            }
            if (count % 15 == 0) {
                earnedExperience *= 1.05;
            }

            totalExperience += earnedExperience;

            if (totalExperience >= neededExperience) {
                success = true;
                break;
            }
        }

        if (success) {
            System.out.printf("Player successfully collected his needed experience for %d battles.", count);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", neededExperience - totalExperience);
        }
    }
}