package Lesson01_BasicSyntax.Exercise;

import java.util.Scanner;

public class P03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPeople = Integer.parseInt(scanner.nextLine());
        String typeOfPeople = scanner.nextLine();
        String typeOfDay = scanner.nextLine();
        double price = 0;

        if (typeOfDay.equals("Friday")) {
            if (typeOfPeople.equals("Students")) {
                price = 8.45;
                if (countPeople >= 30) {
                    price = price * 0.85;
                }
            }
        }
        if (typeOfDay.equals("Friday")) {
            if (typeOfPeople.equals("Business")) {
                price = 10.90;
                if (countPeople >= 100) {
                    countPeople -= 10;
                }
            }
        }
        if (typeOfDay.equals("Friday")) {
            if (typeOfPeople.equals("Regular")) {
                price = 15;
                if (countPeople >= 10 && countPeople <= 20) {
                    price = price * 0.95;
                }
            }
        }
        if (typeOfDay.equals("Saturday")) {
            if (typeOfPeople.equals("Students")) {
                price = 9.80;
                if (countPeople >= 30) {
                    price = price * 0.85;
                }
            }
        }
        if (typeOfDay.equals("Saturday")) {
            if (typeOfPeople.equals("Business")) {
                price = 15.60;
                if (countPeople >= 100) {
                    countPeople -= 10;
                }
            }
        }
        if (typeOfDay.equals("Saturday")) {
            if (typeOfPeople.equals("Regular")) {
                price = 20;
                if (countPeople >= 10 && countPeople <= 20) {
                    price = price * 0.95;
                }
            }
        }
        if (typeOfDay.equals("Sunday")) {
            if (typeOfPeople.equals("Students")) {
                price = 10.46;
                if (countPeople >= 30) {
                    price = price * 0.85;
                }
            }
        }
        if (typeOfDay.equals("Sunday")) {
            if (typeOfPeople.equals("Business")) {
                price = 16;
                if (countPeople >= 100) {
                    countPeople -= 10;
                }
            }
        }
        if (typeOfDay.equals("Sunday")) {
            if (typeOfPeople.equals("Regular")) {
                price = 22.50;
                if (countPeople >= 10 && countPeople <= 20) {
                    price = price * 0.95;
                }
            }
        }
        double totalPrice = countPeople * price;
        System.out.printf("Total price: %.2f", totalPrice);

    }
}

