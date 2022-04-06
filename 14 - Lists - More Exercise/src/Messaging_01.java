import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        StringBuilder text = new StringBuilder(scanner.nextLine());

        for (Integer n : numbers) {
            String output = "";
            int currentNumber = n;
            int sum = 0;
            while (currentNumber > 0) {
                int digit = currentNumber % 10;
                sum += digit;
                currentNumber /= 10;
            }

            if (sum > text.length()) {
                sum = sum - text.length();
            }
            output += text.charAt(sum);
            text.deleteCharAt(sum);
            System.out.print(output);
        }
    }
}
