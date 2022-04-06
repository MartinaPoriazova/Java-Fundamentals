import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
//        String regexName = "@(?<name>[A-Z][a-z]*)\\|";
//        String regexAge = "#(?<age>[0-9]*?)\\*";

        for (int i = 1; i <= lines; i++) {
            String input = scanner.nextLine();

            int indexBeforeTheName = input.indexOf('@');
            int indexAfterOfTheName = input.indexOf('|');

            String name = input.substring(indexBeforeTheName + 1, indexAfterOfTheName);

            int indexBeforeTheAge = input.indexOf('#');
            int indexAfterTheAge = input.indexOf('*');

            String age = input.substring(indexBeforeTheAge + 1, indexAfterTheAge);

            System.out.printf("%s is %s years old.\n", name, age);
        }
    }
}