import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        char[] firstArgument = input[0].toCharArray();
        char[] secondArgument = input[1].toCharArray();
        int totalSum = 0;

        for (int i = 0; i < Math.max(firstArgument.length, secondArgument.length); i++) {
            if (i < firstArgument.length && i < secondArgument.length) {
                totalSum += firstArgument[i] * secondArgument[i];
            } else if (i < firstArgument.length && i >= secondArgument.length) {
                totalSum += firstArgument[i];
            } else if (i >= firstArgument.length && i < secondArgument.length) {
                totalSum += secondArgument[i];
            }
        }
        System.out.printf("%d", totalSum);
    }
}
