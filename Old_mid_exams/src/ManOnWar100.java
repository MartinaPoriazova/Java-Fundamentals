import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOnWar100 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Integer> pirateShipStatus = Arrays
                    .stream(scanner.nextLine().split(">"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<Integer> warshipStatus = Arrays
                    .stream(scanner.nextLine().split(">"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int maxHeathCapacity = Integer.parseInt(scanner.nextLine());
            String input = scanner.nextLine();

            while (!input.equals("Retire")) {
                String command = input.split("\\s+")[0];
                switch (command) {
                    case "Fire":
                        // The pirate ship attacks the warship
                        int index = Integer.parseInt(input.split("\\s+")[1]);
                        boolean isValid = valid(index, warshipStatus.size());

                        if (isValid) {
                            int damage = Integer.parseInt(input.split("\\s+")[2]);
                            int statusDamaged = warshipStatus.get(index) - damage;

                            warshipStatus.set(index, statusDamaged);
                            if (warshipStatus.get(index) <= 0) {
                                System.out.println("You won! The enemy ship has sunken.");
                                return;
                            }
                        }
                        break;
                    case "Defend":
                        // The warship attacks the pirate ship
                        int startIndex = Integer.parseInt(input.split("\\s+")[1]);
                        int endIndex = Integer.parseInt(input.split("\\s+")[2]);
                        boolean startIndexValid = valid(startIndex, pirateShipStatus.size());
                        boolean endIndexValid = valid(endIndex, pirateShipStatus.size());

                        if (startIndexValid && endIndexValid) {
                            int damage = Integer.parseInt(input.split("\\s+")[3]);
                            for (int i = startIndex; i <= endIndex; i++) {
                                int statusDamaged = pirateShipStatus.get(i) - damage;
                                pirateShipStatus.set(i, statusDamaged);
                                if (pirateShipStatus.get(i) <= 0) {
                                    System.out.println("You lost! The pirate ship has sunken.");
                                    return;
                                }
                            }
                        }
                        break;
                    case "Repair":
                        // Repair the pirate ship
                        int repairIndex = Integer.parseInt(input.split("\\s+")[1]);
                        boolean validRepairIndex = valid(repairIndex, pirateShipStatus.size());

                        if (validRepairIndex) {
                            int health = Integer.parseInt(input.split("\\s+")[2]);
                            int repairedStatus = pirateShipStatus.get(repairIndex) + health;
                            pirateShipStatus.set(repairIndex, Math.min(repairedStatus, maxHeathCapacity));
                        }
                        break;
                    case "Status":
                        // Prints all sections of the pirate ship that are below 20% of the Max Health Capacity
                        int criticalStatuses = 0;
                        double criticalHealth = 0.2 * maxHeathCapacity;

                        for (Integer shipStatus : pirateShipStatus) {
                            if (shipStatus < criticalHealth) {
                                criticalStatuses++;
                            }
                        }

                        System.out.printf("%d sections need repair.%n", criticalStatuses);
                        break;
                }
                input = scanner.nextLine();
            }

            int pirateShipSum = 0;
            for (Integer shipStatus : pirateShipStatus) {
                pirateShipSum += shipStatus;
            }

            int warshipSum = 0;
            for (Integer integer : warshipStatus) {
                warshipSum += integer;
            }

            System.out.printf("Pirate ship status: %d%n", pirateShipSum);
            System.out.printf("Warship status: %d", warshipSum);
        }

        private static boolean valid(int index, int size) {

            return index >= 0 && index < size;
        }
    }
