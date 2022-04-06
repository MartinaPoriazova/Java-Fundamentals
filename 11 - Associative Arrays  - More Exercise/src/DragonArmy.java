import org.w3c.dom.stylesheets.LinkStyle;

import java.security.KeyStore;
import java.util.*;

public class DragonArmy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Map<String, TreeSet<String>> dragons = new LinkedHashMap<>();
        Map<String, List<Integer>> stat = new TreeMap<>();

        for (int i = 1; i <= number; i++) {
            String[] input = scanner.nextLine().split(" ");
            //{type} {name} {damage} {health} {armor}
            // 45    // 250   // 10
            String type = input[0];
            String name = input[1];
            int damage = Integer.parseInt(input[2]);
            int health = Integer.parseInt(input[3]);
            int armor = Integer.parseInt(input[4]);

            if (input[2].equals("null")) {
                damage = 45;
            }
            if (input[3].equals("null")) {
                health = 250;
            }
            if (input[4].equals("null")) {
                armor = 10;
            }

            List<Integer> ints = new ArrayList<>();

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeSet<>());
                dragons.get(type).add(name);
                stat.put(name, ints);
                stat.get(name).add(damage);
                stat.get(name).add(health);
                stat.get(name).add(armor);
            }

            if (stat.containsKey(name)) {
                stat.put(name, ints);
                stat.get(name).add(damage);
                stat.get(name).add(health);
                stat.get(name).add(armor);
            }
        }

        dragons.entrySet().stream().forEach(e -> {

                }
        );
    }
}