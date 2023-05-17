package Module02_Fundamentals.Course01_BasicSyntax.Lab;

import java.util.Scanner;

public class P10_MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int product = 0;
        for (int row = num; row <= num; row++) {
            for (int column = 1; column <= 10 ; column++) {
                product = row * column;
                System.out.printf("%d X %d = %d%n", row, column, product);
            }
        }

    }
}
