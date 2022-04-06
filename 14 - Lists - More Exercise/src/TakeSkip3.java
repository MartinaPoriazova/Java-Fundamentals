import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkip3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Character> input = scanner.nextLine().chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        List<Character> digitsListInChars = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (Character.isDigit(input.get(i))) {
                digitsListInChars.add(input.get(i));
                input.remove(input.get(i));
                i--;
            }
        }

        List<Integer> digitsList = digitsListInChars.stream().map(String::valueOf).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < digitsList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(digitsList.get(i));
            } else {
                skipList.add(digitsList.get(i));
            }
        }

        List<String> output = new ArrayList<>();
        int indexToTake = 0;
        for (int i = 0; i < takeList.size(); i++) {
            if (indexToTake >= input.size()) {
                break;
            }
            for (int j = 0; j < takeList.get(i); j++) {
                output.add(input.get(indexToTake).toString());
                indexToTake++;
                if (indexToTake >= input.size()) {
                    break;
                }
            }
            indexToTake += skipList.get(i);
        }

        for (String element : output) {
            System.out.print(element);
        }
    }
}
 