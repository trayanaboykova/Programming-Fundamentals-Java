package Module02_Fundamentals.Course07_AssociativeArrays.MoreExercises;


import java.util.*;
import java.util.stream.Collectors;

public class P01_Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestsMap = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> submissionsMap = new TreeMap<>();

        String input;

        while (!(input = scanner.nextLine()).equals("end of contests")) {

            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            contestsMap.putIfAbsent(contest, password);
        }

        while (!(input = scanner.nextLine()).equals("end of submissions")) {

            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String username = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);

            if (isContestExist(contestsMap, contest) && isPasswordValid(contestsMap, password)) {
                submissionsMap.putIfAbsent(username, new HashMap<>());
                submissionsMap.get(username).putIfAbsent(contest, points);
                if (isUserExist(submissionsMap, username, contest)) {
                    submissionsMap = checkForHigherPoints(submissionsMap, username, contest, points);
                }
            }
        }
        printBestCandidate(submissionsMap);
        printResults(submissionsMap);
    }

    private static void printResults(Map<String, Map<String, Integer>> submissionsMap) {

        System.out.println("Ranking:");
        for (Map.Entry<String, Map<String, Integer>> entryName : submissionsMap.entrySet()) {

            Map<String, Integer> valueSortedMap = entryName.getValue();
            valueSortedMap = sortByValue(valueSortedMap);
            System.out.printf("%s\n", entryName.getKey());
            for (Map.Entry<String, Integer> valueSortedMapEntry : valueSortedMap.entrySet()) {

                System.out.printf("#  %s -> %d\n", valueSortedMapEntry.getKey(), valueSortedMapEntry.getValue());
            }
        }
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> valueSortedMap) {

        Map<String, Integer> sortedMap =
                valueSortedMap.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        return sortedMap;
    }

    private static void printBestCandidate(Map<String, Map<String, Integer>> submissionsMap) {

        String bestCandidate = "";
        String currentCandidate = "";
        int currentSum = 0;
        int bestSum = Integer.MIN_VALUE;

        for (Map.Entry<String, Map<String, Integer>> candidate : submissionsMap.entrySet()) {
            currentCandidate = candidate.getKey();

            for (Map.Entry<String, Integer> getPoints : candidate.getValue().entrySet()) {
                currentSum += getPoints.getValue();
            }

            if (bestSum < currentSum) {
                bestSum = currentSum;
                bestCandidate = currentCandidate;
            }
            currentCandidate = "";
            currentSum = 0;
        }

        System.out.printf("Best candidate is %s with total %d points.\n", bestCandidate, bestSum);
    }

    private static Map<String, Map<String, Integer>> checkForHigherPoints(Map<String, Map<String, Integer>> submissionsMap, String username, String contest, int points) {

        for (Map.Entry<String, Map<String, Integer>> entryName : submissionsMap.entrySet()) {
            for (Map.Entry<String, Integer> valueEntry : entryName.getValue().entrySet()) {
                if (valueEntry.getValue() < points && entryName.getKey().equals(username) && valueEntry.getKey().equals(contest)) {
                    valueEntry.setValue(points);
                    break;
                }
            }

        }
        return submissionsMap;
    }

    private static boolean isUserExist(Map<String, Map<String, Integer>> submissionsMap, String username, String contest) {

        if (submissionsMap.get(username).containsKey(contest)) {
            return true;
        }
        return false;
    }

    private static boolean isContestExist(Map<String, String> contestsMap, String contest) {

        if (contestsMap.containsKey(contest)) {
            return true;
        }
        return false;
    }

    private static boolean isPasswordValid(Map<String, String> contestsMap, String password) {

        if (contestsMap.containsValue(password)) {
            return true;
        }
        return false;
    }
}

