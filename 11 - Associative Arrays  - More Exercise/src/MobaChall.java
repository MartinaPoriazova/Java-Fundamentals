import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

public class MobaChall {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, TreeMap<String, Integer>> players = new TreeMap<>();

        while (!input.equals("Season end")) {
            if (input.contains(" -> ")) {
                String[] inputArray = input.split(" -> ");
                //"{player} -> {position} -> {skill}"
                String player = inputArray[0];
                String position = inputArray[1];
                int skill = Integer.parseInt(inputArray[2]);

                TreeMap<String, Integer> playerInfo = new TreeMap<>();
                players.putIfAbsent(player, playerInfo);

                if (!playerInfo.containsKey(position)) {
                    playerInfo.put(position, skill);
                } else {
                    if (playerInfo.get(position) < skill) {
                        playerInfo.put(position, skill);
                    }
                }
            }

            if (input.contains(" vs ")) {
                String[] inputArray = input.split(" vs ");
                String player1 = inputArray[0];
                String player2 = inputArray[1];

                if (players.containsKey(player1) && players.containsKey(player2)) {
                    if (isCommon(players.get(player1).keySet(), players.get(player2).keySet())) {
                        int player1TotalSkills = players.get(player1).values().stream().mapToInt(e -> e).sum();
                        int player2TotalSkills = players.get(player2).values().stream().mapToInt(e -> e).sum();

                        if (player1TotalSkills > player2TotalSkills) {
                            players.remove(player2);
                        } else if (player2TotalSkills > player1TotalSkills) {
                            players.remove(player1);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }

        players.entrySet()
                .stream()
                .sorted((p1, p2) ->
                        Integer.compare(p2.getValue().values().stream().mapToInt(e -> e).sum(),
                                p1.getValue().values().stream().mapToInt(e -> e).sum()))
                .forEach(p -> {
                    System.out.printf("%s: %d skill%n", p.getKey(),
                            p.getValue().values().stream().mapToInt(e -> e).sum());
                    p.getValue().entrySet().stream()
                            .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                            .forEach(e -> System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue()));
                });
    }

    private static boolean isCommon(Set<String> keySet, Set<String> keySet1) {
        for (String s1 : keySet) {
            for (String s2 : keySet1) {
                if (s1.equals(s2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
