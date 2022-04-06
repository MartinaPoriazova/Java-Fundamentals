import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split(", ");

        for (String word : words) {
            //проверка дали е валидна -> принт
            if (isValidWord(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean isValidWord(String word) {
        boolean isValid = false;
        // валидна дължина -> from 3 to 16
        if (word.length() >= 3 && word.length() <= 16) {
            isValid = true;
        } else {
            return false;
        }
        // валидно съдържание
        for (char symbol : word.toCharArray()) {
            //проверка за буква
            if (Character.isLetterOrDigit(symbol) || symbol == '-' || symbol == '_') {
                isValid = true;
            } else {
                return false;
            }
            
        }
        return isValid;
    }
}
