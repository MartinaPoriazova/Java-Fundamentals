import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Judge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //{username} -> {contest} -> {points}
        Map<String, LinkedHashMap<String, Integer>> contests = new LinkedHashMap<>();
        Map<String, Integer> usersTotalPoints = new LinkedHashMap<>();

        while (!input.equals("no more time")) {
            String[] tokens = input.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            if (!contests.containsKey(contest)) {
                contests.put(contest, new LinkedHashMap<>());
            }

            LinkedHashMap<String, Integer> users = new LinkedHashMap<>();

            if (!users.containsKey(username)) {
                users.put(username, points);
            } else {
                int currentPoints = users.get(username);
                if (currentPoints < points) {
                    users.put(username, points);
                }
            }

            if (!usersTotalPoints.containsKey(username)) {
                usersTotalPoints.put(username, points);
            } else {
                usersTotalPoints.put(username, points + usersTotalPoints.get(username));
            }

            input = scanner.nextLine();
        }
//        contests
//                .entrySet()
//                .stream()
//                .forEach(e-> System.out.printf("%s: %d participants",  contests.keySet(), contests.))
//                .sorted(Map.Entry.<String, Integer> comparingByValue()
//                        .reversed()
//                        .thenComparing(Map.Entry.comparingByKey()))

    }
}
