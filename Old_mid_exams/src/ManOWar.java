import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pirateShipStatus = Arrays.stream(scanner.nextLine()
                .split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> warShipStatus = Arrays.stream(scanner.nextLine()
                .split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxHealth = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Retire")) {
            List<String> command1 = Arrays.stream(command
                    .split("\\s+"))
                    .collect(Collectors.toList());
            switch (command1.get(0)) {
                case "Fire":
                    FireMethod(pirateShipStatus, warShipStatus, command1, maxHealth);
                    break;
                case "Defend":
                    DefendMethod(pirateShipStatus, warShipStatus, command1, maxHealth);
                    break;
                case "Repair":
                    RepairMethod(pirateShipStatus, warShipStatus, command1, maxHealth);
                    break;
                case "Status":
                    int counterToRepair = 0;
                    for (Integer shipStatus : pirateShipStatus) {
                        if (shipStatus < maxHealth * 0.20)
                            counterToRepair++;
                    }
                    System.out.printf("%d sections need repair.\n", counterToRepair);
                    break;
            }
            command = scanner.nextLine();
        }

        int pirateShipSum = 0;
        int warShipSum = 0;

        for (int i = 0; i < pirateShipStatus.size(); i++) {
            pirateShipSum = pirateShipSum + pirateShipStatus.get(i);
        }
        for (int i = 0; i < warShipStatus.size(); i++) {
            warShipSum = warShipSum + warShipStatus.get(i);
        }
        System.out.printf("Pirate ship status: %d\n", pirateShipSum);
        System.out.printf("Warship status: %d", warShipSum);
    }

    private static void FireMethod(List<Integer> pirateShipStatus, List<Integer> warShipStatus, List<String> command1, int maxHealth) {
        int index = Integer.parseInt(command1.get(1));
        int damage = Integer.parseInt(command1.get(2));
        int currentHealth = maxHealth - damage;

        if (index <= warShipStatus.size() - 1) {
            if (currentHealth > 0) {
                warShipStatus.set(index, warShipStatus.get(index) - damage);
            } else {
                System.out.println("You won! The enemy ship has sunken.");
                System.exit(0);
            }
        }
    }

    private static void DefendMethod(List<Integer> pirateShipStatus, List<Integer> warShipStatus, List<String> command1, int maxHealth) {
        int startIndex = Integer.parseInt(command1.get(1));
        int endIndex = Integer.parseInt(command1.get(2));
        int damage = Integer.parseInt(command1.get(3));
        int currentHealth = maxHealth - damage;
        if (startIndex >= 0 && endIndex <= pirateShipStatus.size() - 1) {
            if (currentHealth > 0) {
                for (int i = startIndex; i <= endIndex; i++) {
                    pirateShipStatus.set(i, pirateShipStatus.get(i) - damage);
                }
            } else {
                System.out.println("You lost! The pirate ship has sunken.");
                System.exit(0);
            }
        }
    }

    private static void RepairMethod(List<Integer> pirateShipStatus, List<Integer> warShipStatus, List<String> command1, int maxHealth) {
        int index = Integer.parseInt(command1.get(1));
        int health = Integer.parseInt(command1.get(2));
        int currentHealth = maxHealth + health;
        if (index <= pirateShipStatus.size() - 1) {
            if (currentHealth < 70) {
                pirateShipStatus.set(index, pirateShipStatus.get(index) + health);
            } else {
                pirateShipStatus.set(index, maxHealth);
            }
        }
    }

}

