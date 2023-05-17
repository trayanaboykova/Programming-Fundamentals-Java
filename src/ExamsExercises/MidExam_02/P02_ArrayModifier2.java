package ExamsExercises.MidExam_02;

import java.util.Arrays;
import java.util.Scanner;

public class P02_ArrayModifier2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String commandLine = scanner.nextLine();
        //commands:
        //•	"swap {index1} {index2}" takes two elements and swap their places.
        //•	"multiply {index1} {index2}" takes element at the 1st index and multiply it with the element at 2nd index. Save the product at the 1st index.
        //•	"decrease" decreases all elements in the array with 1.

        while (!commandLine.equals("end")) {
            String command = commandLine.split(" ")[0];
            switch (command) {
                case "swap":
                    int swapFirst = Integer.parseInt(commandLine.split(" ")[1]);
                    int swapSecond = Integer.parseInt(commandLine.split(" ")[2]);
                    int firstElement = numbers[swapFirst];
                    int secondElement = numbers[swapSecond];
                    numbers[swapFirst] = secondElement;
                    numbers[swapSecond] = firstElement;
                    break;
                case "multiply":
                    int multiplyFirst = Integer.parseInt(commandLine.split(" ")[1]);
                    int multiplySecond = Integer.parseInt(commandLine.split(" ")[2]);
                    int first = numbers[multiplyFirst];
                    int second = numbers[multiplySecond];
                    int product = first * second;
                    numbers[multiplyFirst] = product;
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] -= 1;
                    }
            }
            commandLine = scanner.nextLine();
        }
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            if (i != numbers.length - 1){
                System.out.print(currentNumber + ", ");
            }else {
                System.out.print(currentNumber);
            }
        }
    }
}
