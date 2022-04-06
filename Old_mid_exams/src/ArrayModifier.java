import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <Integer> array = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            List <String> commandList = Arrays.stream(command
                    .split(" "))
                    .collect(Collectors.toList());
            switch (commandList.get(0)) {
                case "swap":
                    int firstPosition = Integer.parseInt(commandList.get(1));
                    int secondPosition = Integer.parseInt(commandList.get(2));
                    Collections.swap(array, firstPosition, secondPosition);
                    break;
                case "multiply":
                    int indexOne = Integer.parseInt(commandList.get(1));
                    int indexTwo = Integer.parseInt(commandList.get(2));
                    array.set(indexOne, array.get(indexOne) * array.get(indexTwo));
                    break;
                case "decrease":
                    for (int index = 0; index < array.size(); index++) {
                        array.set(index, array.get(index) - 1);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
//        for (int i = 0; i < array.size(); i++) {
//            System.out.print(array.get(i) + ", ");
//        }
        System.out.print(Arrays.toString(new List[]{array}).replaceAll("[\\[\\]]", ""));
    }

}
