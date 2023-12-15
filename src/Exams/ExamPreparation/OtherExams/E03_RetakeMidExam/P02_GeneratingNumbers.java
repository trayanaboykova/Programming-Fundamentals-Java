package ExamsExercises.OtherExams.E03_RetakeMidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_GeneratingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listSequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("END")) {
            String command = commandLine.split("\\s+")[0];
            switch (command) {
                case "add to start":
                    //add the ints to the beginning of the sequence
                    int numbers = Integer.parseInt(command.split("\\s+")[1]);
                    listSequence.remove(numbers);
                    listSequence.set(0, numbers);
                    break;
                case "remove greater than":
                    //remove every element with value greater than {value}
                    //if there are such elements
                    int value = Integer.parseInt(commandLine.split("\\s+")[1]);
                    for (int i = 0; i < listSequence.size(); i++) {
                            if (value >= 0 && value < listSequence.size())
                            listSequence.remove(i);
                    }
                    break;
                case "replace":
                    //find the first occurrence of the element equal to
                    //the given value and replace it with the given replacement
                    //if there is not an integer equal to the given value
                    //skip the command
                    int valueToReplace = Integer.parseInt(commandLine.split("\\s+")[1]);
                    int replacement = Integer.parseInt(commandLine.split("\\s+")[2]);
                    for (int i = 0; i < listSequence.size(); i++) {
                        if (listSequence.contains(valueToReplace) || valueToReplace == i) {
                            listSequence.set(valueToReplace, replacement);
                            if (listSequence.contains(valueToReplace)) {
                                int index = listSequence.indexOf(valueToReplace);
                                listSequence.set(index, replacement);
                            }
                        }
                    }
                    break;
                case "remove at index":
                    //remove the int at the given index
                    //if the index is valid skip
                    int indexToRemove = Integer.parseInt(commandLine.split("\\s+")[1]);
                    if (indexToRemove >= 0 && indexToRemove < listSequence.size()){
                        listSequence.remove(indexToRemove);
                    }
                    break;
                case "find even":
                    //print the even ints, separated by a single space
                    for (int i = 0; i < listSequence.size(); i++) {
                        if (i % 2 == 0){
                            System.out.println(i + " ");
                        }
                    }
                    break;
                case "find odd":
                    //print the odd ints, separated by space
                    for (int i = 0; i < listSequence.size(); i++) {
                        if (i % 2 != 0){
                            System.out.println(i + " ");
                        }
                    }
                    break;
            }

            commandLine = scanner.nextLine();
        }

        List<String> stringList = new ArrayList<>(listSequence.size());
        for (int i = 0; i < listSequence.size(); i++) {
            stringList.add(String.valueOf(listSequence.get(i)));
        }
        System.out.println(String.join(", ", stringList));
    }
}
