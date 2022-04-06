import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantaGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        List<Integer> houses = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        int currentPosition = 0;

        for (int i = 0; i < numberOfCommands; i++) {

            List<String> commands = Arrays.stream(scanner.nextLine().split(" "))
                    .collect(Collectors.toList());

            String commandType = commands.get(0);

            switch (commandType) {
                case "Forward":
                    int numberOfStepsForward = Integer.parseInt(commands.get(1));

                    currentPosition += numberOfStepsForward;

                    houses.remove(currentPosition);

                    break;
                case "Back":
                    int numberOfStepsBack = Integer.parseInt(commands.get(1));

                    currentPosition -= numberOfStepsBack;

                    houses.remove(currentPosition);

                    break;
                case "Gift":
                    int index = Integer.parseInt(commands.get(1));
                    int houseNumber = Integer.parseInt(commands.get(2));

                    houses.add(index, houseNumber);

                    currentPosition = index;

                    break;
                case "Swap":
                    int indexOfFirst = Integer.parseInt(commands.get(1));
                    int indexOfSecond = Integer.parseInt(commands.get(2));

                    int index1 = 0;
                    int index2 = 0;

                    for (int j = 0; j < houses.size(); j++) {
                        if (houses.get(j) == indexOfFirst) {
                            index1 = j;
                        } else if (houses.get(j) == indexOfSecond) {
                            index2 = j;
                        }
                    }
                    Collections.swap(houses, index1, index2);
                    break;
            }
        }
        System.out.printf("Position: %d",currentPosition);
        System.out.println();
        String res = houses.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(res);
    }
}
 