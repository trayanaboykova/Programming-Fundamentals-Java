package Course08_TextProcessing.MoreExercises;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_MorseCodeTranslator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        LinkedHashMap<String, String> morseCodeMap = new LinkedHashMap<>() {{
            put(".-", "A"); put("-...", "B"); put("-.-.", "C"); put("-..", "D");
            put(".", "E"); put("..-.", "F"); put("--.", "G"); put("....", "H");
            put("..", "I"); put(".---", "J"); put("-.-", "K"); put(".-..", "L");
            put("--", "M"); put("-.", "N"); put("---", "O"); put(".--.", "P");
            put("--.-", "Q"); put(".-.", "R"); put("...", "S"); put("-", "T");
            put("..-", "U"); put("...-", "V"); put(".--", "W"); put("-..-", "X");
            put("-.--", "Y"); put("--..", "Z");
        }};

        List<String> morseList = Arrays.stream(scanner.nextLine().split("\\s+\\|\\s+")).collect(Collectors.toList());

        String decodedMessage = getDecodedMessage(sb, morseCodeMap, morseList);
        System.out.println(decodedMessage);
    }

    private static String getDecodedMessage(StringBuilder sb, LinkedHashMap<String, String> morseCodeMap, List<String> morseList) {
        for (int i = 0; i < morseList.size(); i++) {

            List<String> lettersList = Arrays.stream(morseList.get(i).split("\\s+")).collect(Collectors.toList());

            for (int j = 0; j < lettersList.size(); j++) {
                if (morseCodeMap.containsKey(lettersList.get(j))) {
                    sb.append(morseCodeMap.get(lettersList.get(j)));
                }
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}

