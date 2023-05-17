package Module02_Fundamentals.ExamsExercises.MidExam_01;


import java.util.Scanner;

public class P01_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double priceWithoutTax = 0;

        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                priceWithoutTax += price;
            }
            input = scanner.nextLine();
        }
        double taxes = priceWithoutTax * 0.20;
        double priceWithTax = priceWithoutTax + taxes;
        if (input.equals("special")) {
            priceWithTax = priceWithTax * 0.90;
        }
        if (priceWithTax == 0){
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", priceWithoutTax);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", priceWithTax);
        }

    }
}

