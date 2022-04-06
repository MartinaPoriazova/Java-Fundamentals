import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> coffeeList = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            String input = scanner.nextLine();
            String[] commandLine = input.split("\\s+");
            String command = commandLine[0];
            switch (command) {
                case "Include":
                    String coffeeToAdd = commandLine[1];
                    coffeeList.add(coffeeToAdd);
                    break;
                case "Remove":
                    String coffeeToRemove = commandLine[1];
                    int numberOfCoffees = Integer.parseInt(commandLine[2]);
                    if (coffeeList.size() < numberOfCoffees) {
                        break;
                    }
                    if (coffeeToRemove.equals("first")) {
                        for (int j = 1; j <= numberOfCoffees; j++) {

                            coffeeList.remove(coffeeList.get(0));
                        }
                    }
                    if (coffeeToRemove.equals("last")) {

                        for (int j = 1; j <= numberOfCoffees; j++) {

                            coffeeList.remove(coffeeList.size() - 1);
                        }
                    }
                    break;
                case "Prefer":
                    int coffeeIndex1 = Integer.parseInt(commandLine[1]);
                    int coffeeIndex2 = Integer.parseInt(commandLine[2]);
                    if ((coffeeIndex1 >= 0 && coffeeIndex1 < coffeeList.size()) &&
                            (coffeeIndex2 >= 0 && coffeeIndex2 < coffeeList.size())) {
                        Collections.swap(coffeeList, coffeeIndex1, coffeeIndex2);
                    }
//                    if (coffeeList.contains(coffeeList.get(coffeeIndex1)) && coffeeList.contains(coffeeList.get(coffeeIndex2))) {
//                        Collections.swap(coffeeList, coffeeIndex1, coffeeIndex2);
//                    }
                    break;
                case "Reverse":
                    Collections.reverse(coffeeList);
                    break;
            }
        }
        System.out.println("Coffees:");
        System.out.print(coffeeList.toString().replaceAll("[\\[\\],]", ""));
    }
}
