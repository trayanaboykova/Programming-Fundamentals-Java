package ExamsExercises.OtherExams.E03_RetakeMidExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_SpiceShelf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> listSequence = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("done")) {
            String command = commandLine.split(" ")[0];
            switch (commandLine) {
                case "AddSpice":
                    String spiceToAdd = commandLine.split(" ")[1];
                    if (!listSequence.contains(spiceToAdd)) {
                        listSequence.add(spiceToAdd);
                    }
                    break;
                case "AddManySpices":
                    int index = Integer.parseInt(commandLine.split(" ")[1]);
                    String spiceRow = command.split("\\|")[2];
                    listSequence.set(index, spiceRow);
                    break;
                case "SwapSpices":
                    String firstSpice = commandLine.split(" ")[1];
                    String secondSpice = commandLine.split(" ")[2];
                    int indexOfFirstSpice = listSequence.indexOf(firstSpice);
                    int indexOfSecondSpice = listSequence.indexOf(secondSpice);

                    listSequence.set(indexOfFirstSpice, secondSpice);
                    listSequence.set(indexOfSecondSpice, firstSpice);
                    break;
                case "ThrowAwaySpices":
                    String spiceToThrow = commandLine.split(" ")[1];
                    int numberOfSpices = Integer.parseInt(commandLine.split(" ")[2]);
                    if (listSequence.contains(spiceToThrow)) {
                        listSequence.remove(numberOfSpices + 2);
                    }
                    break;
                case "Arrange":
                    Collections.sort(listSequence);
                    break;
            }

            commandLine = scanner.nextLine();
        }
        for (int i = 0; i < listSequence.size(); i++) {
            System.out.print(listSequence.get(i) + " ");
        }
    }
}
