import java.util.Scanner;
public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        long[] current = new long[n];
        long[] before = new long[n];

        if (n == 1) {
            System.out.println(1);
            return;
        } else {
            System.out.println(1);
            System.out.println(1 + " " + 1);
        }
        for (int i = 0; i < n; i++) {
            before[i] = 1;
            current[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (i >= 2) {
                for (int j = 0; j <= i; j++) {
                    if (j > 0 && j < i) {
                        current[j] = before[j] + before[j - 1];
                    }
                }
                for (int j = 0; j <= i; j++) {
                    before[j] = current[j];
                    System.out.print(current[j] + " ");
                }
                System.out.println();
            }
        }
    }
}