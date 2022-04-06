import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> rooms = Arrays.stream(scanner.nextLine()
                .split("\\|"))
                .collect(Collectors.toList());
        int health = 100;
        int bitcoins = 0;

        for (int i = 0; i < rooms.size(); i++) {
            List<String> room = Arrays.stream(rooms.get(i)
                    .split(" "))
                    .collect(Collectors.toList());
            String command = room.get(0);
            int number = Integer.parseInt(room.get(1));
            switch (command) {
                case "potion":
                    if (health + number <= 100) {
                        health += number;
                    } else {
                        number = 100 - health;
                        health = 100;
                    }
                    System.out.printf("You healed for %d hp.\n", number);
                    System.out.printf("Current health: %d hp.\n", health);
                    break;
                case "chest":
                    bitcoins += number;
                    System.out.printf("You found %d bitcoins.\n", number);
                    break;
                default:
                    health -= number;
                    if (health > 0) {
                        System.out.printf("You slayed %s.\n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.\n", command);
                        System.out.printf("Best room: %d", i +1);
                        return;
                    }
                    break;
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d\n", bitcoins);
        System.out.printf("Health: %d", health);
    }
}
