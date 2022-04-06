import com.sun.jdi.Value;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <String> words = Arrays.stream((scanner.nextLine())
                .split(""))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            List <String> commandList = Arrays.stream(input
                    .split("\\|"))
                    .collect(Collectors.toList());
            String command = commandList.get(0);
            if (command.equals("Move")) {
                //•	Move {number of letters}
                int elementsToMove = Integer.parseInt(commandList.get(1));
                for (int i = 0; i < elementsToMove; i++) {
                    words.add(words.get(i));
                }
                for (int i = 0; i < elementsToMove; i++) {
                    words.remove(0);
                }
                System.out.println(words);
            } else if (command.equals("Insert")) {// Insert|2|o
                //•	Insert {index} {value}
                String elementToInsert = commandList.get(2);
                int indexBefore = Integer.parseInt(commandList.get(1));
                words.add(indexBefore, elementToInsert);
                System.out.println(words);
            } else if (command.equals("ChangeAll")) {
                //•	ChangeAll {substring} {replacement}  ChangeAll|z|l
                String charToReplace = commandList.get(1);
                String newChar = commandList.get(2);
                Collections.replaceAll(words, charToReplace, newChar);
                          }
            input = scanner.nextLine();
        }
        System.out.print("The decrypted message is: ");
        for (String word:words) {
            System.out.print(word);
        }
    }
}
