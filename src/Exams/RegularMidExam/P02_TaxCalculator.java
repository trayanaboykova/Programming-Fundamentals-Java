package Exams.RegularMidExam;

import java.util.Scanner;

public class P02_TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] vehicles = scanner.nextLine().split(">>");
        double totalTax = 0.0;

        for (int i = 0; i < vehicles.length; i++) {
            String vehicle = vehicles[i];
            String[] parts = vehicle.split("\\s+");
            String type = parts[0];
            int years = Integer.parseInt(parts[1]);
            int kilometers = Integer.parseInt(parts[2]);
            double initialTax = 0.0;

            switch (type) {
                case "family":
                    initialTax = 50.0;
                    initialTax -= years * 5;
                    initialTax += (kilometers / 3000.0) * 12;
                    break;
                case "heavyDuty":
                    initialTax = 80.0;
                    initialTax -= years * 8;
                    initialTax += (kilometers / 9000.0) * 14;
                    break;
                case "sports":
                    initialTax = 100.0;
                    initialTax -= years * 9;
                    initialTax += (kilometers / 2000.0) * 18;
                    break;
                default:
                    System.out.println("Invalid car type.");
                    continue;
            }

            totalTax += initialTax;
            System.out.printf("A %s car will pay %.2f euros in taxes.\n", type, initialTax);
        }

        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.", totalTax);
    }
}

