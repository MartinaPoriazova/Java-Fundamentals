import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            }

            List<String> commands = Arrays.asList(command.split(" "));

            switch (commands.get(0)) {
                case "Contains":
                    int numberToCheck = Integer.parseInt(commands.get(1));
                    if (numbers.contains(numberToCheck)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String evenOrOdd = commands.get(1);
                    if (evenOrOdd.equals("even")) {
                        printEven(numbers);
                    } else if (evenOrOdd.equals("odd")) {
                        printOdd(numbers);
                    }
                    break;
                case "Get":
                    printSum(numbers);
                    break;
                case "Filter":
                    String condition = commands.get(1);
                    int filterNumber = Integer.parseInt(commands.get(2));

                    switch (condition) {
                        case "<":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (filterNumber > numbers.get(i)) {
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (filterNumber >= numbers.get(i)) {
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (filterNumber < numbers.get(i)) {
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (filterNumber <= numbers.get(i)) {
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }
        }
    }

    private static List<Integer> printEven(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) % 2 == 0) {
                System.out.print(numbers.get(index) + " ");
            }
        }
        System.out.println();
        return numbers;
    }

    private static List<Integer> printOdd(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) % 2 != 0) {
                System.out.print(numbers.get(index) + " ");
            }
        }
        System.out.println();
        return numbers;
    }

    private static List<Integer> printSum(List<Integer> numbers) {
        int sum = 0;
        for (int index = 0; index < numbers.size(); index++) {
            sum += numbers.get(index);
        }
        System.out.println(sum);
        return numbers;
    }
}
//    private static List<Integer> printFilter(List<Integer> numbers, String condition, int filterNumber) {
//        switch (condition) {
//            case "<":
//                for (int i = 0; i < numbers.size(); i++) {
//                    if (filterNumber > numbers.get(i)) {
//                        System.out.print(numbers.get(i) + " ");
//                    }
//                }
//                break;
//        }
//        System.out.println();
//        return numbers;
//    }
//}
