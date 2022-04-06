import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Character> text = new ArrayList<>();
        List<Character> digits = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char newChar = input.charAt(i);
            if (48 <= (int) newChar && (int) newChar <= 57) { //Character.isDigit(newChar)
                digits.add(newChar);
            } else {
                text.add(newChar);
            }
        }

        List<Character> takeList = new ArrayList<>(); // even - четен
        List<Character> skipList = new ArrayList<>(); // odd - Нечетен

        for (int i = 0; i < digits.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(digits.get(i));
            } else {
                skipList.add(digits.get(i));
            }
        }
        List<String> output = new ArrayList<>();
        int indexToTake = 0;
        for (int i = 0; i < takeList.size(); i++) {
            if (indexToTake >= text.size()) {
                break;
            }
            for (int j = 0; j < takeList.get(i); j++) {
                output.add(text.get(indexToTake).toString());
                indexToTake++;
                if (indexToTake >= text.size()) {
                    break;
                }
            }
            indexToTake += skipList.get(i);
        }

        for (String element : output) {
            System.out.print(element);
        }

    }
}
