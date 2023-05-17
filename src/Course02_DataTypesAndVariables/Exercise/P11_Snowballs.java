package Module02_Fundamentals.Course02_DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P11_Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double maxValue = Double.MIN_VALUE;
        int snowballSnowBiggest = 0;
        int snowballTimeBiggest = 0;
        int snowballQualityBiggest = 0;


        for (int snowBall = 1; snowBall <= n; snowBall++) {
            int snowBallSnow = Integer.parseInt(scanner.nextLine());
            int snowBallTime = Integer.parseInt(scanner.nextLine());
            int snowBallQuality = Integer.parseInt(scanner.nextLine());
            double snowBallValue = Math.pow(snowBallSnow / snowBallTime,snowBallQuality);

            if (snowBallValue > maxValue){
                maxValue = snowBallValue;
                snowballSnowBiggest = snowBallSnow;
                snowballTimeBiggest = snowBallTime;
                snowballQualityBiggest = snowBallQuality;
            }



        }
        System.out.printf("%d : %d = %.0f (%d) ",snowballSnowBiggest, snowballTimeBiggest, maxValue ,snowballQualityBiggest );

    }
}
