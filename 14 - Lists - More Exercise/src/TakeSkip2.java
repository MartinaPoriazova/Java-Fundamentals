import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkip2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> text = Arrays.stream(input.split("")).collect(Collectors.toList());
        List<Integer> numbers = new ArrayList<>();

        getNumbers(text, numbers);
        removeFromText(text);

        List<Integer> takeList = takeList(numbers);
        List<Integer> skipList = skipList(numbers);

        StringBuilder output = new StringBuilder();
        output = findOutput(text, takeList, skipList);
        System.out.println(output);
    }

    private static StringBuilder findOutput(List<String> text, List<Integer> takeList, List<Integer> skipList) {
        StringBuilder output = new StringBuilder();
        int counter = -1;

        for (int i = 0; i < takeList.size(); i++) {
            for (int j = 0; j < takeList.get(i); j++) {
                if (counter == text.size() - 1) {
                    break;
                } else {
                    counter++;
                    output.append(text.get(counter));
                }
            }

            for (int j = 0; j < skipList.get(i); j++) {
                counter++;
            }
        }
        return output;
    }


    private static List<Integer> skipList(List<Integer> numbers) {
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 != 0) {
                skipList.add(numbers.get(i));
            }
        }
        return skipList;
    }

    private static List<Integer> takeList(List<Integer> numbers) {
        List<Integer> taken = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                taken.add(numbers.get(i));
            }
        }
        return taken;
    }


    private static void removeFromText(List<String> text) {
        for (int i = 0; i < text.size(); i++) {
            switch (text.get(i)) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    text.remove(i);
                    i--;
                    break;
            }
        }
    }

    private static void getNumbers(List<String> text, List<Integer> numbers) {
        for (int i = 0; i < text.size(); i++) {
            switch (text.get(i)) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    numbers.add(Integer.parseInt(text.get(i)));
                    break;
            }
        }
    }
}