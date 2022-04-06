import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> cards = Arrays.stream(scanner.nextLine()
                .split(", "))
                .collect(Collectors.toList());
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            String input = scanner.nextLine();
            String[] commandLine = input.split(", ");
            String command = commandLine[0];
            switch (command) {
                case "Add":
                    String cardName = commandLine[1];
                    if (cards.contains(cardName)) {
                        System.out.println("Card is already in the deck");
                    } else {
                        cards.add(cardName);
                        System.out.println("Card successfully added");
                    }
                    break;
                case "Remove":
                    String cardName2 = commandLine[1];
                    if (cards.contains(cardName2)) {
                        cards.remove(cardName2);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;
                case "Remove At":
                    int index = Integer.parseInt(commandLine[1]);
                    if (index >= 0 && index < cards.size()) {
                        cards.remove(index);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    int index2 = Integer.parseInt(commandLine[1]);
                    String cardName3 = commandLine[2];
//                    boolean validIndex = valid(index2, cards.size());
//                    if (validIndex) {
                    if (index2 >= 0 && index2 < cards.size()) {
                        if (cards.contains(cardName3)) {
                            System.out.println("Card is already added");
                        } else {
                            cards.add(index2, cardName3);
                            System.out.println("Card successfully added");
                        }

                    } else {
                        System.out.println("Index out of range");
                        continue;
                    }
                    break;
            }
        }
        System.out.print(cards.toString().replaceAll("[\\[\\]]", ""));

    }
//    private static boolean valid(int index2, int size) {
//        return index2 >= 0 && index2 < size;
//    }
}
