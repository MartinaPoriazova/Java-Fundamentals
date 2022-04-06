import java.util.Scanner;

public class LowerOrUpper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        int parsedChar = letter;

        if (parsedChar >= 65 & parsedChar <= 90) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}
