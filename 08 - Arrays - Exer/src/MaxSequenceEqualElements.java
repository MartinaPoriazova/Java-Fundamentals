import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceEqualElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int maxLength = 0;
        int length = 1;
        int startIndex = 0;
        int bestStart = 0;

        for (int index = 1; index < numbers.length; index++) {

            if (numbers[index] == numbers[index - 1]) {
                length++;
            } else {
                length = 1;
                startIndex = index;
            }

            if (length > maxLength) {
                maxLength = length;
                bestStart = startIndex;
            }

        }

        for (int index = bestStart; index < bestStart + maxLength; index++) {
            System.out.print(numbers[index] + " ");
        }

    }
}