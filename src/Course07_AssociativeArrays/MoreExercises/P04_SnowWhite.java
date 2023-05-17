package Course07_AssociativeArrays.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> dwarfInfoMap = new LinkedHashMap<>();
        String input;

        while (!(input = scanner.nextLine()).equals("Once upon a time")) {

            String name = input.split("\\s+<:>\\s+")[0];
            String hatColor = input.split("\\s+<:>\\s+")[1];
            int physics = Integer.parseInt(input.split("\\s+<:>\\s+")[2]);

            dwarfInfoMap.putIfAbsent(hatColor, new LinkedHashMap<>());
            dwarfInfoMap.get(hatColor).putIfAbsent(name, -1);

            if (dwarfInfoMap.get(hatColor).get(name) < physics) {
                dwarfInfoMap.get(hatColor).put(name, physics);
            }
        }

        printResult(dwarfInfoMap);
    }

    private static void printResult(LinkedHashMap<String, LinkedHashMap<String, Integer>> dwarfInfoMap) {

        Map<String, Integer> dwarfsToPrint = new LinkedHashMap<>();

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : dwarfInfoMap.entrySet()) {
            for (Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                dwarfsToPrint.put(entry.getKey() + " " + subEntry.getKey() + " " + entry.getValue().size(), subEntry.getValue());
            }
        }

        dwarfsToPrint.entrySet().stream().sorted((dwarfTwo, dwarfOne) -> {
            int sort = Integer.compare(dwarfOne.getValue(), dwarfTwo.getValue());
            if (sort == 0) {
                String[] sort1 = dwarfOne.getKey().split(" ");
                String[] sort2 = dwarfTwo.getKey().split(" ");
                sort = sort1[2].compareTo(sort2[2]);
            }
            return sort;
        }).forEach(pair -> {
            String[] printing = pair.getKey().split(" ");
            System.out.printf("(%s) %s <-> %d\n", printing[0], printing[1], pair.getValue());
        });
    }
}

