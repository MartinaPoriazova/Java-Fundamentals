import java.util.*;

public class WordSynonyms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfWords = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> synonymDictionary = new LinkedHashMap<>();

        for (int i = 0; i < countOfWords; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!synonymDictionary.containsKey(word)) {
                List<String> synonymForCurrentWord = new ArrayList<>();
                synonymForCurrentWord.add(synonym);
                synonymDictionary.put(word, synonymForCurrentWord);
            } else {
                List<String> synonymForCurrentWord = synonymDictionary.get(word);
                synonymForCurrentWord.add(synonym);
                synonymDictionary.put(word, synonymForCurrentWord);
            }

        }

        for (Map.Entry<String, List<String>> entryWord : synonymDictionary.entrySet()) {
            String currentWord = entryWord.getKey();
            List<String> synonymsOfCurrentWord = entryWord.getValue();
            System.out.printf("%s - %s%n", currentWord, String.join(", ", synonymsOfCurrentWord));
        }
    }
}
