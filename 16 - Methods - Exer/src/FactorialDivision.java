import java.util.Scanner;

public class FactorialDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", getFactorialOfNum1AndNum2(num1, num2));
    }

    public static double getFactorialOfNum1AndNum2(int num1, int num2) {
        double i, fact1 = 1;

        for (i = 1; i <= num1; i++) {
            fact1 = fact1 * i;
        }

        double k, fact2 = 1;

        for (int j = 1; j <= num2; j++) {
            fact2 = fact2 * j;
        }

        double result = fact1 / fact2;
        return result;
    }
}
