import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "Pesho Gosho Toshko Sasho";
        String pattern = "[A-Z][a-z]+";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        System.out.println(matcher.find());          // true
        System.out.println(matcher.group());         // Andy: 123
        System.out.println(matcher.group(0));        // Andy: 123
        System.out.println(matcher.group(1));        // Andy
        System.out.println(matcher.group(2));        // 123
        System.out.println(matcher.group("number"));

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
