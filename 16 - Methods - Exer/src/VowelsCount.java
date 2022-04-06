import java.util.Locale;
import java.util.Scanner;

public class VowelsCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //= scanner.nextLine().toLowerCase();
        int result = getVowelsCount(input);
        System.out.println(result);
    }

    public static int getVowelsCount(String input) {
        int counter = 0;
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            //char currentSymbol = input.charAt(i);
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'u'
                    || input.charAt(i) == 'y' || input.charAt(i) == 'o') {
                counter++;
            }
        }
        return counter;
    }
}
// първа старт позиция за чар е 0
// методът може да е void и да принтирам в метода, което е по - изчистено за основния код, за да не се създава result
// може и със switch