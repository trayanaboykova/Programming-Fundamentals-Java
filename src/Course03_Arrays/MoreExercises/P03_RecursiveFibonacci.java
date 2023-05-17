package Module02_Fundamentals.Course03_Arrays.MoreExercises;

import java.util.Scanner;

public class P03_RecursiveFibonacci {
    public static int fibonacciRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int fibonacciNumber = 0;
        for (int i = 1; i <= n; i++) {
            fibonacciNumber = fibonacciRecursion(i);
        }
        System.out.println(fibonacciNumber);
    }

}

