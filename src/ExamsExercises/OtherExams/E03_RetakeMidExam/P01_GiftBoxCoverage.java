package Module02_Fundamentals.ExamsExercises.OtherExams.E03_RetakeMidExam;

import java.util.Scanner;

public class P01_GiftBoxCoverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sideSize = Double.parseDouble(scanner.nextLine());
        int sheetsOfPaper = Integer.parseInt(scanner.nextLine());


        double currentArea = sideSize * sideSize * 6;

        double totalCovered = 0;

        for (int i = 1; i <= sheetsOfPaper; i++) {
            double paperLength = Double.parseDouble(scanner.nextLine());
            double paperWidth = Double.parseDouble(scanner.nextLine());
            double coveredArea = paperLength * paperWidth;

            if (i % 3 == 0) {
                coveredArea = coveredArea * 0.75;
            }
            if (i % 5 == 0) {
                coveredArea = 0;
            }
            totalCovered += coveredArea;
        }

        double paperLeft = ((totalCovered - currentArea) / totalCovered) * 100;
        double paperCovered = (totalCovered / currentArea) * 100;
        double needCovering = 100 - (paperCovered);

        if (totalCovered >= currentArea) {
            System.out.println("You've covered the gift box!");
            System.out.printf("%.2f%% wrap paper left.%n", paperLeft);
        } else {
            System.out.println("You are out of paper!");
            System.out.printf("%.2f%% of the box is not covered.%n",needCovering);
        }


    }
}

