import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers[] = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        boolean isFound = false;

        for (int index = 0; index < numbers.length; index++) {
            int currentElement = numbers[index];
            int leftSum = 0;
            int rightSum = 0;

            // от 0 индекс до текущия индекс сумираме всички числа на тези леви позиции
            for (int leftIndex = 0; leftIndex < index; leftIndex++) {
                leftSum += numbers[leftIndex];
            }

            // дясната сума -> от моя индекс + 1 -> надясно
            for (int rightIndex = index + 1; rightIndex <= numbers.length - 1; rightIndex++) {
                rightSum += numbers[rightIndex];
            }

            // проверка дали лява и дясна сума са равни
            if (leftSum == rightSum) {
                System.out.println(index);
                isFound = true;
                break;
            }

        }

        if (!isFound) {
            System.out.println("no");
        }

    }
}
