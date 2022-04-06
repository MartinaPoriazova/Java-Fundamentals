import java.util.*;

public class ForceBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> forceBook = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains(" | ")) {
                String forceUser = input.split("\\s+\\|\\s+")[1];
                String forceSide = input.split("\\s+\\|\\s+")[0];

                //forceBook.putIfAbsent(forceSide, new ArrayList<>());
                if (!forceBook.containsKey(forceSide)) {
                    forceBook.put(forceSide, new ArrayList<>());
                }

                if (!forceBook.get(forceSide).contains(forceUser)) {
                    forceBook.get(forceSide).add(forceUser);
                }
            } else if (input.contains(" -> ")) {
                String forceUser = input.split("\\s+->\\s+")[0];
                String forceSide = input.split("\\s+->\\s+")[1];

                forceBook.forEach((key, value) -> value.remove(forceUser));
                forceBook.putIfAbsent(forceSide, new ArrayList<>());
                forceBook.get(forceSide).add(forceUser);
                System.out.printf("%s joins the %s side!\n", forceUser, forceSide);
            }
            input = scanner.nextLine();
        }

        forceBook.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 0)
                .sorted((e1, e2) -> {
                    int sortedResult = Integer.compare(e2.getValue().size(), e1.getValue().size());
                    if (sortedResult == 0) {
                        //броят на хората в двете страни е еднакъв -> сортирам по име на страната
                        sortedResult = e1.getKey().compareTo(e2.getKey());
                        //е1 < е2 -> -1
                        //е1 == е2 -> 0
                        //е1 > е2 -> 1
                    }
                    return sortedResult;
                })
                .forEach(entry -> {
            //Side: {forceSide}, Members: {forceUsers.Count}
            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
            entry
                    .getValue()
                    .stream()
                    .sorted()
                    .forEach(user -> System.out.println("! " + user));
        });
    }
}