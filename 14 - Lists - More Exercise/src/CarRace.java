import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int indexCount = numbers.size();
        int finishLine = indexCount / 2;
        double leftTime = 0;
        double rigthTime = 0;
        String position = "";

        for (int i = 0; i < finishLine; i++) {

            leftTime += numbers.get(i);
            if (numbers.get(i) == 0) {
                leftTime -= leftTime * 0.20;
            }
        }

        for (int i = indexCount - 1; finishLine < i; i--) {

            rigthTime += numbers.get(i);
            if (numbers.get(i) == 0) {
                rigthTime -= rigthTime * 0.20;
            }
        }

        if (leftTime < rigthTime) {
            position = "left";
            System.out.printf("The winner is %s with total time: %.1f", position, leftTime);
        } else {
            position = "right";
            System.out.printf("The winner is %s with total time: %.1f", position, rigthTime);
        }

    }
}
