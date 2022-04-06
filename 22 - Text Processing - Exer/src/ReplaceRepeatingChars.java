import java.math.BigInteger;
import java.util.Scanner;

public class ReplaceRepeatingChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        StringBuilder newText = new StringBuilder();
        //1. добавям първата буква към новия текст
        //2. взимам всички други букви до края
        //-> проверявам дали текущата буква е различна от последната доабвена в новия текст
        //ако е различна -> добавям я в новия текст
        char firstLetter = inputText.charAt(0);
        newText.append(firstLetter);

        for (int index = 1; index < inputText.length(); index++) {
            char currentSymbol = inputText.charAt(index);
            char lastAddedSymbolInNewText = newText.charAt(newText.length() - 1);
            if (currentSymbol != lastAddedSymbolInNewText) {
                newText.append(currentSymbol);
            }
        }

        System.out.println(newText);


    }
}