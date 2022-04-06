import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> treasureStates = Arrays.stream(scanner.nextLine()
                .split("\\|"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();


        while (!input.equals("Yohoho!")) {
            List<String> newTreasures = Arrays.stream(input
                    .split("\\s+"))
                    .collect(Collectors.toList());
            switch (newTreasures.get(0)) {
                case "Loot":
                    LootMethod(treasureStates, newTreasures);
                    break;
                case "Drop":
                    DropMethod(treasureStates, newTreasures);
                    break;
                case "Steal":
                    StealMethod(treasureStates, newTreasures);
                    break;
            }
            input = scanner.nextLine();
        }
        int sumLength = 0;
        double avrGain = 0;
        for (String treasureState : treasureStates) {
            sumLength += treasureState.length();
        }
        avrGain = sumLength * 1.0 / treasureStates.size();
        if (!treasureStates.isEmpty()) {
            System.out.println();
            System.out.printf("Average treasure gain: %.2f pirate credits.", avrGain);
        } else {
            System.out.println();
            System.out.println("Failed treasure hunt.");
        }
    }

    private static void LootMethod(List<String> treasureStates, List<String> newTreasures) {
        for (int i = 1; i < newTreasures.size(); i++) {
            if (!treasureStates.contains(newTreasures.get(i))) {
                treasureStates.add(0, newTreasures.get(i));
            }
        }
    }

    private static void DropMethod(List<String> treasureStates, List<String> newTreasures) {
        int index = Integer.parseInt(newTreasures.get(1));
        for (int i = 0; i < treasureStates.size(); i++) {
            if (index == i) {
                treasureStates.add(treasureStates.size()+0, treasureStates.get(i));
                treasureStates.remove(i);
            }
        }
    }

    private static void StealMethod(List<String> treasureStates, List<String> newTreasures) {
        int counter = Integer.parseInt(newTreasures.get(1));
        List<String> stolenElements = new ArrayList<>();
        if (counter >= treasureStates.size()) {
            counter = treasureStates.size();
        }
        for (int i = 0; i < counter; i++) {
            stolenElements.add(i, treasureStates.get(treasureStates.size() - 1));
            treasureStates.remove(treasureStates.size() - 1);
        }
        for (int i = stolenElements.size() - 1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(stolenElements.get(i) + ", ");
            } else {
                System.out.print(stolenElements.get(i));
            }
        }
        stolenElements.clear();
    }
}
