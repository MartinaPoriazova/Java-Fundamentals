import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        int countShot = 0;

        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (index < 0 || index >= targets.size() || targets.get(index) == -1){
                input = scanner.nextLine();
                continue;
            }
            int shootTarget = targets.get(index);
            targets.set(index, -1);
            countShot++;

            for (int i = 0; i < targets.size(); i++) {
                int target = targets.get(i);
                if (target != -1) {
                    int indexTarget = targets.indexOf(target);
                    if (target > shootTarget) {
                        targets.set(indexTarget, target - shootTarget);
                    } else {
                        targets.set(indexTarget, target + shootTarget);
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> %s", countShot, targets.toString().replaceAll("[\\[\\],]", ""));
    }
}