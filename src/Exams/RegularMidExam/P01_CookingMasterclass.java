package Exams.RegularMidExam;

import java.util.Scanner;

public class P01_CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());

        int apronsToBuy = (int) Math.ceil(students * 1.2);
        int freePackages = students / 5;

        double totalPrice = (apronPrice * apronsToBuy)
                + (eggPrice * 10 * students)
                + (flourPrice * (students - freePackages));

        if (totalPrice <= budget) {
            System.out.printf("Items purchased for %.2f$.", totalPrice);
        } else {
            double neededMoney = totalPrice - budget;
            System.out.printf("%.2f$ more needed.", neededMoney);
        }
    }
}
