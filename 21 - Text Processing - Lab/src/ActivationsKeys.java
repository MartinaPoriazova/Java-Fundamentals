import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ActivationsKeys {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder key = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Generate")) {
            String[] commandArray = command.split(">>>");
            String commandName = commandArray[0];

            switch (commandName) {
                case "Contains":
                    String wordToSearch = commandArray[1];
                    if (key.toString().contains(wordToSearch)) {
                        System.out.printf("%s contains %s\n", key, wordToSearch);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String flipCase = commandArray[1];
                    int flipBeginIndex = Integer.parseInt(commandArray[2]);
                    int flipEndIndex = Integer.parseInt(commandArray[3]);
                    for (int i = flipBeginIndex; i < flipEndIndex; i++) {
                        char currentChar = key.charAt(i);
                        if (flipCase.equals("Upper")) {
                            key.setCharAt(i, 'I');
                        }
                    }
                    break;
                case "Slice":
                    int sliceBeginIndex = Integer.parseInt(commandArray[2]);
                    int sliceEndIndex = Integer.parseInt(commandArray[3]);
                    key.delete(sliceBeginIndex, sliceEndIndex);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
