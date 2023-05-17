package Course07_AssociativeArrays.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> playersInfoMap = new LinkedHashMap<>();
        String input;

        while (!(input = scanner.nextLine()).equals("Season end")) {

            if (input.contains("->")) {

                String player = input.split("\\s+->\\s+")[0];
                String position = input.split("\\s+->\\s+")[1];
                int skill = Integer.parseInt(input.split("\\s+->\\s+")[2]);

                playersInfoMap.putIfAbsent(player, new LinkedHashMap<>());
                playersInfoMap.get(player).putIfAbsent(position, -1);

                if (playersInfoMap.get(player).get(position) < skill) {
                    playersInfoMap.get(player).put(position, skill);
                }
            } else {

                String playerOne = input.split("\\s+vs\\s+")[0];
                String playerTwo = input.split("\\s+vs\\s+")[1];
                if (isPlayerExist(playersInfoMap, playerOne) && isPlayerExist(playersInfoMap, playerTwo)) {
                    if (isPositionInCommon(playersInfoMap, playerOne, playerTwo)) {
                        playersInfoMap = playersBattle(playersInfoMap, playerOne, playerTwo);
                    }
                }
            }
        }

        printResults(playersInfoMap);
    }

    private static void printResults(Map<String, Map<String, Integer>> playersInfoMap) {

        playersInfoMap.entrySet()
                .stream()
                .sorted((playerOne, playerTwo) -> {
                    int result = Integer.compare(playerTwo.getValue().values().stream().mapToInt(i -> i).sum(),
                            playerOne.getValue().values().stream().mapToInt(i -> i).sum());
                    if (result == 0) {
                        result = playerOne.getKey().compareTo(playerTwo.getKey());
                    }
                    return result;
                }).forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream().mapToInt(i -> i).sum());
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> {
                                int res = Integer.compare(e2.getValue(), e1.getValue());
                                if (res == 0) {
                                    res = e1.getKey().compareTo(e2.getKey());
                                }
                                return res;
                            }).forEach(e -> {
                                System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
                            });
                });
    }

    private static Map<String, Map<String, Integer>> playersBattle(Map<String, Map<String, Integer>> playersInfoMap, String playerOne, String playerTwo) {

        if (playersInfoMap.get(playerOne).values().stream().mapToInt(i -> i).sum() >
                playersInfoMap.get(playerTwo).values().stream().mapToInt(i -> i).sum()) {
            playersInfoMap.remove(playerTwo);
        } else if (playersInfoMap.get(playerOne).values().stream().mapToInt(i -> i).sum() <
                playersInfoMap.get(playerTwo).values().stream().mapToInt(i -> i).sum()) {
            playersInfoMap.remove(playerOne);
        }

        return playersInfoMap;
    }

    private static boolean isPositionInCommon(Map<String, Map<String, Integer>> playersInfoMap, String playerOne, String playerTwo) {

        for (Map.Entry<String, Integer> playerOnePosition : playersInfoMap.get(playerOne).entrySet()) {
            for (Map.Entry<String, Integer> playerTwoPosition : playersInfoMap.get(playerTwo).entrySet()) {
                if (playerOnePosition.getKey().equals(playerTwoPosition.getKey())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPlayerExist(Map<String, Map<String, Integer>> playersInfoMap, String player) {

        return playersInfoMap.containsKey(player);
    }
}

