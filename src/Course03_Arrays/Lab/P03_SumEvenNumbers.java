package Course03_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                           .mapToInt(Integer::parseInt)
                           .toArray();
        int sum = 0;
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] % 2 == 0){
                sum += numbers[i];
            }
        }
        System.out.println(sum);
    }
}
