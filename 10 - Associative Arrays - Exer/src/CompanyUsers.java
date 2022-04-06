import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class CompanyUsers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> companiesListOfEmployees = new TreeMap<>();

        while (!input.equals("End")) {
            String[] inputInfo = input.split(" -> ");
            String companiesName = inputInfo[0];
            String employeesId = inputInfo[1];

            if (!companiesListOfEmployees.containsKey(companiesName)) {
                companiesListOfEmployees.put(companiesName, new ArrayList<>());
            }

            if (!companiesListOfEmployees.get(companiesName).contains(employeesId)) {
                companiesListOfEmployees.get(companiesName).add(employeesId);
            }

            input = scanner.nextLine();
        }

        companiesListOfEmployees
                .entrySet()
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry
                            .getValue()
                            .forEach(emp -> {
                                System.out.println("-- " + emp);
                            });
                });
    }
}
