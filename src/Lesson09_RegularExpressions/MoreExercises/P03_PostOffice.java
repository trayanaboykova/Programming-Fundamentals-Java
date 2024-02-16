package Lesson09_RegularExpressions.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P03_PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern lettersPattern = Pattern.compile("([#$%*&])(?<letters>[A-Z]+)\\1");
        Pattern asciiCodeAndLengthPattern = Pattern.compile("(?<asciiCode>[0-9]{2}):(?<length>[0-9]{2})");

        List<String> input = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        Matcher lettersMatcher = lettersPattern.matcher(input.get(0));

        if (lettersMatcher.find()) {
            String partOne = lettersMatcher.group("letters");
            for (int i = 0; i < partOne.length(); i++) {
                int currentLetter = partOne.charAt(i);
                Matcher asciiCodeAndLengthMatcher = asciiCodeAndLengthPattern.matcher(input.get(1));
                while (asciiCodeAndLengthMatcher.find()) {
                    if (Integer.parseInt(asciiCodeAndLengthMatcher.group("asciiCode")) == currentLetter) {
                        int length = Integer.parseInt(asciiCodeAndLengthMatcher.group("length")) + 1;
                        String[] words = input.get(2).split("\\s+");
                        Arrays.stream(words).filter(s ->
                                        s.length() == length && s.charAt(0) == (char) (currentLetter))
                                .forEach(System.out::println);
                        break;
                    }
                }
            }
        }
    }
}

