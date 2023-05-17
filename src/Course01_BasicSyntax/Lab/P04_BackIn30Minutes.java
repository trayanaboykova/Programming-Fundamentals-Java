package Course01_BasicSyntax.Lab;

import java.util.Scanner;

public class P04_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialHour = Integer.parseInt(scanner.nextLine());
        int initialMinutes = Integer.parseInt(scanner.nextLine());

        int allMinutes = (initialHour * 60) + initialMinutes + 30;
        int hour = allMinutes / 60;
        int minutes = allMinutes % 60;

        if (hour > 23){
            hour = 0;

        }
        System.out.printf("%d:%02d", hour, minutes);
    }
}
