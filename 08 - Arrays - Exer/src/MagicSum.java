import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int number = Integer.parseInt(scanner.nextLine());

        for (int index = 0; index < array.length; index++) {
            for (int index2 = index + 1; index2 < array.length; index2++) {
                if ((array[index] + array[index2]) == number) {
                    System.out.println(array[index] + " " + array[index2]);
                }
            }
        }
    }
}
