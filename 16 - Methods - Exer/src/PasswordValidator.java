import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        //проверка за дължината й - 6 -10 вкл.
        //ако дължината е валидна -> ок, продължаваме нататък
        boolean isValidLength = isValidLength(password);

        //ако не е валидна -> принт на съобщение
        if (isValidLength == false) { //(!isValidLength)
            System.out.println("Password must be between 6 and 10 characters");
        }

        //проверка дали съдържа само букви и цифри
        boolean isValidContent = isValidContent(password);

        if (!isValidContent) {
            System.out.println("Password must consist only of letters and digits");
        }

        //проверка има ли поне 2 цифри
        boolean isValidCout = isValidCountDigit(password);

        if (!isValidCout) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidLength && isValidContent && isValidCout) {
            System.out.println("Password is valid");
        }

    }

    // метод проверка на дължина - връща тру, ако дължината е валидна, фолс, ако не е - булев метод
    public static boolean isValidLength(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else { //nevalidna
            return false;
        }
    }

    // метод за проверка на букви и цифри -> true(валидна)
    public static boolean isValidContent(String password) {
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            //ако символът е различен от буква и цифра, ще върне фолс
            if (!Character.isLetterOrDigit(currentSymbol)) {
                //Или с isLetterOrDigit(currentSymbol) //!Character.isLetter(currentSymbol) || !Character.isDigit(currentSymbol)
                return false;
            }
        }
        //обходила съм всички символи и имам само валидни символи
        return true;
    }

    // метод за проверка на 2 букви - бр цифри в парола - ако 2 ->тру
    public static boolean isValidCountDigit(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                counter++;
            }
        }
        return counter >= 2; // върни ми резултатът от този израз, какъв и да е - същото като s if конструкция
    }
}
