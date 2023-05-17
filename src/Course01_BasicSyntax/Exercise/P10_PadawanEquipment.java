package Module02_Fundamentals.Course01_BasicSyntax.Exercise;

import java.util.Scanner;

public class P10_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double priceLightsaber = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());

        double sumLightsaber = Math.ceil(studentsCount + 0.10 * studentsCount) * priceLightsaber;
        double sumRobes = studentsCount * priceRobe;
        double sumBelts = (studentsCount - studentsCount / 6) * priceBelt;

        double totalSum = sumLightsaber + sumRobes + sumBelts;

        if (totalSum <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalSum);
        } else {
            double needMoney = totalSum - budget;
            System.out.printf("George Lucas will need %.2flv more.", needMoney);
        }

    }

}

