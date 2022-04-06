import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        long left = 0;
        long right = 0;
        long sum = 0;

        for (int i = 0; i < input; i++) {
            left = scanner.nextLong();
            right = scanner.nextLong();
            sum = 0;
            if (left < right) {
                while (right != 0) {
                    sum += right % 10;
                    right /= 10;
                }
            } else {
                while (left != 0) {
                    sum += left % 10;
                    left /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }
    }
}
