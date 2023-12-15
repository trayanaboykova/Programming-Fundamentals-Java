package ExamsExercises.MidExams_05;

import java.util.Scanner;

public class P01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int totalNumberOfLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        //The bonus is calculated with the following formula:
        //{total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})
        double maxBonus = Double.MIN_VALUE;
        int maxAttendance = 0;

        for (int i = 0; i < numberOfStudents; i++) {
            int studentAttendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = (studentAttendance * 1.0 / totalNumberOfLectures) * (5 + additionalBonus);
            if (totalBonus > maxBonus){
                maxBonus = totalBonus;
                maxAttendance = studentAttendance;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxAttendance);
    }

}
