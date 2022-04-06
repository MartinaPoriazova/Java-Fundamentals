import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> num1 = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> num2 = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int smallerListCount = Math.min(num1.size(), num2.size());
        List<Integer> result = new ArrayList<>(smallerListCount);
        Collections.reverse(num2);

        for (int i = 0; i < smallerListCount; i++) {
            result.add(num1.get(i));
            result.add(num2.get(i));
        }

        int constraintOne = 0;
        int constraintTwo = 0;
        if (num1.size() > num2.size()) {
            constraintOne = num1.size() - 1;
            constraintTwo = num1.size() - 2;
        } else {
            constraintOne = num2.size() - 1;
            constraintTwo = num2.size() - 2;
        }

        int smallerConstraintNum = Math.min(constraintTwo, constraintOne);
        int biggerConstraintNum = Math.max(constraintTwo, constraintOne);

        List<Integer> listToPrint = new ArrayList<>(20);

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) >= smallerConstraintNum && result.get(i) <= biggerConstraintNum) {
                listToPrint.add(result.get(i));
            }
        }

        Collections.sort(listToPrint);
        for (Integer n : listToPrint) {
            System.out.println(n + " ");
        }
    }
}
