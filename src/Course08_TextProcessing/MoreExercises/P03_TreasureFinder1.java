package Module02_Fundamentals.Course08_TextProcessing.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P03_TreasureFinder1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern patternItem = Pattern.compile("&(.+?)&");
        Pattern patternDestination = Pattern.compile("<(.+?)>");
        List<Integer> numsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input;

        while (!(input = scanner.nextLine()).equals("find")) {

            List<String> codeList = Arrays.stream(input.split("")).collect(Collectors.toList());

            String hiddenMessage = getHiddenMessage(numsList, codeList);
            Matcher matcherItem = patternItem.matcher(hiddenMessage);
            Matcher matcherDestination = patternDestination.matcher(hiddenMessage);

            if (matcherItem.find() && matcherDestination.find()) {
                System.out.printf("Found %s at %s\n", matcherItem.group(1), matcherDestination.group(1));
            }
        }
    }

    private static String getHiddenMessage(List<Integer> numsList, List<String> codeList) {
        int index = 0;
        for (int i = 0; i < codeList.size(); i++) {
            if (index == numsList.size()) {
                index = 0;
            }
            char symbol = codeList.get(i).charAt(0);
            int num = numsList.get(index);
            symbol = (char) (symbol - num);
            codeList.set(i, String.valueOf(symbol));
            index++;
        }

        return codeList.toString().replaceAll("[\\[\\], ]", "");
    }
}

