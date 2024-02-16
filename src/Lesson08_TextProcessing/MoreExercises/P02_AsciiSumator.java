package Lesson08_TextProcessing.MoreExercises;

import java.util.Scanner;

public class P02_AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);
        int startIndex = one;
        int endIndex = two;
        char[] array = scanner.nextLine().toCharArray();

        if (startIndex < endIndex) {
            for (int i = startIndex + 1; i < endIndex - 1; i++) {

                for (int j = 0; j < array.length; j++) {
                    if (array[j] == i) {
                        sum += i;
                    }
                }
            }
        } else if (endIndex < startIndex) {
            int count = 127 - startIndex + endIndex + 1;
            while (count-- > 0) {
                startIndex++;
                if (startIndex == 128) {
                    startIndex = -1;
                    continue;
                }
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == startIndex) {
                        sum += startIndex;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}

