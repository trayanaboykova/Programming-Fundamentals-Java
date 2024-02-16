package Lesson09_RegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> participants = Arrays.asList(scanner.nextLine().split(", "));
        Map<String, Integer> racers = new LinkedHashMap<>();

        for (String participant : participants) {
            racers.put(participant, 0);
        }

        Pattern namePattern = Pattern.compile("[A-Za-z]");
        Pattern distancePattern = Pattern.compile("\\d");

        String input;
        while (!(input = scanner.nextLine()).equals("end of race")) {
            Matcher nameMatcher = namePattern.matcher(input);
            Matcher distanceMatcher = distancePattern.matcher(input);

            StringBuilder name = new StringBuilder();
            int distance = 0;

            while (nameMatcher.find()) {
                name.append(nameMatcher.group());
            }

            while (distanceMatcher.find()) {
                distance += Integer.parseInt(distanceMatcher.group());
            }

            if (racers.containsKey(name.toString())) {
                racers.put(name.toString(), racers.get(name.toString()) + distance);
            }
        }

        List<String> topThree = new ArrayList<>();
        for (String participant : participants) {
            if (topThree.size() == 3) break;
            topThree.add(participant);
        }

        System.out.println("1st place: " + topThree.get(0));
        System.out.println("2nd place: " + topThree.get(1));
        System.out.println("3rd place: " + topThree.get(2));
    }
}

