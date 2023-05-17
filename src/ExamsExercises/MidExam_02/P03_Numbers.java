package ExamsExercises.MidExam_02;

import java.util.*;
import java.util.stream.Collectors;

public class P03_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        double averageValue = sum * 1.0 / numbers.size();
        List<Integer> topFiveNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > averageValue) {
                topFiveNumbers.add(numbers.get(i));
            }
        }
        Collections.sort(topFiveNumbers);
        Collections.reverse(topFiveNumbers);

        if (topFiveNumbers.isEmpty()) {
            System.out.println("No");
        } else if (topFiveNumbers.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                System.out.print(topFiveNumbers.get(i) + " ");
            }
        } else {
            for (int item : topFiveNumbers) {
                System.out.print(item + " ");
            }
        }
    }
}
