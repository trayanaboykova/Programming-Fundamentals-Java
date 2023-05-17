package Module02_Fundamentals.ExamsExercises.MidExam_02;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" "))
                                    .map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        for (int i = 0; i < integerList.size(); i++) {
            sum += integerList.get(i);
        }
        double average = sum * 1.0 / integerList.size();
        List<Integer> topFive = new ArrayList<>();

        for (int i = 0; i < integerList.size(); i++) {
            if (integerList.get(i) > average) {
                topFive.add(integerList.get(i));
            }
        }
        Collections.sort(topFive);
        Collections.reverse(topFive);

        if (topFive.isEmpty()) {
            System.out.println("No");
        } else if (topFive.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                System.out.print(topFive.get(i) + " ");
            }
        } else {
            for (int item : topFive) {
                System.out.print(item + " ");

            }
        }
    }
}

