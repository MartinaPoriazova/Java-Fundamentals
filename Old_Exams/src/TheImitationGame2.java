import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TheImitationGame2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String message = reader.readLine();

        StringBuilder stringBuilder = new StringBuilder();

        String command;
        while (!"Decode".equals(command = reader.readLine())) {
            String[] commandParts = command.trim().split("\\|");
            String keyCommand = commandParts[0];

            switch (keyCommand) {
                case "Move":
                    int numOfLetters = Integer.parseInt(commandParts[1]);

                    stringBuilder.append(message, 0, numOfLetters);
                    message = message.substring(numOfLetters).concat(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandParts[1]);
                    String value = commandParts[2];
                    stringBuilder.append(message);
                    message = stringBuilder.insert(index, value).toString();
                    stringBuilder.setLength(0);
                    break;
                case "ChangeAll":
                    String substring = commandParts[1];
                    String replacement = commandParts[2];
                    if (message.contains(substring)) {
                        message = message.replace(substring, replacement);
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.printf("The decrypted message is: %s", message);
    }
}