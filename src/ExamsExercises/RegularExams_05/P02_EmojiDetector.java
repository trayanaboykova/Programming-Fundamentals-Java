package ExamsExercises.RegularExams_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String regexEmoji = "([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})(\\1)";
        Pattern pattern = Pattern.compile(regexEmoji);
        Matcher matcher = pattern.matcher(text);

        int coolThreshold = 1; //праг на готиност
        for (char symbol : text.toCharArray()) {
            if (Character.isDigit(symbol)) {
                //'1' -> "1" -> 1
                coolThreshold *= Integer.parseInt(symbol + "");
            }
        }
        System.out.printf("Cool threshold: %d%n", coolThreshold);

        int countValidEmoji = 0;
        List<String> coolEmoji = new ArrayList<>(); //готини емоджита -> сума за емоджито >= coolThreshold

        while(matcher.find()) { //true -> валидно емоджи
            countValidEmoji++;
            //сума на емоджито
            String emoji = matcher.group("emoji");
            int emojiSum = 0;
            for (char symbol : emoji.toCharArray()) {
                emojiSum += (int) symbol;
            }
            //проверка дали емоджито е cool
            if (emojiSum >= coolThreshold) {
                coolEmoji.add(matcher.group());
            }
        }

        System.out.printf("%d emojis found in the text. The cool ones are:%n", countValidEmoji);
        coolEmoji.forEach(emoji -> System.out.println(emoji));

    }
}