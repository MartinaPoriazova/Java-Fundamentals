import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers[] = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int index = 0; index < numbers.length; index++) {
            boolean isBigger = true;
            for (int index2 = index + 1; index2 < numbers.length; index2++) {
                if (numbers[index] <= numbers[index2]) {
                    isBigger = false;
                }
            }
            if (isBigger) {
                System.out.print(numbers[index] + " ");
            }
        }
    }
}
