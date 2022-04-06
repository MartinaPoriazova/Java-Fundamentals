import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emoji3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int coolTr = 0;
        int save = 0;
        String input = scan.nextLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char check = input.charAt(i);
            if (Character.isDigit(check)) {
                int digit = Integer.parseInt(String.valueOf(check));
                list.add(digit);
            }
        }
        long x = 1;
        for (Integer integer : list) {
            x *= integer;
        }
        int count = 0;
        List<String> lis = new ArrayList<>();
        System.out.println(String.format("Cool threshold: %d", x));
        Pattern pattern = Pattern.compile("(?<symbols>[:]{2}|[*]{2})(?<name>[A-Z][a-z]{2,})\\1");
        String here = "";
        String[] tokens = input.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            Matcher matcher = pattern.matcher(tokens[i]);
            while (matcher.find()) {
                count++;
                here = matcher.group("name");
                int valueCheck = 0;
                for (int j = 0; j < here.length(); j++) {
                    char check = here.charAt(j);
                    if (Character.isLetter(check)) {
                        valueCheck += check;
                    }
                }
                if (valueCheck >= x) {
                    lis.add(matcher.group(0));
                }
            }
        }
        System.out.println(String.format("%d emojis found in the text. The cool ones are: ", count));
        printLis(lis);
    }

    private static void printLis(List<String> lis) {
        for (String li : lis) {
            li = li.replace("\\[\\]", "");
            System.out.println(li);
        }
    }
}