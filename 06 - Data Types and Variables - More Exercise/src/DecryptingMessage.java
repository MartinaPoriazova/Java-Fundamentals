import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int turns = 1; turns <= n ; turns++) {
            char chars = scanner.next().charAt(0);
            int newChar = chars + key;
            char message = (char) newChar;
            if (turns == 1) {
                message = Character. toUpperCase(message);
            }
            System.out.print(message);
        }
    }
}
