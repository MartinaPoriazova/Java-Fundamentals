import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> peopleHealth = new TreeMap<>();
        Map<String, Integer> peopleEnergy = new TreeMap<>();

        while (!input.equals("Results")) {
            String[] inputArray = input.split(":");
            String command = inputArray[0];

            switch (command) {
                case "Add": //o	"Add:{personName}:{health}:{energy}"
                    String personName = inputArray[1];
                    int health = Integer.parseInt(inputArray[2]);
                    int energy = Integer.parseInt(inputArray[3]);
                    if (!peopleHealth.containsKey(personName)) {
                        peopleHealth.put(personName, health);
                        peopleEnergy.put(personName, energy);
                    } else {
                        int currentHelth = peopleHealth.get(personName);
                        peopleHealth.put(personName, currentHelth + health);
                    }
                    break;
                case "Attack"://o	"Attack:{attackerName}:{defenderName}:{damage}"
                    String attackerName = inputArray[1];
                    String defenderName = inputArray[2];
                    int damage = Integer.parseInt(inputArray[3]);
                    if (peopleHealth.containsKey(attackerName) && peopleHealth.containsKey(defenderName)) {
                        int currentHealth = peopleHealth.get(defenderName);
                        int currentEnergy = peopleEnergy.get(attackerName);
                        peopleHealth.put(defenderName, currentHealth - damage);
                        peopleEnergy.put(attackerName, currentEnergy - 1);
                    }
                    if (peopleHealth.get(defenderName) <= 0) {
                        peopleHealth.remove(defenderName);
                        peopleEnergy.remove(defenderName);
                        System.out.printf("%s was disqualified!\n", defenderName);
                    }
                    if (peopleEnergy.get(attackerName) <= 0) {
                        peopleHealth.remove(attackerName);
                        peopleEnergy.remove(attackerName);
                        System.out.printf("%s was disqualified!\n", attackerName);
                    }
                    break;
                case "Delete"://o	"Delete:{username}"
                    String usernameToDel = inputArray[1];
                    if (usernameToDel.equals("All")) {
                        peopleHealth.clear();
                        peopleEnergy.clear();
                    } else {
                        if (peopleHealth.containsKey(usernameToDel)) {
                            peopleHealth.remove(usernameToDel);
                            peopleEnergy.remove(usernameToDel);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        int peopleCount = 0;
        for (String k : peopleHealth.keySet()){
            peopleCount++;
        }
        System.out.printf("People count: %d\n", peopleCount);
        // "{personName} - {health} - {energy}"
        peopleHealth.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(Entry -> {
                    String personName = Entry.getKey();
                    System.out.printf("%s - %d - %d\n", personName, Entry.getValue(), peopleEnergy.get(personName));
                });
    }
}
