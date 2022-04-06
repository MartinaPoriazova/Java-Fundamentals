import java.util.Scanner;

public class PrintAndSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // старт число
        // енд число
        // 1. да отпечатам всяко едно число в редицата
        // 2. да принтирам сумата им

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int number = start; number <= end; number++) {
            System.out.print(number + " ");
            sum += number;
        }

        System.out.println();
        System.out.printf("Sum: %d", sum);
    }
}
