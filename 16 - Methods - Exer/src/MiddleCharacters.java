import java.util.Scanner;

public class MiddleCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        getMiddleChar(text);
    }

    public static void getMiddleChar(String text) {
        // нечетна дължина
        if (text.length() % 2 != 0) {
            // елементът на каква позиция е
            int indexMiddleSymbol = text.length() / 2;
            System.out.println(text.charAt(indexMiddleSymbol));

            // четна
        } else {
            // позиция на 1 елемент = дължината / 2 - 1
            // позиция на 2 елемент = дължината / 2
            int indexFirstMiddleSymbol = text.length() / 2 - 1;
            int indexSecondMiddleSymbol = text.length() / 2;
            System.out.printf("%c%c", text.charAt(indexFirstMiddleSymbol), text.charAt(indexSecondMiddleSymbol));
        }
    }
}
