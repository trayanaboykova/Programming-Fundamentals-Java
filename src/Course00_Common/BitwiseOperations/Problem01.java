package Course00_Common.BitwiseOperations;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int zeroOrOne = Integer.parseInt(scanner.nextLine());

        int counter = 0; // брой на 0 или 1;

        while (number > 0) {
            int leftover = number % 2;
            if (leftover == zeroOrOne){
                counter ++;
            }
            number = number / 2; //number /= 2;
        }
        System.out.println(counter);
    }
}
