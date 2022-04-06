import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> breakingPoint = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int entryPoint = Integer.parseInt(scanner.nextLine()); // 2 >= entryPoint <= predposleden

        String itemType = scanner.nextLine();
        int damageLeft = 0;
        int damageRight = 0;

        for (int i = 0; i < entryPoint; i++) {
            switch (itemType) {
                case "cheap": // чупи айтъми с по - нисък рейтинг от ентрито
                    if (breakingPoint.get(i) < breakingPoint.get(entryPoint)) {
                        damageLeft += breakingPoint.get(i);
                    }
                    break;
                case "expensive":
                    if (breakingPoint.get(i) >= breakingPoint.get(entryPoint)) {
                        damageLeft += breakingPoint.get(i);
                    }
                    break;
            }
        }
        for (int i = entryPoint + 1; i < breakingPoint.size(); i++) {
            switch (itemType) {
                case "cheap": // чупи айтъми с по - нисък рейтинг от ентрито
                    if (breakingPoint.get(i) < breakingPoint.get(entryPoint)) {
                        damageRight += breakingPoint.get(i);
                    }
                    break;
                case "expensive":
                    if (breakingPoint.get(i) >= breakingPoint.get(entryPoint)) {
                        damageRight += breakingPoint.get(i);
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
