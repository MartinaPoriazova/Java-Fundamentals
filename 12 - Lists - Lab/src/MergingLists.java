import java.util.*;
import java.util.stream.Collectors;

public class MergingLists {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int smallListSize = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < smallListSize; i++) {
            System.out.print(firstList.get(i) + " " + secondList.get(i) + " ");
        }

        printTheRest(firstList, smallListSize);
        printTheRest(secondList, smallListSize);
    }

    private static void printTheRest(List<Integer> list, int beginIndex) {
        for (int i = beginIndex; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}