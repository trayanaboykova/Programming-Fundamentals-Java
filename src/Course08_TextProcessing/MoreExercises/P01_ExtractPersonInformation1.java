package Course08_TextProcessing.MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_ExtractPersonInformation1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern patternName = Pattern.compile("@(.+?)\\|", Pattern.DOTALL);
        Pattern patternAge = Pattern.compile("#(.+?)\\*", Pattern.DOTALL);
        Matcher matcherName;
        Matcher matcherAge;
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            matcherName = patternName.matcher(line);
            matcherAge = patternAge.matcher(line);

            if (matcherName.find() && matcherAge.find()) {
                System.out.printf("%s is %s years old.\n", matcherName.group(1), matcherAge.group(1));
            }
        }
    }
}

