import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int trackNumber = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> pieces = new TreeMap<>();

        for (int i = 1; i <= trackNumber; i++) {
            String[] piecesInfo = scanner.nextLine().split("\\|");
            //{piece}|{composer}|{key}
            String piece = piecesInfo[0];
            String composer = piecesInfo[1];
            String key = piecesInfo[2];
            pieces.put(piece, new ArrayList<>());
            pieces.get(piece).add(composer);
            pieces.get(piece).add(key);
        }
        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Stop")) {
            String[] commandArray = commandLine.split("\\|");
            String command = commandArray[0];
            String piece = commandArray[1];

            switch (command) {
                //•	Add|{piece}|{composer}|{key}
                case "Add":
                    String composer = commandArray[2];
                    String key = commandArray[3];
                    if (!pieces.containsKey(piece)) {
                        pieces.put(piece, new ArrayList<>());
                        pieces.get(piece).add(composer);
                        pieces.get(piece).add(key);
                        System.out.printf("%s by %s in %s added to the collection!\n", piece, composer, key);
                    } else {
                        System.out.printf("%s is already in the collection!\n", piece);
                    }
                    break;
                //•	Remove|{piece}
                case "Remove":
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!\n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                    }
                    break;
                //•	ChangeKey|{piece}|{new key}
                case "ChangeKey":
                    String currentKey = commandArray[2];
                    if (pieces.containsKey(piece)) {
                        pieces.get(piece).set(1, currentKey);
                        System.out.printf("Changed the key of %s to %s!\n", piece, currentKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }
        //"{Piece} -> Composer: {composer}, Key: {key}"
        pieces
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
