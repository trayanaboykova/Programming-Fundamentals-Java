package Lesson07_AssociativeArrays.Exercise;

import java.util.*;

public class P10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<Integer>>> submissionInfoMap = new LinkedHashMap<>();
        Map<String, List<Integer>> countSubmissionsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("exam finished")) {

            String[] command;
            if (!input.contains("banned")) {

                command = input.split("-");
                String username = command[0];
                String language = command[1];
                int points = Integer.parseInt(command[2]);

                submissionInfoMap.putIfAbsent(username, new HashMap<>());
                submissionInfoMap.get(username).putIfAbsent(language, new ArrayList<>());
                submissionInfoMap.get(username).get(language).add(points);
                countSubmissionsMap.putIfAbsent(language, new ArrayList<>());
                countSubmissionsMap.get(language).add(points);
            } else {

                command = input.split("-");
                String oldUsername = command[0];
                String newUsername = command[1];
                submissionInfoMap.put(oldUsername, submissionInfoMap.put(newUsername, submissionInfoMap.get(oldUsername)));
                submissionInfoMap.remove(oldUsername);
            }

            input = scanner.nextLine();
        }

        printResults(submissionInfoMap);
        printSubmissions(submissionInfoMap, countSubmissionsMap);
    }

    private static void printSubmissions(Map<String, Map<String, List<Integer>>> submissionInfoMap, Map<String, List<Integer>> countSubmissionsMap) {

        System.out.println("Submissions:");
        for (Map.Entry<String, List<Integer>> submission : countSubmissionsMap.entrySet()) {
            System.out.printf("%s - %d\n", submission.getKey(), submission.getValue().size());
        }
    }

    private static void printResults(Map<String, Map<String, List<Integer>>> submissionInfoMap) {

        System.out.println("Results:");
        for (Map.Entry<String, Map<String, List<Integer>>> entry : submissionInfoMap.entrySet()) {
            if (!entry.getKey().contains("banned")) {
                for (Map.Entry<String, List<Integer>> languageEntry : submissionInfoMap.get(entry.getKey()).entrySet()) {
                    int max = Integer.MIN_VALUE;
                    for (int i = 0; i < languageEntry.getValue().size(); i++) {
                        if (languageEntry.getValue().get(i) > max) {
                            max = languageEntry.getValue().get(i);
                        }
                    }
                    System.out.printf("%s | %d\n", entry.getKey(), max);
                }
            }
        }
    }
}
