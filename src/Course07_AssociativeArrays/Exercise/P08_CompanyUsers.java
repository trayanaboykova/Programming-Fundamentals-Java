package Course07_AssociativeArrays.Exercise;

import java.util.*;

public class P08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> idByCompanies = new LinkedHashMap<>();
        List<String> employees;

        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            for (int i = 0; i < tokens.length; i++) {
                tokens[i] = tokens[i].trim();
            }
            String companyName = tokens[0];
            String employeeId = tokens[1];

            idByCompanies.putIfAbsent(companyName, new ArrayList<>());
            employees = idByCompanies.get(companyName);
            if (!employees.isEmpty()) {
                if (!employees.contains(employeeId)) {
                    idByCompanies.get(companyName).add(employeeId);
                }
            } else {
                idByCompanies.get(companyName).add(employeeId);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : idByCompanies.entrySet()) {
            System.out.println(entry.getKey());
            employees = entry.getValue();

            for (String s : employees) {
                System.out.printf("-- %s%n", s);
            }

        }

    }
}

