import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class demo2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> coffeeList = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            String input = scanner.nextLine();
            String[] commandList = input.split(" ");
            String command = commandList[0];
            switch (command) {
                case "Include": //o	"Include {coffee}"
                    String coffeeToAdd = commandList[1];
                    coffeeList.add(coffeeToAdd);
                    break;
                case "Remove": //Remove {first/last} {numberOfCoffees}"
                    String firstLast = commandList[1];
                    int numberOfCoffees = Integer.parseInt(commandList[2]);
                    if (numberOfCoffees < coffeeList.size() - 1) {
                        break;
                    }
                    switch (firstLast) {
                        case "first":
                            for (int j = 1; j <= numberOfCoffees; j++) {
                                coffeeList.remove(0);
                            }
                            break;
                        case "last":
                            for (int k = 1; k <= numberOfCoffees; k++) {
                                coffeeList.remove(coffeeList.size() - 1);
                            }
                            break;
                    }
                    break;
                case "Prefer": //o	"Prefer {coffeeIndex1} {coffeeIndex2}"
                    int coffeeIndex1 = Integer.parseInt(commandList[1]);
                    int coffeeIndex2 = Integer.parseInt(commandList[2]);
                    if ((coffeeIndex1 >= 0 && coffeeIndex1 < coffeeList.size()) &&
                            (coffeeIndex2 >= 0 && coffeeIndex2 < coffeeList.size())) {
                        Collections.swap(coffeeList, coffeeIndex1, coffeeIndex2);
                    }
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
