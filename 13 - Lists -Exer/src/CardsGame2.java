import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> player1 = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> player2 = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (player1.size() > 0 && player2.size() > 0) {
            if (player1.get(0).equals(player2.get(0))) {
                player1.remove(0);
                player2.remove(0);
            } else if (player1.get(0) > player2.get(0)) {
                player1.add(player1.get(0));
                player1.add(player2.get(0));
                player1.remove(0);
                player2.remove(0);
            } else if (player1.get(0) < player2.get(0)) {
                player2.add(player2.get(0));
                player2.add(player1.get(0));
                player1.remove(0);
                player2.remove(0);
            }
        }

        int sum = 0;
        if (player1.size() > 0) {
            for (int number : player1) {
                sum += number;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            for (int number : player2) {
                sum += number;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}