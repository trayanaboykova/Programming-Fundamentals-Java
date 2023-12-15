package Module02_Fundamentals.ExamsExercises.MidExams_04;

import java.util.Scanner;

public class P01_GuineaPig1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodQuantity = Double.parseDouble(scanner.nextLine());
        double hayQuantity = Double.parseDouble(scanner.nextLine());
        double coverQuantity = Double.parseDouble(scanner.nextLine());
        double weightQuantity = Double.parseDouble(scanner.nextLine());

        double foodGrams = foodQuantity * 1000;
        double hayGrams = hayQuantity * 1000;
        double coverGrams = coverQuantity * 1000;
        double weightGrams = weightQuantity * 1000;

        boolean isNotEnough = false;
        int days = 30;
        for (int i = 1; i <= days; i++) {
            foodGrams = foodGrams - 300;
            if (i % 2 == 0) {
                double hayLeft = foodGrams * 0.05;
                hayGrams = hayGrams - hayLeft;
            }
            if (i % 3 == 0) {
                double coverLeft = weightGrams / 3;
                coverGrams = coverGrams - coverLeft;
            }
            if (foodGrams <= 0 || hayGrams <= 0 || coverGrams <= 0) {
                isNotEnough = true;
                break;
            }
        }
        if (isNotEnough) {
            System.out.println("Merry must go to the pet store!");
        } else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", foodGrams / 1000, hayGrams / 1000, coverGrams / 1000);
        }
    }
}
