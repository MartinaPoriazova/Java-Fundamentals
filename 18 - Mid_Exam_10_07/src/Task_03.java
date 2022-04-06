import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> ratings = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int breakingPoint = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        int damageLeft = 0;
        int damageRight = 0;
        List<Integer> brakingPointList = new ArrayList<>();

        for (int i = 1; i <= ratings.size() - 2; i++) {
            brakingPointList.add(ratings.get(i));
        }

        for (int i = 2 - 1; i >= 0; i--) {
            switch (command) {
                case "cheap":
                    for (Integer integer : brakingPointList) {
                        if (ratings.get(i) < integer) {
                            damageLeft += ratings.get(i);

                        }
                    }
                    break;
                case "expensive":
                    for (Integer integer : brakingPointList) {
                        if (ratings.get(i) >= integer) {
                            damageLeft += ratings.get(i);
                        }
                    }
                    break;
            }
        }
        for (int i = ratings.size() - 1; i >= ratings.size() - 2; i--) {
            switch (command) {
                case "cheap":
                    for (Integer integer : brakingPointList) {
                        if (ratings.get(i) < integer) {
                            damageRight += ratings.get(i);

                        }
                    }
                    break;
                case "expensive":
                    for (Integer integer : brakingPointList) {
                        if (ratings.get(i) >= integer) {
                            damageRight += ratings.get(i);
                        }
                    }
                    break;
            }
        }
        if (damageLeft >= damageRight) {
            System.out.printf("Left - " + "%d", damageLeft);
        } else {
            System.out.printf("Right - " + "%d", damageRight);
        }
    }
}
