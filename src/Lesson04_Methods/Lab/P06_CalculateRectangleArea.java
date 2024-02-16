package Lesson04_Methods.Lab;

import java.util.Scanner;

public class P06_CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        calculateArea(width, length);
    }
    public static void calculateArea(int width, int length){
        int area = width * length;
        System.out.println(area);
    }
}
