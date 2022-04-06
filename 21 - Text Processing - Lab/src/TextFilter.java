import java.util.Scanner;

public class TextFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            String wordOfStars = convertWordToStars(bannedWord);
            text = text.replaceAll(bannedWord, wordOfStars);
        }
        System.out.println(text);
    }

    public static String convertWordToStars(String bannedWord) {
        String wordOfStars = "";
        for (int i = 0; i < bannedWord.length(); i++) {
            wordOfStars += "*";
        }
        return wordOfStars;
    }
}
