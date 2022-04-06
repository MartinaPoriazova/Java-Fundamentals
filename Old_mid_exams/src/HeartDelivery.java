import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> houses = Arrays.stream(scanner.nextLine()
                .split("@"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        int currentIndex = 0;

        while (!input.equals("Love!")) {
            List<String> command = Arrays.stream(input
                    .split(" "))
                    .collect(Collectors.toList());
            int length = Integer.parseInt(command.get(1));
            currentIndex += length;
            if (currentIndex >= houses.size()) {
                currentIndex = 0;
            }
            if (houses.get(currentIndex) != 0) {
                houses.set(currentIndex, houses.get(currentIndex) - 2);
                if (houses.get(currentIndex) == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);
        boolean isSuccessful = true;
        for (int house : houses) {
            if (house != 0) {
                isSuccessful = false;
                break;
            }
        }
        int count = 0;
        for (int house : houses) {
            if (house != 0) {
                count++;
            }
        }
        if (isSuccessful) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", count);
        }


        }
    }

