import java.util.Scanner;

public class LettersChangeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] passwords = input.split("\\s+");
        double totalSum = 0; // - общата сума от всички пароли

        for (String password : passwords) {
            //пресмятаме стойността на паролата
            //сумираме ги
            double currentSum = getCurrentSum(password);
            totalSum += currentSum;
        }

        System.out.printf("%.2f", totalSum);
    }

    private static double getCurrentSum(String password) {
        // пасс - буква число буква
        char firstLetter = password.charAt(0);
        char secondLetter = password.charAt(password.length() - 1);
        double number = Integer.parseInt(password.replace(firstLetter, ' ').replace(secondLetter, ' ').trim());
        // трети начин - int number = Integer.parseInt(password.substring(1, password.indexOf(secondLetter)));
        int positionOfFirstLetter = 0;

        // проверка за главна
        if (Character.isUpperCase(firstLetter)) {
            // позиция в азбуката
            int positionUpperLetter = (int) firstLetter - 64;
            number = number / positionUpperLetter;

        } else {
            int positionLowerLetter = (int) firstLetter - 96;
            number = number * positionLowerLetter;

        }
        if (Character.isUpperCase(secondLetter)) {
            int positionUpperLetter = (int) secondLetter - 64;
            number = number - positionUpperLetter;

        } else {
            int positionLowerLetter = (int) secondLetter - 96;
            number = number + positionLowerLetter;

        }

        return number;

    }
}
