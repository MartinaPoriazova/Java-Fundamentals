import java.util.Scanner;

public class NxNMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int[][] nMatrix = getFinalResult(number);

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.printf("%d ", nMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] getFinalResult(int number) {
        int[][] resultMatrix = new int[number][number];

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                resultMatrix[i][j] = number;
            }
        }
        return resultMatrix;
    }
}
