package Module02_Fundamentals.Course05_Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P02_GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sizeList = numbersList.size();
        for (int i = 0; i < sizeList / 2; i++) {
            int firstNum = numbersList.get(i);
            int secondNum = numbersList.get(numbersList.size() - 1);

            numbersList.set(i, firstNum + secondNum);
            numbersList.remove(numbersList.size() - 1);
        }

        for (int item : numbersList) {
            System.out.print(item + " ");
        }
    }
}

