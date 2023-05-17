package Module02_Fundamentals.Course07_AssociativeArrays.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class P02_Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> dataMap = new LinkedHashMap<>();
        String input;

        while (!(input = scanner.nextLine()).equals("no more time")) {
            String username = input.split("\\s+->\\s+")[0];
            String contest = input.split("\\s+->\\s+")[1];
            int points = Integer.parseInt(input.split("\\s+->\\s+")[2]);

            dataMap.putIfAbsent(contest, new LinkedHashMap<>());
            dataMap.get(contest).putIfAbsent(username, -1);
            if (dataMap.get(contest).get(username) < points) {
                dataMap.get(contest).put(username, points);
            }
        }

        printContestStandings(dataMap);

        Map<String, Integer> standings = new LinkedHashMap<>();
        standings = addIndividualStandings(dataMap, standings);

        printIndividualStandings(standings);
    }

    private static void printIndividualStandings(Map<String, Integer> standings) {

        AtomicInteger num = new AtomicInteger();

        System.out.println("Individual standings:");
        num.set(1);

        standings.entrySet().stream().sorted((e2, e1) -> {
            int sort = Integer.compare(e1.getValue(), e2.getValue());
            if (sort == 0) {
                sort = e2.getKey().compareTo(e1.getKey());
            }
            return sort;
        }).forEach(element -> System.out.printf("%d. %s -> %d\n", num.getAndIncrement(), element.getKey(), element.getValue()));
    }

    private static Map<String, Integer> addIndividualStandings(Map<String, LinkedHashMap<String, Integer>> dataMap, Map<String, Integer> standings) {

        for (Map.Entry<String, LinkedHashMap<String, Integer>> contestEntry : dataMap.entrySet()) {
            for (Map.Entry<String, Integer> valuesEntry : contestEntry.getValue().entrySet()) {
                standings.putIfAbsent(valuesEntry.getKey(), 0);
                standings.put(valuesEntry.getKey(), standings.get(valuesEntry.getKey()) + valuesEntry.getValue());
            }
        }
        return standings;
    }

    private static void printContestStandings(Map<String, LinkedHashMap<String, Integer>> dataMap) {

        AtomicInteger num = new AtomicInteger();
        dataMap.forEach((key, value) -> {
            num.set(1);
            System.out.printf("%s: %d participants\n", key, value.size());
            value.entrySet().stream().sorted((i2, i1) -> {
                int sort = Integer.compare(i1.getValue(), i2.getValue());
                if (sort == 0) {
                    sort = i2.getKey().compareTo(i1.getKey());
                }
                return sort;
            }).forEach(element -> System.out.printf("%d. %s <::> %d\n", num.getAndIncrement(), element.getKey(), element.getValue()));
        });
    }
}

