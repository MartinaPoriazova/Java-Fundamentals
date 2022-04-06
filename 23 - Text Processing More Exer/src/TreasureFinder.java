import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] key = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("find")) {
            StringBuilder decoded = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                int currentChar = input.charAt(i);
                int currentLieration = i;
                while (currentLieration >= key.length) {
                    currentLieration -= key.length;
                }

                decoded.append((char) (currentChar - key[currentLieration]));

            }

            String treasure = decoded.substring(decoded.indexOf("&")
                    , decoded.deleteCharAt(decoded.indexOf("&")).indexOf("&"));
            String location = decoded.substring(decoded.indexOf("<") + 1
                    , decoded.indexOf(">"));

            System.out.printf("Found %s at %s%n", treasure, location);
            input = scanner.nextLine();
        }
    }
}
