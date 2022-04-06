import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> journal  = Arrays.stream(scanner.nextLine()
                .split(", "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            List<String> command  = Arrays.stream(input
                    .split(" - "))
                    .collect(Collectors.toList());
            switch (command.get(0)) {
                case "Collect":
                        if (!journal.contains(command.get(1))) {
                            journal.add(command.get(1));
                        }
                    break;
                case "Drop":
                        if (journal.contains(command.get(1))) {
                            journal.remove(command.get(1));
                        }
                    break;
                case "Combine Items":
                    List<String> items  = Arrays.stream(command.get(1)
                            .split(":"))
                            .collect(Collectors.toList());
                        if (journal.contains(items.get(0))) {
                            journal.add(journal.indexOf(items.get(0)) + 1, items.get(1));
                        }
                    break;
                case "Renew":
                        if (journal.contains(command.get(1))) {
                            journal.remove(command.get(1));
                            journal.add(command.get(1));
                        }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print(journal.toString().replaceAll("[\\[\\],]", "").replace(" ", ", "));
    }
}
