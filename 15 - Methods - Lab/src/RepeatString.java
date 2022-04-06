import java.util.Scanner;

public class RepeatString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int turns = Integer.parseInt(scanner.nextLine());
        String repeatedString = repeatString(text, turns);
        System.out.println(repeatedString);
    }

    private static String repeatString(String text, int turns) {
        String result = "";
        for (int i = 0; i < turns; i++) {
            result += text;
        }
        return result;
    }
}
