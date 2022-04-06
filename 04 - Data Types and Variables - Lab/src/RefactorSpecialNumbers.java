import java.util.Scanner;

public class RefactorSpecialNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int num = 1; num <= n; num++) {
            int sum = 0;
            int digit = num;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            if ((sum == 5) || (sum == 7) || (sum == 11)) {
                System.out.printf("%d -> True\n", digit);
            } else {
                System.out.printf("%d -> False\n", digit);
            }
            num = digit;

        }
    }
}
