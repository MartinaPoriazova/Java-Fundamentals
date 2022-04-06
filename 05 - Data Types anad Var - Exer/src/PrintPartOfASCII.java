import java.util.Scanner;

public class PrintPartOfASCII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. да обходим всички стойности
        // 2. за всяка стойност да вземем символа към тази стойност
        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());

        for (int code = startNumber; code <= endNumber; code++) {
            System.out.print((char) code + " ");
        }
    }
}
