import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "(@|#)(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int pairsCounter = 0;
        List<List<String>> mirrorPairs = new ArrayList<>();

        while (matcher.find()) {
            String firstWord = matcher.group("firstWord");
            String secondWord = new StringBuilder(matcher.group("secondWord")).reverse().toString();
            pairsCounter++;

            if (firstWord.equals(secondWord)) {
                mirrorPairs.add(List.of(firstWord, matcher.group("secondWord")));

            }
        }
        if (pairsCounter == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!\n", pairsCounter); //" <=> "
        }
        if (mirrorPairs.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(mirrorPairs.stream()
                    .map(pair -> String.join(" <=> ", pair))
                    .collect(Collectors.joining(", ")));
        }
    }
}
