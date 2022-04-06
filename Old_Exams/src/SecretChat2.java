import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class SecretChat2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        MessageDecrypter decrypter = new MessageDecrypter(reader.readLine());

        reader.lines()
                .takeWhile(command -> !"Reveal".equals(command))
                .map(decrypter::interpreter)
                .forEachOrdered(System.out::println);

        System.out.printf("You have a new text message: %s", decrypter.getMessage());
    }

    private static class MessageDecrypter {
        private static final Pattern COMMAND_PATTERN = Pattern.compile(":\\|:");

        private final StringBuilder msg;

        public MessageDecrypter(String msg) {
            this.msg = new StringBuilder(msg);
        }

        public String interpreter(String command) {
            String[] token = COMMAND_PATTERN.split(command);

            switch (token[0]) {
                case "InsertSpace":
                    return insertSpace(Integer.parseInt(token[1]));
                case "Reverse":
                    return cutReverseAndConcat(token[1]);
                case "ChangeAll":
                    return replace(token[1], token[2]);
                default:
                    throw new IllegalArgumentException("Invalid command: " + command);
            }
        }

        private String insertSpace(int index) {
            msg.insert(index, ' ');
            return msg.toString();
        }

        private String cutReverseAndConcat(String toCut) {
            int index = msg.indexOf(toCut);

            if (index == -1) {
                return "error";
            }

            msg.delete(index, index + toCut.length());
            msg.append(new StringBuilder(toCut).reverse());

            return msg.toString();
        }

        private String replace(String toReplace, String replaceWith) {
            String updatedMessage = Pattern.compile(toReplace).matcher(msg).replaceAll(replaceWith);
            msg.replace(0, msg.length(), updatedMessage);

            return msg.toString();
        }

        public String getMessage() {
            return msg.toString();
        }
    }
}