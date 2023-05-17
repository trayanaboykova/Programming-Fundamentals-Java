package Module02_Fundamentals.ExamsExercises.MidExam_01;

import java.util.Arrays;
import java.util.Scanner;

public class P02_TheLift_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(scanner.nextLine()); //15
        int[] wagons = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        //[0, 0, 0 , 0]


        for (int wagon = 0; wagon <= wagons.length - 1; wagon++) {
            if (peopleWaiting > 0) {
                int currentCountPeople = wagons[wagon]; //текущ брой на хората
                while (currentCountPeople < 4) {
                    //добавям човек във вагона ако има чакащи
                    if (peopleWaiting <= 0) {
                        break;
                    }
                    currentCountPeople++;
                    wagons[wagon] = currentCountPeople;
                    peopleWaiting--;
                }
            }
        }

        if (peopleWaiting <= 0 && wagons[wagons.length - 1] < 4) {
            //имаме останало място
            System.out.println("The lift has empty spots!");
        } else if (peopleWaiting > 0 && wagons[wagons.length - 1] >= 4) {
            //нямаме повече място
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        }


        //отпечатваме вагоните
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
