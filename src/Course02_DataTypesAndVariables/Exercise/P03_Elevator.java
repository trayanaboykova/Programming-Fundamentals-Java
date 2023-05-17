package Module02_Fundamentals.Course02_DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P03_Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numberOfPeople = Double.parseDouble(scanner.nextLine());
        double elevatorCapacity = Double.parseDouble(scanner.nextLine());
        double courses = Math.ceil(numberOfPeople / elevatorCapacity);
        System.out.printf("%.0f", courses);

    }
}
