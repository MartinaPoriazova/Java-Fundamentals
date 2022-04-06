import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        int sumOfNumbs = 0;

        for (int i = 0; i <= arr.length - 1; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            System.out.printf("%d ", num);
            sumOfNumbs += num;
        }
        System.out.println();
        System.out.println(sumOfNumbs);
    }
}
