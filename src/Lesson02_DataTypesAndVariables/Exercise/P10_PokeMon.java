package Lesson02_DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P10_PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int startPower = power;
        int countPoke = 0;
        while (power >= distance) {
            power -= distance;
            countPoke++;
            if (power == startPower / 2) {
                if (exhaustionFactor != 0) {
                    power = power / exhaustionFactor;
                }
            }
        }

        System.out.println(power);
        System.out.println(countPoke);
    }
}
