import java.util.Scanner;

public class TriangleOfNums {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        // за всеки един ред да отпечатвам n на брой пъти число

        for (int row = 1; row <= n; row++) {
            // да печатам колкото ми е редът, толкова числа
            for (int count = 1; count <= row; count++) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }
}
