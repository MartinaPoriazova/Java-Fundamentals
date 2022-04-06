import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<emoji>(?<symbols>[:]{2}|[*]{2})(?<name>[A-Z][a-z]{2,})\\k<symbols>)";
        // (?<name>([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2}))
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> emojis = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        int emojiCounter = 0;
        int coolnesSum = 1;


        while (matcher.find()) {
            emojiCounter++;
            String emoji = matcher.group("name");
            emojis.add(emoji);
        }
        while (matcher.find()) {
            numberList.add(Integer.parseInt(matcher.group()));
            int digit=Integer.parseInt(matcher.group());
            coolnesSum *= digit;
        }


    }
}
