import java.util.Scanner;

public class MultiplyEvensByOdds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int finalResult = getMultipleOfEvensAndOdds(Math.abs(number));
        System.out.println(finalResult);
    }

    public static int getMultipleOfEvensAndOdds(int number) {
        int result = getEvenSum(number) * getOddSum(number);
        return result;
    }

    public static int getEvenSum(int number) {
        int evensSum = 0;

        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                evensSum += digit;
            }
            number = number / 10;
        }
        return evensSum;
    }

    public static int getOddSum(int number) {
        int oddsSum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 1) {
                oddsSum += digit;
            }
            number = number / 10;
        }
        return oddsSum;
    }
}
