import java.util.Scanner;

public class SpecialNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n - броят, числа, които трябва да проверим
        // за всяко от тях дали е специално
        int n = Integer.parseInt(scanner.nextLine());

        for (int num = 1; num <= n; num++) {
            // is num special?
            int digits = num;
            int sum = 0;
            while (digits > 0) {
                int currentDigit = digits % 10;
                sum += currentDigit;
                digits /= 10;
            }

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.println(num + " -> True");
            } else {
                System.out.println(num + " -> False");
            }

        }
    }
}
