package ExamsExercises.MidExam_02;

import java.util.Scanner;

public class P01_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int studentsPerHour = firstEmployee + secondEmployee + thirdEmployee;

        int hours = 0;
        while (studentsCount > 0){
            hours++;
            if (hours % 4 != 0){
                studentsCount -= studentsPerHour;
            }
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
