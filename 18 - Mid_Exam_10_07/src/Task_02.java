import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> sequence = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            List<String> commandList = Arrays.stream(command
                    .split(" "))
                    .collect(Collectors.toList());
            int value = Integer.parseInt(commandList.get(1));
            switch (commandList.get(0)) {
                case "Add":
                    sequence.add(value);
                    break;
                case "Remove":
                    for (int i = 0; i < sequence.size(); i++) {
                        if (value == sequence.get(i)) {
                            sequence.remove(i);
                            break;
                        }
                    }
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(commandList.get(2));
                    for (int i = 0; i < sequence.size(); i++) {
                        if (value == sequence.get(i)) {
                            sequence.set(i, replacement);
                            break;
                        }
                    }
                    break;
                case "Collapse":
                    for (int i = sequence.size() - 1; i >= 0; i--) {
                        if (value > sequence.get(i)) {
                            sequence.remove(i);
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.print(sequence.toString().replaceAll("[\\[\\],]", ""));
    }
}

