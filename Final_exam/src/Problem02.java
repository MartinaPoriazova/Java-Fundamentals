import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "\\\\*(?<symbol>[*]|[@])(?<tag>[A-Z][a-z]{2,})(?<symbo2>[*]|[@]): (\\[(?<char1>[A-Za-z])\\]\\|)(\\[(?<char2>[A-Za-z])\\]\\|)(\\[(?<char3>[A-Za-z])\\]\\|)$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

                if (matcher.matches()) {
                    String tag = matcher.group("tag");
                    String charInput1 = matcher.group("char1");
                    char character1 = charInput1.charAt(0);

                    String charInput2 = matcher.group("char2");
                    char character2 = charInput2.charAt(0);

                    String charInput3 = matcher.group("char3");
                    char character3 = charInput3.charAt(0);

                    System.out.println(tag + ": " + (int) character1 + " " + (int) character2 + " " + (int) character3);
                } else {
                    System.out.println("Valid message not found!");
                }
            }
        }
    }
