import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            //•	Delete {element} - delete all elements in the array, which are equal to the given element
            //•	Insert {element} {position} - insert element at the given position
            String commandName = command.split("\\s+")[0];
            int element = Integer.parseInt(command.split("\\s+")[1]);
            switch (commandName) {
                case "Delete":
                    for (int i = 0; i <= numbers.toArray().length - 1; i++) {
                        int currentElement = numbers.get(i);
                        if (element == currentElement) {
                            numbers.remove(i);
                        }
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(command.split("\\s+")[2]);
                    numbers.add(index, element);
                    break;
            }
            command = scanner.nextLine();
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
