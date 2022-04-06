import java.util.Scanner;

class RepeatStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        for (String word : words) {
            String repeatedWord = repeatWord(word, word.length());
            System.out.print(repeatedWord);
        }
    }

    public static String repeatWord(String word, int numberOfRepetitions) {
        String result = "";
        for (int i = 1; i <= numberOfRepetitions; i++) {
            result += word;
        }
        return result;
    }
}
//String[] words = sc.nextLine().split(" ");
//List<String> result = new ArrayList<>();
//for (String word : words) {
//  result.add(repeat(word, word.length()));
//}
//System.out.println(String.join("", result));
