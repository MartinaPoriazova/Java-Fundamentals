import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shoppingList = Arrays.stream(scanner.nextLine()
                .split("!"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            List<String> command = Arrays.stream(input
                    .split(" "))
                    .collect(Collectors.toList());
            String item = command.get(1);
            switch (command.get(0)) {
                case "Urgent":
                        if (!shoppingList.contains(item)) {
                            shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                        if (shoppingList.contains(item)) {
                            shoppingList.remove(item);
                        }
                    break;
                case "Correct":
                    String oldItem = command.get(1);
                    String newItem = command.get(2);
                        if (shoppingList.contains(oldItem)) {
                            shoppingList.set(shoppingList.indexOf(oldItem), newItem);
                        }
                    break;
                case "Rearrange":
                        if (shoppingList.contains(item)) {
                            shoppingList.remove(item);
                            shoppingList.add(item);
                        }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print(shoppingList.toString().replaceAll("[\\[\\],]", "").replace(" ", ", "));
    }
}
