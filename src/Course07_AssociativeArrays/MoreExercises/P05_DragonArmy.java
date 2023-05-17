package Module02_Fundamentals.Course07_AssociativeArrays.MoreExercises;

import java.util.*;

public class P05_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeMap<String, List<Integer>>> dragonInfoMap = new LinkedHashMap<>();
        String input;

        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {
            input = scanner.nextLine();
            String type = input.split("\\s+")[0];
            String name = input.split("\\s+")[1];
            int damage;
            int health;
            int armor;
            if (input.split("\\s+")[2].equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(input.split("\\s+")[2]);
            }
            if (input.split("\\s+")[3].equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(input.split("\\s+")[3]);
            }
            if (input.split("\\s+")[4].equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(input.split("\\s+")[4]);
            }

            dragonInfoMap.putIfAbsent(type, new TreeMap<>());
            dragonInfoMap.get(type).put(name, new ArrayList<>());
            dragonInfoMap.get(type).get(name).add(damage);
            dragonInfoMap.get(type).get(name).add(health);
            dragonInfoMap.get(type).get(name).add(armor);
        }

        List<Double> averageValues = new ArrayList<>();
        averageValues = getAverageValues(averageValues, dragonInfoMap);

        printResult(dragonInfoMap, averageValues);
    }

    private static void printResult(Map<String, TreeMap<String, List<Integer>>> dragonInfoMap, List<Double> averageValues) {

        int listIndex = 0;
        for (Map.Entry<String, TreeMap<String, List<Integer>>> typeEntry : dragonInfoMap.entrySet()) {
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", typeEntry.getKey(), averageValues.get(listIndex),
                    averageValues.get(listIndex + 1), averageValues.get(listIndex + 2));

            for (Map.Entry<String, List<Integer>> dragonsEntry : typeEntry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", dragonsEntry.getKey(),
                        dragonsEntry.getValue().get(0), dragonsEntry.getValue().get(1), dragonsEntry.getValue().get(2));
            }
            listIndex += 3;
        }
    }

    private static List<Double> getAverageValues(List<Double> averageValues, Map<String, TreeMap<String, List<Integer>>> dragonInfoMap) {
        double averageDamage = 0;
        double averageHealth = 0;
        double averageArmor = 0;
        int damageCount = 0;
        int healthCount = 0;
        int armorCount = 0;
        int currentSumDamage = 0;
        int currentSumHealth = 0;
        int currentSumArmor = 0;

        for (Map.Entry<String, TreeMap<String, List<Integer>>> treeMapEntry : dragonInfoMap.entrySet()) {
            for (Map.Entry<String, List<Integer>> valuesEntry : treeMapEntry.getValue().entrySet()) {
                int index = 0;
                currentSumDamage += valuesEntry.getValue().get(index);
                damageCount++;
                currentSumHealth += valuesEntry.getValue().get(index + 1);
                healthCount++;
                currentSumArmor += valuesEntry.getValue().get(index + 2);
                armorCount++;

            }
            averageDamage = 1.0 * currentSumDamage / damageCount;
            averageHealth = 1.0 * currentSumHealth / healthCount;
            averageArmor = 1.0 * currentSumArmor / armorCount;
            currentSumDamage = 0;
            currentSumHealth = 0;
            currentSumArmor = 0;
            damageCount = 0;
            healthCount = 0;
            armorCount = 0;
            averageValues.add(averageDamage);
            averageValues.add(averageHealth);
            averageValues.add(averageArmor);
        }
        return averageValues;
    }
}

