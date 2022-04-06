import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MorseCodeTranslator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> message = Arrays.stream(scan.nextLine().split(" \\| "))
                .collect(Collectors.toList());
        List<String> result = new ArrayList<>();

        for (int i = 0; i < message.size(); i++) {
            result.add(decodedWord(message.get(i)));
        }

        System.out.println(String.join(" ", result));
    }

    private static String decodedWord(String word) {
        String[] letters = word.split("\\s+");
        StringBuilder currWord = new StringBuilder();

        char[] letter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'};

        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < codes.length; j++) {
                if (letters[i].equals(codes[j])) {
                    currWord.append(letter[j]);
                    break;
                }
            }
        }
        return currWord.toString();
    }
}