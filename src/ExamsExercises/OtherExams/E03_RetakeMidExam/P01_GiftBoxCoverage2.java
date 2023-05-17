package ExamsExercises.OtherExams.E03_RetakeMidExam;

import java.util.Scanner;

public class P01_GiftBoxCoverage2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sizeSide = Double.parseDouble(scanner.nextLine());
        int sheetsOfPaper = Integer.parseInt(scanner.nextLine());

        double giftBoxArea = sizeSide * sizeSide * 6;


        double totalCovered = 0;
        boolean isCovered = false;
        for (int i = 1; i <= sheetsOfPaper; i++) {
            double paperLength = Double.parseDouble(scanner.nextLine());
            double paperWidth = Double.parseDouble(scanner.nextLine());
            double sheetArea = paperLength * paperWidth;
            if (i % 3 == 0){
                sheetArea = sheetArea * 0.75;
            } else if (i % 5 == 0) {
                sheetArea = 0;
            }
            totalCovered += sheetArea;
            if (totalCovered >= giftBoxArea){
                isCovered = true;
                break;
            }
        }
        double paperLeft = ((totalCovered - giftBoxArea) / totalCovered) * 100;
        double paperCovered = (totalCovered / giftBoxArea) * 100;
        double needCovering = 100 - (paperCovered);

        if (isCovered){
            System.out.println("You've covered the gift box");
            System.out.printf("%.2f%% wrap paper left.", paperLeft );
        }else {
            System.out.println("You are out of paper!");
            System.out.printf("%.2f%% of the box is not covered.", needCovering);
        }

    }
}