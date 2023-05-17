package Module02_Fundamentals.Course03_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] integerArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i <= integerArr.length - 1; i++) {
            if (integerArr[i] % 2 == 0){
                sumEven += integerArr[i];
            } else {
                sumOdd += integerArr[i];
            }
        }
        System.out.println(sumEven - sumOdd);
    }
}
