import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            List<String> command = Arrays.stream(input
                    .split(" "))
                    .collect(Collectors.toList());
            int index = Integer.parseInt(command.get(1));
            switch (command.get(0)) {
                case "Shoot":
                    int power = Integer.parseInt(command.get(2));
                    if (index >= 0 && index < targets.size()) {
                        int newTarget = targets.get(index) - power;
                        if (newTarget <= 0) {
                            targets.remove(index);
                        } else {
                            targets.set(index, newTarget);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(command.get(2));
                    if (index >= 0 && index < targets.size()) {
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(command.get(2));
                    if (index - radius >= 0 && index + radius < targets.size()) {
                        for (int i = index + radius; i >= index - radius; i--) {
                            targets.remove(i);
                        }
                    } else {
                    System.out.println("Strike missed!");
                }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print(targets.toString().replaceAll("[\\[\\],]", "").replace(" ", "|"));
    }
}
