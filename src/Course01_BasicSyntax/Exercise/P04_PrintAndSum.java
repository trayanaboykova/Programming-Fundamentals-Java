package Module02_Fundamentals.Course01_BasicSyntax.Exercise;

import java.util.Scanner;

public class P04_PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = startNum; i <= endNum; i++) {
            System.out.print(i + " ");
            sum = sum + i;

        }
        System.out.println();
        System.out.println("Sum: " + sum);
    }
}
