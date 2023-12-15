package ExamsExercises.MidExam_01;

import java.util.Arrays;
import java.util.Scanner;

public class P02_TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        String[] userInput = scanner.nextLine().split(" ");
        int[] liftCabins = Arrays.stream(userInput).
                mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < liftCabins.length; i++) {
            int peopleInCabin = liftCabins[i];
            int freeSpace = 4 - peopleInCabin;

            if (peopleInCabin >= 4) {
                continue;
            }

            if (freeSpace >= peopleWaiting) {
                liftCabins[i] = liftCabins[i] + peopleWaiting;
                peopleWaiting = 0;
                break;
            }

            liftCabins[i] = 4;
            peopleWaiting = peopleWaiting - freeSpace;

        }
        boolean hasEmptySeats = false;
        for (int peopleInCabin : liftCabins) {
            if (peopleInCabin < 4){
                hasEmptySeats = true;
                break;
            }
        }


        if (hasEmptySeats) {
            System.out.println("The lift has empty spots!");
        } else if (!hasEmptySeats && peopleWaiting != 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        }
        Arrays.stream(liftCabins).forEach(e -> System.out.print(e + " "));
    }
}
