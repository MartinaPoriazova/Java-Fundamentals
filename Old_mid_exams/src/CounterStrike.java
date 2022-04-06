import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int wonsCounter = 0;

        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (energy - distance >= 0) {
                energy -= distance;
                wonsCounter++;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonsCounter, energy);
                return;
            }
            if (wonsCounter % 3 == 0) {
                energy += wonsCounter;
            }
            input = scanner.nextLine();
        }
            System.out.printf("Won battles: %d. Energy left: %d", wonsCounter, energy);
    }
}
