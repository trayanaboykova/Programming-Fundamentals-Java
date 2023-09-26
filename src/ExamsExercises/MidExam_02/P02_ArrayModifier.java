package ExamsExercises.MidExam_02;

import java.util.Arrays;
import java.util.Scanner;

public class P02_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayValues = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).
                toArray();

        String commandLine = scanner.nextLine();
        
        while (!commandLine.equals("end")) {
            String command = commandLine.split(" ")[0];
            switch (command) {
                case "swap":
                    int firstIndex = Integer.parseInt(commandLine.split(" ")[1]);
                    int secondIndex = Integer.parseInt(commandLine.split(" ")[2]);
                    swap(arrayValues, firstIndex, secondIndex);
                    break;
                case "multiply":
                    int first = Integer.parseInt(commandLine.split(" ")[1]);
                    int second = Integer.parseInt(commandLine.split(" ")[2]);
                    multiply(arrayValues, first, second);
                    break;
                case "decrease":
                    decrease(arrayValues);
                    break;

            }
            commandLine = scanner.nextLine();
        }

        for (int i = 0; i < arrayValues.length; i++) {
            int currentNumber = arrayValues[i];
            if (i != arrayValues.length - 1){
                System.out.print(currentNumber + ", ");
            }else {
                System.out.print(currentNumber);
            }
        }


    }

    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int firstNumber = array[firstIndex];
        int secondNumber = array[secondIndex];

        array[firstIndex] = secondNumber;
        array[secondIndex] = firstNumber;
    }

    public static void multiply(int[] array, int firstIndex, int secondIndex) {
        array[firstIndex] = array[firstIndex] * array[secondIndex];
    }

    public static void decrease(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] -= 1;
        }
    }
}
